package fr.fortuna.game.charts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JPanel;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import fr.fortuna.controller.TirageNouveauLoto;
/**
 * 
 * @author Oriane
 * classe affichage des gagnants nouveau loto
 */
public class StatChartGagnantNouveauLoto extends StatChartGagnants {

	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Double> result;
	
	public StatChartGagnantNouveauLoto(String title, TirageNouveauLoto tirage) {
		super(title, tirage);
		result=tirage.calculStatGagnant();
		JPanel pan = new JPanel(new BorderLayout());
		JPanel panMid = new JPanel();
		pan.add(panMid, BorderLayout.CENTER);
		// création du panel de diagramme
		JPanel jpanelChart = createPanel();
		jpanelChart.setPreferredSize(new Dimension(500, 600));
		setContentPane(pan);
		panMid.add(jpanelChart);
		System.out.println("plop");
		
	}
	
	protected CategoryDataset createDataset() {
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

}
