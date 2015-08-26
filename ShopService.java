import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by panasyuk on 19.08.2015.
 */
public class ShopService<T> {
    private static Shop shop;

    public ShopService(Shop shop) {
        this.shop = shop;

    }

    public <T extends Bird> void makeStockPosition1(T object) {
        boolean flag = false;
   if (shop.getStocks().size() == 0){
       addNewPosInStock(object, 0);
   } else {
       int a = 0;
       for (int i = 0; i< shop.getStocks().size(); i++){
           if (object.getName().equals(shop.getStocks().get(i).getPositionName())){
               shop.getStocks().get(i).setInStock(shop.getStocks().get(i).getInStock()+1);
               flag = true;
           } else {
               a = i;

           }
       }
       if (flag == false) {
           addNewPosInStock(object, a);
       }
   }

    }
    public <T extends Bird> void addNewPosInStock(T object, int pos){
        System.out.println("pos = " + pos);
        Stock stock = new Stock();
        stock.setPositionName(object.getName());
        stock.setPartNumber(object.getGroupNumber());
        stock.setInStock(1);
        stock.setPrice(object.getPrice());
        shop.getStocks().add(pos, stock);
    }


    public void buyBirds(String nameBird, int qnt, String nameCustomer) {
        Transaction transaction = new Transaction();
        for (int i = 0; i<shop.getStocks().size(); i++){
            if (nameBird.equals(shop.getStocks().get(i).getPositionName())){
                if (shop.getStocks().get(i).getInStock()>=qnt){
                    Date data = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm:ss ");
                    transaction.setData(sdf.format(data));
                    transaction.setBirdName(nameBird);
                    transaction.setPrice(shop.getStocks().get(i).getPrice());
                    shop.getStocks().get(i).setInStock(shop.getStocks().get(i).getInStock()-qnt);
                    transaction.setQnt(qnt);
                    transaction.setTotalPtice(Discount.discount(transaction.getPrice()*transaction.getQnt()));
                    transaction.setCustomerName(nameCustomer);
                    shop.getTransactions().add(transaction);

                    break;
                } else {
                    System.out.println("few birds in stock!");
                    break;
                }
            } else {
                System.out.println("No birds in stock!");
            }
        }

    }

    public void addNewCustomer(String nameNewCustomer) {
        if (!controlNameCustomerInBase(nameNewCustomer)) {
            Customer newCustomer = new Customer();
            newCustomer.setName(nameNewCustomer);
            shop.getCustomers().add(newCustomer);
        }

    }

    public boolean controlNameCustomerInBase(String name) {
        for (Customer customer : shop.getCustomers()) {
            if (customer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public void addTestData() {
        TestData testData = new TestData();
            for (Object b: testData.getTestStockBirds()){
                Bird a = (Bird) b;
                makeStockPosition1(a);
            }

    }

    public void printBase(List<T> list) {

        for (T t : list) {
            System.out.println(t.toString());
        }
    }

    public void reportBirds() {
        sortBirdBasePN();
        Bird[] st = new Bird[shop.getStockBirds().size()];
        st = shop.getStockBirds().toArray(st);


        long a = shop.getStockBirds().get(0).getGroupNumber();
        Bird b = shop.getStockBirds().get(0);
        int n = 0;
        int i;
        for (i = 0; i < shop.getStockBirds().size(); i++) {
            if (shop.getStockBirds().get(i).getGroupNumber() == a) {
                n++;
            } else {
                System.out.println(shop.getStockBirds().get(i - 1).toString() + " in stock: " + n);
                n = 1;
                a = shop.getStockBirds().get(i).getGroupNumber();
            }
        }
        System.out.println("Total birds in Stock: " + shop.getStockBirds().size() + " pcs.");

    }

    public void sortBirdBasePN() {
        shop.getStocks().sort(new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                if (o1.getCn() > o2.getCn()){
                    return 1;
                } else {
                    return -1;
                }
            }
        });


    }
}