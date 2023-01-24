/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

/**
 *
 * @author audranmalosse
 */
public class Test {
    public static void main (String [] args){  

       Personnel pers1 = new PersonnelAdministratif("pers1", "pers1", 0.);
        Personnel pers2 = new PersonnelAdministratif("pers2", "pers2", 0.);
        Personnel pers3 = new PersonnelAdministratif("pers3", "pers3", 0.);
        
        Etudiant Test1 = new Etudiant ("test", "test");
        Etudiant Test2 = new Etudiant ("test1", "test1");
        Etudiant Test3 = new Etudiant ("test2", "test2");
        Etudiant Test4 = new Etudiant ("test", "test");
        Etudiant Test5 = new Etudiant ("test", "test");
        
        Test1.addAbsNonJustif(6);   
        Test1.addAbsJustif(2);
        
        Bureau TestB1 = new Bureau(3, pers1, pers2, pers3);
        Bureau TestB2 = new Bureau(3, pers1, pers2, pers3);
        Bureau TestB3 = new Bureau(3, pers1, pers2, pers3);
        Bureau TestB4 = new Bureau();
        
        pers1.changeBureau(TestB2);
        
        Bureau.afficheBureaux();
 
       /*Test1.addAbsNonJustif(7);
       pers1.addAbsNonJustif(10);
       System.out.println("\netu\n");
       System.out.println(Personne.retourEtuPlus5Abs());
              System.out.println("\npers\n");
       System.out.println(Personne.retourPerPlus5Abs());
              System.out.println("\nend\n");
                   
        System.out.println(Personne.retourPersonnesType("Etudiant"));
        
  */
    }
    
}
