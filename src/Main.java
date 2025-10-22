import java.util.Scanner;

public class Main {
    static double balance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWelcome to our Banking System:");
            System.out.println("1. Show balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Exit");
            System.out.print("Option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number between 1 and 4.");
                scanner.next();
                continue;
            }

            int option = scanner.nextInt();

            switch (option) {
                case 1 -> showBalance();
                case 2 -> deposit(scanner);
                case 3 -> withdraw(scanner);
                case 4 -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Please choose a valid option (1-4).");
            }
        }

        scanner.close();
    }

    public static void showBalance() {
        System.out.println("Your balance is $" + balance);
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter the amount you want to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount you want to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Not enough money! Current balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        }
    }
}
