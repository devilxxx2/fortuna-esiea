package fr.fortuna.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import fr.fortuna.controller.Loto;
import fr.fortuna.controller.TirageEuromillions;
import fr.fortuna.controller.TirageLoto;
import fr.fortuna.dao.LotoCsvTirageDAO;

public class StatChartGagnants extends ApplicationFrame {

	private HashMap<TirageLoto,HashMap<Integer, Double>> resultatStat; 
	private HashMap<Integer, Double> result;
	
	public StatChartGagnants(String title, TirageEuromillions tirage){
		super(title);
		result=tirage.calculStatGagnantEurope();
		// création des panels de base
		JPanel pan = new JPanel(new BorderLayout());
		JPanel panMid = new JPanel();
		pan.add(panMid, BorderLayout.CENTER);
		// création du panel de diagramme
		JPanel jpanelChart = createPanel();
		jpanelChart.setPreferredSize(new Dimension(500, 600));
		setContentPane(pan);
		panMid.add(jpanelChart);
	}
	
	public JPanel createPanel() {
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}
	
	private CategoryDataset createDataset() {
		Double value = 0.0;// La statistique à afficher
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		// récupération de la stat par numéro/étoile
		for (int i = 0; i < result.size(); ++i) {
			value = result.get(i);
			System.out.println(value);
			defaultcategorydataset.addValue(value, "Rang",String.valueOf(i));
		}
		return defaultcategorydataset;
	}
	
	private JFreeChart createChart(CategoryDataset categorydataset) {
		JFreeChart jfreechart = ChartFactory
				.createBarChart("Pourcentage de gagnants à un rang", "Rangs",
						"", categorydataset, PlotOrientation.HORIZONTAL, false,
						true, false);
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
		categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		categoryplot.setRangePannable(true);
		BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();
		ChartUtilities.applyCurrentTheme(jfreechart);
		barrenderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barrenderer
				.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator(
						"", new DecimalFormat("0")));
		barrenderer.setItemLabelAnchorOffset(9D);
		barrenderer.setBaseItemLabelsVisible(true);
		CategoryAxis categoryaxis = categoryplot.getDomainAxis();
		categoryaxis.setCategoryMargin(0.25D);
		categoryaxis.setUpperMargin(0.02D);
		categoryaxis.setLowerMargin(0.02D);
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setUpperMargin(0.10000000000000001D);
		return jfreechart;
	}
	

}
