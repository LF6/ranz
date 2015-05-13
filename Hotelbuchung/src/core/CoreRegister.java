package core;
import gui.GuiMain;
import core.ReadWrite;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.TabbedPaneUI;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

public class CoreRegister implements ActionListener {
	
	public static String name;
	public static String surname;
	public static String street;
	public static String city;
	public static String nr;
	public static String plz;
	public static String gender;
	public static String dd;
	public static String mm;
	public static String yy;
	
	private GuiMain parent;
	
	public CoreRegister(GuiMain parent) {
		super();
		this.parent = parent;
	}

	public static void main(String[] args) {		
		
	}	

	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Registrieren")){	
		
			name = parent.getTextField().getText();
			surname = parent.getTextField_1().getText();
			street = parent.getTextField_2().getText();
			city = parent.getTextField_3().getText();
			nr = parent.getTextField_5().getText();
			plz = parent.getTextField_6().getText();
			gender = (String) parent.getJComboBox_18().getSelectedItem();
			dd = (String) parent.getJComboBox_10().getSelectedItem();
			mm = (String) parent.getJComboBox_9().getSelectedItem();
			yy = (String) parent.getJComboBox_11().getSelectedItem();
			if (surname.length() == 0 || name.length() == 0 || street.length() == 0 || city.length() == 0 || nr.length() == 0 || plz.length() == 0){
				JOptionPane.showMessageDialog(null, "Bitte geben Sie Ihre vollständige Kontaktdaten an!");
			} else {
				try {
					ReadWrite.whichFunction = 1;
					try {
						ReadWrite.main(null);
					} catch (JDOMException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						ReadWrite.ReadFromFile();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GuiMain.comboboxModel.removeAllElements();
					ReadWrite.customerList.toArray(); // to array :)
					for (String customer : ReadWrite.customerList){
						GuiMain.comboboxModel.addElement(customer);
					}
					parent.getComboBox().setModel(GuiMain.comboboxModel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			parent.getTextField().setText("");
			parent.getTextField_1().setText("");
			parent.getTextField_2().setText("");
			parent.getTextField_3().setText("");
			parent.getTextField_5().setText("");
			parent.getTextField_6().setText("");
			parent.getJComboBox_10().setSelectedItem("1");
			parent.getJComboBox_9().setSelectedItem("Jan");
			parent.getJComboBox_11().setSelectedItem("1901");
			parent.getJComboBox_18().setSelectedItem("Herr");
			}
		} else if (actionCommand.equals("Abbrechen")){
			
		
		parent.getTextField().setText("");
		parent.getTextField_1().setText("");
		parent.getTextField_2().setText("");
		parent.getTextField_3().setText("");
		parent.getTextField_5().setText("");
		parent.getTextField_6().setText("");
		parent.getJComboBox_10().setSelectedItem("1");
		parent.getJComboBox_9().setSelectedItem("Jan");
		parent.getJComboBox_11().setSelectedItem("1901");
		parent.getJComboBox_18().setSelectedItem("Herr");
		}
		
	}
}