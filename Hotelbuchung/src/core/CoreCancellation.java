package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jdom2.JDOMException;

import gui.GuiMain;

public class CoreCancellation implements ActionListener {

	public static String name;
	public static String bDay;

	private GuiMain parent;
	
	public CoreCancellation(GuiMain parent) {
		super();
		this.parent = parent;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
	
		if (actionCommand.equals("Stornieren")){
			
			int reply = JOptionPane.showConfirmDialog(null, "Stornierung durchführen?", "corecanel", JOptionPane.YES_NO_OPTION);
			
				if (reply == JOptionPane.YES_OPTION) {
				
					try {
						ReadWrite.cancelCount = ReadWrite.cancelCount +1;
						ReadWrite.DeleteBooking();
						ReadWrite.WriteStatistics();
						ReadWrite.LoadStatistics();
						ReadWrite.ReadFromFile();
						
						GuiMain.comboboxModelBookings.removeAllElements();
						ReadWrite.cancelBookingList.toArray(); // to array :)
						for (String customer : ReadWrite.cancelBookingList){
							GuiMain.comboboxModelBookings.addElement(customer);
						}
						parent.getCancelationCustomer().setModel(GuiMain.comboboxModelBookings);
						
					} catch (IOException | JDOMException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}
	}
}