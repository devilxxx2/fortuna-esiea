package fr.fortuna.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.Media;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Loto extends JPanel implements ActionListener{

	JFrame frame;

	public Loto(JFrame f){
		super();
		this.frame=f;
		createMenu();

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame=new JFrame("Jeux de Loto");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.add(new Loto(frame));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

	}

	public void createMenu(){

		JMenuBar menuBar=new JMenuBar();
		JMenu menu=new JMenu("Jeux");

		JMenuItem menuItem=new JMenuItem("Euromillions");
		menuItem.addActionListener(this);
		menu.add(menuItem);


		menuItem=new JMenuItem("Nouveau Loto");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		frame.setJMenuBar(menuBar);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			this.removeAll();
		if ( ((JMenuItem)(e.getSource()) ).getText().equals("Euromillions")){
			this.add(new JGrilleEuroMillions(1));
			this.add(new JGrilleEuroMillions(2));
			this.add(new JGrilleEuroMillions(3));
			this.add(new JGrilleEuroMillions(4));
			

			this.validate();frame.pack();
		}
		if ( ((JMenuItem)(e.getSource()) ).getText().equals("Nouveau Loto")){
			this.add(new JGrilleNouveauLoto());

			this.validate();frame.pack();
		}


	}

}
