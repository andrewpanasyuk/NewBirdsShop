import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panasyuk on 28.07.2015.
 */
public class Shop {

    private List<Bird>stockBirds;
    private List<Stock>stocks;
    private List<Customer> customers;
    private List<Transaction> transactions;

    public Shop(){
        stockBirds = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
        stocks = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Bird> getStockBirds() {
        return stockBirds;
    }

    public void setStockBirds(List<Bird> stockBirds) {
        this.stockBirds = stockBirds;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
