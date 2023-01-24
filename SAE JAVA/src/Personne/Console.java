/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

import static Personne.Application.*;
import static Personne.Personne.*;
import static Personne.Bureau.*;
import static Personne.Personnel.setPrimeAnnuelle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author fabio
 */
public class Console {

    /**
     * Function qui demande à utilisateur d'indiquer la prime Annuel
     *
     * @see Console#consoleSetPrimeAnnuelle()
     */
    public static void primeAnnuel() {
        System.out.println("Indiquer la prime Annuel");
        double prime = Clavier.lireDouble();
        consoleSetPrimeAnnuelle(prime);
    }

    /**
     * Function qui sauvegarde le registre
     */
    public static void sauvegarderRegistre() {
        try {
            FileOutputStream fileOut = new FileOutputStream("./registre.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(getRegistre());
            out.close();
            fileOut.close();
            System.out.println("\nSauvegarde du registre terminee avec succes...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function qui sauvegarde les bureaux
     */
    public static void sauvegarderLesbureaux() {
        try {
            FileOutputStream fileOut = new FileOutputStream("./listeBureau.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(getBureaux());
            out.close();
            fileOut.close();
            System.out.println("\nSauvegarde des bureaux terminee avec succes...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode pour demander à l'utilisateur le numero du bureau <br>
     * Demande le numero du bureau à l'utilisateur
     */
    public static int indiquerLeNumeroDuBureau() {
        int numBureau;
        do {
            System.out.println("\nindiquer le numero du bureau");
            numBureau = Clavier.lireInt();
            if (recupIndiceBureaux(numBureau) == -1) {
                System.out.println("\nLe numero indique n'existe pas");
                System.out.println("\nVoulez vous afficher les bureaux? Oui/Non");
                String reponse;
                reponse = Clavier.lireString();
                reponse = reponse.toLowerCase();
                if (reponse.equals("oui")) {
                    afficheTousLesBureauxEtInfos();
                }else{ System.out.println("\nRetour au menu principale"); menu();}
            } else {
                return numBureau;
            }
        } while (recupIndiceBureaux(numBureau) == -1);
        return numBureau;
    }

    /**
     * Methode pour demander à l'utilisateur l'id de la personne <br>
     * Demande le numero de la personne à l'utilisateur
     */
    public static int indiquerLeNumeroDeLaPersonne() {
        int numPersonne;
        do {
            System.out.println("\nindiquer le numero de la personne");
            numPersonne = Clavier.lireInt();
            if (recupIndiceRegistre(numPersonne) == -1) {
                System.out.println("\nLe numero indique n'existe pas");
                System.out.println("\nVoulez vous afficher le registre? Oui/Non");
                String reponse;
                reponse = Clavier.lireString();
                reponse = reponse.toLowerCase();
                if (reponse.equals("oui")) {
                    affichageSimpleRegistre();
                }else{ System.out.println("\nRetour au menu principale"); menu();}
            } else {
                return numPersonne;
            }
        } while (recupIndiceRegistre(numPersonne) == -1);
        return numPersonne;
    }

    public static void supprimerUnBureau() {
        int numBureau = indiquerLeNumeroDuBureau();
        retourBureauNum(numBureau).supprimeBureau();
    }

    /**
     * Methode pour changer de bureau un personnel <br>
     * Demande le numero de la personne, le bureau actuel et le bureau futur
     * <br>
     * à l'utilisateur
     */
    public static void changerLeBureauDunePersonne() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        if (retourPersonneNum(numPersonne) instanceof Personnel) {
            System.out.println("\nindiquer le numero du bureau actuel de la personne");
            int numBureau = indiquerLeNumeroDuBureau();
            System.out.println("\nindiquer le numero du bureau futur de la personne");
            int numNewBureau = indiquerLeNumeroDuBureau();
            retourBureauNum(numBureau).envoieVersNewBureau((Personnel) (retourPersonneNum(numPersonne)), retourBureauNum(numNewBureau));
        } else {
            System.out.println("Ce n'est pas un Personnel");
        }
    }

    /**
     * Methode pour afficher le salaire annuel <br>
     * Demande le numero de la personne à l'utilisateur
     */
    public static void recuperationDuSalaireAnnuel() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        System.out.println("Le salarie "+retourPersonneNum(numPersonne).getNom()+" gagne :" +((Personnel) retourPersonneNum(numPersonne)).defSalaireAnnuel()+"euros");

    }

    /**
     * Methode pour afficher le salaire mensuel <br>
     * Demande le numero de la personne à l'utilisateur
     */
    public static void recuperationDuSalaireMensuel() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        
       System.out.println("Le salarie "+retourPersonneNum(numPersonne).getNom()+" gagne :" +((Personnel) retourPersonneNum(numPersonne)).getSalaireMensuel()+"euros");
    }

    /**
     * Methode pour proposer à l'utilisateur de creer un bureau apres
     * l'ajout<br>
     * d'une personne dans le registre <br>
     * Demande si l'utilisateur veux creer un bureau s'il aucun bureau de creer
     * <br>
     * Demande si l'utilisateur veux alourer un bureaux si un bureau est creer
     * <br>
     *
     * @see Console#ajouterUnBureau()
     * @see Console#ajouterUnOccupant()
     * @see Application#ajoutPersonne()
     */
    public static void alouerUnBureauApresCreation() {
        if (getSizeBureaux() < 1) {
            String reponse;
            System.out.println("\nIndiquer si vous voulez creer un bureau et ajouter un occupant? Oui/Non");
            reponse = Clavier.lireString();
            reponse = reponse.toLowerCase();
            if (reponse.equals("oui")) {
                ajouterUnBureau();
                ajouterUnOccupant();
            } else {
                ajoutPersonne();
            }
        } else {
            System.out.println("\nIndiquer si vous voulez ajouter un occupant a un bureau? Oui/Non");
            String reponse;
            reponse = Clavier.lireString();
            reponse = reponse.toLowerCase();
            if (reponse.equals("oui")) {
                ajouterUnOccupant();
            } else {
                ajoutPersonne();
            }
        }

    }

    /**
     * Methode pour afficher les occupants d'un bureau <br>
     * Demande le numero du bureau à l'utilisateur
     */
    public static void afficherLesOccupantsDunBureau() {
        int numBureau = indiquerLeNumeroDuBureau();
        retourBureauNum(numBureau).getStringOccupants();
    }

    /**
     * Methode pour afficher tous les bureaux et leurs informations
     */
    public static void afficheTousLesBureauxEtInfos() {
        afficheBureaux();
    }

    /**
     * Methode pour afficher toutes les informations d'un bureau en particulier
     * <br>
     * Demande le numero du bureau à l'utilisateur
     */
    public static void afficherToutesLesInfos() {
        int numBureau = indiquerLeNumeroDuBureau();
        System.out.println(retourBureauNum(numBureau));
    }

    /**
     * Methode pour assigner un personnel à un bureau <br>
     * Demande le numero de la personne et numero du bureau à l'utilisateur
     */
    public static void ajouterUnOccupant() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        if (retourPersonneNum(numPersonne) instanceof Personnel) {
            int numBureau = indiquerLeNumeroDuBureau();
            retourBureauNum(numBureau).setOccupant((Personnel) retourPersonneNum(numPersonne));
        } else {
            System.out.println("Ce n'est pas un Personnel");
        }
    }

    /**
     * Methode pour ajouter un bureau <br>
     * Demande le nombre de place dans un bureau et l'ajoute au registre des
     * <br>
     * bureau
     */
    public static void ajouterUnBureau() {
        System.out.println("\nindiquer le nombre de place souhaité dans le bureau");
        int numPlace = Clavier.lireInt();
        Bureau bureau = new Bureau(numPlace);
    }

    /**
     * Methode pour definir les heures a effectué par le personnel <br>
     * Demande le numero de la personne et les nombre d'heure effectué <br>
     * à l'utilisateur
     */
    public static void heureAEffectue() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        System.out.println("\nindiquer les heures à effectué");
        double heureAEffectue = Clavier.lireDouble();
        if (retourPersonneNum(numPersonne) instanceof Personnel) {
            ((Personnel) retourPersonneNum(numPersonne)).addNbHeuresEffectuee(heureAEffectue);
        } else {
            System.out.println("Ce n'est pas un Personnel");
        }
    }

    /**
     * Methode pour definir la bourse des etudiant boursier <br>
     * Demande le numero de la personne et le montant de la bourse <br>
     * à l'utilisateur
     */
    public static void definiBourseEtudiantboursier() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        System.out.println("\nIndiquer le montant de la bourse");
        double montantBourse = Clavier.lireDouble();
        if (retourPersonneNum(numPersonne) instanceof EtudiantBoursier) {
            ((EtudiantBoursier) retourPersonneNum(numPersonne)).setBourse(montantBourse);
        } else {
            System.out.println("Ce n'est pas un Personnel");
        }
    }

    /**
     * Methode pour definir la prime annuell <br>
     * Demande le montant de la prime annuel
     */
    public static void consoleSetPrimeAnnuelle(double prime) {
        setPrimeAnnuelle(prime);
    }

    /**
     * Methode pour definir la prime des personnel <br>
     * Demande le numero de la personne et si elle souhaite <br>
     * donner la prime a la personne
     */
    public static void definiPrime() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        boolean choix;
        String reponse;
        System.out.println("\nIndiquer si vous voulez donner la prime Oui/Non");
        reponse = Clavier.lireString();
        reponse = reponse.toLowerCase();
        if (reponse.equals("oui")) {
            choix = true;
        } else {
            choix = false;
        }
        if (retourPersonneNum(numPersonne) instanceof Personnel) {
            ((Personnel) retourPersonneNum(numPersonne)).setObtentionPrime(choix);
        } else {
            System.out.println("Ce n'est pas un Personnel");
        }
    }

    /**
     * Methode pour fixer le salaire Fixe des personnels <br>
     * Demande le numero de la personne et le salaire fixe <br>
     * à l'utilisateur
     */
    public static void definiSalaireFixe() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        System.out.println("\nindiquer le salaire fixe");
        double salaireFixe = Clavier.lireDouble();
        if (retourPersonneNum(numPersonne) instanceof Personnel) {
            ((Personnel) retourPersonneNum(numPersonne)).setSalaireFixe(salaireFixe);
        } else {
            System.out.println("Ce n'est pas un Personnel");
        }
    }

