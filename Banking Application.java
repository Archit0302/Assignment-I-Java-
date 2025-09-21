import java.util.Scanner;

class BankingApplication {
    // Account attributes
    static class Account {
        int accountNumber;
        String accountHolderName;
        double balance;
        String email;
        String phoneNumber;

        Account(int accNum, String name, double bal, String mail, String phone)
        {
            accountNumber = accNum; accountHolderName = name; balance = bal; email = mail; phoneNumber = phone;
        }

        boolean deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Error: Amount must be positive!");
                return false;
            }
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
            return true;
        }

        boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Error: Amount must be positive!");
                return false;
            }
            if (amount > balance) {
                System.out.println("Error: Insufficient balance!");
                return false;
            }
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: $" + balance);
            return true;
        }

        void displayAccountDetails() {
            System.out.println("\n=== Account Details ===");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Name: " + accountHolderName);
            System.out.println("Balance: $" + balance);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phoneNumber);
        }

        void updateContactDetails(String newEmail, String newPhone) {
            if (newEmail.contains("@") && newEmail.contains(".")) email = newEmail;
            if (newPhone.matches("\\d{10,}")) phoneNumber = newPhone;
            System.out.println("Contact details updated!");
        }
    }

    // Application attributes
    static Account[] accounts = new Account[100];
    static int accountCount = 0;
    static Scanner scanner = new Scanner(System.in);
    static int nextAccountNumber = 1001;

    static void createAccount() {
        if (accountCount >= 100) {
            System.out.println("Maximum accounts reached!");
            return;
        }

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter initial deposit amount: ");
        double deposit = getValidAmount();
        if (deposit < 0)
            return;

        System.out.print("Enter email address: ");
        String email = scanner.nextLine().trim();
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid email!");
            return;
        }

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        if (!phone.matches("\\d{10,}")) {
            System.out.println("Invalid phone number!");
            return;
        }

        accounts[accountCount++] = new Account(nextAccountNumber, name, deposit, email, phone);
        System.out.println("Account created successfully with Account Number: " + nextAccountNumber++);
    }

    static void performDeposit() {
        Account acc = getAccount();
        if (acc == null) return;
        System.out.print("Enter amount to deposit: ");
        acc.deposit(getValidAmount());
    }

    static void performWithdrawal() {
        Account acc = getAccount();
        if (acc == null) return;
        System.out.print("Enter amount to withdraw: ");
        acc.withdraw(getValidAmount());
    }

    static void showAccountDetails() {
        Account acc = getAccount();
        if (acc != null) acc.displayAccountDetails();
    }

    static void updateContact() {
        Account acc = getAccount();
        if (acc == null) return;
        System.out.print("Enter new email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter new phone: ");
        String phone = scanner.nextLine().trim();
        acc.updateContactDetails(email, phone);
    }

    static Account getAccount() {
        if (accountCount == 0) { System.out.println("No accounts found!"); return null; }
        System.out.print("Enter account number: ");
        try {
            int accNum = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < accountCount; i++) {
                if (accounts[i].accountNumber == accNum) return accounts[i];
            }
            System.out.println("Account not found!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid account number!");
        }
        return null;
    }

    static double getValidAmount() {
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format!");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking Application!");

        while (true) {
            System.out.println("\n1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": createAccount();
                    break;
                case "2": performDeposit();
                    break;
                case "3": performWithdrawal();
                    break;
                case "4": showAccountDetails();
                    break;
                case "5": updateContact();
                    break;
                case "6":
                    System.out.println("Thank you for using the Banking Application!");
                    scanner.close();
                    return;
                default: System.out.println("Invalid choice! Enter 1-6.");
            }
        }
    }
}