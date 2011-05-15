package fr.fortuna.game.charts;

import java.util.HashMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import fr.fortuna.controller.TirageLoto;
/**
 * 
 * @author Oriane
 * classe d'affichage des gagnants loto par rang
 */
public class StatChartGagnantsLoto extends StatChartGagnants{

	private static final long serialVersionUID = 1L;
	
	/** la statistique à afficher*/
	private HashMap<Integer, Double> result;
	/**
	 * 
	 * @param title titre de la fenêtre
	 * @param tirage le tirage concerné
	 */
	public StatChartGagnantsLoto(String title, TirageLoto tirage) {
		super(title, tirage);
		result=tirage.calculStatGagnant();
	}
	
	
	/**
	 * créée le tableau de valeurs pour l'affichage
	 */
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
