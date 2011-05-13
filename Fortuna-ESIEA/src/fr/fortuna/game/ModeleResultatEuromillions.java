package fr.fortuna.game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.fortuna.controller.Resultat;
import fr.fortuna.controller.TirageEuromillions;

public class ModeleResultatEuromillions extends AbstractTableModel {
	
	
	private final String[] entetes	= { "Réf.", "Marque", "Poids", "Couleur", "Smart", "Type" };
	private ArrayList<Resultat> resultats;
	

	public ModeleResultatEuromillions(List<Resultat> resultats) {
		super();
		this.resultats=(ArrayList<Resultat>) resultats;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub	
		return resultats.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: // Date
			return ((TirageEuromillions)(resultats.get(rowIndex).getTirage())).getDateTirage();
		case 1: // Jour
			return ((TirageEuromillions)(resultats.get(rowIndex).getTirage())).getJour();
		case 2: // Boules
			return ((TirageEuromillions)(resultats.get(rowIndex).getTirage())).getBoulesCroissantes();
		case 3: // Spécial
			return ((TirageEuromillions)(resultats.get(rowIndex).getTirage())).getEtoilesCroissantes();
		case 4:
			

		default:
			return null;
		}
	}
	
	

}
