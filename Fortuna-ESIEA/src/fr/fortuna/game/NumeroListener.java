package fr.fortuna.game;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

import fr.fortuna.model.GrilleEuroMillions;

public class NumeroListener implements ItemListener {
	
	private final int MAX_NUM;
	private final int MAX_SPECIAL;
	int count_num;
	int count_special;
	
	public NumeroListener(int max_num, int max_special){
		MAX_NUM=max_num;
		MAX_SPECIAL=max_special;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		JToggleButton button=(JToggleButton)e.getSource();
		if( button.isSelected()){
			button.setBackground(Color.RED);
		}
		else
			button.setBackground(Color.WHITE);
		
	}

}
