package fr.fortuna.game;

import javax.swing.JFrame;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f=new JFrame("Loto");
		f.setVisible(true);
		f.add(new JGrilleEuroMillions(1));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(70, 70);
		f.pack();
		f.validate();
		
		
	}

}
