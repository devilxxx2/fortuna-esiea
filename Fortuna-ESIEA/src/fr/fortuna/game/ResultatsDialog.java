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
		System.out.println("OK 1");
		
		if(resultats.isEmpty()) {
			System.out.println("BLUOP");
			this.dispose();
			throw new IllegalArgumentException("Le tableau de résultat est vide");			
		}
		panel=new JPanel(/*new GridLayout(resultats.size(), 1)*/);
		add(new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		panel.add(tablePanel=new JPanel(new GridLayout(resultats.size(), 1)));
		
		if(resultats.get(0).getTirage() instanceof TirageEuromillions){
			for(Resultat r : resultats)	{
				// Les numeros sous formes string
				label=new JLabel(((TirageEuromillions)r.getTirage()).getDateTirage());
				tablePanel.add(label);
				// Les étoiles sous strings
				label=new JLabel(((TirageEuromillions)r.getTirage()).toString());
				ModeleResultatEuromillions mod=new ModeleResultatEuromillions(r);
				table = new JTable(mod);
				tablePanel.add(new JScrollPane(table));
				table.setAutoCreateRowSorter(true);
			}
		}
		if(resultats.get(0).getTirage() instanceof TirageNouveauLoto){
			for(Resultat r : resultats)	{
				table = new JTable(new ModeleResultatEuromillions(r));
				tablePanel.add(table);
			}
		}



	}



}
