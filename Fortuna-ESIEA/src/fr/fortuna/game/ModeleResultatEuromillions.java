package fr.fortuna.game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.fortuna.controller.Resultat;
import fr.fortuna.controller.TirageEuromillions;

public class ModeleResultatEuromillions extends AbstractTableModel {


	private final String[] entetes	= { "Bons numéros", "Bonnes étoiles", "Nb gagants France", "Nb gagant Europe", "Gains"};
	private Resultat resultat;


	public ModeleResultatEuromillions(Resultat resultat) {
		super();
		this.resultat=resultat;
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
		return ((TirageEuromillions)(resultat.getTirage())).getGainParRgEurope().length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		
		case 0:
			switch(rowIndex) {
			case 0:
				return 5;
			case 1:
				return 5;
			case 2:
				return 5;
			case 3:
				return 4;
			case 4:
				return 4;
			case 5:
				return 4;
			case 6:
				return 3;
			case 7:
				return 2;
			case 8:
				return 3;
			case 9:
				return 3;
			case 10:
				return 1;
			case 11:
				return 2;
			case 12:
				return 2;				
			}
		case 1:
			switch(rowIndex) {

			case 0:
				return 2;
			case 1:
				return 1;
			case 2:
				return 0;
			case 3:
				return 2;
			case 4:
				return 1;
			case 5:
				return 0;
			case 6:
				return 2;
			case 7:
				return 2;
			case 8:
				return 1;
			case 9:
				return 0;
			case 10:
				return 2;
			case 11:
				return 1;
			case 12:
				return 0;				
			}

		case 2: // Boules
			int[] nbGagantsRangFrance=((TirageEuromillions)(resultat.getTirage())).getNombreDeGagnantsRgFrance();
			return nbGagantsRangFrance[rowIndex];
		case 3: // Spécial
			int[] nbGagantsRangEurope=((TirageEuromillions)(resultat.getTirage())).getNombreDeGagnantsRgEurope();
			return nbGagantsRangEurope[rowIndex];
		case 4:
			return resultat.getGain();

		default:
			return null;
		}
	}



}
