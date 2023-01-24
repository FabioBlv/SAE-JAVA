package Personne;

import Personne.Clavier;

public class EntierContraint {
	//Declaration des variables de la classe
	private final int min;
	private final int max;
	private int val;
	
	//Premier constructeur de la classe ReelContraint en lui donnant un double min et un double max
	public EntierContraint(int min, int max) {
		if(min > max) {
			this.max = min;
			this.min = max;
		}
		else {
			this.min = min;
			this.max = max;
		}
		this.val = this.min;
	}
	
	//Second constructeur de la classe ReelContraint en lui donnant aucune valeur
	public EntierContraint() {
		this.min = 0;
		this.max = 0;
		this.val = 0;
	}
	
	//Troisième constructeur de la classe ReelContraint en lui un double min, un double max et un double val
	public EntierContraint(int min, int max, int val) {
		if(min > max) {
			this.max = min;
			this.min = max;
		}
		else {
			this.min = min;
			this.max = max;
		}
		if(val > this.max) this.val = this.max;
		else if (val < this.min) this.val = this.min;
		else this.val = val;
	}
	
	//Fonction qui permet de demander à un utilisateur de rentrer une valeur et d'attribuer celle ci à la variable val
	public void saisir() {
		System.out.println("Veuillez rentrer une valeur dans l'intervalle [ "+this.min+" ; "+this.max+" ] : ");
		int newval = Clavier.lireInt();
		this.setVal(newval);
	}
	
	//Fonction qui permet de set une valeur à la variable val
	public void setVal(int val) {
		if(val < this.min) this.val = this.min;
		else if(val > this.max) this.val = this.max;
		else this.val = val;
	}
	
	//Fonction qui permet de renvoyer la valeur de la varible val
	public int getVal() {
		return this.val;
	}
	
	//Fonction qui permet de renvoyer la valeur de la varible min
	public int getMin() {
		return this.min;
	}
	
	//Fonction qui permet de renvoyer la valeur de la varible max
	public int getMax() {
		return this.max;
	}
}
