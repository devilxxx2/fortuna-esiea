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

import fr.fortuna.model.Grille;
import fr.fortuna.model.GrilleEuroMillions;

public class JGrilleEuroMillions extends JPanel implements JGrille {
        private JGrilleNumeros nums;
        private JGrilleNumeros etoiles;

        public JGrilleEuroMillions(int numeroGrille){
                super();

                TitledBorder titledBorder=BorderFactory.createTitledBorder(
                		BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red),
                		Integer.toString(numeroGrille));
        		titledBorder.setTitleJustification(TitledBorder.CENTER);
        		this.setBorder(titledBorder);

                nums = new JGrilleNumeros(50, 6, "Num�ros");
                etoiles = new JGrilleNumeros(9, 3, "�toiles");
                this.add(nums);
                this.add(etoiles);
        }

        @Override
        public Grille getGrille() {
                return new GrilleEuroMillions(nums.getNums(), etoiles.getNums());
        }
}
