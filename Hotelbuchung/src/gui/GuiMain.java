package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import core.CoreBooking;
import core.CoreCancellation;
import core.CoreRegister;
import core.ReadWrite;
import core.CoreOverview;
import core.CoreStatistic;

import java.io.IOException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JEditorPane;

import org.jdom2.JDOMException;

import javax.swing.JList;

import java.awt.Font;



public class GuiMain extends JFrame {
	
	public static Object item;
	public static Object item2;

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JLabel lblWohnort;
	private JLabel lblGeburtsdatum;
	private JLabel lblNr;
	private JLabel lblStadt;
	private JLabel lblPlz;
	private JTextField RegisterName;
	private JTextField RegisterSurname;
	private JTextField RegisterStreet;
	private JTextField RegisterCity;
	private JTextField RegisterStreetNo;
	private JTextField RegisterPostcode;
	private JLabel lblHerr;
	private JLabel lblDdmmyyyy;
	private JLabel lblZeitraum;
	private JComboBox BookingCategory;
	private JComboBox Arrangement;
	private JComboBox BookingFromDD;
	private JComboBox BookingFromMM;
	private JComboBox BookingFromYY;
	private JComboBox BookingUntilYY;
	private JComboBox BookingUntilDD;
	private JComboBox BookingUntilMM;
	private JComboBox RegisterBdayMM;
	private JComboBox RegisterBdayDD;
	private JComboBox RegisterBdayYY;
	private JComboBox OverviewFromDD;
	private JComboBox OverviewFromMM;
	private JComboBox OverviewFromYY;
	private JComboBox OverviewUntilDD;
	private JComboBox OverviewUntilMM;
	private JComboBox OverviewUntilYY;
	private JComboBox RegisterGender;
	private JComboBox JComboBox;
	private JEditorPane editorBookingBday;
	private JComboBox BookingCustomer;
	private JComboBox CancelationCustomer;
	public static DefaultComboBoxModel comboboxModel;
	public static DefaultComboBoxModel comboboxModelBookings;
	private DefaultListModel listModel = new DefaultListModel();
	private JList listFreeRooms;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblStornierungen;
	private JLabel econCount;
	private JLabel busiCount;
	private JLabel suiCount;
	private JLabel canCount;
	private JLabel todayCustomers;
	private JLabel todayCustomersCount;
	private JLabel todayCheckins;
	private JLabel todayCheckouts;
	private JLabel lblCheckins;
	private JLabel lblCheckouts;
	
	

