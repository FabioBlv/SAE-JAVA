/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 *
 * @author lucasspitz
 */
public class Bureau implements Serializable {

    /**
     * Attributs statics
     *
     * @param bureaux liste de tous les bureaux créés
     * @param comptNum compteur du nb de bureaux créés (pour attribuer le num
     * des noveaux bureaux
     */
    private static ArrayList<Bureau> bureaux = new ArrayList<>();
    private static int comptNum;

    /**
     * Attributs
     *
     * @param nbPlace nb de places dans le bureau
     * @param numero numero du bureau, définit automatiquement grâce au compteur
     * @param occupants tab de type Personnel contenant les références vers les
     * X (nbPlace) occupants du bureau
     */
    private int nbPlace;
    private final int numero;
    private Personnel occupants[];

    static {

        comptNum = 0;
    }

//---- CONSTRUCTEURS ----
    /**
     * Constructeur par défaut
     */
    Bureau() {

        setNbPlace(3);
        occupants = new Personnel[3];
        incrCompt();
        numero = comptNum;
        incrTab();
    }

    /**
     * Constructeur sans assigner d'occupants
     *
     * @param nbPlace (int) Il n'y a pas d'autre arguments car le numéro du
     * bureau est déterminé par le compteur (att static) et la taille du tab
     * occupant par nbPlace
     */
    Bureau(int nbPlace) {

        setNbPlace(nbPlace);
        occupants = new Personnel[3];
        incrCompt();
        numero = comptNum;
        incrTab();

    }

    /**
     * Constructeur avec assignation d'un occupant<br>
     * Utilise le constructeur sans assignation d'occupants
     * @param nbPlace (int)
     * @param occupant1 (référence de type Personne) Il n'y a pas d'autre
     * arguments car le numéro du bureau est déterminé par le compteur (att
     * static) et la taille du tab occupant par nbPlace
     * @see Bureau#Bureau(int) 
     */
    Bureau(int nbPlace, Personnel occupant1) {

        this(nbPlace);
        setOccupant(occupant1);
    }

    /**
     * Constructeur avec assignation de deux occupants<br>
     * Utilise le constructeur avec assignation d'un occupant
     * @param nbPlace (int)
     * @param occupant1 (référence de type Personne)
     * @param occupant2 (référence de type Personne) Il n'y a pas d'autre
     * arguments car le numéro du bureau est déterminé par le compteur (att
     * static) et la taille du tab occupant par nbPlace
     * @see Bureau#Bureau(int, Personne.Personnel) 
     */
    Bureau(int nbPlace, Personnel occupant1, Personnel occupant2) {

        this(nbPlace, occupant1);
        setOccupant(occupant2);
    }

    /**
     * Constructeur avec assignation de trois occupants<br>
     * Utilise le constructeur avec l'assignation de deux occupants
     * @param nbPlace (int)
     * @param occupant1 (référence de type Personne)
     * @param occupant2 (référence de type Personne)
     * @param occupant3 (référence de type Personne) Il n'y a pas d'autre
     * arguments car le numéro du bureau est déterminé par le compteur (att
     * static) et la taille du tab occupant par nbPlace
     * @see Bureau#Bureau(int, Personne.Personnel, Personne.Personnel) 
     */
    Bureau(int nbPlace, Personnel occupant1, Personnel occupant2, Personnel occupant3) {

        this(nbPlace, occupant1, occupant2);
        setOccupant(occupant3);
    }

//---- SETTERS ----
    /**
     * La méthode vérifie que la valeur envoyée soit légale [1;3], sinon corrige
     * puis assigne à att : nbPlace <br>
     * La méthode est private car uniquement appelée par les constructeurs et changeNbPlace
     * @param nbPlace minimum 1 place, maximum 3 places (int)
     */
    private void setNbPlace(int nbPlace) {

        if (nbPlace < 1) {       
            this.nbPlace = 1;
        } else if (nbPlace > 3) {
            this.nbPlace = 3;
        } else {
            this.nbPlace = nbPlace;
        }

    }



//---- GETTERS ----
    
    /**
     * Getter du nb de places du bureau
     * @return Le nb de places du bureau (int)
     */
    public int getNbPlace() {

        return nbPlace;
    }

    /**
     * Getter du numero du bureau
     * @return Le numero du bureau (int)
     */
    public int getNumero() {

        return numero;
    }
    
