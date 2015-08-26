import java.awt.*;
import java.util.ArrayList;

/**
 * Created by panasyuk on 27.07.2015.
 */
public class Work {
    public static void main(String[] args) throws Exception{
        SplashScreen splashScreen = SplashScreen.getSplashScreen();
        Thread.sleep(2000);
//        splashScreen.close();

        Shop shop = new Shop();
        ShopService shopService = new ShopService(shop);
        Statistic statistic = new Statistic(shop);

        Visual visual = new Visual(shop);

        shopService.addTestData();
        shopService.sortBirdBasePN();
        shopService.printBase(shop.getStocks());

        shopService.buyBirds("Eagle", 15, "Ivanov");
        shopService.buyBirds("Eagle", 5, "Ivanov");
        shopService.buyBirds("Goose", 12, "Sidorov");
        shopService.buyBirds("Eagle", 35, "Ivanov");
        System.out.println("--------------------------------");
        shopService.printBase(shop.getStocks());
        System.out.println("---------------------------------");
        shopService.printBase(shop.getTransactions());
        System.out.println("---------------------------------");
        statistic.cashIn();
        statistic.birdsInStock();

        statistic.birdsBuyTotal();



    }
}
