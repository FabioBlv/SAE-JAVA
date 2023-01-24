/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

/**
 *
 * @author audranmalosse
 */
public abstract class PersonnelEnseignant extends Personnel {

    /**
     * Constructeur prenant en arguments :
     * @param Nom Nom du Personnel (String)
     * @param Prenom Prénom du Personnel (String)
     * @see Personnel#Personnel(String Nom, String Prenom)
     */
    public PersonnelEnseignant(String Nom, String Prenom){
        super(Nom, Prenom);
    }
}
