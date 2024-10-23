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
                    item.stock -= quantity;
                    double amount = item.price * quantity;
                    cart.add(item);
                    //System.out.println("\t\t\t Added to cart " + quantity + "x" + item.description);
                } else {
                    System.out.println("\t\t\t The item has no stock left.");
                }
                return;
            }
        }
        System.out.println("\t\t\t Item is not found.");
    }

    // Returns true if item is deleted from cart, else false
    boolean deleteItem(String itemID){
        boolean isDeleted = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(itemID)) {
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
                System.out.println("Item is available " + item.name);
                return;
            }
        }

        // Based on item.name
        for (Item item : Item.availableItems) {
            // (?i) - means case insensitive
            // ^ - means start of string
            // %s - format delimiter for String type
            // + - one or more of the preceeding element
            //String pattern = String.format("(?i)^%s?.+", searchedItem); // this marreplace yung %s ng searchedItem
            // TODO: Explain regex pattern
            String pattern = String.format("(?i).*%s.*", searchedItem); // THIS PATTERN IS INSANE IT WORKS!
            // System.out.println(pattern);

            // TODO: Formatting
            if (item.name.matches(pattern)) { // this is endgame now, aight final pattern....
                System.out.println("\t\t\t Item -> " + item.name);
            }
        }
        
        //System.out.println("The item is unavailable/doesn't exist.");
    }

    public void calculateTransaction() {

        double totalamount = 0;
        String isSenior;
        double discount = 0;

        System.out.println("Is the customer a Senior Citizen or PWD? (YES/NO): ");
        isSenior = scan.nextLine();
        System.out.println("Receipt of the Items: ");
        for (Item item : cart) {
            System.out.println(item.description + item.price);
            totalamount += item.price;
        }

        // Discounts
        double vat = totalamount * 0.12;
        if (isSenior.equalsIgnoreCase("YES")) {
            discount = totalamount * 0.10;
        }
        double finalamount = (totalamount + vat) - discount;

        System.out.println("Total Amount: " + totalamount + "php");
        System.out.println("VAT (12%): " + vat + "php");
        System.out.println("Discount: " + discount + "php");
        System.out.println("Final Amount: " + finalamount + "php");
    }

    public void displayCart() {
        if (cart.size() == 0) {
            System.out.println("\n\n\t\t\t. . NO ITEMS ARE IN THE CART . .");
            return;
        }
        // what heppend 
        // TODO: Remove 'stock' // last column shud be quantity, total, hmmm, how to get quantity  // should we continue tomorr //  i will leave this to Rico frfr he will do ta        
        System.out.printf("%-5s %-25s %-15s %-15s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Quantity", "Amount");
        System.out.println("------------------------------------------------------------------------------------");
        for (Item item : cart) {
            // TODO: Proper output sa quantity and total columns
            System.out.printf("%-5s %-25s %-15s %-15s %-10.2f %-10d\n", item.id, item.name, item.description, item.type.name(), 2);
        }      
   }
}
// i will send whole private repo go github doood, para marun mo ung activity

// formatting sa #2 and #3, tas checkout kulang yeppp
// checkout nalang ba kulang??????