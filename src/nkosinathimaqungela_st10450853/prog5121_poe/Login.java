
package nkosinathimaqungela_st10450853.prog5121_poe;

/**
 *
 * @author maqun
 */
public class Login {
    private String username;
    private String password;
    private Registration registration;
    private boolean loginStatus;

    public Login(String username, String password, Registration registration) {
        this.username = username;
        this.password = password;
        this.registration = registration;
    }

    public boolean loginUser() {
        String storedUsername = registration.getStoredUsername();
        String storedPassword = registration.getStoredPassword();

        if (storedUsername == null || storedPassword == null) {
            loginStatus = false;
            return false;
        }

        loginStatus = username.equals(storedUsername) && 
                password.equals(storedPassword);
        return loginStatus;
    }
    
    public String returnLoginStatus() {
        if (loginStatus) {
            return "Hello " + registration.getFirstName() + " " +
                  registration.getLastName() + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

