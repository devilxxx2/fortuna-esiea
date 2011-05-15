package fr.fortuna.game;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.fortuna.controller.TirageEuromillions;
import fr.fortuna.controller.Resultat;

public class ModeleRechercheEuroMillions extends AbstractTableModel {
	private final String[] entetes = {"Date", "Numéros", "Étoiles", "Rang",
		"Montant"};
	private List<Resultat> resultats;

	public ModeleRechercheEuroMillions(List<Resultat> resultats) {
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

	public TirageEuromillions getTirage(int row) {
		return (TirageEuromillions)resultats.get(row).getTirage();
	}

	@Override
	public int getRowCount() {
		return resultats.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return ((TirageEuromillions)resultats.get(rowIndex).getTirage()).getDateTirage();
		case 1:
			return ((TirageEuromillions)resultats.get(rowIndex).getTirage()).getBoulesStr();
		case 2:
			return ((TirageEuromillions)resultats.get(rowIndex).getTirage()).getEtoilesStr();
		case 3:
			return resultats.get(rowIndex).getRang();
		case 4:
			return resultats.get(rowIndex).getGain();
		default:
			return null;
		}
	}
}
