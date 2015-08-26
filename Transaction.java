import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by panasyuk on 27.07.2015.
 */
public class Transaction {
    static int totalCounter=0;
    private int counter;
    private String data;
    private String customerName;
    private String birdName;
    private int qnt;
    private double price;
    private double totalPtice;

    public Transaction(){
        totalCounter++;
        counter = totalCounter;

    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public static int getTotalCounter() {
        return totalCounter;
    }

    public static void setTotalCounter(int totalCounter) {
        Transaction.totalCounter = totalCounter;
    }

    public double getTotalPtice() {
        return totalPtice;
    }

    public void setTotalPtice(double totalPtice) {
        this.totalPtice = totalPtice;
    }

    @Override
    public String toString() {

        return "Transaction:" + counter + " " + data +  " " + birdName + " " + qnt + " " + price + " " + totalPtice + " " + customerName;
    }
}