    /**
     * Méthode qui retourne la taille de la lisate bureaux <br>
     * Méthode qui a surtout vocation à être utilisée par l'application
     * @return taille de la liste bureaux (int)
     */
    public static int getSizeBureaux(){
        
        return bureaux.size();
    } 

    /** 
     * Méthode utilisée par toString() pout récupérer plus facilement la liste des occupants<br>
     * Elle peut aussi être utilisée pour print directement les occupants d'un bureau
     * @return "Occupant(s) du bureau {numero du bureau} : " + liste des occupants du bureau (String)
     * @see Bureau#toString() 
     */
    public String getStringOccupants() {

        String stringOccupants = "Occupant(s) du bureau " + getNumero() + " : \n";
        for (int i = 0; i < nbPlace; i++) {

            if (occupants[i] != null) {
                stringOccupants += occupants[i].getNomPrenom() + "\n";
            }
        }

        return stringOccupants;
    }
    
    

//---- AFFICHEURS ----
    
    /* Méthode obsolète depuis l'introduction de getStringOccupants()
    public void afficheOccupants() {

        System.out.println(getStringOccupants());
    }
    */
    
    /**
     * Méthode toString() redéfinie depuis Objet <br>
     * Utilise la méthode getStringOccupants() pour récupérer facilement la liste des occupants <br>
     * Méthode utilisée par afficheBureaux() pour afficher plus facilement la liste de toutes les informations de tous les bureaux <br>
     * Méthode qui a surtout vocation à être utilisée par l'application
     * @return Toutes les informations du bureau (String)
     * @see Bureau#getStringOccupants() 
     * @see Bureau#afficheBureaux() 
     */
    @Override
    public String toString() {

        return "Numero du bureau : " + numero + "\nNombre de place(s) : " + nbPlace + "\n" + getStringOccupants();
    }
    
    /**
     * Méthode qui affiche toutes les infos de tous les bureaux <br>
     * Utilise la méthode toString() pour récupérer plus facilement toutes les infos de chacun des bureaux <br>
     * Méthode qui a surtout vocation à être utilisée par l'application
     * @see Bureau#toString() 
     */
    public static void afficheBureaux() {

        int size = bureaux.size();
        for (int i = 0; i < size; i++) {
            System.out.println(bureaux.get(i).toString());
        }

    }

    

//---- METHODES ---- 
    /**
     * Méthode appelée uniquement par les constructeurs qui incrémente le compteur static comptNum,
     * compteur qui permet de définir le numéro du bureau à sa création
     */
    private void incrCompt() {
        comptNum++;
    }

    /**
     * Méthode appelée uniquement par les constructeurs pour ajouter le bureau nouvellement créé
     * à l'ArrayList static bureaux contenant la liste des bureaux
     * @param B référence vers le bureau à ajouté à la liste
     */
    private void incrTab() {
        bureaux.add(this);
    }

    /**
     * Methode equals() redéfinie depuis Object <br>
     * Le code pourrait être plus simple car par définition (et de la manière dont Bureau et Personnel sont implémentés),
     * un bureau ne peut être égal à un autre bureau que s'ils sont le même bureau.<br>
     * Toutefois en cas de changements futurs il vaut mieux garder le code dans son intégralité
     * @param o référence de type objet
     * @return true si c'est le même bureau, false sinon
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Bureau b = (Bureau) o;
        return this.nbPlace == b.nbPlace && this.numero == b.nbPlace && this.occupants == b.occupants;
    }
    
        /**
     * Méthode qui assigne le Personnel passé en argument au bureau en le rangeant 
     * dans la première place disponible du tab Personnel[3] occupants du bureau <br>
     * Puis appelle le setSonBureau() du Personnel pour assigner la ref du bureau 
     * @see Personnel#setSonBureau(Personne.Bureau) 
     * @param occupant référence vers le Personnel à ajouter au bureau (ref. Personnel)
     * @return true si l'assignation a fonctionné, false sinon
     */
    public final boolean setOccupant(Personnel occupant) {
        
        boolean assigne = false;
        if (occupant.getSonBureau() == null) {
            
            for (int i = 0; i < nbPlace; i++) {
                if (Utils.isNull(occupants[i]) && !assigne) {
                    occupants[i] = occupant;
                    occupant.setSonBureau(this);
                    assigne = true;
                }
            }
            if (!assigne) {
                System.out.println("ERREUR : Il n'y a plus de places dans ce bureau");
            }
        } else {
            System.out.println("ERREUR : " + occupant.getNomPrenom() + " est déjà dans le bureau " + occupant.getSonBureau().numero);
        }
        return assigne;
    }

