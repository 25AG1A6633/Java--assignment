import java.util.Scanner;

public class StringAnalyzer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine().trim();

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        // Demonstrating split()
        String[] words = sentence.split("\\s+");

        System.out.println("Word Count : " + words.length);

        // First word using substring()
        int firstSpace = sentence.indexOf(" ");

        String firstWord;
        if (firstSpace == -1) {
            firstWord = sentence;
        } else {
            firstWord = sentence.substring(0, firstSpace);
        }

        // Last word using substring()
        int lastSpace = sentence.lastIndexOf(" ");

        String lastWord;
        if (lastSpace == -1) {
            lastWord = sentence;
        } else {
            lastWord = sentence.substring(lastSpace + 1);
        }

        System.out.println("First Word : " + firstWord);
        System.out.println("Last Word : " + lastWord);

        // indexOf() and lastIndexOf()
        int firstIndex = sentence.indexOf(ch);
        int lastIndex = sentence.lastIndexOf(ch);

        System.out.println("First '" + ch + "' index : " + firstIndex);
        System.out.println("Last '" + ch + "' index : " + lastIndex);

        // compareTo()
        int comparison = firstWord.compareTo(lastWord);

        System.out.println(
                "Comparison (first vs last word) : " + comparison
        );

        // toCharArray()
        char[] characters = sentence.toCharArray();

        // charAt()
        char firstCharacter = sentence.charAt(0);

        // String.valueOf()
        String firstCharacterString = String.valueOf(firstCharacter);

        System.out.println(
                "First Character : " + firstCharacterString
        );

        System.out.println(
                "ASCII Value : " + (int) characters[0]
        );
    }
}