package fr.fortuna.game;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.ui.RefineryUtilities;

import fr.fortuna.controller.TirageEuromillions;
import fr.fortuna.game.charts.StatChartsGagnantEuromillion;

public class StatsDialog extends JDialog {

	JPanel mainPanel, panel;

	private StatsDialog() {
		super();


		setModalityType(ModalityType.APPLICATION_MODAL);


	}

	public StatsDialog(Window owner, String title, StatChartGagnants chartGagants, StatChartNumeros chartNums) {
		super(owner, title);

		JTabbedPane tab=new JTabbedPane(JTabbedPane.BOTTOM);
		mainPanel=new JPanel();

		tab.addTab("Statistiques gagants",chartGagants);
		tab.addTab("Statistiques gain",chartNums);

		add(tab);

		setVisible(true);
		setResizable(false);
		pack();
		setModalityType(ModalityType.APPLICATION_MODAL);


	}


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



}
