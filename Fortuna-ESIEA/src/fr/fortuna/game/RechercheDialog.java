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
import fr.fortuna.controller.GrilleEuroMillions;
import fr.fortuna.controller.GrilleNouveauLoto;

public class RechercheDialog extends JDialog {
	public RechercheDialog(List<Resultat> resultats, Window parent){
		super(parent, "Résultat de recherche", Dialog.ModalityType.MODELESS);

		setVisible(true);

		if(resultats.isEmpty()) {
			this.dispose();
			throw new IllegalArgumentException("Le tableau de résultat est vide");
		}

		JPanel mainPanel = new JPanel(new BorderLayout(0,0));

		if(resultats.get(0).getGrille() instanceof GrilleEuroMillions) {
			GrilleEuroMillions grilleEuro =
				(GrilleEuroMillions)resultats.get(0).getGrille();
			mainPanel.add(new JLabel("Grille : " +
					grilleEuro + " Prix : " +
					grilleEuro.getPrice()), BorderLayout.NORTH);

			JTable table = new JTable(new ModeleRechercheEuroMillions(resultats));
			table.setAutoCreateRowSorter(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			mainPanel.add(new JScrollPane(table,
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);

			JPanel bottomPanel = new JPanel();
			/*bottomPanel.add(new JLabel("Prix cumulés des grilles : " +
						prixTotalGrilles(resultats)));
			bottomPanel.add(new JLabel("Total des gains : " +
						sommeTotaleGains(resultats)));*/
			mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		}
		else if(resultats.get(0).getGrille() instanceof GrilleNouveauLoto){
		}

		add(mainPanel);
		pack();
	}

	public double sommeTotaleGains(List<Resultat> resultats){
		double gains = 0;
		for (Resultat r : resultats)
			gains += r.getGain();
		return gains;
	}

	public double prixTotalGrilles(List<Resultat> resultats){
		double price = 0;
		for (Resultat r : resultats)
			price += r.getGrille().getPrice();
		return price;
	}
}
