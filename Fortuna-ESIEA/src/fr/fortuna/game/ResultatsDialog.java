package fr.fortuna.game;

import java.awt.Dialog;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;

import fr.fortuna.controller.Resultat;
import fr.fortuna.controller.Tirage;
import fr.fortuna.controller.TirageEuromillions;
import fr.fortuna.controller.TirageNouveauLoto;
import fr.fortuna.controller.TirageNouveauSuperLoto;

public class ResultatsDialog extends JDialog {
	
	JTable table;
	Tirage tirage;
	
	
	public ResultatsDialog(List<Resultat> tirages, JFrame parent){
		
		super(parent, "Résultats de " + parent.getTitle(), Dialog.ModalityType.APPLICATION_MODAL);
		
		if(tirages instanceof TirageEuromillions){
			
			table = new JTable(new ModeleResultatEuromillions(tirages));
			
		}
		
		
	}
	
	

}
