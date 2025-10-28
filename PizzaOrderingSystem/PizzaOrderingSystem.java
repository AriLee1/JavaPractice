import java.util.ArrayList;
import java.util.Scanner;

//This is for basic definition of product.
class Product {
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() { // basiclly, just return the names of product. I will do override.
        return name;
    }
}

// Pizza classes (There are Cheese,Pepperoni, MorelMushroom)
class Pizza extends Product {
    private String size;

    public Pizza(String size) {
        super();
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

class CheesePizza extends Pizza {
    public CheesePizza(String size) { // adjusting the price as the size
        super(size);
        setName("Cheese Pizza");
        if (size.equalsIgnoreCase("Small")) {
            setPrice(8.99);
        } else if (size.equalsIgnoreCase("Medium")) {
            setPrice(10.99);
        } else if (size.equalsIgnoreCase("Large")) {
            setPrice(12.99);
        }
    }

    @Override
    public String getDescription() {
        return getSize() + " " + getName();
    }
}

class PepperoniPizza extends Pizza {
    public PepperoniPizza(String size) {
        super(size);
        setName("Pepperoni Pizza");
        if (size.equalsIgnoreCase("Small")) {
            setPrice(9.99);
        } else if (size.equalsIgnoreCase("Medium")) {
            setPrice(11.99);
        } else if (size.equalsIgnoreCase("Large")) {
            setPrice(13.99);
        }
    }

    @Override
    public String getDescription() {
        return getSize() + " " + getName();
    }
}

class MorelMushroomPizza extends Pizza {
    public MorelMushroomPizza(String size) {
        super(size);
        setName("Morel Mushroom Pizza");
        if (size.equalsIgnoreCase("Small")) {
            setPrice(12.99);
        } else if (size.equalsIgnoreCase("Medium")) {
            setPrice(14.99);
        } else if (size.equalsIgnoreCase("Large")) {
            setPrice(16.99);
        }
    }

    @Override
    public String getDescription() {
        return getSize() + " " + getName();
    }
}

// Drink classes (Rootbeer,dietcoke,fanta )
class Drink extends Product {
    private boolean hasIce; // check if there's ice
    private String flavor; // save what flavor

    public Drink() {
        super();
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public boolean hasIce() {
        return hasIce;
    }

    public void setIce(boolean hasIce) {
        this.hasIce = hasIce;
    }
}

class Fountain extends Drink {
    public Fountain(String flavor, boolean hasIce) {
        setFlavor(flavor);
        setIce(hasIce);
        setPrice(2.50);

        // Set the name based on the flavor.
        if (flavor.equalsIgnoreCase("RootBeer")) {
            setName("Root Beer Fountain Drink");
        } else if (flavor.equalsIgnoreCase("DietCoke")) {
            setName("Diet Coke Fountain Drink");
        } else if (flavor.equalsIgnoreCase("Fanta")) {
            setName("Fanta Fountain Drink");
        } else {
            setName(flavor + " Fountain Drink");
        }
    }

    @Override // check ice
    public String getDescription() {
        String iceText = hasIce() ? "with Ice" : "without Ice";
        return getName() + " " + iceText;
    }
}

class BubbleTea extends Drink { // drink price: 2.5, bubbletea price: 4.5
    public BubbleTea(String flavor, boolean hasIce) {
        setFlavor(flavor);
        setIce(hasIce);
        setPrice(4.50);
        setName(flavor + " Bubble Tea");
    }

    @Override
    public String getDescription() {
        String iceText = hasIce() ? "with Ice" : "without Ice";
        return getName() + " " + iceText;
    }
}

// Main ordering system class
public class PizzaOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> order = new ArrayList<>();

        System.out.println("Please Input Your Order: (like this! Pizza:Cheese:Medium, Drink:Fountain:RootBeer:Ice):");
        String input = scanner.nextLine();
        String[] items = input.split(",\\s*"); // Split by comma and optional spaces

        for (String item : items) {
            String[] parts = item.split(":");

            switch (parts[0]) {
                case "Pizza":
                    Pizza pizza = null;
                    // Use nested switch to determine which pizza
                    switch (parts[1]) {
                        case "Cheese":
                            pizza = new CheesePizza(parts[2]);
                            break;
                        case "Pepperoni":
                            pizza = new PepperoniPizza(parts[2]);
                            break;
                        case "MorelMushroom":
                            pizza = new MorelMushroomPizza(parts[2]);
                            break;
                        default:
                            System.out.println("Unknown pizza type: " + parts[1]);
                    }
                    if (pizza != null) {
                        order.add(pizza);
                    }
                    break;

                case "Drink":
                    // Use nested switch for which drink
                    switch (parts[1]) {
                        case "Fountain":
                            boolean hasIce = parts[3].equalsIgnoreCase("Ice");
                            order.add(new Fountain(parts[2], hasIce));
                            break;
                        case "BubbleTea":
                            hasIce = parts[3].equalsIgnoreCase("Ice");
                            order.add(new BubbleTea(parts[2], hasIce));
                            break;
                        default:
                            System.out.println("Unknown drink type: " + parts[1]);
                    }
                    break;

                default:
                    System.out.println("Unknown product type: " + parts[0]);
            }
        }

        // Display order summary and total price.
        System.out.println("\nOrder Summary:\n");
        double totalPrice = 0.0;
        for (Product product : order) {
            System.out.printf("%s - $%.2f\n", product.getDescription(), product.getPrice());
            totalPrice += product.getPrice();
        }
        System.out.printf("Total Price: $%.2f\n", totalPrice);

        scanner.close();
    }
}
