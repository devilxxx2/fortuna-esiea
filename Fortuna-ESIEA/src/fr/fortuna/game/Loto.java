package fr.fortuna.game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Loto extends JPanel implements ActionListener{

	JFrame frame;

	public Loto(JFrame f){
		super(new GridLayout(4, 1, 0, 3));

		this.frame=f;
		createMenu();
		addButtons();

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

	public void addButtons(){

		JButton b=new JButton("Jouer à Euromillions");
		this.add(b);
		b.addActionListener(this);

		b=new JButton("Jouer au Nouveau Loto");
		this.add(b);
		b.addActionListener(this);

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

		if(e.getSource() instanceof JMenuItem) {
			JMenuItem button=(JMenuItem)(e.getSource());
			if ( button.getText().equals("Euromillions")){
				JDialog dial=new JDialog(frame, "Euromillions");
				dial.setModal(false);
				dial.setVisible(true);
				dial.add(new JGrilleEuroMillions(2));
				dial.pack();



				this.validate();frame.pack();
			}
			if ( button.getText().equals("Nouveau Loto")){
				JDialog dial=new JDialog(frame, "Nouveau Loto");
				dial.setModal(false);
				dial.setVisible(true);
				dial.add(new JGrilleNouveauLoto());
				dial.pack();

			}

		}


	}

}
