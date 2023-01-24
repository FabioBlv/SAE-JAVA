/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;
import java.util.ArrayList; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
/**
 *
 * @author audranmalosse
 */
public abstract class Personne implements Serializable {

    // attributs 
    private final int numPersonne;
    private int absJustif= 0;
    private int absNonJustif =0;
    private String nom;
    private String prenom;
    private static int cpt = 0;
    private static ArrayList<Personne>registre = new ArrayList<>();
    
    
    /**Constructeur qui utilise les setters avec Nom et Prenom comme argument.
     * @param Nom Nom de la personne
     * @param Prenom Pernom de la personne
     */
    public Personne (String Nom, String Prenom){
            this.setNom(Nom);
            this.setPrenom(Prenom);
            this.numPersonne = cpt++;
            this.ajoutPersonne(this);
            
    }
    
    /**
     * Constructeur par defaut qui utilise les setters et aucun argument
     */
    public Personne (){
        this("INCONNU","INCONNU");
    }
    
    //getter
    public String getNom(){ return this.nom;}
    public String getPrenom(){ return this.prenom;}
    //Pour l'affichage, où l'on a souvent besoin de nom + prenom
    public String getNomPrenom(){return this.getNom() + " " + this.getPrenom();}
    public int getAbsJustif(){ return this.absJustif;}
    public int getAbsNonJustif(){ return this.absNonJustif;}
    public int getNumPersonne(){ return this.numPersonne;}
    

    
    //setter
    void setNom(String Nom){this.nom = Utils.verifString(Nom);} 
    void setPrenom(String Prenom){this.prenom = Utils.verifString(Prenom);}
    
    /** 
     * addAbsNonJustif ajoute une absence injustifiée
     */
    public void addAbsNonJustif(){this.absNonJustif++;}
    
    /** 
     * addAbsNonJustif ajoute la valeurs transmise en paramètre au nombre d'absences déjà enregistrée
     * @param Nombre Nombre d'absences injustifiées
     */
    public void addAbsNonJustif(int Nombre){this.absNonJustif+=Math.abs(Nombre);}
    
    /** addAbsJustif transforme une absence injustifiée en absence justifiée 
     * si il y en a au moins une.
     */
    public void addAbsJustif (){
        if (absNonJustif >= 1){
            this.absJustif += 1;
            this.absNonJustif -=1;
        }
        else
            System.out.println("ERREUR: Il n'y a pas assez d'absences non justifiée");
    }
    
    /** 
     * addAbsJustif transforme le nombre d'absence injustifiée, transmise en paramètre, en absence justifiée
     * @param Nombre Nombre d'absences injustifiées que l'on veut passer en absence justifiées
     */
    public void addAbsJustif (int Nombre){
        
        if (absNonJustif>=Math.abs(Nombre)){
            this.absNonJustif -= Math.abs(Nombre);
            this.absJustif += Math.abs(Nombre);
        }
        else
            System.out.println("ERREUR: Il n'y a pas assez d'absences non justifiée"); 
    }
    /** 
     * Test d'égalité de deux peronne
     * @param obj personne dont on veut tester l'égalitée
     * @return 
     */
    public boolean equals (Personne obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Personne))
            return false;
        Personne p = (Personne) obj;
        return this.nom.equals(p.nom) && this.prenom.equals(p.prenom) && this.numPersonne == p.numPersonne;
    }
    
    /** 
     * Méthode d'incrémentation du tableau
     * @param P Personne qui sera ajouté au registre
     */
    public static void ajoutPersonne (Personne P){registre.add(P);}
    
    /**
     * Méthode qui parcour le registr
     * @param i Index d'une personne
     */
    public static void supprimePersonne (int i) {registre.remove(i);}
    
    /**
     * Redéfinition de toString
     */
    @Override
    public String toString(){
        return "\nNature de la personne : " + this.getClass().getSimpleName() +
               "\nNom : " + this.nom + 
               "\nPrenom : " + this.prenom + 
               "\nid Personne : " + this.numPersonne + 
               "\nNombre d'absences justifié : " + this.absJustif +
               "\nNombre d'absence injustifié : " + this.absNonJustif + "\n";
    }
    /**Affiche le registre*/
    public static void afficheRegistre(){
            System.out.println(registre);
    } 
    
    /**
     * Revoie l'indice de la personne dans le registre en lui transmettant son ID.
     * @param NumPersonne ID d'une personne
     * @return Indice dans registre d'une personne 
     */
    public static int recupIndiceRegistre(int NumPersonne){
        int i=0;
        while (i<registre.size()){
            if (registre.get(i).getNumPersonne() == NumPersonne )
                return i;
            i++;
        }
        return -1;
    }
    
    /**
     * Retourne la taille actuel du registr
     * @return Taille du registre
     */
    public static int tailleRegistre(){return registre.size();}
        
    /**
     * Retourne un registre de personnes du même types
     * @param classe Nom de classe en string
     * @return Registre temporaire de Personnes du mêmes types
     */
    public static ArrayList<Personne> retourPersonnesType(String classe){
        ArrayList<Personne>registreTmp = new ArrayList<>();
        int i;  
        for (i=0; i<registre.size(); i++)
            if (registre.get(i).getClass().getName().equals(classe))
                registreTmp.add(registre.get(i));
        return registreTmp;
    }
    
    public static Personne retourPersonneNum (int Num){
        return registre.get(Personne.recupIndiceRegistre(Num));
    }

    /**
     * Retourne un registre d'étudient qui ont plus de 5 absences
     * @return ArrayList registre temporaire
     */
    public static ArrayList<Personne> retourEtuPlus5Abs() {
        ArrayList<Personne> registreTmp = new ArrayList<>();
        for (int i = 0; i < registre.size(); i++) {
            if (registre.get(i) instanceof Etudiant && registre.get(i).getAbsNonJustif()>5) {
                registreTmp.add(registre.get(i));
            }
        }
        return registreTmp;
    }
    
     /**
      * Retourne un registre de personnes qui ont plus de 5 aabsences
     * @return ArrayList registre temporaire
     */
    public static ArrayList<Personne> retourPerPlus5Abs() {
        ArrayList<Personne> registreTmp = new ArrayList<>();
        for (int i = 0; i < registre.size(); i++) {
            if (registre.get(i) instanceof Personnel && registre.get(i).getAbsNonJustif()>5) {
                registreTmp.add(registre.get(i));
            }
        }
        return registreTmp;
    }
        
    /**
     * Affichage léger du registre: ID , Nom Prenom , Type de personne
     */
    public static void affichageSimpleRegistre(){
        int i;
            System.out.println( " ID Personne  |    Nom         Prenom     |    Type de Personne");
        for (i=0; i<registre.size(); i++){
            System.out.print("\n      " + (registre.get(i)).getNumPersonne() + "      ");
            System.out.print("       " + (registre.get(i)).getNomPrenom()+ "      ");
            System.out.print("             " + (registre.get(i)).getClass().getName()+ "  ");
            
        }
    }
    
     /**
     * Getter de ArrayList Personne
     * @return L'ArreyList de Personne
     */
    public static ArrayList<Personne> getRegistre() {
        return registre;
    }




    /**
     * Lit les donnees dans le registre et les ajoute a ArrayList(Personne)
     */
    public static void chargerLesDonnesRegistre() {
        try {
            FileInputStream fileIn = new FileInputStream("./registre.txt");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            registre = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
