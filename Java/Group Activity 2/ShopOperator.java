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

    public void searchItem(String itemID) {
        //System.out.println("Enter Item ID to search on the cart: ");
        //String itemName = scanner.nextLine();
        // Base to sa itemID
        for(Item item : Item.availableItems) {
            if (item.id.equals(itemID)) {
                System.out.println("Item has been found on the cart " + item);
            }
        }
        // Base sa name
        for (Item item: Item.availableItems) {
            if (item.name.)
        }
        
        System.out.println("The item is not found on the cart.");
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
        // TODO: Remove 'stock'
        System.out.printf("%-5s %-30s %-30s %-15s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Stock");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Item item : cart) {
            System.out.printf("%-5s %-30s %-30s %-15s %-9.2f %-9d\n", item.id, item.name, item.description, item.type.name(), item.price, item.stock);
        }      
    }
}