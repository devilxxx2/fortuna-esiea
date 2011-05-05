package fr.fortuna.Tirage;

import java.util.List;

public class Euromillions/* implements Jeu*/ {
	private List<TirageEuromillions> tirages;
	
	public Euromillions(List<TirageEuromillions> t){
		tirages=t;
	}
	
	public List<TirageEuromillions> getTirages()
	{
		return tirages;
	}
	
	private Euromillions(){}

	/*	@Override
	public void jouer(Grille g) {
		// TODO Auto-generated method stub
		
	}*/
}


