package core;
import gui.GuiMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.jdom2.JDOMException;



public class CoreBooking implements ActionListener {
	
	public static String customer;
	public static String category;
	public static String arrangement;
	public static String datefromdd;
	public static String datefrommm;
	public static String datefromyy;
	public static String dateuntildd;
	public static String dateuntilmm;
	public static String dateuntilyy;
	public static String isAvailable;
	private GuiMain parent;
	private String customers = "";
	private int business = 5;
	private int suite = 5;
	private int economy = 5;
	
	public CoreBooking(GuiMain parent) {
			super();
		this.parent = parent;
	}

	public static void main(String[] args) {
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Buchen")){
			
			customers = (String) parent.getComboBox().getSelectedItem();
			
			customer = (String) parent.getComboBox().getSelectedItem();
			category = (String) parent.getJComboBox_1().getSelectedItem();
			arrangement = (String) parent.getJComboBox_2().getSelectedItem();
			datefromdd = (String) parent.getJComboBox_3().getSelectedItem();
			datefrommm = (String) parent.getJComboBox_4().getSelectedItem();
			datefromyy = (String) parent.getJComboBox_5().getSelectedItem();
			dateuntildd = (String) parent.getJComboBox_7().getSelectedItem();
			dateuntilmm = (String) parent.getJComboBox_8().getSelectedItem();
			dateuntilyy = (String) parent.getJComboBox_6().getSelectedItem();
			
			if(category == "Economy"){
				if(ReadWrite.categoryEconomy.size() <= economy){
					executeBooking();
				}else{
					JOptionPane.showMessageDialog(null, "Zimmer dieser Kategorie sind ausgebucht!");
				}
					
			}
			if(category == "Suite"){
				if(ReadWrite.categorySuite.size() <= suite){
					executeBooking();
				}else{
					JOptionPane.showMessageDialog(null, "Zimmer dieser Kategorie sind ausgebucht!");
				}
			}
			if(category == "Business"){
				if(ReadWrite.categoryBusiness.size() <= business){
					executeBooking();
				}else{
					JOptionPane.showMessageDialog(null, "Zimmer dieser Kategorie sind ausgebucht!");
				}
			}
			
		}
		if (actionCommand.equals("Kunden löschen")){
			deleteCustomer();
		}
	}
			
			
			
	private void executeBooking(){
			if(GuiMain.comboboxModelBookings.getIndexOf(customers) == -1){		
					int reply = JOptionPane.showConfirmDialog(null, "Jetzt verbindlich Buchen?", "Buchen", JOptionPane.YES_NO_OPTION);
			
					if (reply == JOptionPane.YES_OPTION) {
						try {
							try {
								ReadWrite.categoryBusiness.clear();
								ReadWrite.categoryEconomy.clear();
								ReadWrite.categorySuite.clear();
								ReadWrite.WriteBooking();
								ReadWrite.ReadFromFile();
								
								if(category == "Economy"){
									ReadWrite.economyCount = ReadWrite.economyCount +1;
								} else if(category == "Business"){
									ReadWrite.businessCount = ReadWrite.businessCount +1;
								} else if(category == "Suite"){
									ReadWrite.suiteCount = ReadWrite.suiteCount +1;
								}
								ReadWrite.WriteStatistics();
								ReadWrite.LoadStatistics();
							} catch (JDOMException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							GuiMain.comboboxModelBookings.removeAllElements();
							ReadWrite.cancelBookingList.toArray(); // to array :)
							for (String customer : ReadWrite.cancelBookingList){
								GuiMain.comboboxModelBookings.addElement(customer);
							}
							parent.getCancelationCustomer().setModel(GuiMain.comboboxModelBookings);
							
						} catch (IOException ioe) {
							ioe.printStackTrace();
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Es ist schon eine Buchung für diesen Kunden vorhanden!\n Bitte löschen Sie diese zuerst!");
					}
			try {
				ReadWrite.ReadFromFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
			
	private void deleteCustomer(){
		
			
			int reply1 = JOptionPane.showConfirmDialog(null, "Kunden wirklich löschen?", "löschen", JOptionPane.YES_NO_OPTION);
			isAvailable = (String) parent.getComboBox().getSelectedItem();
			
			if (reply1 == JOptionPane.YES_OPTION) {
				
				try {
					ReadWrite.DeleteCustomer();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} catch (JDOMException e1) {
					
					e1.printStackTrace();
				}
				try {
					ReadWrite.ReadFromFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				GuiMain.comboboxModel.removeAllElements();
				ReadWrite.customerList.toArray(); 
				for (String customer : ReadWrite.customerList){
					GuiMain.comboboxModel.addElement(customer);
				}
				parent.getComboBox().setModel(GuiMain.comboboxModel);
				
				GuiMain.comboboxModelBookings.removeAllElements();
				ReadWrite.cancelBookingList.toArray(); // to array :)
				for (String customer : ReadWrite.cancelBookingList){
					GuiMain.comboboxModelBookings.addElement(customer);
				}
				parent.getCancelationCustomer().setModel(GuiMain.comboboxModelBookings);
				
			}
			try {
				ReadWrite.ReadFromFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}