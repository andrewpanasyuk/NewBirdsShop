/**
 * Created by panasyuk on 27.07.2015.
 */
public class Eagle extends Bird {
    private int age;

    public Eagle() {
        setName("Eagle");
        setGroupNumber(10100010000L);
    }
public Eagle(int age){
    setName("Eagle");
    this.age=age;
    newGroupNumber();


}
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void newGroupNumber() {
        if (getAge() < 5) {
            setGroupNumber(10100010000L);
        } else if (getAge() >= 5 && getAge() < 10) {
            setGroupNumber(10100020000L);
        } else if (getAge() >= 10) {
            setGroupNumber(10100030000L);
        }

    }

}
