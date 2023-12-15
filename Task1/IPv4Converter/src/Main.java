import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {

            System.out.println("""
                    Please, select operation:\s
                    1 - Convert IPv4 to digit form
                    2 - Convert digit to IPv4 form
                    3 - Exit
                    """);

            int operation = scanner.nextInt();
            scanner.nextLine();

            switch (operation) {
                case 1 -> {
                    System.out.println("Please, enter IPv4 address: ");
                    String address = scanner.nextLine();

                    try {
                        System.out.println("The result of converting address" +
                                " in digit form: " + IPv4Converter.convertIPv4ToDigitForm(address) +
                                " and " + IPv4Converter.convertIPv4ToNegativeDigitForm(address));
                    } catch (UnknownHostException exception) {
                        System.err.println("Cannot convert address to digit form: " + exception.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Please, enter digit: ");
                    long digitForm = scanner.nextLong();

                    try {
                        System.out.println("The result of converting digit form" +
                                " in address: " + IPv4Converter.convertDigitFormToIPv4(digitForm));
                    } catch (UnknownHostException exception) {
                        System.err.println("Cannot convert address to digit form: " + exception.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Shutdown. Goodbye!");
                    continueProgram = false;
                    scanner.close();
                }
                default -> System.out.println("Incorrect operation. Please, repeat your choice.");
            }

        }
    }
}