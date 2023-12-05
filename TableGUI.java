import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableGUI extends JFrame implements ActionListener {
    private JFrame jFrame;
    private JLabel label;
    private JTextField numDrawersField;
    private JButton showItemButton;
    private JTextField widthField;
    private JTextField lengthField;
    private JComboBox<String> woodTypeComboBox;
    private JTextField numTablesField;

    TableGUI() {
        jFrame = new JFrame();
        ImageIcon logo = new ImageIcon("Daystar Uni.jpeg");
        jFrame.setIconImage(logo.getImage());
        jFrame.setTitle("Antique Furniture Kenya Limited");
        jFrame.setSize(1250, 700);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Combo box
        String[] size = {"Standard", "Custom"};
        JComboBox<String> comboBox = new JComboBox<>(size);
        comboBox.setSelectedIndex(0);

        // Label to display the selected item from the combo box
        label = new JLabel();

        // Button to display the selected item from the combo box
        showItemButton = new JButton("Show Selected Item");
        showItemButton.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            label.setText("Selected Item: " + selected);
        });

        // Label and text field for the number of drawers
        JLabel numDrawersLabel = new JLabel("Enter Number of Drawers (max 6):");
        numDrawersField = new JTextField(10);

        // Button to show the entered number of drawers
        JButton showDrawersButton = new JButton("Show Drawers");
        showDrawersButton.addActionListener(e -> {
            try {
                int numDrawers = Integer.parseInt(numDrawersField.getText());
                if (numDrawers <= 6) {
                    label.setText("Number of Drawers: " + numDrawers);
                } else {
                    label.setText("Number of Drawers cannot exceed 6");
                }
            } catch (NumberFormatException ex) {
                label.setText("Invalid input for drawers. Please enter a number.");
            }
        });

        // A panel with components using GridLayout
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10)); // 8 rows, 2 columns, horizontal and vertical gap
        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Right-align components in this panel
        panel.add(new JLabel("Select Size:"));
        panel.add(comboBox);
        panel.add(showItemButton);
        panel.add(label);
        panel.add(numDrawersLabel);
        panel.add(new JPanel()); // Empty panel for spacing
        panel.add(numDrawersField);
        panel.add(showDrawersButton);

        // Create a new panel for dimensions components
        JPanel dimensionsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dimensionsPanel.add(new JLabel("Enter Dimensions (width x length):"));
        dimensionsPanel.add(new JPanel()); // Empty panel for spacing
        dimensionsPanel.add(widthField = new JTextField(5));
        dimensionsPanel.add(lengthField = new JTextField(5));
        dimensionsPanel.add(new JButton("Show Dimensions and Calculate Area") {{
            addActionListener(e -> {
                try {
                    int width = Integer.parseInt(widthField.getText());
                    int length = Integer.parseInt(lengthField.getText());
                    int area = width * length;

                    int basePrice = 42500;
                    int standardArea = 80 * 120;

                    int extraAreaCharge = Math.max(area - standardArea, 0) * 825;

                    label.setText("Area: " + area + " cm²\nExtra Area Charge: " + extraAreaCharge + " KES");
                } catch (NumberFormatException ex) {
                    label.setText("Invalid input for dimensions. Please enter numbers.");
                }
            });
        }});

        // Continue adding components to the main panel
        panel.add(dimensionsPanel);

        // Continue adding components to the main panel
        panel.add(new JLabel("Select Wood Type:"));
        panel.add(woodTypeComboBox = new JComboBox<>(new String[]{"Mahogany", "Oak", "Pine"}));
        panel.add(new JButton("Show Wood Type") {{
            addActionListener(e -> {
                String selectedWoodType = (String) woodTypeComboBox.getSelectedItem();
                label.setText("Selected Wood Type: " + selectedWoodType);
            });
        }});

        // Continue adding components to the main panel
        panel.add(new JLabel("Enter Number of Tables:"));
        panel.add(numTablesField = new JTextField(5));
        panel.add(new JButton("Calculate Cost and Apply Discount") {{
            addActionListener(e -> {
                try {
                    int numTables = Integer.parseInt(numTablesField.getText());
                    double discount = (numTables > 1) ? 0.05 : 0.0;
                    double totalCost = calculateTotalCost();
                    double discountedCost = totalCost * (1 - discount);
                    label.setText(String.format("Total Cost: %.2f KES\nDiscounted Cost: %.2f KES", totalCost, discountedCost));
                } catch (NumberFormatException ex) {
                    label.setText("Invalid input for the number of tables. Please enter a number.");
                }
            });
        }});

        // Button to generate the invoice
        panel.add(new JButton("Generate Invoice") {{
            addActionListener(e -> generateInvoice());
        }});

        // Add the main panel to the content pane
        jFrame.getContentPane().add(panel);

        // Set layout for the content pane
        jFrame.setLayout(new FlowLayout());

        jFrame.setVisible(true);
    }

    private double calculateTotalCost() {
        int width = Integer.parseInt(widthField.getText());
        int length = Integer.parseInt(lengthField.getText());
        int area = width * length;

        int basePrice = 42500;
        int standardArea = 80 * 120;
        int extraAreaCharge = Math.max(area - standardArea, 0) * 825;

        String selectedWoodType = (String) woodTypeComboBox.getSelectedItem();
        int woodTypeCharge = 0;
        if (selectedWoodType.equals("Mahogany")) {
            woodTypeCharge = 3000;
        } else if (selectedWoodType.equals("Oak")) {
            woodTypeCharge = 2015;
        }

        int numDrawers = Integer.parseInt(numDrawersField.getText());
        int drawerCost = (numDrawers > 1) ? 2000 * (numDrawers - 1) + 2500 : 2500;

        return basePrice + extraAreaCharge + woodTypeCharge + drawerCost;
    }

    private void generateInvoice() {
        // Extract values for generating the invoice
        String typeOfWood = (String) woodTypeComboBox.getSelectedItem();
        int length = Integer.parseInt(lengthField.getText());
        int width = Integer.parseInt(widthField.getText());
        int drawers = Integer.parseInt(numDrawersField.getText());
        int numberOfTables = Integer.parseInt(numTablesField.getText());
        int drawerCost = calculateDrawerCost();
        int woodPrice = calculateWoodPrice();
        double totalCost = calculateTotalCost();

        // Display the invoice in a dialog box
        String invoice = "============================= \n" +
                "Wood Type   : " + typeOfWood + "\n" +
                "Dimensions  : " + length + " cm x " + width + " cm\n" +
                "Drawers     : " + drawers + "\n" +
                "No of Tables: " + numberOfTables + "\n" +
                "Drawer cost : Ksh" + drawerCost + "\n" +
                "Wood price  : Ksh " + woodPrice + "\n" +
                "Table Cost  : Ksh " + totalCost + "\n" +
                "Discount    : Ksh" + calculateDiscount() + "\n" +
                "Total Cost  : Ksh " + (totalCost - calculateDiscount()) + "\n" +
                "============================= ";
        JOptionPane.showMessageDialog(jFrame, invoice, "Invoice", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TableGUI());
    }
}