    /**
     * Methode pour retourner les personnels avec plus de 5 absence
     */
    public static void consoleRetourPerPlus5Abs() {
        retourPerPlus5Abs();
    }

    /**
     * Methode pour retourner les etudiants avec plus de 5 absence
     */
    public static void consoleRetourEtuPlus5Abs() {
        retourPerPlus5Abs();
    }

    /**
     * Méthode pour ajouter une absence justifié <br>
     * demande le numero de la personne et le nombre d'absence justifié <br>
     * à l'utilisateur
     */
    public static void ajoutDuneAbsenceJustifie() {
        int numPersonne = indiquerLeNumeroDeLaPersonne();
        System.out.println("\nIndiquer le nombre d'absence justifie");
        int numAbsenceJusitife = Clavier.lireInt();
        retourPersonneNum(numPersonne).addAbsJustif(numAbsenceJusitife);
        absence();
    }

    /**
     * Méthode pour ajouter une absence injustifié <br>
     * demande le numero de la personne et le nombre d'absence injustifié <br>
     * à utilisateur
     */
    public static void ajoutDuneAbsenceinjustifie() {

        int numPersonne = indiquerLeNumeroDeLaPersonne();
        System.out.println("\nindiquer le nombre d'absence injustifie");
        int numAbsenceJusitife = Clavier.lireInt();
        retourPersonneNum(numPersonne).addAbsNonJustif(numAbsenceJusitife);
        absence();
    }

