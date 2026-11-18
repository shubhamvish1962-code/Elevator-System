import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        while (true) {
            System.out.println("\n=== ELEVATOR MANAGEMENT SYSTEM ===");
            System.out.println("1. Show Elevator Status");
            System.out.println("2. New Request");
            System.out.println("3. Show All Requests");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("\n--- ELEVATOR STATUS ---");
                    controller.showElevatorStatus();
                } else if (choice == 2) {
                    System.out.print("Enter From Floor (0 - 5): ");
                    int fromFloor = scanner.nextInt();

                    System.out.print("Enter To Floor (0 - 5): ");
                    int toFloor = scanner.nextInt();

                    System.out.print("Enter Weight (kg): ");
                    int weight = scanner.nextInt();

                    System.out.print("Enter Request Type (PERSON or GOODS): ");
                    String requestType = scanner.next();

                    Request req = new Request(fromFloor, toFloor, weight, requestType);
                    controller.processRequest(req);
                } else if (choice == 3) {
                    System.out.println("\n--- ALL REQUESTS ---");
                    controller.showAllRequests();
                } else if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Please enter a whole number within the integer range.");
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("\nInput ended. Exiting...");
                break;
            } catch (InvalidFloorException | OverloadException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
