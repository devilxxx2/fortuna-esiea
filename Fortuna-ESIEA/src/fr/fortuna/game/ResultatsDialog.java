package fr.fortuna.game;

import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.fortuna.controller.Resultat;
import fr.fortuna.controller.Tirage;
import fr.fortuna.controller.TirageEuromillions;
import fr.fortuna.controller.TirageNouveauLoto;

public class ResultatsDialog extends JDialog {

	JTable table;
	Tirage tirage;
	JPanel panel, tablePanel;
	JLabel label;


	public ResultatsDialog(List<Resultat> resultats, Window parent){

		super(parent, "Blup", Dialog.ModalityType.MODELESS);

		setVisible(true);

		if(resultats.isEmpty()) {
			this.dispose();
			throw new IllegalArgumentException("Le tableau de résultat est vide");			
		}
		panel=new JPanel(/*new GridLayout(resultats.size(), 1)*/);
		add(new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		panel.add(tablePanel=new JPanel(new GridLayout(resultats.size(), 1)));

		if(resultats.get(0).getTirage() instanceof TirageEuromillions){
			TirageEuromillions tirageEuro=((TirageEuromillions)resultats.get(0).getTirage());

			label=new JLabel("Tirage : " + tirageEuro.getBoulesCroissantesStr());
			tablePanel.add(label);

			table = new JTable(new ModeleResultatEuromillions(resultats));
			tablePanel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
			table.setAutoCreateRowSorter(true);
			
			tablePanel.add(label);
			
			label=new JLabel("Prix cumulés des grilles :" + prixTotalGrilles(resultats));
			tablePanel.add(label);
			label=new JLabel("Total des gains : " + sommeTotaleGains(resultats));
			tablePanel.add(label);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		}
		if(resultats.get(0).getTirage() instanceof TirageNouveauLoto){

		}

		pack();

	}
	public double sommeTotaleGains(List<Resultat> resultats){
		return 11.5;
	}
	public double prixTotalGrilles(List<Resultat> resultats){
		return 12.0;
	}



}
