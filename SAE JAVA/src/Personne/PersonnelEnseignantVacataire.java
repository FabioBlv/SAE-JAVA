/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

/**
 *
 * @author audranmalosse
 */
public class PersonnelEnseignantVacataire extends PersonnelEnseignant{
    
    public PersonnelEnseignantVacataire(String Nom, String Prenom){
        super(Nom, Prenom);
        super.setEstVacataire(true);
        }
    
    public PersonnelEnseignantVacataire(){
        this("INCONNU", "INCONNU");
        }
}
