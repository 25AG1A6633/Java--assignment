import java.util.Scanner;

public class SecureTextFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine().trim();

        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine().trim();

        // -------------------------------
        // 1. Title Case
        // -------------------------------

        String[] nameWords = fullName.toLowerCase().split("\\s+");

        String formattedName = "";

        for (String word : nameWords) {

            String firstLetter =
                    word.substring(0, 1).toUpperCase();

            String remaining =
                    word.substring(1).toLowerCase();

            formattedName += firstLetter + remaining + " ";
        }

        formattedName = formattedName.trim();

        // -------------------------------
        // 2. Mask Email
        // -------------------------------

        int atIndex = email.indexOf("@");

        String maskedEmail;

        if (atIndex >= 3) {

            String firstThree = email.substring(0, 3);

            String remaining =
                    "*".repeat(atIndex - 3);

            maskedEmail =
                    firstThree + remaining +
                    email.substring(atIndex);

        } else {
            maskedEmail = email;
        }

        // -------------------------------
        // 3. Email Validation
        // -------------------------------

        boolean validEmail = email.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );

        // -------------------------------
        // 4. Reverse Each Word
        // -------------------------------

        String[] words = sentence.split("\\s+");

        StringBuilder reversedSentence =
                new StringBuilder();

        for (String word : words) {

            char[] chars = word.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                reversedSentence.append(chars[i]);
            }

            reversedSentence.append(" ");
        }

        // -------------------------------
        // 5. Count Vowels
        // -------------------------------

        int vowelCount = 0;

        for (char c : sentence.toLowerCase().toCharArray()) {

            if (c == 'a' || c == 'e' ||
                c == 'i' || c == 'o' ||
                c == 'u') {

                vowelCount++;
            }
        }

        // -------------------------------
        // 6. == vs equals()
        // -------------------------------

        String x = new String("Java");
        String y = new String("Java");

        System.out.println("\nFormatted Name : " + formattedName);
        System.out.println("Masked Email : " + maskedEmail);
        System.out.println("Valid Email : " + validEmail);
        System.out.println("Reversed Words : " +
                reversedSentence.toString().trim());
        System.out.println("Vowel Count : " + vowelCount);

        System.out.println("\nString Comparison:");
        System.out.println("x == y : " + (x == y));
        System.out.println("x.equals(y) : " + x.equals(y));

        // Demonstrating isBlank()
        System.out.println(
                "Name is blank : " + fullName.isBlank()
        );
    }
}