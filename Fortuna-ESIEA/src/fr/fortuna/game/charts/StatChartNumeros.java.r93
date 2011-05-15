package fr.fortuna.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import fr.fortuna.controller.Loto;
import fr.fortuna.controller.TirageLoto;
import fr.fortuna.dao.LotoCsvTirageDAO;

/**
 * @author Vegas
 *
 */
public class StatChartNumeros extends ApplicationFrame{
	
	/*statistiques à afficher*/
	private ArrayList<HashMap<Integer, Double>> resultatStat; 
	private String typeStat;
	private boolean isNumero;
	/**
	 * 
	 * @param title 
	 * @param isNumero true si on affiche les numéros, false si on affiche les étoiles
	 */
	public StatChartNumeros(String title, boolean isNumero){
		super(title);
		this.isNumero=isNumero;
		File csv=new File("CSV Files/loto.csv");
		LotoCsvTirageDAO dao = new LotoCsvTirageDAO(csv); 
		List<TirageLoto> tirages=dao.loadAllTirages();
		Loto loto = new Loto(tirages);
		HashMap<TirageLoto, HashMap<Integer, Double>> maMap = loto
				.calculStatGagnant();
		resultatStat = loto.calculStatJeu();
		// création des panels de base
		JPanel pan = new JPanel(new BorderLayout());
		JPanel panMid = new JPanel();
		pan.add(panMid, BorderLayout.CENTER);
		// création du panel de diagramme
		JPanel jpanelChart = createPanelNumeros();
		jpanelChart.setPreferredSize(new Dimension(500, 600));
		setContentPane(pan);
		panMid.add(jpanelChart);
	}
	
	public JPanel createPanelNumeros() {
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}
	
	private CategoryDataset createDataset() {
		Double value = 0.0;// La statistique à afficher
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		// récupération de la stat par numéro/étoile
		int index=-1;
		String label="";
		if(isNumero){
			index=0; 
			label="Numéros";
		}else{
			index=1;
			label="Etoiles";
		}	
		for (int i = 0; i < resultatStat.get(index).size(); ++i) {
			value = resultatStat.get(index).get(i);
			defaultcategorydataset.addValue(value, label,String.valueOf(i));
		}
		return defaultcategorydataset;
	}
	
	private JFreeChart createChart(CategoryDataset categorydataset) {
		JFreeChart jfreechart;
		if(isNumero){
			jfreechart= ChartFactory
				.createBarChart("Fréquence de sortie des numéros", "Numéros",
						"", categorydataset, PlotOrientation.HORIZONTAL, false,
						true, false);
		}else {
			jfreechart = ChartFactory.createBarChart("Fréquence de sortie des étoiles", "Etoiles",
					"", categorydataset, PlotOrientation.HORIZONTAL, false,
					true, false);
		}
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
		categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		categoryplot.setRangePannable(true);
		BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();
		ChartUtilities.applyCurrentTheme(jfreechart);
		barrenderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
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
	
	/*public static void main(String args[]) {
		StatChartNumeros chart = new StatChartNumeros("Statistiques",true);
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
		StatChartNumeros chart1 = new StatChartNumeros("Statistiques",false);
		chart1.pack();
		RefineryUtilities.centerFrameOnScreen(chart1);
		chart1.setVisible(true);
	}*/
	
}
