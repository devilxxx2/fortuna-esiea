package fr.fortuna.game;

import javax.swing.JFrame;

public class Test2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f=new JFrame("Euromillions");
		f.setVisible(true);
		f.add(new JGrilleEuroMillions());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(70, 70);
		f.pack();
		f.validate();

		f=new JFrame("Loto");
		f.setVisible(true);
		f.add(new JGrilleLoto());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(70, 70);
		f.pack();
		f.validate();
	}
}
