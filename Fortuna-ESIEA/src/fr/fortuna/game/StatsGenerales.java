package fr.fortuna.game;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JPanel;
import fr.fortuna.game.charts.StatChartGains;

public class StatsGenerales extends JDialog {

	JPanel mainPanel, panel;

	public StatsGenerales(Window owner, String title, StatChartGains chartGains) {
		super(owner, title);

		add(chartGains);


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