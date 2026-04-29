import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> responses = new HashMap<>();

        responses.put("hello", "Hello! How can I assist you today?");
        responses.put("hi", "Hi there! How can I help you?");
        responses.put("how are you", "I'm just a bot, but I'm functioning perfectly!");
        responses.put("name", "I am a simple customer service chatbot.");
        responses.put("help", "Sure! You can ask me basic questions.");
        responses.put("thanks", "You're welcome! Happy to help.");
        responses.put("bye", "Goodbye! Have a great day!");

        System.out.println("====================================");
        System.out.println(" CUSTOMER SERVICE CHATBOT ");
        System.out.println("====================================");
        System.out.println("Chatbot: Hello! Type 'bye' to exit.\n");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase().trim();

            if (userInput.equals("bye")) {
                System.out.println("Chatbot: " + responses.get("bye"));
                break;
            }

            boolean found = false;

            for (String key : responses.keySet()) {
                if (userInput.contains(key)) {
                    System.out.println("Chatbot: " + responses.get(key));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Chatbot: Sorry, I didn't understand that. Please try again.");
            }
        }

        scanner.close();
    }
}
