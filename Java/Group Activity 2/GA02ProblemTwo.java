import java.util.Scanner;

public class GA02ProblemTwo {
	public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ShopOperator op = new ShopOperator();
        Item item = new Item();
        item.initializeItems();
    
        displayOptions(true, "Welcome to Cart2Go",new String[]{
            "%-20s 1.) DISPLAY ITEMS (All or Based on Category)\n", 
		    "%-20s 2.) SHOW CART (Add or Delete Items)\n",
            "%-20s 3.) SEARCH ITEM (Based on Id or Name)\n",
            "%-20s 4.) CHECKOUT\n",
            "%-20s 5.) EXIT\n",
        });
		int userInput = prompt("\t\t\t Select a number [1-5]: ", 1, 5);
		if (userInput == 1) { // Display Items
            clearScreen();
            displayOptions(true, "   Display Items  ", new String[]{
                "%-20s 1.) ALL ITEMS\n",
                "%-20s 2.) ITEMS BASED ON CATEGORY\n"
            });
			userInput = prompt("\t\t\t Select a number [1-2]: ", 1, 2);
			if (userInput == 1) {
                clearScreen();
				item.displayAllItems();
                System.out.print("\n\t\t\t<===== Press Enter to go back . . .");
                scan = new Scanner(System.in);
                scan.nextLine();  // Wait for user to press Enter
			} else if (userInput == 2) {
                clearScreen();
                displayOptions(true, "Select a Category ", new String[]{
                    "%-20s 1.) FRUITS\n",
                    "%-20s 2.) VEGETABLES\n",
                    "%-20s 3.) DAIRY\n",
                    "%-20s 4.) MEAT\n",
                    "%-20s 5.) BAKERY\n",
                    "%-20s 6.) BEVERAGES\n",
                    "%-20s 7.) SNACKS\n",
                    "%-20s 8.) CONDIMENTS\n",
                });
                userInput = prompt("\t\t\t Select a number [1-8]: ", 1, 8);
                clearScreen();
                item.displayItemsInCategory(userInput - 1);
                System.out.print("\n\t\t\t<===== Press Enter to go back . . .");
                scan = new Scanner(System.in);
                scan.nextLine();  // Wait for user to press Enter
			}
		} else if (userInput == 2) { // Show cart
            while (true) {
                clearScreen();
                op.displayCart();
                displayOptions(false, "Select Cart Option", new String[]{
                    "%-20s 1.) ADD ITEM TO CART\n",
                    "%-20s 2.) DELETE ITEM IN CART\n",
                    "%-20s 3.) BACK\n"
                });
                userInput = prompt("\t\t\t Select a number [1-3]: ", 1, 3);
                if (userInput == 1) {
                    System.out.print("\t\t\t Enter Item ID to be added on the cart: ");
                    String itemId = scan.nextLine();
                    op.addItem(itemId);
                    continue;
                } else if (userInput == 2) {
                    System.out.print("\t\t\t Enter Item ID to be deleted on the cart: ");
                    String itemId = scan.nextLine();
                    if (op.deleteItem(itemId)) {
                        System.out.printf("\t\t\t [Item %s] successfully removed from the cart", itemId);
                        continue;
                    }
                    System.out.printf("\t\t\t [Item %s] failed to remove item from cart", itemId);
                } else if (userInput == 3) {
                    break;
                }
            }
		} else if (userInput == 3) { // Search item
            System.out.printf("\t\t\t Enter Item Name/Item ID: ");  
            String itemNameOrId = scan.nextLine();
            while(true) {
                clearScreen();
                op.searchItem(itemNameOrId); 
                displayOptions(false, " Search All Items ", new String[]{
                    "%-20s 1.) PERFORM SEARCH QUERY\n",
                    "%-20s 2.) BACK\n",
                });
                userInput = prompt("\t\t\t Select a number [1-2]: ", 1, 2);
                if (userInput == 1) {
                    System.out.printf("\t\t\t Enter Item Name/Item ID: ");  
                    itemNameOrId = scan.nextLine();
                } else if (userInput == 2) {
                    break;
                }
            }


		} else if (userInput == 4) { // Checkout

		} else if (userInput == 5) { // Exit
			System.out.printf("\n%-20s EXITING PROGRAM THANK YOU :D\n\n", " ");
			System.exit(0);
		}

		          // 1.) Show Items
		                 // 1 - Display All Items
		                 // 2 - Show Items based on Category
		                     // - Select a Category
		                        // 1. Fruits
		                        // ....
		            // 2.) Show Cart
		                 // 1 - Add item
		                 // 2 - Delete item
		            // 3.) Search Item
		            // 4.) Checkout
            // 5.) Exit


        //System.out.println("Choose Category: ");
        //System.out.println("1. Fruits\n2. Vegetables")
        //int list = scan.nextInt();

        /*
        switch(list - 1){
            case Item.Category.FRUITS: // 0
                // Siguro parang ganito
                Item.displayItemsInCategory(Item.Category.FRUITS);
                break;
            case Item.Category.VEGETABLES:
                Item.displayItemsInCategory(Item.Category.Fruits);
                break;
            case Item.Category.DAIRY:

            case Item.Category.MEAT:

            case Item.Category.BAKERY:

            case Item.Category.BEVERAGES:

            case Item.Category.SNACKS:

            case Item.Category.CONDIMENTS:
        }*/
            // 1.) Show Items
                 // 1 - Display All Items
                 // 2 - Show Items based on Category
                     // - Select a Category
                        // 1. Fruits
                        // ....
            // 2.) Show Cart
                 // 1 - Add item
                 // 2 - Delete item
            // 3.) Search Item
            // 4.) Checkout 
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Clear screen for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Clear screen for Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }

    public static void displayOptions(boolean showBanner, String bannerMessage, String[] options) {
        if (showBanner) {
            System.out.println("\n\n\tMM'\"\"\"'YMMM                     dP   d8888b. MM'\"\"\"\"\"`MM");
            System.out.println("\tM' .mmm. `M                     88       `88 M' .mmm. `M          ");
            System.out.println("\tM  MMMMMooM .d8888b. 88d888b. d8888P .aaadP' M  MMMMMMMM .d8888b. ");
            System.out.println("\tM  MMMMMMMM 88'  `88 88'  `88   88   88'     M  MMM   `M 88'  `88 ");
            System.out.println("\tM. `MMM' .M 88.  .88 88         88   88.     M. `MMM' .M 88.  .88 ");
            System.out.println("\tMM.     .dM `88888P8 dP         dP   Y88888P MM.     .MM `88888P' ");
            System.out.println("\tMMMMMMMMMMM                                  MMMMMMMMMMM          ");
        }
        // Banner message should be exactly 18 characters...
        System.out.println("\n\n\t===================== " + bannerMessage + " ========================\n");
        for (String element: options) {
            System.out.printf(element, " ");
        }
        System.out.println("\n\t=================================================================\n");
	}

	// Useful method for easily getting user input
	public static int prompt(String text, int minimum, int maximum) {
		System.out.print(text);
		while (true) {
			int number = scan.nextInt();
			if (number < minimum || number > maximum) {
				System.out.printf("\t\t\t ERROR! Please enter range between %d-%d!\n", minimum, maximum);
				System.out.print(text);
				continue;
			}
            scan.nextLine(); // Clears newline buffer
			return number;
		}
	}
}