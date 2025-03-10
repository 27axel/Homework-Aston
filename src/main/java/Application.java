public class Application {
    public static void main(String[] args) {
        try {
            sendMessage("Helo");
        } catch (InvalidMessageFormatException e) {
            System.out.println("Catch InvalidMessageFormatException: " + e.getMessage());
        }
    }

    public static void sendMessage(String message) throws InvalidMessageFormatException {
        if (message.length() < 5) {
            throw new InvalidMessageFormatException("The message contains less than 5 characters");
        }

        System.out.println(message);
    }
}
