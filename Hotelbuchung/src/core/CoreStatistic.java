package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import gui.GuiMain;

public class CoreStatistic implements ActionListener {

	private static GuiMain parent;

	public static String currentDate;
	public static int todayCounter = 0;
	public static int todayCheckin = 0;
	public static int todayCheckout = 0;

	public CoreStatistic(GuiMain parent) {
		super();
		this.parent = parent;
	}

	public static void CurrentDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int tag = cal.get(Calendar.DAY_OF_MONTH);
		int monat = cal.get(Calendar.MONTH) + 1;
		int jahr = cal.get(Calendar.YEAR);

		currentDate = tag + "." + monat + "." + jahr;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date today;
		try {
			today = sdf.parse(currentDate);

			for (int i = 0; i < ReadWrite.bookingDateFrom.size(); i++) {
				String fromDate = ReadWrite.bookingDateFrom.get(i);
				String untilDate = ReadWrite.bookingDateUntil.get(i);

				Date from = sdf.parse(fromDate);
				Date until = sdf.parse(untilDate);

				if (today.equals(from) || today.equals(until)
						|| (today.after(from) && today.before(until))) {
					todayCounter++;
				}
				
				if (today.equals(from)){
					todayCheckin++;
				}
				
				if (today.equals(until)){
					todayCheckout++;
				}

			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		if (actionCommand.equals("Aktualisieren")) {
			parent.getEconCount().setText(ReadWrite.economyCount + "");
			parent.getBusiCount().setText(ReadWrite.businessCount + "");
			parent.getSuiCount().setText(ReadWrite.suiteCount + "");
			parent.getCanCount().setText(ReadWrite.cancelCount + "");
			
			todayCounter = 0;
			todayCheckin = 0;
			todayCheckout = 0;
			CurrentDate();
			parent.getTodayCustomersCount().setText(todayCounter + "");
			parent.getTodayCheckins().setText(todayCheckin + "");
			parent.getTodayCheckouts().setText(todayCheckout + "");
		}
	}

}