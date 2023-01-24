/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

/**
 *
 * @author audranmalosse
 */
public class Utils {
    
    /**Permet de verifier si l'argument transmis est bien un booléen*/
    public static boolean verifBool(boolean Bool){
        if (Bool == true || Bool == false)
            return Bool;
        else
            return false;
    }
    
    /**Permet de vérifier qu'un string n'est pas null ou vide*/
        public static String verifString(String Char){
            if (isNull(Char) || Char.equals("") || Char.equals(" "))
                return "INCONNU";
            else 
                return Char;
        }
    
        public static boolean isNull(Object o){
            return (o == null);
        }
}
