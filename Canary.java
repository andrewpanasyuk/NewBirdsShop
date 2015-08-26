import java.awt.*;

/**
 * Created by panasyuk on 19.08.2015.
 */
public class Canary extends Bird {
    private Color color;

    public Canary(){
        setName("Canary");
        color = Color.BLUE;

    }
    public Canary(Color color){
        this.color = color;
        setName("Canary");
        newGroupNumber();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void newGroupNumber() {
        if (getColor() == color.RED) {
            setGroupNumber(10300000001L);
        } else {
            setGroupNumber(10300000002L);
        }

    }
}
