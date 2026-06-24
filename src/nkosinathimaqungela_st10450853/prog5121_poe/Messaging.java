/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */    
package nkosinathimaqungela_st10450853.prog5121_poe;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.ArrayList;
/**
 *
 * @author maqun
 */
public class Messaging {
  

    private Scanner scanner;
    private Random random;
    private static final Pattern recipientCellPhone = 
            Pattern.compile("^\\+27[6-8][0-9]{8}$");
    static ArrayList<Message> sentMessages = new ArrayList<>();
       
    
    
    private static class Message {
        String id;
        String recipient;
        String content;
        private String toLowerCase;
        
        public Message(String id, String recipient, String content){
            this.id = id;
            this.recipient = recipient;
            this.content = content;
        }
    }
    
    public Messaging(Scanner scanner){
        this.scanner = scanner;
        this.random = new Random();
    }
    
    public void textMenu(){
        boolean quit = false;
        
        while (!quit){
            System.out.println("\nzMain Menu");
            System.out.println("************************************");
            System.out.println("Please choose an option to continue");            
            System.out.println("1. Send Messages");            
            System.out.println("2. Recently Sent Messages");
            System.out.println("3. Quit");
            
            String option = scanner.nextLine();
            
            switch (option){
                case "1": handleSendMessages();
                            break;
                            
                case "2": System.out.println("\n--- Sent Messages ---");
                 
                                System.out.println("coming soon");  
                                textMenu();
                           
                
    
                case "3": System.out.println("Goodbye!");
                            quit = true;
                            break;
    
                            
                default:
                    System.out.println("Invalid option. Please choose 1 or 3");
            }
        }
    }
    
     void handleSendMessages(){
        System.out.println("How many messages would you like to send?");
        int numberOfMessages = 0;
        
        try {
            numberOfMessages = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid number. Returning to menu");
            return;
        }
        
        for (int i = 1; i <= numberOfMessages; i++) {
            String recipientNumber = null;
            
            // Keep prompting until a valid phone number is entered
            while (recipientNumber == null) {
                System.out.print("Enter recipient cellphone number (Must start"
                        + " with +27 and be 10-12 digits)");
                String input = scanner.nextLine().trim();
                
                if (recipientCellPhone.matcher(input).matches()) {
                    recipientNumber = input;
                } else {
                    System.out.println("Invalid Cellphone number. Please try "
                            + "again.");
                }
            }
            
            System.out.print("Enter Message " + i + " (max 250 characters): ");
            String message = scanner.nextLine();
            
            
            if (message.length() > 250) {
                System.out.println("Message too long! Please refrain from using"
                        + " more that 250 Characters.");
                i--; // Retry this iteration
                continue;
            }
            
            if (message.length() < 250){
                System.out.println("1. Send Message");            
                System.out.println("2. Store message to send later");
                System.out.println("Press 0 to delete the message");
                
                String option = scanner.nextLine();
                switch (option){
                case "1": handleSendMessages();
                            break;
                            
                case "2": System.out.println("\nStoring Message");
                    generateIdNumber();
                    break;
                                
                           
                case "3": System.out.println("Returning to previous page");
                    handleSendMessages();
                    break;
                
            }
          
            
            String StoredmessageId = generateIdNumber();{
            System.out.println("Message " + i + " sent to " + recipientNumber +
                    ": \"" + message + "\"");
            System.out.println("Message stored. Message ID: " + StoredmessageId);
            }
            
            String sentMessageId = generateIdNumber();{
            System.out.println("Message " + i + " sent to " + recipientNumber +
                    ": \"" + message + "\"");
            System.out.println("Message stored. Message ID: " + sentMessageId);
            }
        }
    }
    
     
    
}
public String generateIdNumber(){
        StringBuilder idNumber = new StringBuilder();
        for (int i = 0; i < 10; i++){
            idNumber.append(random.nextInt(10));
            }
        return idNumber.toString();
        }
}

