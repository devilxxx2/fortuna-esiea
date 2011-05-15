package fr.fortuna.game;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fr.fortuna.game.charts.StatChartGains;
import fr.fortuna.game.charts.StatChartNumeros;

public class StatsGeneralesDialog extends JDialog {

	JPanel mainPanel, panel;

	public StatsGeneralesDialog(Window owner, String title, StatChartNumeros chartNums, StatChartNumeros chartSpecial) {
		super(owner, title);

		JTabbedPane tab=new JTabbedPane(JTabbedPane.BOTTOM);
		
		
		tab.addTab("Statistiques des numéros", chartNums.getContentPane());
		tab.addTab("Statistiques des étoiles", chartSpecial.getContentPane());
		add(tab);

		setVisible(true);
		setResizable(false);
		pack();
		
		setModalityType(ModalityType.APPLICATION_MODAL);

	}

/*
	public static void main(String args[]) {
		
		TirageEuromillions tt=new TirageEuromillions();
		tt.generate();
		
		StatChartsGagnantEuromillion ss=new StatChartsGagnantEuromillion("blou", tt);
		
		StatChartNumeros chart = new StatChartNumeros("Statistiques",true);
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
		StatChartNumeros chart1 = new StatChartNumeros("Statistiques",false);
		chart1.pack();
		RefineryUtilities.centerFrameOnScreen(chart1);
		chart1.setVisible(true);
		new StatsDialog(new JFrame(), "Bloup", ss, chart);


	}
*/

}