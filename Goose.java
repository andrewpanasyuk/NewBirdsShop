/**
 * Created by panasyuk on 28.07.2015.
 */
public class Goose extends Bird {
    private double weight;
    public Goose(){
        setName("Goose");
        newGroupNumber();

    }
    public Goose(double weight){
        this.weight = weight;
        setName("Goose");
        newGroupNumber();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void newGroupNumber() {
        if (getWeight() < 2) {
            setGroupNumber(10200000100L);
        } else if (getWeight() >= 2 && getWeight() < 3) {
            setGroupNumber(10200000200L);
        } else if (getWeight() >= 3 && getWeight() < 4) {
            setGroupNumber(10200000300L);
        } else {
            setGroupNumber(10200000400L);
        }

    }
}
