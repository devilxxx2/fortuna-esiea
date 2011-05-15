package fr.fortuna.game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.fortuna.controller.Euromillions;
import fr.fortuna.controller.NouveauLoto;
import fr.fortuna.dao.EuromillionsCsvTirageDAO;
import fr.fortuna.dao.NouveauLotoCsvTirageDAO;

import java.io.File;

public class MainFrame extends JFrame implements ActionListener{
	private JPanel panel;
	private Euromillions euromillions;
	private NouveauLoto nouveauloto;
	private NouveauLoto nouveausuperloto;

	public MainFrame(){
		super("Jeux de Loto");

		File csv=new File("CSV Files/euromillions.csv");
		EuromillionsCsvTirageDAO te = new EuromillionsCsvTirageDAO(csv);
		euromillions = new Euromillions(te.loadAllTirages());

		csv=new File("CSV Files/nouveau_loto.csv");
		NouveauLotoCsvTirageDAO tnl = new NouveauLotoCsvTirageDAO(csv);
		nouveauloto = new NouveauLoto(tnl.loadAllTirages());

		csv=new File("CSV Files/nouveau_superloto.csv");
		NouveauLotoCsvTirageDAO tnsl = new NouveauLotoCsvTirageDAO(csv);
		nouveausuperloto = new NouveauLoto(tnsl.loadAllTirages());

		setVisible(true);
		setSize(750, 500);

		panel = new JPanel(new GridLayout(4, 1, 0, 5));

/*		setPreferredSize(new Dimension(750, 500));
		setSize(750, 500);  */
		panel.validate();
		panel.updateUI();

		createMenu();
		addButtons();

		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(350, 450));
		setResizable(false);
		pack();
	}

	public void addButtons(){
		JButton b=new JButton("Jouer à Euromillions");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Jouer au Nouveau Loto");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Jouer au Nouveau SuperLoto");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Jouer au Loto");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Règles des jeux");
		b.addActionListener(this);
		panel.add(b);
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

		menuItem=new JMenuItem("Nouveau SuperLoto");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem=new JMenuItem("Loto");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		setJMenuBar(menuBar);
	}

	public void popEuroMillions(){
		new JEuroMillionsDialog(this, euromillions);
	}

	public void popNouveauLoto(){
		new JNouveauLotoDialog(this, nouveauloto);
	}

	public void popNouveauSuperLoto(){
		new JNouveauLotoDialog(this, nouveausuperloto);
	}

	public void popLoto(){
		new JLotoDialog(this);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem item=(JMenuItem)(e.getSource());
			if ( item.getText().equals("Euromillions")){
				popEuroMillions();
			}
			if ( item.getText().equals("Nouveau Loto")){
				popNouveauLoto();
			}
			if ( item.getText().equals("Loto")){
				popLoto();
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
			if ( button.getText().equals("Jouer au Nouveau SuperLoto")){
				popNouveauSuperLoto();
			}
			if ( button.getText().equals("Jouer au Loto")){
				popLoto();
			}
		}
	}
}