    /**
     * Récupère le Personnel dans le tab Personnel[3] occupants du bureau courant <br>
     * Appelle setSonBureau() du Personnel avec en arg. null (pour pouvoir faire la réassignation) <br>
     * Appelle ensuite setOccupant du newBureau, si l'assignation réussie :<br>
     *  - Apelle le setSonBureau() du Personnel avec en arg. newBureau<br>
     *  - Delete sa référence du tab Personnel[3] occypants du bureau courant<br>
     * Sinon :<br>
     *  - Appelle setSonBureau() du Personnel avec en arg. le bureau courant<br>
     *  - Print un message d'erreur<br>
     * Retire le Personnel du tab Personnel[3] occupants du bureau courant<br>
     * @param occupant Personnel duquel il faut changer le bureau (ref. Personnel)
     * @param newBureau Bureau vers lequel il faut déplacer le Personnel (ref. Bureau)
     * @see Bureau#setOccupant(Personne.Personnel) 
     * @see Personnel#setSonBureau(Personne.Bureau)
     */
    public void envoieVersNewBureau(Personnel occupant, Bureau newBureau) {
        
        boolean reassigne = false;
        for (int i = 0; i < nbPlace; i++) {

            if (occupants[i].equals(occupant)) {
                occupants[i].setSonBureau(null);
                if (newBureau.setOccupant(occupants[i])) {
                    occupants[i].setSonBureau(newBureau);
                    occupants[i] = null;
                    reassigne = true;
                }
                else occupants[i].setSonBureau(this);
            }

        }
        if (!reassigne) System.out.println("ERREUR : Le bureau " + newBureau.getNumero() + " est plein");
    }
    /**
     * Méthode permettant de récupérer la position d'un bureau dans la liste bureaux grâce à son numéro<br>
     * Méthode utilisée par retourBureauNum()<br>
     * Méthode qui a surtout vocation à être utilisée par l'application
     * @param NumBureau numéro du bureau dont on veut récupérer la position dans la liste (int)
     * @return l'indice du bureau dont le numéro a été passé en argument (int)
     * @see Bureau#retourBureauNum(int) 
     */
    public static int recupIndiceBureaux(int NumBureau){
        int i=0;
        while (i<bureaux.size()){
            if (bureaux.get(i).getNumero()== NumBureau )
                return i;
            i++;
        }
        return -1;
    }
    
    /**
     * Méthode permettant de récupérer la référence d'un bureau grâce à son numéro<br>
     * Utilise la méthode recupIndiceBureaux() pour savoir à quel indice de la liste
     * bureaux aller chercher la référence du bureau dont le numero a été passé en arg.<br>
     * Méthode qui a surtout vocation à être utilisée par l'application
     * @param NumBureau numéro du bureau dont on veut récupérer la référence (int)
     * @return référence du bureau dont le num a été fourni en argument (Bureau)
     * @see Bureau#recupIndiceBureaux(int) 
     */
     public static Bureau retourBureauNum (int NumBureau){
        return bureaux.get(Bureau.recupIndiceBureaux(NumBureau));
    }
     
    /**
     * Méthode qui permet de supprimer un bureau<br>
     * La méthode réassigne les Personnels présent dans le bureau en bouclant à
     * travers le tab Personnel[3] occupants et en appelant changeBureau() pour chaque
     * occupant<br>
     * Qui prend en argument le premier bureau avec une place disponible que trouve
     * la méthode bureauAvecPlace()<br>
     * Puis supprime la référence du Bureau de la liste bureaux 
     * @return true si la suppression à fonctionnée, false sinon
     * @see Personnel#changeBureau(Personne.Bureau) 
     * @see Bureau#bureauAvecPlace() 
     */
    public boolean supprimeBureau(){
        Bureau temp;
        for (int i = 0; i < nbPlace ;i++){
            
            temp = Bureau.bureauAvecPlace();
            
             if (Utils.isNull(temp)){
                System.out.println("ERREUR : Impossible de supprimer "
                    + "le bureau car il n'y a pas assez de places dans les autres bureaux pour tous les occupants");
                return false;
             }
            occupants[i].changeBureau(Bureau.bureauAvecPlace());
            System.out.println("Le nouveau bureau de " + occupants[i].getNomPrenom()
            + " est le numéro " + temp.getNumero());
        }
        Bureau.bureaux.remove(Bureau.bureaux.get(recupIndiceBureaux(numero)));
        return true;    
    }
    
