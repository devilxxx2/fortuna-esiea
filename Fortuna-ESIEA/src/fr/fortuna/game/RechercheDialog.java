package fr.fortuna.game;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import fr.fortuna.controller.Resultat;
import fr.fortuna.controller.Tirage;
import fr.fortuna.controller.TirageLoto;
import fr.fortuna.controller.TirageEuromillions;
import fr.fortuna.controller.TirageNouveauLoto;
import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleLoto;
import fr.fortuna.controller.GrilleEuroMillions;
import fr.fortuna.controller.GrilleNouveauLoto;
import fr.fortuna.game.charts.StatChartGagnantNouveauLoto;
import fr.fortuna.game.charts.StatChartGainsNouveauLoto;
import fr.fortuna.game.charts.StatChartsGagnantEuromillion;
import fr.fortuna.game.charts.StatChartGainsEuromillion;
import fr.fortuna.game.charts.StatChartGagnantsLoto;
import fr.fortuna.game.charts.StatChartGainsLoto;

public class RechercheDialog extends JDialog implements MouseListener {
	private TableModel model;

	public RechercheDialog(List<Resultat> resultats, Window parent){
		super(parent, "Résultat de recherche", Dialog.ModalityType.MODELESS);

		setVisible(true);

		if(resultats.isEmpty()) {
			this.dispose();
			throw new IllegalArgumentException("Le tableau de résultat est vide");
		}

		JPanel mainPanel = new JPanel(new BorderLayout(0,0));

		Grille grille = resultats.get(0).getGrille();
		mainPanel.add(new JLabel("Grille : " +
				grille + " | Prix : " +
				grille.getPrice()), BorderLayout.NORTH);

		JTable table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		mainPanel.add(new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		table.addMouseListener(this);

		if(resultats.get(0).getGrille() instanceof GrilleEuroMillions)
			table.setModel(model = new ModeleRechercheEuroMillions(resultats));
		else if(resultats.get(0).getGrille() instanceof GrilleNouveauLoto)
			table.setModel(model = new ModeleRechercheNouveauLoto(resultats));
		else if(resultats.get(0).getGrille() instanceof GrilleLoto)
			table.setModel(model = new ModeleRechercheLoto(resultats));
		else
			throw new IllegalArgumentException("Grille inconnue");

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

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			JTable table = (JTable)e.getSource();
			int row = table.convertRowIndexToModel(table.getSelectedRow());
			if(model instanceof ModeleRechercheLoto)
			{
				TirageLoto t = ((ModeleRechercheLoto)model).getTirage(row);
				new StatsDialog(this, "Statistiques Loto",
						new StatChartGagnantsLoto("Gagnants", t),
						new StatChartGainsLoto("Gains", t));
			}
			else if(model instanceof ModeleRechercheNouveauLoto)
			{
				TirageNouveauLoto t = ((ModeleRechercheNouveauLoto)model).getTirage(row);
				new StatsDialog(this, "Statistiques Nouveau Loto",
						new StatChartGagnantNouveauLoto("Gagnants", t),
						new StatChartGainsNouveauLoto("Gains", t));
			}
			else if(model instanceof ModeleRechercheEuroMillions)
			{
				TirageEuromillions t = ((ModeleRechercheEuroMillions)model).getTirage(row);
				new StatsDialog(this, "Statistiques EuroMillions",
						new StatChartsGagnantEuromillion("Gagnants", t),
						new StatChartGainsEuromillion("Gains", t));
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseEvent(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