    /**
     * Méthode pour retourner les personnes du registre en fonction de leur
     * classe
     */
    public static void afficherToutesLesPersonne() {
        int choix = -1;
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[1] : Afficher tout les etudiants");
        System.out.println("[2] : Afficher tout les etudiants boursier");
        System.out.println("[3] : Afficher tout les personnel administratif");
        System.out.println("[4] : Afficher tout les enseignant titulaire");
        System.out.println("[5] : Afficher tout les enseignant vacataire");
        choix = Clavier.lireInt();
        switch (choix) {
            case 0:
                menu();
                break;
            case 1:
                System.out.println(retourPersonnesType("Personne.Etudiant"));

                supprimePersonne();
                break;
            case 2:
                System.out.println(retourPersonnesType("Personne.EtudiantBoursier"));
                supprimePersonne();
                break;
            case 3:
                System.out.println(retourPersonnesType("Pesonne.PersonnelAdministratif"));
                supprimePersonne();
                break;
            case 4:
                System.out.println(retourPersonnesType("Personne.PersonnelEnseignantTitulaire"));
                supprimePersonne();
                break;
            case 5:
                System.out.println(retourPersonnesType("Personne.PersonnelEnseignantVacataire"));
                supprimePersonne();
                break;
        }
    }

    /**
     * Méthode pour retourner tout les personnel administraitf <br>
     */
    public static void retourPersonneTypeAdministratif() {
        System.out.println(retourPersonnesType("Pesonne.PersonnelAdministratif"));
    }

