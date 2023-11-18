import java.util.Arrays;
import java.util.Scanner;

public class SimpleEncryption {

    //source   1 https://javarevisited.blogspot.com/2016/02/how-to-remove-all-special-characters-of-String-in-java.html#:~:text=You%20can%20use%20a%20regular,all%20special%20characters%20from%20String.
    //souce 2 https://www.quora.com/How-do-you-check-for-an-empty-string-and-null-character-in-the-C-programming-language#:~:text=Null%20Character%20Check%3A%20To%20check,c%20%3D%3D%20'%5C0')

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String keyWord = input.nextLine().toLowerCase();
        String message = input.nextLine().replaceAll("[^a-zA-Z0-9_-]", "").toLowerCase();
        //System.out.println(message);

        int rows = message.length()/keyWord.length() + 1;

        char[][] table = new char[rows][keyWord.length()];

        int k = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<keyWord.length(); j++){
                if(k<message.length()) {
                    char temp = (char)(((message.charAt(k)-97) + (keyWord.charAt(j)-97))%26 + 97);
                    table[i][j] = Character.toUpperCase(temp);
                    //System.out.println(table[i][j]);
                    k++;
                }else{
                    continue;
                }
            }
        }

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<keyWord.length(); j++){
                if(table[i][j]!='\0') {
                    System.out.print(table[i][j]);
                }
            }
        }
    }
}
