package br.com.view;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * 
 * @version Thiago de Lima Gonçalves RA: 100838359
 *
 */

public class IdiomaView extends JFrame{

	private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JTextField num1Field = null;
    private JTextField num2Field = null;
    private JButton equalButton = null;
    private JTextField resultField = null;
    
    
	public IdiomaView(){
		super();
		
	}
	
	private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getNum1Field(), null);
            jContentPane.add(getNum2Field(), null);
            jContentPane.add(getEqualButton(), null);
            jContentPane.add(getResultField(), null);
        }
        return jContentPane;
    }
	
	private JTextField getNum1Field() {
        if (num1Field == null) {
            num1Field = new JTextField();
            num1Field.setBounds(new Rectangle(11, 16, 49, 20));
        }
        return num1Field;
    }
    
    private JTextField getNum2Field() {
        if (num2Field == null) {
            num2Field = new JTextField();
            num2Field.setBounds(new Rectangle(113, 16, 50, 20));
        }
        return num2Field;
    }
   
    private JButton getEqualButton() {
        if (equalButton == null) {
            equalButton = new JButton();
            equalButton.setBounds(new Rectangle(174, 14, 54, 26));
            equalButton.setText("=");
        }
        equalButton.setActionCommand("equal");
        return equalButton;
    }
   
    private JTextField getResultField() {
        if (resultField == null) {
            resultField = new JTextField();
            resultField.setBounds(new Rectangle(243, 17, 54, 20));
        }
        return resultField;
    }
}
