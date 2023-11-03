import java.util.Scanner;

public class FishinHole{

    /**
     * @author Jackson Ding, Crescent School, ICS4U
     * Version 1.2 - No Methods, Wrong Output Solved by adding detection mechanism to see if 1 fish is caught
     * Main Algorithms - Find the maxmimum number of fish that can be caught for each type, use nested forloops to loop through all 3 different types of fish to find combinations avaiable
     * Solves the CCC '06 J3 - Cell-Phone Messaging problem (https://dmoj.ca/problem/ccc06j3)
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //scanner for input
        int totalAllow; //the total allowable points
        int[] fishtype = new int[3]; //array to take all of the points for each fish

        //taking inputs
        fishtype[0] = input.nextInt();
        fishtype[1] = input.nextInt();
        fishtype[2] = input.nextInt();
        totalAllow = input.nextInt();

        //declare variables for the max possible amount of each fish and a variable to track the available methods
        int num1, num2, num3, numTrack;

        //find the maximum of fish allowed for each type of fish
        num1 = totalAllow/fishtype[0];
        num2 = totalAllow/fishtype[1];
        num3 = totalAllow/fishtype[2];
        numTrack = 0; //start with 0 avaiable combination of catching fish

        //loop through all of the possible combination with none exceeding the maximum available amount for each fish type
        for(int i = 0; i<=num1; i++){
            for(int j = 0; j<=num2; j++){
                for(int k = 0; k<=num3; k++){
                    if(i*fishtype[0]+j*fishtype[1]+k*fishtype[2]<=totalAllow){ //find all of th emethods that is works (including equals because it would work as well)
                        if(i+j+k==0){//detect at least if 1 fish is caught
                            continue; //skip this loop
                        }else {
                            //print and track the number of available methods
                            System.out.println(i + " Brown Trout, " + j + " Northern Pike, " + k + " Yellow Pickerel");
                            //System.out.println(i*fishtype[0]+j*fishtype[1]+k*fishtype[2]+"<="+totalAllow); --> for testing to see if the sum is actually smaller or equal to the total allowable points
                            numTrack++;
                        }
                    }
                }
            }
        }

        //final print statement
        System.out.println("Number of ways to catch fish: " + numTrack);

    }
}