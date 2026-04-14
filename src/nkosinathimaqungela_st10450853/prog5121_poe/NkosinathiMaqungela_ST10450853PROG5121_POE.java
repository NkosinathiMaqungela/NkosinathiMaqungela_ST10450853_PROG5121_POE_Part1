
package nkosinathimaqungela_st10450853.prog5121_poe;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Nkosinathi Maqungela ST10450853
 */
public class NkosinathiMaqungela_ST10450853PROG5121_POE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean registrationSuccessful = false;
        
        while (!registrationSuccessful) {
            String username = null;
            String password = null;
            String cellNumber = null;
            String firstName = null;
            String lastName = null;
            
            
            Registration registration = new Registration("", "", "", "", ""); 
            // Temporary object for validation

            // Input collection with immediate validation and reprompting
            while (username == null) {
                try {
                    System.out.println("Enter username (must contain an "
                            + "underscore and be no more than 5 characters):");
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        throw new IllegalArgumentException("Username cannot be"
                                + " empty.");
                    }
                    registration = new Registration(input, "", "", "", "");
                    if (!registration.checkUserName()) {
                        throw new IllegalArgumentException("Username must "
                                + "contain an underscore and be no more than 5"
                                + " characters.");
                    }
                    username = input;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error: " + e.getMessage());
                }
            }

            while (password == null) {
                try {
                    System.out.println("Enter password (at least 8 characters,"
                            + " including a capital letter, number, and special"
                            + " character):");
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        throw new IllegalArgumentException("Password cannot be"
                                + " empty.");
                    }
                    registration = new Registration("", input, "", "", "");
                    if (!registration.checkPasswordComplexity()) {
                        throw new IllegalArgumentException("Password must be at"
                                + " least 8 characters, with a capital letter,"
                                + " number, and special character.");
                    }
                    password = input;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error: " + e.getMessage());
                }
            }

            while (cellNumber == null) {
                try {
                    System.out.println("Enter cell phone number (must start with"
                            + " '+27' and be 10-12 digits):");
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        throw new IllegalArgumentException("Cell phone number "
                                + "cannot be empty.");
                    }
                    registration = new Registration("", "", input, "", "");
                    if (!registration.checkCellNumber()) {
                        throw new IllegalArgumentException("Cell phone number"
                                + " must start with '+27' and be 10-12 digits.");
                    }
                    cellNumber = input;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error: " + e.getMessage());
                }
            }

            while (firstName == null) {
                try {
                    System.out.println("Enter first name (letters only):");
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        throw new IllegalArgumentException("First name cannot "
                                + "be empty.");
                    }
                    if (!Pattern.matches("^[a-zA-Z]+$", input)) {
                        throw new IllegalArgumentException("First name must"
                                + " contain only letters.");
                    }
                    firstName = input;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error: " + e.getMessage());
                }
            }

            while (lastName == null) {
                try {
                    System.out.println("Enter last name (letters only):");
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        throw new IllegalArgumentException("Last name cannot be"
                                + " empty.");
                    }
                    if (!Pattern.matches("^[a-zA-Z]+$", input)) {
                        throw new IllegalArgumentException("Last name must "
                                + "contain only letters.");
                    }
                    lastName = input;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error: " + e.getMessage());
                }
            }

            // Create registration object with validated inputs
            registration = new Registration(username, password, cellNumber,
                    firstName, lastName);

            // Validate input and register user
            String registrationResult = registration.registerUser();
            System.out.println(registrationResult);

            // Check if registration is successful
            if (registrationResult.contains("Username successfully captured") &&
                registrationResult.contains("Password successfully captured") &&
                registrationResult.contains("Cell phone number successfully"
                        + " added")) {
                registrationSuccessful = true;

                boolean loginSuccessful = false;
                while (!loginSuccessful) {
                    System.out.println("\nRegistration successful!"
                            + " Now attempting login...");
                    Login login = new Login(username, password, registration);
                    login.loginUser();
                    System.out.println(login.returnLoginStatus());

                    if (login.returnLoginStatus().contains("Hello")) {
                        loginSuccessful = true;
                        System.out.println("Welcome to the Chat App");
                        
                    }
                }
            } else {
                System.out.println("\nRegistration failed due to invalid input."
                        + " Please try again.");
            }
            
        }
        
    }
}
