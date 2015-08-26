import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by panasyuk on 10.08.2015.
 */
public class Stock <T extends Bird> {
    private static int stockNumber;
    private int cn;
    private long partNumber;
    private String PositionName;
    private int inStock;
    private int minStock;
    private double inPrice;
    private double price;

    public Stock(){
        stockNumber++;
        cn = stockNumber;
    }

    @Override
    public String toString() {
        return "#" + cn + " " + "s/n: " + partNumber + ": " + PositionName + " " + inStock + " pcs. " + price + "$;";

//                "Stock{" +
//                "inPrice=" + inPrice +
//                ", partNumber=" + partNumber +
//                ", PositionName='" + PositionName + '\'' +
//                ", inStock=" + inStock +
//                ", minStock=" + minStock +
//                ", price=" + price +
//                '}';
    }
//    public <T> Stock makeStockPosition(Object cl) throws Exception{
//        Stock stock = new Stock();
//        stock.setPositionName(cl.getClass().getCanonicalName());
//        stock.setInStock(0);
//        stock.setMinStock(0);
//
//
//        Field [] fields = cl.getClass().getDeclaredFields();
//        for (int i = 0; i < fields.length; i++){
//            if (fields[i].getModifiers() == 2) {
//                fields[i].setAccessible(true);
//            }
//            if (fields[i].getName().equals("price")){
//                setPrice(fields[i].getDouble(cl));
//            }
//
//        }
//        stock.setInPrice(0.0);
//
//        return stock;
//
//
//
//
//
//
//    }


    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public double getInPrice() {
        return inPrice;
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public long getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(long partNumber) {
        this.partNumber = partNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getStockNumber() {
        return stockNumber;
    }

    public static void setStockNumber(int stockNumber) {
        Stock.stockNumber = stockNumber;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        this.PositionName = positionName;
    }

}
