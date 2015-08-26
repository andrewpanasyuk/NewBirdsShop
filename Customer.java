/**
 * Created by panasyuk on 27.07.2015.
 */
public class Customer {
    private static int n;
    private int number;
    private String name;

    public Customer() {
        n++;
        number = n;
    }

    public Customer(String name) {
        n++;
        number = n;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Customer:" +
                " name = " + name +
                ", s/n = " + number +
                ';';
    }
}
