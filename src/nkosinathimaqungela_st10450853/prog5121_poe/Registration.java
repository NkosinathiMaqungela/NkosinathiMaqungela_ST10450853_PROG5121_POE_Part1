
package nkosinathimaqungela_st10450853.prog5121_poe;

import java.util.Scanner;

public class Registration {
    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;
    private String storedUsername;
    private String storedPassword;
    
    Scanner scanner = new Scanner(System.in);

    public Registration(String username, String password, String cellNumber
            , String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public boolean checkUserName() {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) return false;
        boolean hasCapital = false, hasNumber = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasCapital && hasNumber && hasSpecial;
    }
    
    public boolean checkCellNumber() {
        
        if (cellNumber == null) return false;
        return  cellNumber.length()
                <= 12 && cellNumber.length() >= 10
                && cellNumber.matches("^\\+27[6-8][0-9]{8}$");
    }
     
    public String registerUser() {
        boolean validUsername = checkUserName();
        boolean validPassword = checkPasswordComplexity();
        boolean validCellPhone = checkCellPhoneNumber();

        StringBuilder message = new StringBuilder();
        if (!validUsername) {
            message.append("Username is not correctly formatted, please ensure"
                    + " that your username contains an underscore and is no more"
                    + " than five characters in length.\n");
        } else {
            message.append("Username successfully captured.\n");
        }

        if (!validPassword) {
            message.append("Password is not correctly formatted; please ensure"
                    + " that the password contains at least eight characters,"
                    + " a capital letter, a number, and a special character.\n")
                    ;
        } else {
            message.append("Password successfully captured.\n");
        }

        if (!validCellPhone) {
            message.append("Cell phone number incorrectly formatted or does not"
                    + " contain international code.\n");
        } else {
            message.append("Cell phone number successfully added.\n");
        }

        if (validUsername && validPassword && validCellPhone) {
            storedUsername = username;
            storedPassword = password;
        }
        
         return message.toString().trim();
       
    }

    public String getStoredUsername() {
        return storedUsername;
    }

    public String getStoredPassword() {
        return storedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    
    
}
