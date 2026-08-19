import java.util.Arrays;
import java.util.Scanner;

public class PalindromeAnagramChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        System.out.print("Enter third string: ");
        String str3 = sc.nextLine();

        // Remove spaces and punctuation
        String cleaned = str1.replaceAll("[^a-zA-Z0-9]", "");

        // Convert to lowercase
        cleaned = cleaned.toLowerCase();

        // Palindrome check
        String reversed = new StringBuilder(cleaned)
                .reverse()
                .toString();

        boolean palindrome = cleaned.equals(reversed);

        // Anagram check
        String a = str2.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        String b = str3.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean anagram = Arrays.equals(arr1, arr2);

        // Regex validation
        boolean valid = cleaned.matches("[a-zA-Z0-9]+");

        // contains()
        boolean containsPlan = cleaned.contains("plan");

        // intern() and hashCode()
        String s1 = new String("Java");
        String s2 = new String("Java");

        String interned1 = s1.intern();
        String interned2 = s2.intern();

        boolean hashEqual =
                interned1.hashCode() == interned2.hashCode();

        // String.format()
        String report = String.format(
                "Palindrome : %b | Anagram : %b",
                palindrome,
                anagram
        );

        // String.join()
        String finalReport = String.join(
                "\n",
                "Palindrome Check : \"" + str1 + "\" -> " + palindrome,
                "Anagram Check : \"" + str2 + "\" & \"" + str3 + "\" -> " + anagram,
                "Formatted Report : [ " + report + " ]",
                "Contains 'plan' : " + containsPlan,
                "Valid Alphanumeric : " + valid,
                "HashCodes equal for interned strings : " + hashEqual
        );

        System.out.println("\n" + finalReport);
    }
}