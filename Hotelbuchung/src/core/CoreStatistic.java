package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GuiMain;

public class CoreStatistic implements ActionListener {

	private static GuiMain parent;
	
	public CoreStatistic(GuiMain parent) {
		super();
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
	
		if (actionCommand.equals("Aktualisieren")){
			parent.getEconCount().setText(ReadWrite.economyCount+"");
			parent.getBusiCount().setText(ReadWrite.businessCount+"");
			parent.getSuiCount().setText(ReadWrite.suiteCount+"");
			parent.getCanCount().setText(ReadWrite.cancelCount+"");
		}
	}
	
}