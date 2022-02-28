package com.magd;

import java.util.Arrays;
import java.util.Scanner;

public class Email {

    private final String firstName;
    private final String lastName;
    private String password;
    private final String email;
    private String alternateEmail;
    private int mailBoxCapacity = 500;


    // Constructor(firstName,lastName)

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created for " + firstName + " " + lastName);
        // Call a method asking for the department -> return the department
        String department = setDepartment();
        System.out.println("Department = " + department);

        // Call a method that returns a random password
        int defaultPasswordLength = 8;
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        String companySuffix = "company.com";
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + this.email);
    }

    // Ask for department
    private String setDepartment() {
        System.out.println("New worker: " + this.firstName + " " + this.lastName);
        System.out.print("Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code: ");

        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        return switch (depChoice) {
            case 1 -> "sales";
            case 2 -> "dev";
            case 3 -> "acct";
            default -> "";
        };
    }


    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }


    // Set the mailbox capacity
    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\n"
                + "COMPANY EMAIL: " + email + "\n"
                + "MAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }


    public static void main(String[] args) {
        // e.g. firstName = "Ali" , lastName = "Majid"
        Email email = new Email("Ali", "Majid");
        System.out.println(email.showInfo());
    }
}
