package fr.fortuna.maths;

/*
 * Fait les statistiques d'après les résultats de tous tirages précédent
 */
public class Stat {
	
	/*
	 * Prend les numéros des anciens tirages et donne le nombre de fois que chaque boule est tombé
	 * t_int : tableau de tous les tirages pour un jeu donné
	 * typeJeu : Le type de jeu (euromillions, ancienLoto, loto, superLoto)
	 * Dans le cas de euromillions, retourne un tableau de 59 entiers, 50 pour les boules, et 9 pour les étoiles
	 * Dans le cas du loto et du superLoto, retourne un tableau de 59 entiers, 49 pour les boules, et 10 pour le numéro chance
	 * Dans le cas de l'ancien loto, retourne un tableau de 98 entiers, 49 pour les boules classiques, et 49 pour les numéros complémentaires 
	 */
	public static int[] statNumero(int[][] tab_tirage, String typeJeu) {
		
		if (typeJeu.equals("euromillions")) {	//cas de l'euromillions
			int[] retour = new int[59]; //le tableau de retour
			int numero;	//numéro actuel dans la double boucle
			for (int i = 0; i < tab_tirage.length; i++) {	//boucle sur tous les tirages
				for (int j = 0; j < tab_tirage[i].length; j++) { //boucle sur tous les numéros du tirage	
					numero = tab_tirage[i][j];
					if (j < 5) {	//Si c'est une boule
						retour[numero-1]++;
					}
					else {	//Si c'est une étoile
						retour[numero+49]++; 
					}
				}
			}
			return retour;
		}
		else if (typeJeu.equals("Loto") || typeJeu.equals("superLoto")) { //cas du loto actuel
			int[] retour = new int[59]; //le tableau de retour
			int numero;
			for (int i = 0; i < tab_tirage.length; i++) {
				for (int j = 0; j < tab_tirage[i].length; j++) {
					numero = tab_tirage[i][j];
					if (j == 5) {	//numéro chance
						retour[numero+48]++;
					}
					else {	//boule
						retour[numero-1]++;
					}
				}
			}
			return retour;
		}
		
		else if (typeJeu.equals("ancienLoto")) {	//cas de l'ancien loto
			int[] retour = new int[98]; //le tableau de retour
			int numero;
			for (int i = 0; i < tab_tirage.length; i++) {
				for (int j = 0; j < tab_tirage[i].length; j++) {
					numero = tab_tirage[i][j];
					if (j == 6) { //numero complémentaire
						retour[numero+48]++;
					}
					else {	//numero classique
						retour[numero-1]++;
					}
				}
			}
		}
		
		else {	//Cas d'erreur
			System.out.println("Erreur : Le jeu indiqué n'est pas pris en charge.");
			System.exit(0);
		}
		return null;
	}
}
