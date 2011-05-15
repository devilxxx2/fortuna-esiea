package fr.fortuna.game.charts;

import java.util.HashMap;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import fr.fortuna.controller.Tirage;
import fr.fortuna.controller.TirageEuromillions;

public class StatChartGainsEuromillion extends StatChartGains{

	private static final long serialVersionUID = 1L;
	/** la statistique à afficher*/
	private HashMap<Integer, Double> result;
	public StatChartGainsEuromillion(String title, TirageEuromillions tirage) {
		super(title, tirage);
		result=tirage.calculStatGainEurope();
	}

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
