/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tempconverter;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class TempConverter extends JFrame implements ActionListener, FocusListener {
    private JTextField celsiusText;
    private JTextField fahrenheitText;
    private JButton convert;
    private String celsius;
    private String fahrenheit;
    
    public TempConverter() {
        celsiusText = new JTextField();
        celsiusText.setPreferredSize(new Dimension(100, 25));
        celsiusText.addFocusListener(this);
        
        fahrenheitText = new JTextField();
        fahrenheitText.setPreferredSize(new Dimension(100, 25));
        fahrenheitText.addFocusListener(this);
        
        convert = new JButton("Convert");
        convert.addActionListener(this);
        
        JLabel celsiusLabel = new JLabel("°C");
        JLabel fahrenheitLabel = new JLabel("°F");
        
        JPanel celsiusPanel = new JPanel();
        celsiusPanel.setLayout(new FlowLayout());
        celsiusPanel.add(celsiusLabel);
        celsiusPanel.add(celsiusText);
        
        JPanel fahrenheitPanel = new JPanel();
        fahrenheitPanel.setLayout(new FlowLayout());
        fahrenheitPanel.add(fahrenheitLabel);
        fahrenheitPanel.add(fahrenheitText);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(250, 250));
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.add(celsiusPanel, new GridBagConstraints(0, 0, 3, 1, 0, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE, new Insets(0, 0, 100, 0), 0, 0));
        mainPanel.add(fahrenheitPanel, new GridBagConstraints(0, 0, 3, 1, 0, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(convert, new GridBagConstraints(0, 0, 3, 1, 0, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE, new Insets(100, 0, 0, 0), 0, 0));
        
        setTitle("Converter");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TempConverter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convert) {
            if (!celsiusText.getText().equals("")) {
                fahrenheit = Double.toString(Double.parseDouble(celsiusText.getText()) * 1.8 + 32);
                fahrenheitText.setText(fahrenheit);
            }
            
            else if (!fahrenheitText.getText().equals("")) {
                celsius = Double.toString((Double.parseDouble(fahrenheitText.getText()) - 32) / 1.8);
                celsiusText.setText(celsius);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == celsiusText) {
            fahrenheitText.setText("");
        }
        
        else if (e.getSource() == fahrenheitText) {
            celsiusText.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {}
    
}
