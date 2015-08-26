/**
 * Created by panasyuk on 20.08.2015.
 */
public class Statistic {
    private Shop shop;

    public Statistic(Shop shop){
        this.shop = shop;
    }

    public String cashIn() {
        double cash = 0;
        for (int i = 0; i < shop.getTransactions().size(); i++) {
            cash += shop.getTransactions().get(i).getTotalPtice();
        }
        return "Total cash: " + cash + "$;";

    }

    public void birdsInStock(){
        for (Stock st: shop.getStocks()){
            System.out.println(st.getPositionName() + " - " + st.getInStock());
        }
    }
    public void birdsBuyTotal(){
        System.out.println("Total buy:");

        for(Transaction tr: shop.getTransactions()){
            System.out.println(tr.getBirdName() + " - " + tr.getQnt());
        }
    }
}