    /**
     * Methode qui renvoie le 1er bureau avec une place disponible<br>
     * La méthode circule dans la liste des bureaux et à chaque bureau
     * circule dans le tab Personnel[3] occupants pour voir si une place est dispo
     * @return référence vers le 1er Bureau avec une place disponible trouvé
     */
    public static Bureau bureauAvecPlace() {
        int limite = bureaux.size();
        Bureau temp;
        for (int j = 0; j < limite; j++) {
            temp = bureaux.get(j);
            for (int i = 0; i < temp.nbPlace; i++) {
                if (temp.nbPlace >= i && Utils.isNull(temp.occupants[i])){
                    return temp;
                }
            }
        }
        return null;
    }

    /**
     * Methode qui permet de modifier le nb de places dans un bureau
     * Plusieurs cas de figure :<br>
     * - Le nouveau nombre de place est égal à l'actuel, seul setNbPlace() est appelée<br>
     * - Le nouveau nombre de place est supérieur à l'ancien, seul setNbPlace() est appelée<br>
     * - Si le nouveau de place est égal à 0, renvoie un message d'erreur, 
     *   suggérant de plutôt supprimer le bureau<br>
     * - Le nouveau nombre de place est inférieur à l'ancien, les Personnels
     *   allant perdre leur place sont déplacés vers un nouveau bureau, puis setNbPlace est appelée
     * (la methode gère aussi l'impossibilité de déplacer les occupants par manque de place)<br>
     * La méthode utilise la méthode changeBureau() de Personnel pour déplacer les occupants<br>
     * La méthode utilise bureauAvecPlace() pour vérifier qu'il est possible de/et déplacer les occupants<br>
     * La méthode utilise setNbPlace() pour changer le nombre de place
     * (c'est elle qui gère les expections de type nb de places trop grand/petit)
     * Private temporaire, le temps que la feature soit test, elle ne sera surement pas implémentée faute de temps
     * @param newNbPlace nouveau nb de places du bureau (int)
     * @return true si le changement du nb de place a réussie, false sinon
     * @see Bureau#setNbPlace(int)
     * @see Bureau#bureauAvecPlace() 
     * @see Personnel#changeBureau(Personne.Bureau) 
     */
    private boolean changeNbPlace(int newNbPlace){
        
        int diffPlace = nbPlace - newNbPlace;
        boolean reassignation = false;
        
        if (newNbPlace == 0) System.out.println("ERREUR : Impossible de passer"
                + " le nombre de places du bureau à 0,"
                + " veuillez plutôt supprimer le bureau");
        else{
            for (int i = 0; i < diffPlace; i++){
                reassignation = false;
                if (!Utils.isNull(Bureau.bureauAvecPlace())){
                    if (!Utils.isNull(occupants[nbPlace -1 - i])){
                    occupants[nbPlace -1 - i].changeBureau(Bureau.bureauAvecPlace());
                    reassignation = true;
                    }
                }    
            }
        if (reassignation)setNbPlace(newNbPlace);
        else System.out.println("ERREUR : Impossible de changer le nb de places"
                + " du bureau, faute de places dispônibles dans les autres "
                + "bureaux pour accueillir les occupants déplacés ");
        }
        return reassignation;
    }
            /**
     * Lit les donnees dans le registre et les ajoute a ArrayList(Personne)
     */
    public static void chargerLesDonnesBureau() {
        try {
            FileInputStream fileIn = new FileInputStream("./listeBureau.txt");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            bureaux = (ArrayList) ois.readObject();
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


        /**
     * Getter de ArrayList des bureau
     * @return L'ArrayListe  de Bureau
     */
        public static ArrayList<Bureau> getBureaux() {
        return bureaux;
    }

    /**
     * Méthode hasCode() redéfinie depuis Object <br>
     * Je ne pense pas qu'on va utiliser le hashcode, mais on l'a au cas où et
     * ça fait disparaitre le warning
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.nbPlace;
        hash = 47 * hash + this.numero;
        hash = 47 * hash + Arrays.deepHashCode(this.occupants);
        return hash;
    }

}