import java.util.Scanner;

public class UserLogin {

    public static final int MAX_TRIES = 3;
    public static final String VALID_PASSWORD = "password";

    public static void login() throws MaximumTriesExceededException, InvalidPasswordException {
        Scanner scanner = new Scanner(System.in);
        int attempt = 0;

        while (attempt < MAX_TRIES) {
            System.out.println("Welcome!");
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            attempt++;

            if (password.equals(VALID_PASSWORD)) {
                System.out.println("\nLogin successful!");
                scanner.close();
                return; // Exit loop on successful login
            } else if (attempt == MAX_TRIES) {
                scanner.close();
                throw new MaximumTriesExceededException("\nYou have exceeded the maximum number of login attempts.");
            } else {
                System.out.println("\nInvalid password. Please try again.\n");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            login();
        } catch (InvalidPasswordException | MaximumTriesExceededException e) {
            System.out.println(e.getMessage());
        }
    }
}
