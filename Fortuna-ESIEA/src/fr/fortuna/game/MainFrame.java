package fr.fortuna.game;

import java.awt.Dimension;
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

public class MainFrame extends JPanel implements ActionListener{

	JFrame frame;

	public MainFrame(JFrame f){
		super(new GridLayout(4, 1, 0, 5));
		this.frame=f;
		
/*		setPreferredSize(new Dimension(750, 500));
		setSize(750, 500);  */
		validate();updateUI();
		
		createMenu();
		addButtons();

	}

	public void addButtons(){

		JButton b=new JButton("Jouer à Euromillions");
		b.addActionListener(this);
		this.add(b);
		
		b=new JButton("Jouer au Nouveau Loto");
		b.addActionListener(this);
		this.add(b);
		
		b=new JButton("Règles des jeux");
		b.addActionListener(this);
		this.add(b);

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
	
	public void popEuroMillions(){
		JDialog dial=new JDialog(frame, "Euromillions");
		dial.setModal(false);
		dial.setVisible(true);
		dial.add(new JGrilleEuroMillions(2));
		dial.pack();
		this.validate();frame.pack();

	}
	
	public void popNouveauLoto(){
		JDialog dial=new JDialog(frame, "Nouveau Loto");
		dial.setModal(false);
		dial.setVisible(true);
		dial.add(new JGrilleNouveauLoto());
		dial.pack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame=new JFrame("Jeux de Loto");
		frame.setVisible(true);
		frame.setSize(750, 500);
		frame.add(new MainFrame(frame));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(350, 450));
		frame.setAlwaysOnTop(true); // FIST FUCK POUR BLASTCOCK
		frame.setResizable(false);
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem item=(JMenuItem)(e.getSource());
			if ( item.getText().equals("Euromillions")){
				popEuroMillions();
			}
			if ( item.getText().equals("Nouveau Loto")){
				popNouveauLoto();

			}

		}
		if(e.getSource() instanceof JButton){
			JButton button=(JButton)(e.getSource());
			if ( button.getText().equals("Jouer à Euromillions")){
				popEuroMillions();
			}
			if ( button.getText().equals("Jouer au Nouveau Loto")){
				popNouveauLoto();


			}
			
		}


	}
	
	

}
