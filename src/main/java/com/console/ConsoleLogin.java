package com.console;

import java.io.Console;

/**
 * Created by fz on 2016/3/17.
 */
public class ConsoleLogin {

    public static void main(String[] args) {

        Console console = System.console();
        String username = console.readLine("Enter your username:");
        console.printf("Your username is %s\n", username);
        if (username.equals("fz")) {
            char[] password = console.readPassword("Enter your password:");
            console.printf("Your password is %s\n", new String(password));
        } else {
            console.printf("Username is not present\n");
        }
    }
}
