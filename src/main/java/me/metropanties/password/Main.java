package me.metropanties.password;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Password length:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int length = scanner.nextInt();

            System.out.println("Use symbols:");
            boolean useSymbols = scanner.nextBoolean();

            PasswordGenerator generator = new PasswordGenerator(length, useSymbols);
            String password = generator.generate();
            try {
                generator.save(password);
                System.out.println("Password generated!");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
