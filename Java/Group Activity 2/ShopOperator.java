import java.util.LinkedList;
import java.util.Scanner;

public class ShopOperator {
    public LinkedList<Item> cart;
    public Scanner scan;
    public ShopOperator() {
        scan = new Scanner(System.in);
        cart = new LinkedList<>();
    }

    public void addItem(String itemID) {
        for (Item item : Item.availableItems) {
            if (item.id.equals(itemID)) {
                System.out.print("\t\t\t Enter quantity: ");
                int quantity = scan.nextInt(); 
                if (quantity <= item.stock) {
                    item.quantity = quantity;
                    item.totalAmount = item.price * quantity;
                    item.stock -= quantity;
                    // Only add the item if it doesn't exist in the cart
                    if (!cart.contains(item)) { 
                        cart.add(item);
                    }
                    scan.nextLine();
                } else if (quantity > item.stock) {
                    System.out.println("\t\t\t The quantity you entered exceceds the current stock of the item. Please enter a quantity that is");
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
            if (cart.get(i).id.equals(itemID)) {
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
                // TODO: Formatting
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
            // %s - format delimiter for String type
            // TODO: Explain regex pattern
            String pattern = String.format("(?i).*%s.*", searchedItem); // THIS PATTERN IS INSANE IT WORKS!
            if (item.name.matches(pattern)) {
                System.out.printf("%-5s %-25s %-15s %-15s %-10.2f %-10d\n", item.id, item.name, item.description, item.type.name(), item.price, item.stock);
            }
        } 
        //System.out.println("The item is unavailable/doesn't exist.");
    }

    
    public boolean calculateTransaction() {

        if (cart.isEmpty()) {
            System.out.println("\n\t\t ~ Saars, please puts ze items ze carts - Rene Descartes ~");
            return false;
        }

        double totalamount = 0;
        String isSenior;
        double discount = 0;
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.print("\n\t\t\t Is the customer a Senior Citizen or PWD? (YES/NO): ");
        isSenior = scan.nextLine();

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t Receipt of the Items: \n");
        System.out.printf("%-5s %-25s %-15s %-15s %-10s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Quantity", "Total Amount");
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
            totalamount += item.totalAmount;
        }

        // Discounts
        double vat = totalamount * 0.12;
        if (isSenior.equalsIgnoreCase("YES")) {
            discount = totalamount * 0.10;
        }
        double finalamount = (totalamount + vat) - discount;

        System.out.println("\n\t\t\t Total Amount: " + totalamount + "php");
        System.out.println("\t\t\t VAT (12%): " + vat + "php");
        System.out.println("\t\t\t Discount: " + discount + "php");
        System.out.println("\t\t\t Final Amount: " + finalamount + "php");
        
        //payment time
        System.out.print("\n\n\t\t\t Enter Payment: ");
        double customerPayment = scan.nextDouble();
        scan.nextLine();
        if(customerPayment < finalamount){
            System.out.println("\t\t\t Insufficient Funds. Pay with exact amount or more.");
            return false;
        } 

        System.out.println("\t\t\t Payment Complete!");
        double change = customerPayment - finalamount;
        System.out.println("\t\t\t Total Change: " + change);
        System.out.println("\t\t\t Thanks for Shopping @ Cart2Go ");
        return true;
    }


    public void displayCart() {
        if (cart.size() == 0) {
            System.out.println("\n\n\t\t\t. . NO ITEMS ARE IN THE CART . .");
            return;
        }
        // TODO: Remove 'stock' // last column shud be quantity, total, hmmm, how to get quantity  // should we continue tomorr //  i will leave this to Rico frfr he will do ta        
        System.out.printf("%-5s %-25s %-15s %-15s %-10s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Quantity", "Total Amount");
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
}