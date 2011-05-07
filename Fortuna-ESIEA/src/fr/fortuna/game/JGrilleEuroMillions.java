package fr.fortuna.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
	

public class JGrilleEuroMillions extends JPanel implements JGrille {

	
	private JToggleButton[] grille;
	private final int NB_CASES=49;
	JToggleButton box;
	GridBagConstraints c;
	
	public JGrilleEuroMillions(int num){
		super(new GridLayout(7, 7));

		TitledBorder titledBorder=BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.RED), Integer.toString(num));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(titledBorder);
		GridBagLayout grid=new GridBagLayout();
		c=new GridBagConstraints();
		c.weightx=5;
		c.weighty=5;
		
		grille=new JToggleButton[49];
		createGrille();
	
	}
	
	private void createGrille(){
		
		String num;
		
		for(int i=0; i<NB_CASES; i++){
			if(i<9)num="0" + (i+1);
			else num=Integer.toString(i+1);
			box=new JToggleButton(num);
			box.setMargin(new Insets(0, 0, 0, 0));
		//	box.setSize(2, 2);
			box.setPreferredSize(new Dimension(2,2));
			// box.setMaximumSize(new Dimension(2,2));
			add(box,c);
			
		}
		
		
	}
	
	@Override
	public ArrayList<Grille> getGrilles() {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	
	
	
}
