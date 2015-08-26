import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by panasyuk on 19.08.2015.
 */
public class TestData <T> {
    private List<Bird> testStockBirds;
    private List<Customer> testBaseCustomers;
    private Map<String, List<T>> totalTestData;


    public TestData(){
        testBaseCustomers = new ArrayList<>();
        testStockBirds = new ArrayList<>();

        totalTestData = new HashMap<>();
        creatTestBase();


    }

    public void creatTestBase(){



        for (int i = 0; i<25; i++){
            Eagle eagle = new Eagle(9);
            eagle.setPrice(55.00);
            testStockBirds.add(eagle);
        }
        for (int i = 0; i<38; i++){
            Goose goose = new Goose(1.5);
            goose.setPrice(8.0);
            testStockBirds.add(goose);
        }
        for (int i = 0; i<58; i++){
            Canary canary = new Canary(Color.YELLOW);
            canary.setPrice(1.5);
            testStockBirds.add(canary);
        }

        Customer customer0 = new Customer();
        customer0.setName("Ivanov");
        testBaseCustomers.add(customer0);
        Customer customer1 = new Customer();
        customer1.setName("Petrov");
        testBaseCustomers.add(customer1);
        Customer customer2 = new Customer();
        customer2.setName("Sidorov");
        testBaseCustomers.add(customer2);
        Customer customer3 = new Customer();
        customer3.setName("John");
        testBaseCustomers.add(customer3);
        Customer customer4 = new Customer();
        customer4.setName("Pupkin");
        testBaseCustomers.add(customer4);
    }


    public List<Customer> getTestBaseCustomers() {
        return testBaseCustomers;
    }

    public List<Bird> getTestStockBirds() {
        return testStockBirds;
    }

}
