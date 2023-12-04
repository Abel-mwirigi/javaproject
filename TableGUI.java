import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

public class TableGUI extends JFrame implements ActionListener{
  private JFrame mainFrame;
  private JLabel headerLabel;
  private JLabel statusLabel;
  private JPanel controlPanel;
  private JFrame jFrame;
   JTextField num1,num2;
   JLabel tableSize, drawers, woodType, tables, label;
   JButton add;

   TableGUI(){
       jFrame = new JFrame();
       ImageIcon logo =new ImageIcon("Daystar Uni.jpeg");
       jFrame.setIconImage(logo.getImage());
       jFrame.setTitle("Antique Furniture Kenya Limited");
       jFrame.setSize(600,500);
       jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       jFrame.setLayout(null);

       /**num1=new JTextField();
       num1.setBounds(50, 50, 300, 50);
       jFrame.add(num1);

       num2=new JTextField();
       num2.setBounds(50, 120, 300, 50);
       jFrame.add(num2);

       add = new JButton("Add");
       add.setBounds(150, 190, 100, 50);
       add.addActionListener(this::actionPerformed);
       jFrame.add(add);**/

       /**implementation of combo box */

       String[] size = {"Standard", "Custom"};//array of elements for the combo box

       JComboBox<String>comboBox = new JComboBox<>(size);//jcomboBox with the array of elements

       comboBox.setSelectedIndex(0);//default selected item

       label = new JLabel();//label to display the selected item

       //button to display the selected item
       JButton button = new JButton("Show Selected Item");
       button.addActionListener(e -> {
        String selected = (String) comboBox.getSelectedItem();
        label.setText("Selected Item: " + selected);
    });
    
        // A panel with the combo box, label, and button
        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(button);
        panel.add(label);

        jFrame.getContentPane().add(panel);


       /**tableSize= new JLabel();
       tableSize.setBounds(50, 100, 300, 50);
       tableSize.setText("first");
       jFrame.add(tableSize);

       drawers= new JLabel();
       drawers.setBounds(50, 140, 300, 50);
       drawers.setText("second");
       jFrame.add(drawers);

       woodType= new JLabel();
       woodType.setBounds(50, 180, 300, 50);
       woodType.setText("third");
       jFrame.add(woodType);

       tables= new JLabel();
       tables.setBounds(50, 220, 300, 50);
       tables.setText("forth");
       jFrame.add(tables);**/

       jFrame.setVisible(true);
      
   }
@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
}
}
    

