package fr.fortuna.game;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.fortuna.controller.GrilleEuroMillions;
import fr.fortuna.controller.Resultat;

public class ModeleResultatEuromillions extends AbstractTableModel {
	private final String[] entetes = {"Numéro grille", "Numéros joués", "Etoiles jouées", "Mise", "Rang", "Montant"};
	private List<Resultat> resultats;


	public ModeleResultatEuromillions(List<Resultat> resultats) {
		super();
		this.resultats=resultats;
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		return resultats.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return ((GrilleEuroMillions)resultats.get(rowIndex).getGrille()).getNumeroGrille();
		case 1:
			return ((GrilleEuroMillions)resultats.get(rowIndex).getGrille()).toString();
		case 2:
			return ((GrilleEuroMillions)resultats.get(rowIndex).getGrille()).getStarsString();
		case 3:
			return ((GrilleEuroMillions)resultats.get(rowIndex).getGrille()).getPrice();
		case 4:
			return resultats.get(rowIndex).getRang();
		case 5:
			return resultats.get(rowIndex).getGain();
		default:
			return null;
		}
	}
}
