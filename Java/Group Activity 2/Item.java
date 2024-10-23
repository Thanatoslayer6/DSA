import java.util.LinkedList;

public class Item {
    public static enum Category {
        FRUITS,
        VEGETABLES,
        DAIRY,
        MEAT,
        BAKERY,
        BEVERAGES,
        SNACKS,
        CONDIMENTS,
    };

    public String id, name, description;
    public Category type;
    public double price;
    public int stock;
    public static LinkedList<Item> availableItems;

    // Constructor
    public Item() {
        availableItems = new LinkedList<>();
    }

    // Overload the constructor if parameters are passed
    public Item(String id, String name, String description, Category type, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public void displayAllItems() {
        System.out.printf("%-5s %-25s %-15s %-15s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Stock");
        System.out.println("------------------------------------------------------------------------------------");
        for (Item item: availableItems) {
            System.out.printf("%-5s %-25s %-15s %-15s %-10.2f %-10d\n", item.id, item.name, item.description, item.type.name(), item.price, item.stock);
        }
    }

    public void displayItemsInCategory(int type) {
        //System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Stock");
        System.out.printf("%-5s %-25s %-15s %-15s %-10s %-10s\n", "Id", "Name", "Description", "Category", "Price", "Stock");
        System.out.println("------------------------------------------------------------------------------------");
        for (Item item : availableItems) {
            if (item.type.ordinal() == type) {
                //System.out.printf("%-10s %-15s %-15s %-10s %-9.2f %-9.2d", item.id, item.name, item.description, item.type.name(), item.stock);
                System.out.printf("%-5s %-25s %-15s %-15s %-10.2f %-10d\n", item.id, item.name, item.description, item.type.name(), item.price, item.stock);
            }
        }
    }

    public void initializeItems() {
        // Fruits
        availableItems.add(new Item("F01", "Apple", "6pcs pack", Category.FRUITS, 209.0, 75));
        availableItems.add(new Item("F02", "Lemon", "6pcs pack", Category.FRUITS, 139, 30 ));
        availableItems.add(new Item("F03", "Grapes", "1kg", Category.FRUITS, 479, 51 ));
        availableItems.add(new Item("F04", "Banana", "1kg", Category.FRUITS, 99, 29 ));
        availableItems.add(new Item("F05", "Watermelon", "1 whole-sized", Category.FRUITS, 139, 13 ));
        // Vegetables
        availableItems.add(new Item("V01", "Onion","500g", Category.VEGETABLES, 42, 201 ));
        availableItems.add(new Item("V02", "Tomato","500g", Category.VEGETABLES, 99, 98 ));
        availableItems.add(new Item("V03", "Broccoli","each", Category.VEGETABLES, 220, 76 ));
        availableItems.add(new Item("V04", "Carrot","500g", Category.VEGETABLES, 119, 41 ));
        availableItems.add(new Item("V05", "Cabbage","600g-700g", Category.VEGETABLES, 119, 41 ));
        // Dairy
        availableItems.add(new Item("D01", "Fresh Eggs","3 dozen", Category.DAIRY, 295, 56 ));
        availableItems.add(new Item("D02", "Evaporated Milk","370mL", Category.DAIRY, 34.95, 110 ));
        availableItems.add(new Item("D03", "Buttermilk (Salted)","200g", Category.DAIRY, 60.50, 89 ));
        availableItems.add(new Item("D04", "Filled Cheese","430g", Category.DAIRY, 145, 45 ));
        availableItems.add(new Item("D05", "Fresh Milk","1L", Category.DAIRY, 99.50, 42 ));
        // Meat,
        availableItems.add(new Item("M01", "Chicken Breast Fillet","500g-550g", Category.MEAT, 164.45, 99 ));
        availableItems.add(new Item("M02", "Pork Chop", "400g-500g", Category.MEAT, 142.50, 80 ));
        availableItems.add(new Item("M03", "Chicken (Liver)","250g-300g", Category.MEAT, 55.20, 70 ));
        availableItems.add(new Item("M04", "Chicken (Wings)","500g-550g", Category.MEAT, 103.95, 50 ));
        availableItems.add(new Item("M05", "Beef (Cubes)","1kg", Category.MEAT, 207.35, 41 ));
        // Bakery,
        availableItems.add(new Item("B01", "White Bread","450g", Category.BAKERY, 54, 55 ));
        availableItems.add(new Item("B02", "Cheese Bread","120g", Category.BAKERY, 43, 35 ));
        availableItems.add(new Item("B03", "Pancake","500g", Category.BAKERY, 94.50, 101 ));
        availableItems.add(new Item("B04", "Cupcake","10pcs.", Category.BAKERY, 82.50, 72 ));
        availableItems.add(new Item("B05", "All Purpose Breading Mix","65g", Category.BAKERY, 11.50, 209 ));
        // Beverages,
        availableItems.add(new Item("E01", "Coca-Cola Coke","1.5L", Category.BEVERAGES, 61, 203 ));
        availableItems.add(new Item("E02", "Sprite","1.5L", Category.BEVERAGES, 61, 179 ));
        availableItems.add(new Item("E03", "Royal","1.5L", Category.BEVERAGES, 61, 150 ));
        availableItems.add(new Item("E04", "Root Beer","1.5L", Category.BEVERAGES, 61, 301 ));
        availableItems.add(new Item("E05", "C2 Green Tea Apple","1L", Category.BEVERAGES, 56.50, 237 ));
        availableItems.add(new Item("E06", "Zesto","200mL", Category.BEVERAGES, 9.50, 155 ));
        // Snacks,
        availableItems.add(new Item("S01", "Stick-O ","380g", Category.SNACKS, 84.50, 88 ));
        availableItems.add(new Item("S02", "VCut Potato Chips ","25g", Category.SNACKS, 19.50, 51 ));
        availableItems.add(new Item("S03", "Leslie Cheezy","70g", Category.SNACKS, 31.50, 91 ));
        availableItems.add(new Item("S04", "Dewberry ","33g (10pcs.)", Category.SNACKS, 85.50, 89 ));
        availableItems.add(new Item("S05", "Pringles ","107g", Category.SNACKS, 92.50, 144 ));
        // Condiments
        availableItems.add(new Item("C01", "Fish Sauce","1L", Category.CONDIMENTS, 67.50, 48 ));
        availableItems.add(new Item("C02", "Soy Sauce","1L", Category.CONDIMENTS, 67.50, 92 ));
        availableItems.add(new Item("C03", "Knor Liquid Seasoning","250mL", Category.CONDIMENTS, 102.50, 112 ));
        availableItems.add(new Item("C04", "Iodized Salt","150g", Category.CONDIMENTS, 13.50, 89 ));
        availableItems.add(new Item("C05", "Vinegar","1L", Category.CONDIMENTS, 40, 142 ));
    }

}