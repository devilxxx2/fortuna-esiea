package fr.fortuna.game;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.List;
import java.util.prefs.BackingStoreException;

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
	JPanel panel, tablePanel, bottomPanel;
	JLabel topLabel, bottomLabel, label;


	public ResultatsDialog(List<Resultat> resultats, Window parent){

		super(parent, "Blup", Dialog.ModalityType.MODELESS);

		setVisible(true);

		if(resultats.isEmpty()) {
			this.dispose();
			throw new IllegalArgumentException("Le tableau de résultat est vide");			
		}
		
		BorderLayout layout=new BorderLayout(0,0);

		panel=new JPanel(layout);
		add(new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		JScrollPane js=new JScrollPane();

		tablePanel=new JPanel(new GridLayout(resultats.size(), 1));
		panel.add(tablePanel, BorderLayout.CENTER);
		
		bottomPanel=new JPanel();
		
		if(resultats.get(0).getTirage() instanceof TirageEuromillions){
			TirageEuromillions tirageEuro=((TirageEuromillions)resultats.get(0).getTirage());

			topLabel=new JLabel("Tirage : " + tirageEuro.getBoulesCroissantesStr());
			panel.add(topLabel, BorderLayout.NORTH);

			table = new JTable(new ModeleResultatEuromillions(resultats));
			tablePanel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
			table.setAutoCreateRowSorter(true);
			
			label=new JLabel("Prix cumulés des grilles :" + prixTotalGrilles(resultats));
			bottomPanel.add(label);
			label=new JLabel("Total des gains : " + sommeTotaleGains(resultats));
			bottomPanel.add(label);
			panel.add(bottomPanel, BorderLayout.SOUTH);
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
