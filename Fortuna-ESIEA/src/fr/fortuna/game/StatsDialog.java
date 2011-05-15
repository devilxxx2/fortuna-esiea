package fr.fortuna.game;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fr.fortuna.game.charts.StatChartGagnants;
import fr.fortuna.game.charts.StatChartGains;

public class StatsDialog extends JDialog {

	JPanel mainPanel, panel;

	public StatsDialog(Window owner, String title, StatChartGagnants chartGagants, StatChartGains chartGains) {
		super(owner, title);

		JTabbedPane tab=new JTabbedPane(JTabbedPane.BOTTOM);
		mainPanel=new JPanel();

		tab.addTab("Statistiques gagants",chartGagants.getContentPane());
		tab.addTab("Statistiques gain",chartGains.getContentPane());

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