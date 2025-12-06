import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    double amount;
    String category;
    String description;
    String date; 

    Expense(double amount, String category, String description, String date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    void display() {
        System.out.printf("%-10s | %-10s | %-30s | $%.2f\n", date, category, description, amount);
    }
}

public class ExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Spending");
            System.out.println("4. Filter by Category");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    showTotal();
                    break;
                case 4:
                    filterByCategory(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addExpense(Scanner scanner) {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter category (e.g., Food, Travel, Bills): ");
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        expenses.add(new Expense(amount, category, description, date));
        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.printf("%-10s | %-10s | %-30s | Amount\n", "Date", "Category", "Description");
        System.out.println("---------------------------------------------------------------");
        for (Expense exp : expenses) {
            exp.display();
        }
    }

    static void showTotal() {
        double total = 0;
        for (Expense exp : expenses) {
            total += exp.amount;
        }
        System.out.printf("Total spending: ₹%.2f\n", total);
    }

    static void filterByCategory(Scanner scanner) {
        System.out.print("Enter category to filter: ");
        String filter = scanner.nextLine();
        boolean found = false;
        System.out.printf("%-10s | %-10s | %-30s | Amount\n", "Date", "Category", "Description");
        System.out.println("---------------------------------------------------------------");
        for (Expense exp : expenses) {
            if (exp.category.equalsIgnoreCase(filter)) {
                exp.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found for category: " + filter);
        }
    }

}
