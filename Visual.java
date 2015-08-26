import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by panasyuk on 11.08.2015.
 */
public class Visual extends JPanel {
    private Shop shop;
    private JFrame frame;
    private JPanel panel;
    private int pi = 0;
    private ShopService shopService;
    private Statistic statistic;
    private Table currentTable;


    public Visual(Shop shop) {
        this.shop = shop;

        shopService = new ShopService(shop);
        currentTable = new Table(shop);
        statistic = new Statistic(shop);
        visualMake();


    }


    public void visualMake() {
        frame = new JFrame();
        frame.setName("Birds shop");
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = papam();
        frame.setContentPane(panel);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Action");
        JMenuItem currentStock = new JMenuItem("Stock");
        currentStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTablInFrame("Stock");
            }
        });
        JMenuItem byu = new JMenuItem("Buy Birds");

        byu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrderForma();
            }
        });

        JMenu menuReport = new JMenu("Reports");
        JMenuItem menuTotalCash = new JMenuItem("Total Cash");

        menuTotalCash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
            }
        });

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.pack();
                frame.repaint();

            }
        });
        menuReport.add(menuTotalCash);
        menu.add(byu);
        menu.add(currentStock);
        menu.add(exit);
        menuBar.add(menu);
        menuBar.add(menuReport);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel papam() {
        JPanel startPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };

        return startPanel;
    }

    public void showOrderForma() {
        frame.getContentPane().removeAll();
        panel = orderForma();
        frame.setContentPane(panel);
        frame.pack();
        frame.repaint();

    }




    public JPanel orderForma() {
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new GridBagLayout());

        JLabel nameCustumer = new JLabel("Name Customer: ");
        JTextField inputName = new JTextField("");
        inputName.setColumns(25);

        orderPanel.add(nameCustumer, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 5, 0), 0, 0));
        orderPanel.add(inputName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 0), 0, 0));


        JLabel berds = new JLabel("Berds: ");
        List<Stock> lp = shop.getStocks();
        ButtonGroup bg = new ButtonGroup();


        JPanel prod = new JPanel();
        ActionListener rbl = new RBListener();
        prod.setLayout(new GridLayout(lp.size(), 0));
        prod.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JRadioButton rb;
        for (int i = 0; i < lp.size(); i++) {
            Stock p = lp.get(i);

            rb = new JRadioButton("Bird: " + p.getPositionName() + ", Price: " + p.getPrice() + "$, In Stock: " + p.getInStock() + " pcs.");
            rb.setActionCommand(String.valueOf(i));
            rb.addActionListener(rbl);
            if (i == 0) {
                rb.setSelected(true);
            }
            bg.add(rb);
            prod.add(rb);
        }

        orderPanel.add(berds, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, 0, new Insets(0, 0, 5, 0), 0, 0));
        orderPanel.add(prod, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 5, 0), 0, 0));


        JLabel number = new JLabel("Count: ");
        orderPanel.add(number, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 5, 0), 0, 0));
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField fildNumber = new JFormattedTextField(nf);
        fildNumber.setColumns(2);
        fildNumber.setValue(0);
        orderPanel.add(fildNumber, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 5, 0), 0, 0));

        Button bt = new Button("Buy!");
        bt.setLocation(100, 100);
        orderPanel.add(bt, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 5, 0), 0, 0));
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customer = (String) inputName.getText();
                int b = Integer.parseInt(fildNumber.getText());
                shopService.buyBirds(lp.get(pi).getPositionName(), b, customer);
                addTablInFrame("Transaction");

            }
        });
        return orderPanel;
    }

    private class RBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pi = Integer.parseInt(e.getActionCommand());
        }
    }


    public void addTablInFrame(String nameTabl) {
        frame.getContentPane().removeAll();
        frame.add(currentTable.makeTabl(nameTabl));
        frame.pack();
        frame.repaint();

    }

}
