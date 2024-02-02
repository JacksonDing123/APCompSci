import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class AbsolutelyAcidic {
    //source 1 Jeff Qiu on how to store all of the sensor information as 1 array

    /**
     * @author Jackson Ding, Crescent School, ICS4U
     * Version 1.7 - No Methods, fixed the issue to find the actual right secondMaximumFrequency
     * Main Algorithms - make a array that contains all of the senor information where the index is the sensor value and the value of the index is the frequency, iterate twice to find the maximum and second maximum frequency and then depending on if the max and second max is the same frequency the program finds the max and min values to find the maxmimum difference
     * Solves the CCC '12 S3 - Absolutely Acidic (https://dmoj.ca/problem/ccc12s3)
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);//creates scanner
        int n = input.nextInt(); //finds how many censors there are
        int[] inputarray = new int[1001]; //create a array with index as the sensor values and the values as frequencies
        int max = 0; //temporary variable for max value with max frequency
        int min = 1001;//temporary variable for min value with max frequency
        int secondMax = 0;//temporary variable for max value with second max frequency
        int secondMin = 1001;//temporary variable for min value with second max frequency
        int maxFrequency = 0;//used to store the max frequency
        int secondMaxFrequency = 0;//used to store the seocndmaximum frequency if there is one
        int maxFrequencyIndex = 0;//used to store the index of the maxfrequency to avoid second counting the max frequency for the second max frequency
        int secondMaxFrequencyIndex = 0;

        //for test cases
//        int[] test1 = {823, 412, 219, 532, 712, 412, 532, 712, 219, 823, 219, 847, 219, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712, 219, 823, 412, 532, 712};

        //takes all of the inputs
        for(int i = 0; i<n; i++){
            int x = input.nextInt();
            inputarray[x]++;
        }

// for test cases
//        for(int i = 0; i< test1.length; i++){
//            inputarray[test1[i]]++;
//        }

        //finds the maximum frequency if the next value is bigger than the current one
        for(int i = 0; i<inputarray.length; i++){
            if(inputarray[i]>maxFrequency){
                maxFrequency = inputarray[i];
                maxFrequencyIndex = i;
            }
        }

        //finds the second maximum value meanwhile avoiding using the same index of frequency as the max frequency
        for(int i = 0; i<inputarray.length;i++){
            if(inputarray[i]>secondMaxFrequency&&inputarray[i]<=maxFrequency&&i!=maxFrequencyIndex){
                secondMaxFrequency = inputarray[i];
                secondMaxFrequencyIndex = i;
            }
        }

//        System.out.println(maxFrequency);
//        System.out.println(secondMaxFrequency);
//        System.out.println(maxFrequencyIndex);
//        System.out.println(secondMaxFrequencyIndex);

        //finds the max value if there are two of the same maximum frequencies
        if(maxFrequency == secondMaxFrequency){
            for(int i = 0; i<inputarray.length; i++){
                if(inputarray[i]==maxFrequency){
                    if(i>max){
                        max = i;
                    }
                    if(i<min){
                        min = i;
                    }
                }
            }
            System.out.println(max - min);
        }else{ //finds the max value of there are two different maximum frequencies
            for(int i = 0; i<inputarray.length; i++){
                if(inputarray[i]==maxFrequency){
                    if(i>max){
                        max = i;
                    }
                    if(i<min){
                        min = i;
                    }
                }else if(inputarray[i]==secondMaxFrequency){
                    if(i>secondMax){
                        secondMax = i;
                    }
                    if(i<secondMin){
                        secondMin = i;
                    }
                }
            }
            //finds the maximum value by finding the two potential biggest different between the max and min values and testing to see whcih is larger
            System.out.println((Math.abs(max-secondMin)>Math.abs(secondMax-min))?Math.abs(max-secondMin):Math.abs(secondMax-min));
        }
    }
}