package fr.fortuna.game.charts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JPanel;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import fr.fortuna.controller.Tirage;
import fr.fortuna.controller.TirageEuromillions;
/**
 * 
 * @author Oriane
 * classe d'affichage des gagnants euromillion par rang
 */
public class StatChartsGagnantEuromillion extends StatChartGagnants{

	
	private static final long serialVersionUID = 1L;
	/** les statistiques à afficher*/
	private HashMap<Integer, Double> result;
	
	/**
	 * 
	 * @param title le titre de la fenêtre
	 * @param tirage le tirage concerné
	 */
	public StatChartsGagnantEuromillion(String title, TirageEuromillions tirage) {
		super(title, tirage);
		result=tirage.calculStatGagnantEurope();
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
	
	/**
	 * méthode de création des données à afficher
	 */
	@Override
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
