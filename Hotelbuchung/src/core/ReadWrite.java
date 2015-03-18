package core;
import core.CoreRegister;
import gui.GuiMain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class ReadWrite {
	
	public static String bDay;
	public static String bDay2;
	public static String street;
	public static String city;
	public static String bookingCategory;
	public static String bookingArrangement;
	public static String dayFrom;
	public static String dayUntil;
	public static String overviewRoom;
	public static String overviewDateF;
	public static String overviewDateU;
	public static List<String> bookingDateFrom = new ArrayList<String>();
	public static List<String> bookingDateUntil = new ArrayList<String>();
	public static List<String> bookingRoom = new ArrayList<String>();
	public static List<String> cancelBookingList = new ArrayList<String>();
	public static List<String> customerList = new ArrayList<String>();
	public static byte whichFunction = 0;
	public static byte ReadBdayForBooking;
	public static int economyCount;
	public static int businessCount;
	public static int suiteCount;
	public static int cancelCount;
	
	public static void main(String[] args) throws IOException, JDOMException {
		
		if(whichFunction == 1){
			WriteToFile();
			whichFunction = 0;
		}else {
			ReadFromFile();
		}
	}

	public static void WriteToFile() throws IOException, JDOMException {
		
		SAXBuilder builder = new SAXBuilder();
		File xmlCustomer = new File("SAVE//Kunden.xml");
		Document document = null;
		Element root = null;
		
		if(xmlCustomer.exists()){
			
			FileInputStream fis = new FileInputStream(xmlCustomer);
			document = builder.build(fis);
			root = document.getRootElement();
			fis.close();
		} else {
			document = new Document();
			root = new Element("customer");
			
		}
			
			Element cust1 = new Element("cust");
			cust1.addContent(new Element("gender").setText(CoreRegister.gender));
			cust1.addContent(new Element("name").setText(CoreRegister.surname + ", " + CoreRegister.name));
			cust1.addContent(new Element("birthday").setText(CoreRegister.dd + "." + CoreRegister.mm + "." + CoreRegister.yy));
			cust1.addContent(new Element("street").setText(CoreRegister.street + " " + CoreRegister.nr));
			cust1.addContent(new Element("city").setText(CoreRegister.plz + " " + CoreRegister.city));
			
			root.addContent(cust1);
			document.setContent(root);
						
			XMLOutputter xmlOutput = new XMLOutputter();
			
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, new FileOutputStream("SAVE//Kunden.xml"));
}

		

		
	public static void ReadFromFile() throws IOException {
		
		SAXBuilder builder = new SAXBuilder();
		SAXBuilder builder2 = new SAXBuilder();
		File xmlCustomer = new File("SAVE//Kunden.xml");
		File xmlCustomer2 = new File("SAVE//Booking.xml");
		FileInputStream fis = new FileInputStream(xmlCustomer);
		FileInputStream fis2 = new FileInputStream(xmlCustomer2);
		Document document;
		Document document2;
		cancelBookingList.clear();
		customerList.clear();
		
		try {
			document = builder.build(fis);
			Element root = document.getRootElement();
			fis.close();
			
		List<Element> cList = root.getChildren("cust");
		for(Element names : cList){
			String fulln = names.getChildText("name");
				customerList.add(fulln);
			}

			document2 = builder2.build(fis2);
			Element root2 = document2.getRootElement();
			fis2.close();
		
		List<Element> bList = root2.getChildren("booking");
		for(Element names : bList){
			String fulln = names.getChildText("name");
				cancelBookingList.add(fulln);
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public static void WriteBooking() throws IOException, JDOMException {
		
		SAXBuilder builder = new SAXBuilder();
		File xmlCustomer = new File("SAVE//Booking.xml");
		Document document = null;
		Element root = null;
		
		if(xmlCustomer.exists()){
			
			FileInputStream fis = new FileInputStream(xmlCustomer);
			document = builder.build(fis);
			root = document.getRootElement();
			fis.close();
		} else {
			document = new Document();
			root = new Element("bookings");
			
		}
		
		List list = root.getChildren("booking");
		
		Element booking = new Element("booking");
				
		booking.addContent(new Element("name").setText(CoreBooking.customer));
		booking.addContent(new Element("birthday").setText(bDay));
		booking.addContent(new Element("category").setText(CoreBooking.category+""));
		booking.addContent(new Element("arrangement").setText(CoreBooking.arrangement+""));
		booking.addContent(new Element("from").setText(CoreBooking.datefromdd+"."+CoreBooking.datefrommm+"."+CoreBooking.datefromyy));
		booking.addContent(new Element("until").setText(CoreBooking.dateuntildd+"."+CoreBooking.dateuntilmm+"."+CoreBooking.dateuntilyy));
		
		root.addContent(booking);
		document.setContent(root);
					
		XMLOutputter xmlOutput = new XMLOutputter();
		
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(document, new FileOutputStream("SAVE//Booking.xml"));
	}
	
	public static void ReadBirthday() throws IOException {
		SAXBuilder builder = new SAXBuilder();
		File xmlCustomer = new File("SAVE//Kunden.xml");
		FileInputStream fis = new FileInputStream(xmlCustomer);
		Document document;
		
		try {
			document = builder.build(fis);
			Element root = document.getRootElement();
			fis.close();
			
			List<Element> cList = root.getChildren("cust");
			for(Element cust : cList){
				String name = cust.getChildText("name");
				if(ReadBdayForBooking == 1){
				if(GuiMain.item.equals(name)){
					bDay = cust.getChildText("birthday");
					street = cust.getChildText("street");
					city = cust.getChildText("city");
				}}else{
				}
			}

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ReadFromBookings() throws IOException, JDOMException {
		SAXBuilder builder = new SAXBuilder();
		File xmlCustomer = new File("SAVE//Booking.xml");
		FileInputStream fis = new FileInputStream(xmlCustomer);
		Document document;
		
		document = builder.build(fis);
		Element root = document.getRootElement();
		fis.close();
		
		List<Element> bList = root.getChildren("booking");
		for(Element booking : bList){

			overviewRoom = booking.getChildText("category");
			overviewDateF = booking.getChildText("from");
			overviewDateU = booking.getChildText("until");

			if(bList.size()!=bookingDateFrom.size()){
				bookingDateFrom.add(overviewDateF);
			}
			if(bList.size()!=bookingDateUntil.size()){
				bookingDateUntil.add(overviewDateU);
			}
			if(bList.size()!=bookingRoom.size()){
				bookingRoom.add(overviewRoom);
			}
			String name = booking.getChildText("name");
			if(GuiMain.item2.equals(name)){
				bDay2 = booking.getChildText("birthday");
				bookingCategory = booking.getChildText("category");
				bookingArrangement = booking.getChildText("arrangement");
				dayFrom = booking.getChildText("from");
				dayUntil = booking.getChildText("until");
			}
		}
	}
	
	public static void DeleteBooking() throws IOException, JDOMException {
		SAXBuilder builder = new SAXBuilder();
		File xmlCustomer = new File("SAVE//Booking.xml");
		FileInputStream fis = new FileInputStream(xmlCustomer);
		Document document;
		
		document = builder.build(fis);
		Element root = document.getRootElement();
		fis.close();
		
		List<Element> bList = root.getChildren("booking");
		for(Element booking : bList){
			String name = booking.getChildText("name");

			if(GuiMain.item2.equals(name)){
				booking.getParent().removeContent(booking);
				document.setContent(root);
				
				XMLOutputter xmlOutput = new XMLOutputter();
				
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(document, new FileOutputStream("SAVE//Booking.xml"));
				return;
			}
		}
	}
	
	public static void WriteStatistics() throws IOException, JDOMException {
		SAXBuilder builder = new SAXBuilder();
		File xmlStatistic = new File ("SAVE//Statistic.xml");
		Document document = null;
		Element root = null;
		
		if (xmlStatistic.exists()){
			FileInputStream fis = new FileInputStream(xmlStatistic);
			document = builder.build(fis);
			root = document.getRootElement();
			fis.close();
		}else{
			document = new Document();
			root = new Element("statistics");
			
			Element bookings = new Element("bookings");
			
			bookings.addContent(new Element("economy").setText(""+ economyCount));
			bookings.addContent(new Element("business").setText(""+ businessCount));
			bookings.addContent(new Element("suite").setText(""+ suiteCount));
			
			root.addContent(bookings);
			root.addContent(new Element("cancellations").setText(""));
			
			document.setContent(root);
		}
		
		Element books = root.getChild("bookings");
		
		Element eco = books.getChild("economy");
		eco.setText(""+economyCount);
		
		Element busi = books.getChild("business");
		busi.setText(""+businessCount);
		
		Element sui = books.getChild("suite");
		sui.setText(""+suiteCount);
		
		Element cancel = root.getChild("cancellations");
		cancel.setText(""+cancelCount);

		XMLOutputter xmlOutput = new XMLOutputter();
		
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(document, new FileOutputStream("SAVE//Statistic.xml"));
	}
	
	public static void LoadStatistics() throws IOException, JDOMException {
		SAXBuilder builder = new SAXBuilder();
		File xmlStatistic = new File ("SAVE//Statistic.xml");
		FileInputStream fis = new FileInputStream(xmlStatistic);
		Document document;
		
		document = builder.build(fis);
		Element root = document.getRootElement();
		fis.close();
		
		Element bookings = root.getChild("bookings");
		
		String economy = bookings.getChildText("economy");
		String business = bookings.getChildText("business");
		String suite = bookings.getChildText("suite");
		
		String cancels = root.getChildText("cancellations");
		
		economyCount = Integer.parseInt(economy);
		businessCount = Integer.parseInt(business);
		suiteCount = Integer.parseInt(suite);
		cancelCount = Integer.parseInt(cancels);
	}
	
	public static void DeleteCustomer() throws IOException, JDOMException {
		SAXBuilder builder = new SAXBuilder();
		File xmlCustomer = new File("SAVE//Kunden.xml");
		File xmlBooking = new File("SAVE//Booking.xml");
		FileInputStream fis = new FileInputStream(xmlCustomer);
		FileInputStream fis2 = new FileInputStream(xmlBooking);
		Document document;
		Document document2;
		
		document = builder.build(fis);
		document2 = builder.build(fis2);
		Element root = document.getRootElement();
		Element root2 = document2.getRootElement();
		fis.close();
		fis2.close();
		
		List<Element> dList = root.getChildren("cust");
		
		for(Element customer : dList){
			String name = customer.getChildText("name");
			if(GuiMain.item.equals(name)){
				customer.getParent().removeContent(customer);
				document.setContent(root);
				
				XMLOutputter xmlOutput = new XMLOutputter();
				
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(document, new FileOutputStream("SAVE//Kunden.xml"));
				continue;
				}
		}
		
		List<Element> bookingList = root2.getChildren("booking");
		
		for(Element booking : bookingList){
			String name = booking.getChildText("name");
			if(CoreBooking.isAvailable.equals(name)){
				int reply = JOptionPane.showConfirmDialog(null, "Damit wird auch die Buchung des Kunden gelöscht!", "löschen", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION){
				booking.getParent().removeContent(booking);
				document2.setContent(root2);
				
				XMLOutputter xmlOutput = new XMLOutputter();
				
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(document2, new FileOutputStream("SAVE//Booking.xml"));
				return;
				}
			}
		}
	} 
}