    /**
     * Méthode pour retourner tout les personnel Titulaire <br>
     */
    public static void retourPersonneTypeEnseignantsTitulaires() {
        System.out.println(retourPersonnesType("Personne.PersonnelEnseignantTitulaire"));
    }

    /**
     * Méthode pour retourner tout les personnel Vacataire <br>
     */
    public static void retourPersonneTypeEnseignantsVacataire() {
        System.out.println(retourPersonnesType("Personne.PersonnelEnseignantVacataire"));
    }

    /**
     * Méthode pour supprimer un element de Arraylist dans la classe Personne
     * <br>
     * demande le numero de la personne à utilisateur
     */
    public static void effacerUnElement() {
        int idASupprimer = indiquerLeNumeroDeLaPersonne();
        if (recupIndiceRegistre(idASupprimer) < 0) {
            System.out.print("Le numéero de la personne n'a pas ete trouve.");
        } else {
            supprimePersonne(recupIndiceRegistre(idASupprimer));
            System.out.print("le numero " + idASupprimer + "a bien été supprime");
        }
    }

    /**
     * Méthode pour quitter le programme
     */
    public static int quitterLeProgramme() {
        System.out.println("Merci d'avoir utilise notre programme");
        return 0;
    }

    /**
     * Méthode de creation d'un etudiant <br>
     * Demande le nom et le prenom à l'utilisateur
     */
    public static void creatEtudiant() {
        System.out.println("Saisir le Nom");
        String nom = Clavier.lireString();
        System.out.println("Saisir le Prénom");
        String prenom = Clavier.lireString();
        Personne Personne = new Etudiant(nom, prenom);
    }

    /**
     * Méthode de creation d'un etudiant boursier <br>
     * Demande le nom , Prenom et le montant de la bourse à l'utilisateur <br>
     */
    public static void creatEtudiantBoursier() {
        System.out.println("Saisir le Nom");
        String nom = Clavier.lireString();
        System.out.println("Saisir le Prénom");
        String prenom = Clavier.lireString();
        System.out.println("Saisir le montant de la bourse");
        double bourse = Clavier.lireDouble();
        Personne Personne = new EtudiantBoursier(nom, prenom, bourse);
    }

    /**
     * Méthode de creation d'un personnel administratif <br>
     * Demande le Nom , Prenom et le salaire fixe à l'utilisateur
     */
    public static void creatPersonnelAdministratif() {
        System.out.println("Saisir le Nom");
        String nom = Clavier.lireString();
        System.out.println("Saisir le Prénom");
        String prenom = Clavier.lireString();
        System.out.println("Saisir le salaire fixe");
        double salaireFixe = Clavier.lireDouble();
        Personne Personne = new PersonnelAdministratif(nom, prenom, salaireFixe);
    }

    /**
     * Méthode de creation d'un personnel enseignant titulaire <br>
     * Demande le nom, Prenom, Nombre d'heures statutaire et <br>
     * salaire fixe à l'utilisateur
     */
    public static void creatPersonnelEnseignantTitulaire() {
        System.out.println("Saisir le Nom");
        String nom = Clavier.lireString();
        System.out.println("Saisir le Prénom");
        String prenom = Clavier.lireString();
        System.out.println("Saisir le Nombre Heures Statutaire");
        double NbHeuresStatutaire = Clavier.lireDouble();
        System.out.println("Saisir le salaire fixe");
        double salaireFixe = Clavier.lireDouble();
        Personne Personne = new PersonnelEnseignantTitulaire(nom, prenom, NbHeuresStatutaire, salaireFixe);
    }

    /**
     * Méthode de creation d'un personnel enseignant vacataire <br>
     * Demande le Nom , Prenom et le nombre d'heure a l'utilisateur
     */
    public static void creatPersonnelEnseignantVacataire() {
        System.out.println("Saisir le Nom");
        String nom = Clavier.lireString();
        System.out.println("Saisir le Prénom");
        String prenom = Clavier.lireString();
        System.out.println("Saisir le nombre d'heure");
        int nbHeure = Clavier.lireInt();
        Personne Personne = new PersonnelEnseignantVacataire(nom, prenom);
    }

    /**
     * Méthode pour afficher le registre depuis l'application <br>
     *
     * @see Personne#affichageSimpleRegistre()
     */
    public static void consoleAffichageSimpleRegistre() {
        affichageSimpleRegistre();
    }
}
