import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShopOperator {
    public static Scanner scan;
    private LinkedList<Item> cart;

    public ShopOperator() { // Activates scan and cart
        scan = new Scanner(System.in);
        cart = new LinkedList<>();
    }

    public void addItem(String itemID) {
        for (Item item : Item.availableItems) {
            if (item.id.equals(itemID)) {
                System.out.print("\t\t\t Enter quantity: ");
                int quantity = scan.nextInt();
                scan.nextLine(); // Clear newline buffer
                if (quantity <= item.stock) {
                    item.quantity = quantity;
                    item.totalAmount = item.price * quantity;
                    item.stock -= quantity;
                    // Only add the item if it doesn't exist in the cart
                    if (!cart.contains(item)) {
                        cart.add(item);
                    }

                } else if (quantity > item.stock) {
                    System.out.println("\t\t\t The quantity you entered exceceds the current stock.");
                    System.out.print("\n\t\t\t<===== Press Enter to try again . . .");
                    scan.nextLine();  // Wait for user to press Enter
                } else {
                    System.out.println("\t\t\t The item has no stock left.");
                    System.out.print("\n\t\t\t<===== Press Enter to try again . . .");
                    scan.nextLine();  // Wait for user to press Enter
                }
                return;
            }
        }
        System.out.println("\t\t\t Item is not found.");
        System.out.print("\n\t\t\t<===== Press Enter to try again . . .");
        scan.nextLine();  // Wait for user to press Enter
    }

    // Returns true if item is deleted from cart, else false
    boolean deleteItem(String itemID){
        boolean isDeleted = false;
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i); // Create Item variable for better readability
            if (item.id.equals(itemID)) {
                // Before removing the item, we need to put the qty back in the stock
                item.stock += item.quantity;
                item.quantity = 0;
                item.totalAmount = 0;
                cart.remove(i);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    public void searchItem(String searchedItem) {
        // Based on item.id
        for(Item item : Item.availableItems) {
            if (item.id.equals(searchedItem)) {
                System.out.printf("%-5s %-25s %-15s %-15s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Stock");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.printf("%-5s %-25s %-15s %-15s %-10.2f %-10d\n", item.id, item.name, item.description, item.type.name(), item.price, item.stock);
                return;
            }
        }

        // Based on item.name
        System.out.printf("%-5s %-25s %-15s %-15s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Stock");
        System.out.println("------------------------------------------------------------------------------------");
        for (Item item : Item.availableItems) {
            // (?i) - means case insensitive
            // .* - matches any character (.) zero or more times (*), meaning it can match anything before and after the searched item.
            // %s - format delimiter or placeholder for String type
            // Basically the pattern checks if searchedItem appears anywhere in a string, ignoring case.
            String regexPattern = String.format("(?i).*%s.*", searchedItem);
            if (item.name.matches(regexPattern)) {
                System.out.printf("%-5s %-25s %-15s %-15s %-10.2f %-10d\n", item.id, item.name, item.description, item.type.name(), item.price, item.stock);
            }
        }
    }


    public boolean displayTransaction(boolean isSeniorOrPWD) {
        if (cart.isEmpty()) {
            System.out.println("\n\t\t\t. . NO ITEMS ARE IN THE CART . .");
            return false;
        }

        double subTotal = 0;
        double discount = 0;
        String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
        String formattedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\n\t\t\t Cart2Go - Receipt\n");
        System.out.println("\t\t\t Date: " + formattedDate);
        System.out.println("\t\t\t Time: " + formattedTime);
        System.out.println("\t\t\t Items Purchased: " + cart.size() + "\n");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-25s %-15s %-10s %-10s %-10s\n", "Name", "Description", "Price", "Quantity", "Total");
        System.out.println("--------------------------------------------------------------------------");
        // Summation of amount of items
        for (Item item : cart) {
            System.out.printf("%-25s %-15s %-10.2f %-10d %-10.2f\n",
                                item.name,
                                item.description,
                                item.price,
                                item.quantity,
                                item.totalAmount
                            );
            subTotal += item.totalAmount;
        }
        System.out.println("--------------------------------------------------------------------------");

        // Calculate VAT, Discount, Total, and Change
        double VAT = subTotal * 0.12;
        if (isSeniorOrPWD) {
            discount = subTotal * 0.10;
        }
        double total = (subTotal + VAT) - discount;

        System.out.printf("\n\t\t Subtotal....................: PHP %.2f", subTotal);
        System.out.printf("\n\t\t VAT (12%%)...................: PHP %.2f", VAT);
        System.out.printf("\n\t\t Discount....................: PHP %.2f", discount);
        System.out.printf("\n\t\t Total.......................: PHP %.2f", total);

        // Payment time
        System.out.print("\n\n\t\t Payment.....................: PHP ");
        double payment = scan.nextDouble();
        scan.nextLine(); // Clear newline buffer
        if(payment < total){
            System.out.println("\n\t\t Insufficient Funds. Pay with exact amount or more.");
            return false;
        }

        System.out.println("\n\t\t\t Payment Successful!");
        double change = payment - total;
        System.out.printf("\n\t\t Change.......................: PHP %.2f", change);
        System.out.println("\n\n\t\t --- Thanks for Shopping @ Cart2Go! --- \n");
        System.out.println("--------------------------------------------------------------------------");
        return true;
    }


    public void displayCart() {
        if (cart.size() == 0) {
            System.out.println("\n\n\t\t\t. . NO ITEMS ARE IN THE CART . .");
            return;
        }
        System.out.printf("%-5s %-25s %-15s %-15s %-10s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Quantity", "Total");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Item item : cart) {
            System.out.printf("%-5s %-25s %-15s %-15s %-10.2f %-10d %-10.2f\n",
                                item.id,
                                item.name,
                                item.description,
                                item.type.name(),
                                item.price,
                                item.quantity,
                                item.totalAmount
                            );
        }
   }

   public void resetCart() {
       // Reset quantity and totalAmount fields before clearing...
       for (Item item : cart) {
            item.quantity = 0;
            item.totalAmount = 0;
       }
       cart.clear();
   }
}
