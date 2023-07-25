import java.util.Scanner;

public class QuestionDetector {

    public static boolean isQuestion(String inputText) {
        // Convert the input text to lowercase for case-insensitive matching
        String lowercaseInput = inputText.toLowerCase();

        // Common question keywords
        String[] questionKeywords = {"who", "what", "where", "when", "why", "how", "is", "am", "are",
                "can", "could", "did", "do", "does", "has", "have", "had"};

        // Check if the input text starts with any of the question keywords and ends with a question mark
        for (String keyword : questionKeywords) {
            if (lowercaseInput.startsWith(keyword + " ") || lowercaseInput.startsWith(keyword + "?")) {
                return true;
            }
        }

        // Check if the input text contains a question mark
        if (lowercaseInput.contains("?")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String inputText = scanner.nextLine();

        if (isQuestion(inputText)) {
            System.out.println("The input contains a question.");
        } else {
            System.out.println("The input is not a question.");
        }
    }
}
