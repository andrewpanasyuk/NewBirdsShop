/**
 * Created by panasyuk on 27.07.2015.
 */
abstract class Bird {
    private long groupNumber;
    private String name;
    private double price;
    private int onStock;

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

    public int getOnStock() {
        return onStock;
    }

    public void setOnStock(int onStock) {
        this.onStock = onStock;
    }

    public long getGroupNumber() {
        return groupNumber;
    }

    @Override
    public String toString() {
        return "#" + groupNumber + " name Bird: " + getName() + ", price: " + getPrice() + "$;";
    }

    public void setGroupNumber(long groupNumber) {
        this.groupNumber = groupNumber;
    }



}
