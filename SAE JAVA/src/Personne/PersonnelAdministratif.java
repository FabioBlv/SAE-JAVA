/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

/**
 *
 * @author audranmalosse
 */
public class PersonnelAdministratif extends Personnel {
    
    

    /**
     * Constructeur prenant en arguments :
     * @param Nom, Nom du Personnel Administratif (abrégé PA) (String)
     * @param Prenom, Prenom du PA (String)
     * @param SalaireFixe, valeur du salaire fxe du PA (double)
     * @see Personnel#Personnel(String Nom, String Prenom)
     */
    public PersonnelAdministratif (String Nom, String Prenom, Double SalaireFixe) {
        super(Nom,Prenom,SalaireFixe);
        super.setDroitPrime(true);
    }
    /**
     * Constructeur prenant en arguments:
     * @param Nom, Nom du Personnel Administratif (abrégé PA) (String)
     * @param Prenom, Prenom du PA (String)
     * @see PersonnelAdministratif#PersonnelAdministratif(String Nom, String Prenom, Double SalaireFixe)
     */
    public PersonnelAdministratif (String Nom, String Prenom) {
        this(Nom,Prenom, 0.);
    }
    /**
     * Constructeur par défaut
     * @see PersonnelAdministratif#PersonnelAdministratif(String Nom, String Prenom, Double SalaireFixe)
     */
    public PersonnelAdministratif () {
        this("INCONNU","INCONNU", 0.);
    }
}
