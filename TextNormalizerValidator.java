import java.util.Scanner;

public class TextNormalizerValidator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Demonstrating trim()
        String cleaned = str.trim();

        // Demonstrating isEmpty()
        if (cleaned.isEmpty()) {
            System.out.println("EMPTY STRING");
            return;
        }

        // Demonstrating equalsIgnoreCase()
        if (cleaned.equalsIgnoreCase("admin")) {
            System.out.println("RESERVED WORD");
            return;
        }

        // Demonstrating replace()
        cleaned = cleaned.replace("_", " ");

        // Demonstrating startsWith(), endsWith(), toLowerCase()
        String lower = cleaned.toLowerCase();

        if (lower.startsWith("temp") && lower.endsWith("user")) {
            cleaned = cleaned.concat(" FLAGGED");
        }

        System.out.println(cleaned);
    }
}