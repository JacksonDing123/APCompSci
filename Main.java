import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * @author Jackson Ding, Crescent School, ICS4U
     * Version 1.3 - No Methods, Wrong Output Solved by resetting "current" and "last" variable
     * Solves the CCC '06 J3 - Cell-Phone Messaging problem (https://dmoj.ca/problem/ccc06j3)
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // make a new scanner
        String x;//the string used to containing the user input

        int current = 0; //used to track current button pressed
        int last = 100; //used to track the button pressed later to see if the same one is used, 100 is used to ensure the first time comparing isn't the same with 2 extra

        //2d array for the buttons on the phone
        char[][] phone = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'d','e','f'},{'w','x','y','z'}};
        int result = 0;//variable used for printing results

        //loops the intake until halt is pressed
        do{
            x = input.nextLine(); //takes string

            //stops if string is halt
            if(x.equals("halt")){
                break;
            }

            //loops through the string
            for(int j = 0; j<x.length(); j++){
                //the following code is used to determine where the letter is on the button and how many times is needed to press
                char num = x.charAt(j);
                int add = 0;

                for(int k = 0; k<phone.length; k++){
                    for(int z = 0; z<phone[k].length; z++){
                        if(phone[k][z]==num){
                            add = z+1;//because everything starts as 0 for the index 1 is added
                            current = k;//records the current index
                        }
                    }
                }

                if(current == last){ //if the current index is the same as the previous index then add 2 extra seconds
                    result+=2+add;
                }else{
                    result+=add; //add the amount if it is not on the same button
                }

                last = current; //resets the last and current parameters
                current = 0; //current to 0 because it always changes
            }
            System.out.println(result);//print the result
            result = 0;//reset results

            current = 0;//resets current and last
            last = 100;

        }while(!x.equals("halt"));
    }
}