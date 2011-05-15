package fr.fortuna.game.charts;

import java.util.HashMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import fr.fortuna.controller.TirageLoto;

public class StatChartGagnantsLoto extends StatChartGagnants{

	private HashMap<Integer, Double> result;
	
	public StatChartGagnantsLoto(String title, TirageLoto tirage) {
		super(title, tirage);
		result=tirage.calculStatGagnant();
	}

	private static final long serialVersionUID = 1L;	
	
	
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