	/**
	 * Launch the application.
	 * @throws JDOMException 
	 */
	public static void main(String[] args) throws JDOMException {
		try {
			ReadWrite.ReadFromFile();
			ReadWrite.LoadStatistics();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain frame = new GuiMain();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GuiMain() throws IOException {
		setTitle("Hotel \"Superladen\"");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		tabbedPane.setToolTipText("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int tag = cal.get(Calendar.DAY_OF_MONTH);
		int monat = cal.get(Calendar.MONTH)+1;
		int jahr = cal.get(Calendar.YEAR);
		
		CoreOverview searchButton = new CoreOverview(this);
		CoreOverview OvButton = new CoreOverview(this);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("\u00DCbersicht", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("von");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 59, 63, 14);
		panel_4.add(label);
		
		OverviewFromDD = new JComboBox();
		OverviewFromDD.setBounds(83, 57, 44, 20);
		panel_4.add(OverviewFromDD);
		
		OverviewFromMM = new JComboBox();
		OverviewFromMM.setBounds(133, 57, 50, 20);
		panel_4.add(OverviewFromMM);
		
		OverviewFromYY = new JComboBox();
		OverviewFromYY.setBounds(189, 57, 57, 20);
		panel_4.add(OverviewFromYY);
		
		JLabel label_1 = new JLabel(" bis");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(252, 59, 63, 14);
		panel_4.add(label_1);
		
		OverviewUntilDD = new JComboBox();
		OverviewUntilDD.setBounds(325, 59, 44, 20);
		panel_4.add(OverviewUntilDD);
		
		OverviewUntilMM = new JComboBox();
		OverviewUntilMM.setBounds(375, 59, 50, 20);
		panel_4.add(OverviewUntilMM);
		
		OverviewUntilYY = new JComboBox();
		OverviewUntilYY.setBounds(431, 59, 57, 20);
		panel_4.add(OverviewUntilYY);
		
		JLabel lblNewLabel = new JLabel("Freie Zimmer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 553, 14);
		panel_4.add(lblNewLabel);
		
		JButton btnSearch = new JButton("Suchen");
		btnSearch.addActionListener(searchButton);
		btnSearch.setBounds(232, 100, 89, 23);
		panel_4.add(btnSearch);
		
		JLabel lblFreieZimmerVerfgbar = new JLabel("Gebuchte Zimmer");
		lblFreieZimmerVerfgbar.setHorizontalAlignment(SwingConstants.CENTER);
		lblFreieZimmerVerfgbar.setBounds(10, 149, 543, 20);
		panel_4.add(lblFreieZimmerVerfgbar);
		
		JButton btnToBooking = new JButton("Zur Buchung");
		btnToBooking.addActionListener(OvButton);
		btnToBooking.setBounds(223, 327, 110, 23);
		panel_4.add(btnToBooking);
		
		JLabel lblFrDiesenZeitraum = new JLabel("F\u00FCr diesen Zeitraum buchen?");
		lblFrDiesenZeitraum.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrDiesenZeitraum.setBounds(10, 293, 533, 23);
		panel_4.add(lblFrDiesenZeitraum);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 180, 273, 102);
		panel_4.add(scrollPane);
		
		listFreeRooms = new JList();
		scrollPane.setViewportView(listFreeRooms);
		
		panel = new JPanel();
		tabbedPane.addTab("Registrierung", null, panel, null);
		panel.setLayout(null);

		lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(146, 90, 68, 14);
		panel.add(lblVorname);

		RegisterName = new JTextField();
		RegisterName.setBounds(239, 89, 86, 20);
		panel.add(RegisterName);
		RegisterName.setColumns(10);

		lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(146, 116, 68, 14);
		panel.add(lblNachname);

		RegisterSurname = new JTextField();
		RegisterSurname.setBounds(239, 115, 86, 20);
		RegisterSurname.setColumns(10);
		panel.add(RegisterSurname);

		lblWohnort = new JLabel("Stra\u00DFe");
		lblWohnort.setBounds(146, 142, 68, 14);
		panel.add(lblWohnort);

		RegisterStreet = new JTextField();
		RegisterStreet.setBounds(239, 141, 86, 20);
		RegisterStreet.setColumns(10);
		panel.add(RegisterStreet);

		lblNr = new JLabel("Nr.");
		lblNr.setBounds(333, 144, 22, 14);
		panel.add(lblNr);

		RegisterStreetNo = new JTextField();
		RegisterStreetNo.setBounds(365, 142, 30, 20);
		panel.add(RegisterStreetNo);
		RegisterStreetNo.setColumns(3);

		lblStadt = new JLabel("Stadt");
		lblStadt.setBounds(146, 168, 68, 14);
		panel.add(lblStadt);

		RegisterCity = new JTextField();
		RegisterCity.setBounds(239, 167, 86, 20);
		RegisterCity.setColumns(10);
		panel.add(RegisterCity);

		lblPlz = new JLabel("PLZ");
		lblPlz.setBounds(331, 170, 24, 14);
		panel.add(lblPlz);

		RegisterPostcode = new JTextField();
		RegisterPostcode.setBounds(365, 168, 46, 20);
		RegisterPostcode.setColumns(5);
		panel.add(RegisterPostcode);

		lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(146, 194, 83, 14);
		panel.add(lblGeburtsdatum);

		lblHerr = new JLabel("Anrede");
		lblHerr.setBounds(146, 64, 68, 14);
		panel.add(lblHerr);

		RegisterGender = new JComboBox();
		RegisterGender.setBounds(239, 64, 86, 20);
		panel.add(RegisterGender);
		RegisterGender.addItem("Herr");
		RegisterGender.addItem("Frau");

		JButton btnRegister = new JButton("Registrieren");
		CoreRegister regButton = new CoreRegister(this);
		btnRegister.addActionListener(regButton);
		btnRegister.setBounds(146, 275, 114, 23);
		panel.add(btnRegister);

		JButton btnNewButton_1 = new JButton("Abbrechen");
		CoreRegister cancelButton = new CoreRegister(this);
		btnNewButton_1.addActionListener(cancelButton);
		btnNewButton_1.setBounds(281, 275, 114, 23);
		panel.add(btnNewButton_1);
		
		RegisterBdayDD = new JComboBox();
		RegisterBdayDD.setBounds(239, 193, 48, 20);
		panel.add(RegisterBdayDD);
		for(int i=1; i<32; i++){
			if (i<10){
				RegisterBdayDD.addItem("0"+i);
			}else{
				RegisterBdayDD.addItem(""+i);	
			}
		}
		
		RegisterBdayMM = new JComboBox();
		RegisterBdayMM.setBounds(297, 193, 50, 20);
		panel.add(RegisterBdayMM);
		for(int i = 1; i<13; i++){
			if (i<10){
				RegisterBdayMM.addItem("0"+i);
			}else{
				RegisterBdayMM.addItem(""+i);	
			}
		}
		
		RegisterBdayYY = new JComboBox();
		RegisterBdayYY.setBounds(354, 193, 57, 20);
		panel.add(RegisterBdayYY);
		
		for(int i=1; i<100; i++){
			if (i<10){
			RegisterBdayYY.addItem("190"+i);	
			}
			else{
			RegisterBdayYY.addItem("19"+i);
			}
		}
		int year = jahr - 2000;
		for(int i=0; i<=year; i++){
			if(i<10){
			RegisterBdayYY.addItem("200"+i);
			}
			else{
			RegisterBdayYY.addItem("20"+i);
			}
		}

		panel_1 = new JPanel();
		tabbedPane.addTab("Buchung", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblKunde = new JLabel("Kunde");
		lblKunde.setBounds(48, 64, 37, 14);
		panel_1.add(lblKunde);

		JLabel lblKategorie = new JLabel("Kategorie");
		lblKategorie.setBounds(277, 158, 63, 14);
		panel_1.add(lblKategorie);

		BookingCategory = new JComboBox();
		BookingCategory.setBounds(365, 157, 130, 20);
		panel_1.add(BookingCategory);
		BookingCategory.addItem("Economy");
		BookingCategory.addItem("Business");
		BookingCategory.addItem("Suite");

		JLabel lblArrangement = new JLabel("Arrangement");
		lblArrangement.setBounds(277, 190, 83, 14);
		panel_1.add(lblArrangement);

		Arrangement = new JComboBox();
		Arrangement.setBounds(365, 188, 130, 20);
		panel_1.add(Arrangement);
		Arrangement.addItem("Bed & Breakfast");
		Arrangement.addItem("Halbpension");
		Arrangement.addItem("Vollpension");

		JButton btnBooking = new JButton("Buchen");
		CoreBooking bookButton = new CoreBooking(this);
		btnBooking.addActionListener(bookButton);
		btnBooking.setBounds(146, 275, 114, 23);
		panel_1.add(btnBooking);

		JButton btnBookingCancel = new JButton("Abbrechen");
		btnBookingCancel.setBounds(281, 275, 114, 23);
		panel_1.add(btnBookingCancel);

		lblZeitraum = new JLabel("von");
		lblZeitraum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZeitraum.setBounds(10, 163, 63, 14);
		panel_1.add(lblZeitraum);

		lblDdmmyyyy = new JLabel(" bis");
		lblDdmmyyyy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDdmmyyyy.setBounds(10, 188, 63, 14);
		panel_1.add(lblDdmmyyyy);

		BookingFromDD = new JComboBox();
		BookingFromDD.setBounds(83, 161, 44, 20);
		panel_1.add(BookingFromDD);
		for (int i=1; i<32; i++){
			if (i<10){
				BookingFromDD.addItem("0"+i);
			}else{
				BookingFromDD.addItem(""+i);	
			}
		}
		if(tag < 10){
			BookingFromDD.setSelectedItem("0"+tag);
		}else{
			BookingFromDD.setSelectedItem(""+tag);	
		}
		
		BookingFromMM = new JComboBox();
		BookingFromMM.setBounds(133, 161, 50, 20);
		panel_1.add(BookingFromMM);
		for(int i = 1; i<13; i++){
			if (i<10){
				BookingFromMM.addItem("0"+i);
			}else{
				BookingFromMM.addItem(""+i);	
			}
		}
		if(monat < 10){
			BookingFromMM.setSelectedItem("0"+monat);
		}else{
			BookingFromMM.setSelectedItem(""+monat);	
		}

		BookingFromYY = new JComboBox();
		BookingFromYY.setBounds(189, 161, 57, 20);
		panel_1.add(BookingFromYY);
		for (int y=year; y<100;y++){
				BookingFromYY.addItem("20"+y);
		}
		BookingFromYY.setSelectedItem(""+jahr);
		
		BookingUntilYY = new JComboBox();
		BookingUntilYY.setBounds(189, 188, 57, 20);
		panel_1.add(BookingUntilYY);
		for (int y=year; y<100;y++){
				BookingUntilYY.addItem("20"+y);
		}
		BookingUntilYY.setSelectedItem(""+jahr);
		
		BookingUntilDD = new JComboBox();
		BookingUntilDD.setBounds(83, 188, 44, 20);
		panel_1.add(BookingUntilDD);
		for (int i=1; i<32; i++){
			if (i<10){
				BookingUntilDD.addItem("0"+i);
			}else{
				BookingUntilDD.addItem(""+i);	
			}
		}
		if(tag < 10){
			BookingUntilDD.setSelectedItem("0"+tag);
		}else{
			BookingUntilDD.setSelectedItem(""+tag);	
		}
		
		BookingUntilMM = new JComboBox();
		BookingUntilMM.setBounds(133, 188, 50, 20);
		panel_1.add(BookingUntilMM);
		for(int i = 1; i<13; i++){
			if (i<10){
				BookingUntilMM.addItem("0"+i);
			}else{
				BookingUntilMM.addItem(""+i);	
			}
		}
		if(monat < 10){
			BookingUntilMM.setSelectedItem("0"+monat);
		}else{
			BookingUntilMM.setSelectedItem(""+monat);	
		}
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setToolTipText("");
		editorPane.setBounds(90, 90, 156, 56);
		panel_1.add(editorPane);
		
		BookingCustomer = new JComboBox();
		BookingCustomer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					item = arg0.getItem();
						ReadWrite.ReadBdayForBooking = 1;
					try {
						ReadWrite.ReadBirthday();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					editorPane.setText(ReadWrite.bDay+"\n"
									+  ReadWrite.street+"\n"
									+  ReadWrite.city+"\n");
				}
			}
		});
		BookingCustomer.setBounds(90, 61, 156, 20);
		panel_1.add(BookingCustomer);
		comboboxModel = (DefaultComboBoxModel) BookingCustomer.getModel();
		comboboxModel.removeAllElements();
		ReadWrite.customerList.toArray(); // to array :)
//		Vector<String> VectorCos = new Vector<String>();
//		VectorCos.addAll(Arrays.asList(ReadWrite.customerList));
		for (String customer : ReadWrite.customerList){
			comboboxModel.addElement(customer);
		}
		BookingCustomer.setModel(comboboxModel);
		
		JLabel lblGeburtstag = new JLabel("Geburtstag");
		lblGeburtstag.setBounds(20, 89, 65, 20);
		panel_1.add(lblGeburtstag);
		
		JButton deleteCustomer = new JButton("Kunden l\u00F6schen");
		CoreBooking deleteCustomerBtn = new CoreBooking(this);
		deleteCustomer.addActionListener(deleteCustomerBtn);
		deleteCustomer.setBounds(332, 61, 163, 20);
		panel_1.add(deleteCustomer);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Stornierung", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnStornieren = new JButton("Stornieren");
		CoreCancellation cancellationButton = new CoreCancellation(this);
		btnStornieren.addActionListener(cancellationButton);		
		btnStornieren.setBounds(146, 275, 114, 23);
		panel_2.add(btnStornieren);
		
		JButton button_2 = new JButton("Abbrechen");
		button_2.setBounds(281, 275, 114, 23);
		panel_2.add(button_2);
		
		final JEditorPane CancelationBday;
		CancelationBday = new JEditorPane();
		CancelationBday.setToolTipText("");
		CancelationBday.setEditable(false);
		CancelationBday.setBounds(146, 107, 249, 104);
		panel_2.add(CancelationBday);
		
		CancelationCustomer = new JComboBox();
		CancelationCustomer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					item2 = arg0.getItem();
					
					try {
						ReadWrite.ReadFromBookings();
					} catch (IOException | JDOMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					CancelationBday.setText("Geburtstag: \t"+ReadWrite.bDay2+"\n"
											+"Kategorie: \t"+ReadWrite.bookingCategory+"\n"
											+"Arrangement: \t"+ReadWrite.bookingArrangement+"\n"
											+"Von: \t"+ReadWrite.dayFrom+"\n"
											+"Bis: \t"+ReadWrite.dayUntil);
				}
			}
		});
		CancelationCustomer.setBounds(214, 78, 156, 20);
		panel_2.add(CancelationCustomer);
		comboboxModelBookings = (DefaultComboBoxModel) CancelationCustomer.getModel();
		comboboxModelBookings.removeAllElements();
		ReadWrite.cancelBookingList.toArray();
		for (String customers : ReadWrite.cancelBookingList){
			comboboxModelBookings.addElement(customers);
		}
		CancelationCustomer.setModel(comboboxModelBookings);
		
		JLabel label_3 = new JLabel("Kunde");
		label_3.setBounds(172, 81, 37, 14);
		panel_2.add(label_3);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Statistik", null, panel_3, null);
		panel_3.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Economy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(100, 60, 80, 14);
		panel_3.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Business");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(100, 85, 80, 14);
		panel_3.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Suite");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(100, 110, 80, 14);
		panel_3.add(lblNewLabel_3);
		
		lblStornierungen = new JLabel("Stornierungen");
		lblStornierungen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStornierungen.setBounds(100, 135, 100, 14);
		panel_3.add(lblStornierungen);
		
		econCount = new JLabel(""+ReadWrite.economyCount);
		econCount.setBounds(210, 60, 46, 14);
		panel_3.add(econCount);
		
		busiCount = new JLabel(""+ReadWrite.businessCount);
		busiCount.setBounds(210, 85, 46, 14);
		panel_3.add(busiCount);
		
		suiCount = new JLabel(""+ReadWrite.suiteCount);
		suiCount.setBounds(210, 110, 46, 14);
		panel_3.add(suiCount);
		
		canCount = new JLabel(""+ReadWrite.cancelCount);
		canCount.setBounds(210, 135, 46, 14);
		panel_3.add(canCount);
		
		CoreStatistic.CurrentDate();
		
		todayCustomers = new JLabel("Heutige Kunden");
		todayCustomers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		todayCustomers.setBounds(290, 60, 120, 14);
		panel_3.add(todayCustomers);
		
		todayCustomersCount = new JLabel(""+CoreStatistic.todayCounter);
		todayCustomersCount.setBounds(410, 60, 46, 14);
		panel_3.add(todayCustomersCount);
		
		lblCheckins = new JLabel("Heutige Anreisen");
		lblCheckins.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCheckins.setBounds(290, 85, 120, 14);
		panel_3.add(lblCheckins);
		
		todayCheckins = new JLabel(""+CoreStatistic.todayCheckin);
		todayCheckins.setBounds(410, 85, 46, 14);
		panel_3.add(todayCheckins);
		
		lblCheckouts = new JLabel("Heutige Abreisen");
		lblCheckouts.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCheckouts.setBounds(290, 110, 120, 14);
		panel_3.add(lblCheckouts);
		
		todayCheckouts = new JLabel(""+CoreStatistic.todayCheckout);
		todayCheckouts.setBounds(410, 110, 46, 14);
		panel_3.add(todayCheckouts);
		
		JButton btnAktualisieren = new JButton("Aktualisieren");
		CoreStatistic RefButton = new CoreStatistic(this);
		btnAktualisieren.addActionListener(RefButton);
		btnAktualisieren.setBounds(223, 327, 110, 23);
		panel_3.add(btnAktualisieren);
		for(int i=1; i<32; i++){
			if (i<10){
				OverviewFromDD.addItem("0"+i);
			}else{
				OverviewFromDD.addItem(""+i);	
			}
			
		}
		if(tag < 10){
			OverviewFromDD.setSelectedItem("0"+tag);
		}else{
			OverviewFromDD.setSelectedItem(""+tag);	
		}
		for(int i = 1; i<13; i++){
			if (i<10){
				OverviewFromMM.addItem("0"+i);
			}else{
				OverviewFromMM.addItem(""+i);	
			}
		}
		if(monat < 10){
			OverviewFromMM.setSelectedItem("0"+monat);
		}else{
			OverviewFromMM.setSelectedItem(""+monat);	
		}
		for(int i=14; i<100; i++){
			OverviewFromYY.addItem("20"+i);
		}
		for(int i=1; i<32; i++){
			if (i<10){
				OverviewUntilDD.addItem("0"+i);
			}else{
				OverviewUntilDD.addItem(""+i);
			}
		}
		if(tag < 10){
			OverviewUntilDD.setSelectedItem("0"+tag);
		}else{
			OverviewUntilDD.setSelectedItem(""+tag);	
		}
		for(int i = 1; i<13; i++){
			if (i<10){
				OverviewUntilMM.addItem("0"+i);
			}else{
				OverviewUntilMM.addItem(""+i);	
			}
		}
		if(monat < 10){
			OverviewUntilMM.setSelectedItem("0"+monat);
		}else{
			OverviewUntilMM.setSelectedItem(""+monat);	
		}
		for(int i=14; i<100; i++){
			OverviewUntilYY.addItem("20"+i);
		}
		
		OverviewUntilYY.setSelectedItem(""+jahr);
		OverviewFromYY.setSelectedItem(""+jahr);
		contentPane.setLayout(gl_contentPane);
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JEditorPane getEditorPane() {
		return editorBookingBday;
	}

	public void setEditorPane(JEditorPane editorPane) {
		this.editorBookingBday = editorPane;
	}

	public JComboBox getComboBox() {
		return BookingCustomer;
	}

	public static void setComboBox(JComboBox comboBox) {
		comboBox = comboBox;
	}

	public JComboBox getJComboBox_1() {
		return BookingCategory;
	}

	public void setJComboBox_1(JComboBox jComboBox_1) {
		BookingCategory = jComboBox_1;
	}

	public JComboBox getJComboBox_6() {
		return BookingUntilYY;
	}

	public void setJComboBox_6(JComboBox jComboBox_6) {
		BookingUntilYY = jComboBox_6;
	}

	public JComboBox getJComboBox_7() {
		return BookingUntilDD;
	}

	public void setJComboBox_7(JComboBox jComboBox_7) {
		BookingUntilDD = jComboBox_7;
	}

	public JComboBox getJComboBox_8() {
		return BookingUntilMM;
	}

	public void setJComboBox_8(JComboBox jComboBox_8) {
		BookingUntilMM = jComboBox_8;
	}

	public JComboBox getJComboBox_12() {
		return OverviewFromDD;
	}

	public void setJComboBox_12(JComboBox jComboBox_12) {
		OverviewFromDD = jComboBox_12;
	}

	public JComboBox getJComboBox_13() {
		return OverviewFromMM;
	}

	public void setJComboBox_13(JComboBox jComboBox_13) {
		OverviewFromMM = jComboBox_13;
	}

	public JComboBox getJComboBox_14() {
		return OverviewFromYY;
	}

	public void setJComboBox_14(JComboBox jComboBox_14) {
		OverviewFromYY = jComboBox_14;
	}

	public JComboBox getJComboBox_15() {
		return OverviewUntilDD;
	}

	public void setJComboBox_15(JComboBox jComboBox_15) {
		OverviewUntilDD = jComboBox_15;
	}

	public JComboBox getJComboBox_16() {
		return OverviewUntilMM;
	}

	public void setJComboBox_16(JComboBox jComboBox_16) {
		OverviewUntilMM = jComboBox_16;
	}

	public JComboBox getJComboBox_17() {
		return OverviewUntilYY;
	}

	public void setJComboBox_17(JComboBox jComboBox_17) {
		OverviewUntilYY = jComboBox_17;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JPanel getPanel_3() {
		return panel_3;
	}

	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}

	public JTextField getTextField() {
		return RegisterName;
	}

	public void setTextField(JTextField textField) {
		textField.setText("");
		this.RegisterName = textField;
	}

	public JTextField getTextField_1() {
		return RegisterSurname;
	}

	public void setTextField_1(JTextField textField_1) {
		this.RegisterSurname = textField_1;
	}

	public JTextField getTextField_2() {
		return RegisterStreet;
	}

	public void setTextField_2(JTextField textField_2) {
		this.RegisterStreet = textField_2;
	}

	public JTextField getTextField_3() {
		return RegisterCity;
	}

	public void setTextField_3(JTextField textField_3) {
		this.RegisterCity = textField_3;
	}

	public JTextField getTextField_5() {
		return RegisterStreetNo;
	}

	public void setTextField_5(JTextField textField_5) {
		this.RegisterStreetNo = textField_5;
	}

	public JTextField getTextField_6() {
		return RegisterPostcode;
	}

	public void setTextField_6(JTextField textField_6) {
		this.RegisterPostcode = textField_6;
	}

	public JComboBox getJComboBox_2() {
		return Arrangement;
	}

	public void setJComboBox_2(JComboBox jComboBox_2) {
		Arrangement = jComboBox_2;
	}

	public JComboBox getJComboBox_3() {
		return BookingFromDD;
	}

	public void setJComboBox_3(JComboBox jComboBox_3) {
		BookingFromDD = jComboBox_3;
	}

	public JComboBox getJComboBox_4() {
		return BookingFromMM;
	}

	public void setJComboBox_4(JComboBox jComboBox_4) {
		BookingFromMM = jComboBox_4;
	}

	public JComboBox getJComboBox_5() {
		return BookingFromYY;
	}

	public void setJComboBox_5(JComboBox jComboBox_5) {
		BookingFromYY = jComboBox_5;
	}

	public JComboBox getJComboBox_10() {
		return RegisterBdayDD;
	}

	public void setJComboBox_10(JComboBox jComboBox_10) {
		RegisterBdayDD = jComboBox_10;
	}

	public JComboBox getJComboBox_9() {
		return RegisterBdayMM;
	}

	public void setJComboBox_9(JComboBox jComboBox_9) {
		RegisterBdayMM = jComboBox_9;
	}

	public JComboBox getJComboBox_11() {
		return RegisterBdayYY;
	}

	public void setJComboBox_11(JComboBox jComboBox_11) {
		RegisterBdayYY = jComboBox_11;
	}

	public JComboBox getJComboBox_18() {
		return RegisterGender;
	}

	public void setJComboBox_18(JComboBox jComboBox_18) {
		this.RegisterGender = jComboBox_18;
	}

	public JComboBox getJComboBox() {
		return JComboBox;
	}

	public void setJComboBox(JComboBox jComboBox) {
		JComboBox = jComboBox;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}

	public JList getListFreeRooms() {
		return listFreeRooms;
	}

	public void setListFreeRooms(JList listFreeRooms) {
		this.listFreeRooms = listFreeRooms;
	}

	public JComboBox getCancelationCustomer() {
		return CancelationCustomer;
	}

	public void setCancelationCustomer(JComboBox cancelationCustomer) {
		CancelationCustomer = cancelationCustomer;
	}

	public JLabel getEconCount() {
		return econCount;
	}

	public void setEconCount(JLabel econCount) {
		this.econCount = econCount;
	}

	public JLabel getBusiCount() {
		return busiCount;
	}

	public void setBusiCount(JLabel busiCount) {
		this.busiCount = busiCount;
	}

	public JLabel getSuiCount() {
		return suiCount;
	}

	public void setSuiCount(JLabel suiCount) {
		this.suiCount = suiCount;
	}

	public JLabel getCanCount() {
		return canCount;
	}

	public void setCanCount(JLabel canCount) {
		this.canCount = canCount;
	}

	public JLabel getTodayCustomersCount() {
		return todayCustomersCount;
	}

	public void setTodayCustomersCount(JLabel todayCustomersCount) {
		this.todayCustomersCount = todayCustomersCount;
	}

	public JLabel getTodayCheckins() {
		return todayCheckins;
	}

	public void setTodayCheckins(JLabel todayCheckins) {
		this.todayCheckins = todayCheckins;
	}

	public JLabel getTodayCheckouts() {
		return todayCheckouts;
	}

	public void setTodayCheckouts(JLabel todayCheckouts) {
		this.todayCheckouts = todayCheckouts;
	}
}
