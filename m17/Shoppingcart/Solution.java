import java.util.Scanner;
/**
 * Class for item.
 */
class Item {
    /**
     * { var_description }.
     */
    private String productName;
    /**
     * { var_description }.
     */
    private int quantity;
    /**
     * { var_description }.
     */
    private double price;

    /**
     * Constructs the object.
     *
     * @param      name        The name
     * @param      toQuantity  To quantity
     * @param      qPrice      The quarter price
     */
    Item(final String name, final int toQuantity, final double qPrice) {
        productName = name;
        quantity = toQuantity;
        price = qPrice;
    }

    /**
     * Constructs the object.
     *
     * @param      name        The name
     * @param      toQuantity  To quantity
     */
    Item(final String name, final int toQuantity) {
        productName = name;
        quantity = toQuantity;
    }

    /**
     * Gets the product name.
     *
     * @return     The product name.
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Gets the quantity.
     *
     * @return     The quantity.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Sets the product name.
     *
     * @param      pName  The name
     */
    public void setProductName(final String pName) {
        this.productName = pName;
    }

    /**
     * Sets the quantity.
     *
     * @param      quan  The quan
     */
    public void setQuantity(final int quan) {
        this.quantity = quan;
    }

    /**
     * Sets the price.
     *
     * @param      givePrice  The give price
     */
    public void setPrice(final double givePrice) {
        this.price = givePrice;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.productName + " "
            + this.quantity + " " + this.price;
    }
}


/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * { var_description }.
     */
    private List<Item> catalog;
    /**
     * { var_description }.
     */
    private List<Item> cart;
    /**
     * { var_description }.
     */
    private String[] coupons;
    /**
     * { var_description }.
     */
    private double discount;
    /**
     * { var_description }.
     */
    private boolean flag;

    /**
     * Constructs the object.
     */
    ShoppingCart() {
        catalog = new List<Item>();
        cart = new List<Item>();
        coupons = new String[]{"IND10", "IND20", "IND30", "IND50"};
        discount = 0;
        flag = false;
    }

    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        if (!catalog.contains(item)) {
            catalog.add(item);
        }
    }

    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println(catalog.get(i));
        }
    }

    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i));
        }
    }

    /**
     * { function_description }.
     *
     * @param      name    The name
     * @param      search  The search
     *
     * @return     { description_of_the_return_value }
     */
    private int index(final String name, final List<Item> search) {
        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).getProductName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds to cartesian.
     *
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        int indexCatalog = index(item.getProductName(), catalog);
        if (indexCatalog != -1) {
            double price = catalog.get(indexCatalog).getPrice();
            int indexCart = index(item.getProductName(), cart);
            if (indexCart == -1) {
                //item is absent in cart....
                cart.add(new Item(item.getProductName(),
                    item.getQuantity(), price));
            } else {
                //item is present in cart....
                Item oldItem = cart.get(indexCart);
                oldItem.setQuantity(oldItem.getQuantity()
                    + item.getQuantity());
            }
        }
    }

    /**
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        int indexCatalog = index(item.getProductName(), catalog);
        if (indexCatalog != -1) {
            double price = catalog.get(indexCatalog).getPrice();
            int indexCart = index(item.getProductName(), cart);
            if (indexCart != -1) {
                Item oldItem = cart.get(indexCart);
                if (oldItem.getQuantity() - item.getQuantity() != 0) {
                oldItem.setQuantity(oldItem.getQuantity()
                    - item.getQuantity());
                } else {
                    cart.remove(indexCart);
                }
            }
        }
    }

    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    public double getTotalAmount() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getQuantity()
             * cart.get(i).getPrice();
        }
        return total;
    }

    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public double getPayableAmount() {
        double amount = getTotalAmount();
        amount -= discount;
        amount += (0.15 * amount);
        return amount;
    }

    /**
     * Gets the coupon.
     */
    private void getCoupon() {
        discount = ((discount / 100) * getTotalAmount());
    }

    /**
     * { function_description }.
     *
     * @param      coupon  The coupon
     */
    public void applyCoupon(final String coupon) {
        if (!flag) {
            flag = true;
            for (int i = 0; i < coupons.length; i++) {
                if (coupons[i].equals(coupon)) {
                    discount = Double.parseDouble(
                        coupon.substring(3, coupon.length()));
                    getCoupon();
                    return;
                }
            }
            System.out.println("Invalid coupon");
        }
    }


    /**
     * { function_description }.
     */
    public void show() {
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getProductName() + " " +cart.get(i).getQuantity());
        }
    }

    /**
     * { function_description }.
     */
    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        showCart();
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + discount);
        System.out.println("Tax:"   + ( (getTotalAmount() - discount) * (0.3 * 0.5)));
        System.out.println("Payable amount: " + getPayableAmount());
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { item_description }.
     */
    private Solution() {

    }

    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
                case "Item":
                    String[] items = tokens[1].split(",");
                    cart.addToCatalog(new Item(items[0],
                        Integer.parseInt(items[1]),
                        Double.parseDouble(items[2])));
                break;
                case "add":
                    items = tokens[1].split(",");
                    cart.addToCart(new Item(items[0],
                    Integer.parseInt(items[1])));
                break;
                case "remove":
                    items = tokens[1].split(",");
                    cart.removeFromCart(new Item(items[0],
                    Integer.parseInt(items[1])));
                break;
                case "show":
                    cart.show();
                break;
                case "totalAmount":
                    System.out.println("totalAmount: " + cart.getTotalAmount());
                break;
                case "payableAmount":
                    System.out.println("Payable amount: "
                    + cart.getPayableAmount());
                break;
                case "catalog":
                    cart.showCatalog();
                break;
                case "coupon":
                    //System.out.println(tokens[1]);
                    cart.applyCoupon(tokens[1]);
                break;
                case "print":
                    cart.printInvoice();
                break;
                default:
                break;
            }
        }
    }
}
