import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("       BANK ACCOUNT SIMULATION");
        System.out.println("====================================");

        String name = readNonEmptyName("Enter account holder name: ");
        double initialBalance = readAmount("Enter initial balance (Rs.): ", true);
        BankAccount account = new BankAccount(name, initialBalance);

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInteger("Enter your choice (1-5): ");
            switch (choice) {
                case 1:
                    account.deposit(readAmount("Enter amount to deposit (Rs.): ", false));
                    break;
                case 2:
                    account.withdraw(readAmount("Enter amount to withdraw (Rs.): ", false));
                    break;
                case 3:
                    System.out.printf("%nAccount holder: %s%nCurrent balance: Rs. %.2f%n",
                            account.getAccountHolder(), account.getBalance());
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using Bank Account Simulation. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 5.");
            }
        }
        SCANNER.close();
    }

    private static void showMenu() {
        System.out.println("\n--------------- MENU ---------------");
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Check balance");
        System.out.println("4. View transaction history");
        System.out.println("5. Exit");
        System.out.println("------------------------------------");
    }

    private static String readNonEmptyName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = SCANNER.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Name cannot be empty. Please try again.");
        }
    }

    private static int readInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static double readAmount(String prompt, boolean allowZero) {
        while (true) {
            System.out.print(prompt);
            try {
                double amount = Double.parseDouble(SCANNER.nextLine().trim());
                if (!Double.isFinite(amount) || amount < 0 || (!allowZero && amount == 0)) {
                    System.out.println(allowZero
                            ? "Enter a valid amount of Rs. 0 or more."
                            : "Enter a valid amount greater than Rs. 0.");
                    continue;
                }
                return amount;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid amount. Please enter a number, e.g. 500 or 250.50.");
            }
        }
    }
}
