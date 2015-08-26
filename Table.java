import javax.swing.*;
import javax.swing.table.TableColumn;


/**
 * Created by panasyuk on 10.08.2015.
 */
public class Table extends JPanel {
    private Shop shop;
    private ShopService shopService;
    private JScrollPane panelTabl;

    public Table() {

    }

    public Table(Shop shop) {
        this.shop = shop;
        shopService = new ShopService(shop);

    }

    public JScrollPane makeTabl(String typeTable) {
        JTable startPanel = new JTable();
        if (typeTable.equals("Transaction")) {
            startPanel = transactonTable();
        } else if (typeTable.equals("Stock")) {
            startPanel = stockTable();
        }
        return new JScrollPane(startPanel);

    }

    public JTable stockTable() {
        String[] colum = new String[]{"#", "s/n", "Birds name", "in stock", "Coast"};
        String[][] row = new String[shop.getStocks().size()][colum.length];
        for (int i = 0; i < shop.getStocks().size(); i++) {
            row[i][0] = Integer.toString(shop.getStocks().get(i).getCn());
            row[i][1] = Long.toString(shop.getStocks().get(i).getPartNumber());
            row[i][2] = shop.getStocks().get(i).getPositionName();
            row[i][3] = Integer.toString(shop.getStocks().get(i).getInStock());
            row[i][4] = Double.toString(shop.getStocks().get(i).getPrice());
        }
        JTable table = new JTable(row, colum);
        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(20); //third column is bigger
            } else if (i == 1) {
                column.setPreferredWidth(100);
            } else {
                column.setPreferredWidth(50);
            }
        }

        return table;
    }

    public JTable transactonTable() {
        String[] colum = new String[]{"#", "Data", "Bird", "qnt.", "cost", "total", "Customer"};
        String[][] row = new String[shop.getTransactions().size()][7];
        for (int i = 0; i < shop.getTransactions().size(); i++) {
            row[i][0] = Integer.toString(shop.getTransactions().get(i).getCounter());
            row[i][1] = shop.getTransactions().get(i).getData();
            row[i][2] = shop.getTransactions().get(i).getBirdName();
            row[i][3] = Integer.toString(shop.getTransactions().get(i).getQnt());
            row[i][4] = Double.toString(shop.getTransactions().get(i).getPrice());
            row[i][5] = Double.toString(shop.getTransactions().get(i).getTotalPtice());
            row[i][6] = shop.getTransactions().get(i).getCustomerName();
        }
        JTable table = new JTable(row, colum);

        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(25); //third column is bigger
            } else if (i == 1) {
                column.setPreferredWidth(120);
            } else {
                column.setPreferredWidth(50);
            }
        }
        return table;
    }

}
