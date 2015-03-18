package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import gui.GuiMain;


public class CoreOverview implements ActionListener{

	private GuiMain parent;
	private String FromDD;
	private String FromMM;
	private String FromYY;
	private String UntilDD;
	private String UntilMM;
	private String UntilYY;
	private String rooms;
	private String datesFrom;
	private String datesUntil;
	private List<String> overviewBook = new ArrayList<String>();
	
	public CoreOverview(GuiMain parent) {
		super();
		this.parent = parent;
	}
	
	public static void main(String[] args) {
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Zur Buchung")){	
		
			int reply = JOptionPane.showConfirmDialog(null, "Kunde vorhanden?", "Ja", JOptionPane.YES_NO_OPTION);
			
			if (reply == JOptionPane.YES_OPTION) {				
				parent.getTabbedPane().setSelectedComponent(parent.getPanel_1());
				parent.getJComboBox_3().setSelectedItem(parent.getJComboBox_12().getSelectedItem());
				parent.getJComboBox_4().setSelectedItem(parent.getJComboBox_13().getSelectedItem());
				parent.getJComboBox_5().setSelectedItem(parent.getJComboBox_14().getSelectedItem());
				parent.getJComboBox_7().setSelectedItem(parent.getJComboBox_15().getSelectedItem());
				parent.getJComboBox_8().setSelectedItem(parent.getJComboBox_16().getSelectedItem());
				parent.getJComboBox_6().setSelectedItem(parent.getJComboBox_17().getSelectedItem());
			} else {
				parent.getTabbedPane().setSelectedComponent(parent.getPanel());
				parent.getJComboBox_3().setSelectedItem(parent.getJComboBox_12().getSelectedItem());
				parent.getJComboBox_4().setSelectedItem(parent.getJComboBox_13().getSelectedItem());
				parent.getJComboBox_5().setSelectedItem(parent.getJComboBox_14().getSelectedItem());
				parent.getJComboBox_7().setSelectedItem(parent.getJComboBox_15().getSelectedItem());
				parent.getJComboBox_8().setSelectedItem(parent.getJComboBox_16().getSelectedItem());
				parent.getJComboBox_6().setSelectedItem(parent.getJComboBox_17().getSelectedItem());
			}
		}else if(actionCommand.equals("Suchen")){
			
			parent.getListModel().clear();
			overviewBook.clear();
			
			FromDD = (String) parent.getJComboBox_12().getSelectedItem();
			FromMM = (String) parent.getJComboBox_13().getSelectedItem();
			FromYY = (String) parent.getJComboBox_14().getSelectedItem();
			UntilDD = (String) parent.getJComboBox_15().getSelectedItem();
			UntilMM = (String) parent.getJComboBox_16().getSelectedItem();
			UntilYY = (String) parent.getJComboBox_17().getSelectedItem();
			
			String FromDate = FromDD+"."+FromMM+"."+FromYY;
			String UntilDate = UntilDD+"."+UntilMM+"."+UntilYY;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			try {
				Date overviewDateFrom = sdf.parse(FromDate);
				Date overviewDateUntil = sdf.parse(UntilDate);
				
				for (int i=0; i < ReadWrite.bookingDateFrom.size(); i++){
					datesFrom = ReadWrite.bookingDateFrom.get(i);
					datesUntil = ReadWrite.bookingDateUntil.get(i);
					rooms = ReadWrite.bookingRoom.get(i);
					
					Date dateFrom = sdf.parse(datesFrom);
					Date dateUntil = sdf.parse(datesUntil);
					
					if(((dateFrom.after(overviewDateFrom) || dateFrom.equals(overviewDateFrom)) && (dateFrom.before(overviewDateUntil) || dateFrom.equals(overviewDateUntil))) || ((dateUntil.after(overviewDateFrom) || dateUntil.equals(overviewDateFrom)) && (dateUntil.before(overviewDateUntil) || dateUntil.equals(overviewDateUntil)))){
						overviewBook.add(rooms+": "+datesFrom+" - "+datesUntil);
					}
				}
				
				for (int i =0; i < overviewBook.size(); i++){
					parent.getListModel().addElement(overviewBook.get(i));
				}				
				parent.getListFreeRooms().setModel(parent.getListModel());
			} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
}
