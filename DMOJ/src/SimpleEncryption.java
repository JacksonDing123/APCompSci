import java.util.Arrays;
import java.util.Scanner;

public class SimpleEncryption {

    //source 1 https://javarevisited.blogspot.com/2016/02/how-to-remove-all-special-characters-of-String-in-java.html#:~:text=You%20can%20use%20a%20regular,all%20special%20characters%20from%20String.
    //souce 2 https://www.quora.com/How-do-you-check-for-an-empty-string-and-null-character-in-the-C-programming-language#:~:text=Null%20Character%20Check%3A%20To%20check,c%20%3D%3D%20'%5C0')

    /**
     * @author Jackson Ding, Crescent School, ICS4U
     * Version 1.2 - No Methods, Wrong Output Solved by using correct math with the characters from the message
     * Main Algorithms - Make a 2D char array based on the keyword and the message, then add each character after being modified with the respective character in that colum from the message to the array, the characters are modified by shifting the respective placement of each char depending on the keyword
     * Solves the CCC '04 J4 - Simple Encryption (https://dmoj.ca/problem/ccc04j4)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner for input
        String keyWord = input.nextLine().toLowerCase(); //get the keyword in lower case for easier math and operations later
        String message = input.nextLine().replaceAll("[^a-zA-Z0-9_-]", "").toLowerCase(); // find the message without any space and special characters and in lower case for easier operations later
        //System.out.println(message); //for testing purposes

        int rows = message.length()/keyWord.length() + 1; // find the amount of rows that is required to contain the whole word, +1 to make sure the last row is included and make sure there is at least 1 row

        char[][] table = new char[rows][keyWord.length()]; //make a new 2d char array based on the rows and colums. the colums it the length of the keyword

        //changes each char in the message to the encrypted character
        int k = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<keyWord.length(); j++){
                if(k<message.length()) {
                    char temp = (char)(((message.charAt(k)-97) + (keyWord.charAt(j)-97))%26 + 97);
                    //finds the place value of the character from the message in the alphabet first, add it by the place value of the character from the respective keyword, then mod it by 26 for correct shifts in character, then change the value with respect to the ascii table
                    table[i][j] = Character.toUpperCase(temp); //change the character to upper case
                    //System.out.println(table[i][j]); //for testing purposes
                    k++;// to move to the next character
                }else{
                    continue;
                }
            }
        }

        //final output
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<keyWord.length(); j++){
                //print the char if it isn't null
                if(table[i][j]!='\0') {
                    System.out.print(table[i][j]);
                }
            }
        }
    }
}
