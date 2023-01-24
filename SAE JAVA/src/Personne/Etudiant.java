/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

/**
 *
 * @author audranmalosse
 */
public class Etudiant extends Personne {
    private boolean anneeValide = true;
    
    
    public Etudiant (String Nom, String Prenom){
        super(Nom, Prenom);  
    }
    
    public Etudiant (){
        this("INCONNU", "INCONNU");  
    }
    
    public boolean anneeValidee () {
        return getAbsNonJustif() >= 5;
    }
    /**Méthode de vérification du nombre d'absences injustifie pour valider ou 
     * non l'année
     */
    public void verifAbs (){
        this.anneeValide = super.getAbsNonJustif() < 5;
    }
    /** Redefinition de la méthode pour ajouter une abs injustifier et tester
     * la validité de l'année. 
     */
    @Override
    public void addAbsNonJustif(){
        super.addAbsNonJustif();
        this.verifAbs();
    }
    /** Redefinition de la méthode pour ajouter un nombre d'abs injustifier et 
     * tester la validité de l'année. 
     */
    @Override
    public void addAbsNonJustif(int Nombre){
        super.addAbsNonJustif(Nombre);
        this.verifAbs();
    }
    
    /** addAbsJustif transforme une absence injustifiée en absence justifiée 
     * si il y en a au moins une et test la validitée de l'année.
     */ 
    @Override
    public void addAbsJustif (){
        super.addAbsJustif();
        this.verifAbs();
    }
    
    /** addAbsJustif transforme le nombre d'absence injustifiée, transmise en 
     * paramètre, en absence justifiée et test la validitée de l'année.
     */
    @Override
    public void addAbsJustif (int Nombre){
        super.addAbsJustif(Nombre);
        this.verifAbs();
    }
    
    @Override
    public boolean equals(Personne P) {
        return super.equals(P);
    }

    @Override
    public String toString() {
        return super.toString() + "\nValidation de l'année : " + this.anneeValide + "\n";
        
    }
    /**Méthode qui print le résultat du nombre d'absence*/
    public void impVerifAbs(){
        if (super.getAbsNonJustif()>=5)
            System.out.print("L'etudiant a trop d'absences pour valider son année");
        else
            System.out.print("L'etudiant a n'a pas de souci d'absence pour valider son année");
    }
    
    /** Méthode qui retourne si oui ou non cest un étudiant
     * @param O Un objet à coparer
     * @return Boolean
     */
    public boolean estEtudiant (Object O) {
        return O instanceof Etudiant;
    }
    
}