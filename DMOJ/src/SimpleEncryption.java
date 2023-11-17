import java.util.Arrays;
import java.util.Scanner;

public class SimpleEncryption {

    //source   1 https://javarevisited.blogspot.com/2016/02/how-to-remove-all-special-characters-of-String-in-java.html#:~:text=You%20can%20use%20a%20regular,all%20special%20characters%20from%20String.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String keyWord = input.nextLine().toLowerCase();
        String message = input.nextLine().replaceAll("[^a-zA-Z0-9_-]", "");
        System.out.println(message);

        int rows = message.length()/keyWord.length() + 1;

        char[][] table = new char[rows][keyWord.length()];

        int k = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<keyWord.length(); j++){
                if(k<message.length()) {
                    table[i][j] = (char)(message.charAt(k) + (keyWord.charAt(j)-97));
                    k++;
                }else{
                    continue;
                }
            }
        }
        System.out.println(Arrays.deepToString(table));
    }
}
