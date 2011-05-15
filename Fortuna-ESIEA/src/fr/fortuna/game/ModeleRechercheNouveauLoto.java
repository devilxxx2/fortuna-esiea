package fr.fortuna.game;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.fortuna.controller.TirageNouveauLoto;
import fr.fortuna.controller.Resultat;

public class ModeleRechercheNouveauLoto extends AbstractTableModel {
	private final String[] entetes = {"Date tirage", "Numéros", "Numéro chance", "Rang", "Montant"};
	private List<Resultat> resultats;

	public ModeleRechercheNouveauLoto(List<Resultat> resultats) {
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

	public TirageNouveauLoto getTirage(int row) {
		return (TirageNouveauLoto)resultats.get(row).getTirage();
	}

	@Override
	public int getRowCount() {
		return resultats.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return ((TirageNouveauLoto)resultats.get(rowIndex).getTirage()).getDateTirage();
		case 1:
			return ((TirageNouveauLoto)resultats.get(rowIndex).getTirage()).getBoulesStr();
		case 2:
			return ((TirageNouveauLoto)resultats.get(rowIndex).getTirage()).getNumChance();
		case 3:
			return resultats.get(rowIndex).getRang();
		case 4:
			return resultats.get(rowIndex).getGain();
		default:
			return null;
		}
	}
}
