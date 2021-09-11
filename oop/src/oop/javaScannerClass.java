package oop;

import java.util.Scanner;

public class javaScannerClass {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = scanner.nextInt();

        System.out.print("Enter your name: ");
        System.out.print("Enter your age: ");

        System.out.println("Welcome to java programming, " + name);
        System.out.println("Your are " + age + " years old.");

        scanner.close();
    }
}
