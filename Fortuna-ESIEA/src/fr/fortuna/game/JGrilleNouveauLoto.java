package fr.fortuna.game;

import javax.swing.JPanel;
import fr.fortuna.model.Grille;
import fr.fortuna.model.GrilleNouveauLoto;

public class JGrilleNouveauLoto extends JPanel implements JGrille {
	private JGrilleNumeros nums;
	private JGrilleNumeros chance;

	public JGrilleNouveauLoto(){
		super();

		nums = new JGrilleNumeros(49, 7, "Numéros");
		chance = new JGrilleNumeros(10, 10, "Chance");
		this.add(nums);
		this.add(chance);
	}

	@Override
	public Grille getGrille() {
		return new GrilleNouveauLoto(nums.getNums(), chance.getNums());
	}
}
