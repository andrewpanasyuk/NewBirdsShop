/**
 * Created by panasyuk on 14.08.2015.
 */
public class Discount {
    public static Double discount(double total){
        if (total >= 50.0 && total <100.0){
            return total*0.95;
        } else if (total >= 100) {
            return total*0.9;
        }
        return total;
    }
}
