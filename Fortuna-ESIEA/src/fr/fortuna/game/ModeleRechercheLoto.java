package fr.fortuna.game;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.fortuna.controller.TirageLoto;
import fr.fortuna.controller.Resultat;

public class ModeleRechercheLoto extends AbstractTableModel {
	private final String[] entetes = {"Date tirage", "Numéros", "Complémentaire", "Rang", "Montant"};
	private List<Resultat> resultats;

	public ModeleRechercheLoto(List<Resultat> resultats) {
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
			return ((TirageLoto)resultats.get(rowIndex).getTirage()).getDateTirage();
		case 1:
			return ((TirageLoto)resultats.get(rowIndex).getTirage()).getBoulesStr();
		case 2:
			return ((TirageLoto)resultats.get(rowIndex).getTirage()).getBouleComplementaire();
		case 3:
			return resultats.get(rowIndex).getRang();
		case 4:
			return resultats.get(rowIndex).getGain();
		default:
			return null;
		}
	}
}
