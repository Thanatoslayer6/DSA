public class GA02ProblemTwo {
    public static void main(String[] args) {
        ShopOperator op = new ShopOperator();
        Item item = new Item();

        while (true) {
            displayOptions(true, "Welcome to Cart2Go",new String[]{
                "%-20s 1.) DISPLAY ITEMS (All or Based on Category)\n",
                "%-20s 2.) SHOW CART (Add or Delete Items)\n",
                "%-20s 3.) SEARCH ITEM (Based on ID or Name)\n",
                "%-20s 4.) CHECKOUT\n",
                "%-20s 5.) EXIT\n",
            });
            int userInput = prompt("\t\t\t Select a number [1-5]: ", 1, 5);
            if (userInput == 1) { // Display Items
                while(true) {
                    clearScreen();
                    displayOptions(true, "   Display Items  ", new String[]{
                        "%-20s 1.) ALL ITEMS\n",
                        "%-20s 2.) ITEMS BASED ON CATEGORY\n",
                        "%-20s 3.) BACK\n"
                    });
                    userInput = prompt("\t\t\t Select a number [1-3]: ", 1, 3);
                    if (userInput == 1) {
                        clearScreen();
                        item.displayAllItems();
                        System.out.print("\n\t\t\t<===== Press Enter to go back . . .");
                        ShopOperator.scan.nextLine();  // Wait for user to press Enter
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
                        ShopOperator.scan.nextLine();  // Wait for user to press Enter
                    } else if (userInput == 3) {
                        clearScreen();
                        break;
                    }
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
                        String itemId = ShopOperator.scan.nextLine();
                        op.addItem(itemId);
                        continue;
                    } else if (userInput == 2) {
                        System.out.print("\t\t\t Enter Item ID to be deleted on the cart: ");
                        String itemId = ShopOperator.scan.nextLine();
                        if (op.deleteItem(itemId)) {
                            System.out.printf("\t\t\t [Item %s] successfully removed from the cart", itemId);
                            continue;
                        }
                        System.out.printf("\t\t\t [Item %s] failed to remove item from cart", itemId);
                    } else if (userInput == 3) {
                        clearScreen();
                        break;
                    }
                }
            } else if (userInput == 3) { // Search item
                boolean didUserAddItem = false;
                String itemNameOrId = "", itemId = "";
                while(true) {
                    if (didUserAddItem == false) {
                        System.out.printf("\t\t\t Enter Item Name/Item ID: ");
                        itemNameOrId = ShopOperator.scan.nextLine();
                    }
                    clearScreen();
                    op.searchItem(itemNameOrId);
                    displayOptions(false, " Search All Items ", new String[]{
                        "%-20s 1.) PERFORM SEARCH QUERY\n",
                        "%-20s 2.) ADD ITEM TO CART\n",
                        "%-20s 3.) BACK\n",
                    });
                    userInput = prompt("\t\t\t Select a number [1-3]: ", 1, 3);
                    if (userInput == 1) {
                        didUserAddItem = false;
                        continue;
                    } else if (userInput == 2) {
                        System.out.print("\t\t\t Enter Item ID to be added on the cart: ");
                        itemId = ShopOperator.scan.nextLine();
                        op.addItem(itemId);
                        didUserAddItem = true;
                        continue;
                    } else if (userInput == 3) {
                        clearScreen();
                        break;
                    }
                }
            } else if (userInput == 4) { // Checkout
                System.out.print("\t\t Is the customer a Senior Citizen or PWD? (YES/NO): ");
                boolean isSeniorOrPWD = (ShopOperator.scan.nextLine()).equalsIgnoreCase("YES");  
                clearScreen();
                if (op.displayTransaction(isSeniorOrPWD)) {
					System.out.print("\n\t\t\t Press Enter to proceed =====> ");
					ShopOperator.scan.nextLine();
                    op.resetCart();
					clearScreen();
                    continue;
                }
                System.out.print("\n\t\t\t<===== Press Enter to go back . . .");
                ShopOperator.scan.nextLine();  // Wait for user to press Enter
                clearScreen();
            } else if (userInput == 5) { // Exit
            	clearScreen();
                displayOptions(true, "Thanks for Shopping", new String[]{"%-35s Goodbye."});
                break;
            }
        }
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
        // Banner message should be exactly 18 characters for the design to be symmetrical
        System.out.println("\n\n\t===================== " + bannerMessage + " ========================\n");
        for (String element: options) {
            System.out.printf(element, " ");
        }
        System.out.println("\n\t=================================================================\n");
	}

	// Useful method for easily getting user input
	public static int prompt(String text, int minimum, int maximum) {
		while (true) {
		    System.out.print(text);
			int number = ShopOperator.scan.nextInt();
            ShopOperator.scan.nextLine(); // Clear newline buffer
			if (number < minimum || number > maximum) {
				System.out.printf("\t\t\t ERROR! Please enter range between %d-%d!\n", minimum, maximum);
				continue;
			}
			return number;
		}
	}
}
