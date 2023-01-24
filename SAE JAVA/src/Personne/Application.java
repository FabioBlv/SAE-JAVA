/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personne;

import static Personne.Console.*;

/**
 *
 * @author fabio
 */
public class Application {

    /**
     * Methode du menu principale Plusieur choix sont proposés à l'utilisateur :
     * - Arreter le programme - Retour au menu principale - Effacer du registre
     * - Les etudiants avec plus de 5 absence injustifié - Liste des salaries
     * qui ont une retenue sur salaire - Modifier les personnes dans le registre
     * - Ajouter une absence - Gestion des bureaux - Gestion des salaires - Voir
     * tout le registre
     *
     * @see Console#quitterLeProgramme()
     * @see Console#consoleRetourEtuPlus5Abs()
     * @see Console#consoleRetourPerPlus5Abs()
     */
    public static void menu() {
        int choix = -1;
        System.out.println("\nMenu principal");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Ajouter au registre");
        System.out.println("[2] : Effacer du registre");
        System.out.println("[3] : Les etudiants avec plus de 5 absence injustifie");
        System.out.println("[4] : Liste des salaries qui ont une retenue sur salaire");
        System.out.println("[5] : Modifier les personnes dans le registre");
        System.out.println("[6] : Ajouter une absence");
        System.out.println("[7] : Gestion des bureaux");
        System.out.println("[8] : Gestion des salaires");
        System.out.println("[9] : Voir tout le registre");
        System.out.println("[10]: Sauvegarder");
        System.out.println("[11]: Indiquer la prime annuel");
        System.out.println("[12]: Charger les donnees sauvegarder");
        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                ajoutPersonne();
                break;
            case 2:
                supprimePersonne();
                break;
            case 3:
                consoleRetourEtuPlus5Abs();
                menu();
                break;
            case 4:
                consoleRetourPerPlus5Abs();
                menu();
                break;
            case 5:
                modifierLeRegistre();
                menu();
                break;
            case 6:
                absence();
                break;
            case 7:
                gestionDesBureaux();
                break;
            case 8:
                gestionDesSalaire();
                break;
            case 9:
                consoleAffichageSimpleRegistre();
                menu();
                break;
            case 10:
                sauvegarderRegistre();
                sauvegarderLesbureaux();
                menu();
                break;
            case 11:
                primeAnnuel();
                menu();
                break;
            case 12:
                Personne.chargerLesDonnesRegistre();
                Bureau.chargerLesDonnesBureau();
                menu();
                break;
            default:
                menu();
                break;
        }
    }

    /**
     * Menu d'ajout d'une personne Plusieur choix sont proposés à l'utilisateur
     * : - Arreter le programme - Retour au menu principale - Ajouter un
     * etudiant - Ajouter un etudiant boursier - Ajouter un enseignant titulaire
     * - Ajouter un enseignant vacataire - Ajouter un personnel administratif
     *
     * @see Console#creatEtudiant()
     * @see Console#creatEtudiantBoursier()
     * @see Console#creatPersonnelEnseignantTitulaire()
     * @see Console#creatPersonnelEnseignantVacataire()
     * @see Console#creatPersonnelAdministratif()
     */
    public static void ajoutPersonne() {
        int choix = -1;
        System.out.println("\nMenu d'Ajout des Personnes");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1]: Retour au menu principal");
        System.out.println("[2] : Ajouter un etudiant");
        System.out.println("[3] : Ajouter un etudiant boursier");
        System.out.println("[4] : Ajouter un enseignant titulaire");
        System.out.println("[5] : Ajouter un enseignant vacataire");
        System.out.println("[6] : Ajouter un personnel administratif");
        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                creatEtudiant();
                ajoutPersonne();
                break;
            case 3:
                creatEtudiantBoursier();
                ajoutPersonne();
                break;
            case 4:
                creatPersonnelEnseignantTitulaire();
                ajoutPersonne();
                break;
            case 5:
                creatPersonnelEnseignantVacataire();
                ajoutPersonne();
                break;
            case 6:
                creatPersonnelAdministratif();
                ajoutPersonne();
                break;
            default:
                menu();
                break;

        }
    }

    /**
     * Menu pour supprimer une personne Plusieur choix sont proposés à
     * l'utilisateur : - Arreter le programme - Retour au menu principale -
     * Effacer un element du registre - Voir les elements du registre
     *
     * @see Console#quitterLeProgramme()
     * @see Console#effacerUnElement()
     * @see Console#afficherToutesLesPersonne()
     */
    public static void supprimePersonne() {
        int choix = -1;
        System.out.println("\nMenu de Supression des Personnes");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Retour au menu principal");
        System.out.println("[2] : Effacer un element du registre");
        System.out.println("[3] : Voir les elements du registre");
        choix = Clavier.lireInt();
        switch (choix) {

            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                effacerUnElement();
                supprimePersonne();
                break;
            case 3:
                afficherToutesLesPersonne();
                break;
            default:
                menu();
                break;
        }
    }

    /**
     * Menu pour gerer les absences Plusieur choix sont proposés à l'utilisateur
     * : - Arreter le programme - Retour au menu principale - Ajouter une
     * absence jusitfie - Ajouter une absence injusitfie
     *
     * @see Console#quitterLeProgramme()
     * @see Console#ajoutDuneAbsenceJustifie()
     * @see Console#ajoutDuneAbsenceinjustifie()
     */
    public static void absence() {
        int choix = -1;
        System.out.println("\nMenu Gestion des Absences");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Retour au menu principal");
        System.out.println("[2] : Ajouter une absence jusitfie");
        System.out.println("[3] : Ajouter une absence injusitfie");
        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                ajoutDuneAbsenceJustifie();
                break;
            case 3:
                ajoutDuneAbsenceinjustifie();
                break;
            default:
                menu();
                break;
        }
    }

    /**
     * Menu pour les modifier elements du registre ( Arraylist de personne )
     * Plusieur choix sont proposés à l'utilisateur : - Arreter le programme -
     * Retour au menu principale - Personnel Administratif - Personnel
     * Enseignant Titulaire - Personnel Enseignant Vacataire - Ajouter une bouse
     * a un Etudiant Boursier
     *
     * @see Console#quitterLeProgramme()
     * @see Console#definiBourseEtudiantboursier()
     */
    public static void modifierLeRegistre() {
        int choix = -1;
        System.out.println("\nMenu pour modifier les elements du registre");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Retour au menu principal");
        System.out.println("[2] : Personnel Administratif");
        System.out.println("[3] : Personnel Enseignant Titulaire");
        System.out.println("[4] : Personnel Enseignant Vacataire");
        System.out.println("[5] : Ajouter une bouse a un Etudiant Boursier");

        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                menuPersonnelAdministratif();
                modifierLeRegistre();
                break;
            case 3:
                menuPersonnelEnseignantTitulaire();
                modifierLeRegistre();
                break;
            case 4:
                menuPersonnelEnseignantVacataire();
                modifierLeRegistre();
                break;
            case 5:
                definiBourseEtudiantboursier();
                modifierLeRegistre();
                break;
            default:
                menu();
                break;
        }
    }

    /**
     * Menu pour modfier les Personnel Adminstratif Plusieur choix sont proposés
     * à l'utilisateur : - Arreter le programme - Retour au menu principale -
     * Modifier le Salaire Fixe - Obtient la prime - afficher les Personnels
     * Admistratif
     *
     * @see Console#quitterLeProgramme()
     * @see Console#definiSalaireFixe()
     * @see Console#definiPrime()
     * @see Console#retourPersonneTypeAdministratif()
     */
    public static void menuPersonnelAdministratif() {
        int choix = -1;
        System.out.println("\nMenu pour modifier les elements des Personnels Administratifs");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Retour au menu principal");
        System.out.println("[2] : Modifier le Salaire Fixe");
        System.out.println("[3] : Obtient la prime");
        System.out.println("[4] : afficher les Personnels Admistratif");
        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                definiSalaireFixe();
                menuPersonnelAdministratif();
                break;
            case 3:
                definiPrime();
                menuPersonnelAdministratif();
                break;
            case 4:
                retourPersonneTypeAdministratif();
                menuPersonnelAdministratif();
                break;
            default:
                menu();
                break;

        }

    }

    /**
     * Menu pour gerer les enseignant titulaire Plusieur choix sont proposés à
     * l'utilisateur : - Arreter le programme - Retour au menu principale -
     * Modifier le Salaire Fixe - Modifier les Heure Effectue - Obtient la prime
     * - Afficher les Enseignants Titulaires
     *
     * @see Console#quitterLeProgramme()
     * @see Console#definiSalaireFixe()
     * @see Console#heureAEffectue()
     * @see Console#definiPrime()
     * @see Console#retourPersonneTypeEnseignantsTitulaires()
     */
    public static void menuPersonnelEnseignantTitulaire() {
        int choix = -1;
        System.out.println("\nMenu pour modifier les elements des Enseignants Titulaires");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Retour au menu principal");
        System.out.println("[2] : Modifier le Salaire Fixe");
        System.out.println("[3] : Modifier les Heure  Effectue");
        System.out.println("[4] : Obtient la prime");
        System.out.println("[5] : Afficher les Enseignants Titulaires");
        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                definiSalaireFixe();
                menuPersonnelEnseignantTitulaire();
                break;
            case 3:
                heureAEffectue();
                menuPersonnelEnseignantTitulaire();
                break;
            case 4:
                definiPrime();
                menuPersonnelEnseignantTitulaire();
                break;
            case 5:
                retourPersonneTypeEnseignantsTitulaires();
                menuPersonnelEnseignantTitulaire();
                break;
            default:
                menu();
                break;
        }

    }

    /**
     * Menu pour gerer les enseignant vacataire Plusieur choix sont proposés à
     * l'utilisateur : - Arreter le programme - Retour au menu principale -
     * Modifier les Heure Effectue - Afficher les Enseignants Vacataire
     *
     * @see Console#quitterLeProgramme()
     * @see Console#heureAEffectue()
     * @see Console#retourPersonneTypeEnseignantsVacataire()
     */
    public static void menuPersonnelEnseignantVacataire() {
        int choix = -1;
        System.out.println("\nMenu pour modifier les elements des Enseignants Vacataire");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Retour au menu principal");
        System.out.println("[2] : Modifier les Heure  Effectue");
        System.out.println("[3] : Afficher les Enseignants Vacataire");
        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                heureAEffectue();
                menuPersonnelEnseignantVacataire();
                break;
            case 3:
                retourPersonneTypeEnseignantsVacataire();
                menuPersonnelEnseignantVacataire();
                break;
            default:
                menu();
                break;
        }

    }

    /**
     * Menu pour gerer les bureaux Plusieur choix sont proposés à l'utilisateur
     * : - Arreter le programme - Retour au menu principale - Ajouter un bureau
     * - Ajouter un occupant à un bureau - Afficher toutes les infos d'un Bureau
     * - Affiche tous les bureaux et toutes leurs infos - Afficher les occupants
     * d'un bureau - Changer le bureau d'une personne - Supprimer un bureau
     *
     * @see Console#quitterLeProgramme()
     * @see Console#ajouterUnBureau()
     * @see Console#ajouterUnOccupant()
     * @see Console#afficherToutesLesInfos()
     * @see Console#afficheTousLesBureauxEtInfos()
     * @see Console#afficherLesOccupantsDunBureau()
     * @see Console#changerLeBureauDunePersonne()
     */
    public static void gestionDesBureaux() {
        int choix = -1;
        System.out.println("\nMenu de gestion des bureaux");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Retour au menu principal");
        System.out.println("[2] : Ajouter un bureau");
        System.out.println("[3] : Ajouter un occupant à un bureau");
        System.out.println("[4] : Afficher toutes les infos d'un Bureau");
        System.out.println("[5] : Affiche tous les bureaux et toutes leurs infos");
        System.out.println("[6] : Afficher les occupants d'un bureau");
        System.out.println("[7] : Changer le bureau d'une personne");
        System.out.println("[8] : Supprimer un bureau");
        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                ajouterUnBureau();
                gestionDesBureaux();
                break;
            case 3:
                ajouterUnOccupant();
                gestionDesBureaux();
                break;
            case 4:
                afficherToutesLesInfos();
                gestionDesBureaux();
                break;
            case 5:
                afficheTousLesBureauxEtInfos();
                gestionDesBureaux();
                break;
            case 6:
                afficherLesOccupantsDunBureau();
                gestionDesBureaux();
                break;
            case 7:
                changerLeBureauDunePersonne();
                gestionDesBureaux();
                break;
            case 8:
                supprimerUnBureau();
                gestionDesBureaux();
                break;
            default:
                menu();
                break;

        }

    }

    /**
     * Menu pour gerer les salaires Plusieur choix sont proposés à l'utilisateur
     * : - Arreter le programme - Retour au menu principale - Recuperation du
     * salaire Mensuel - Recuperation du salaire Annuel
     *
     * @see Console#quitterLeProgramme()
     * @see Console#recuperationDuSalaireMensuel()
     * @see Console#recuperationDuSalaireAnnuel()
     */
    public static void gestionDesSalaire() {
        int choix = -1;
        System.out.println("\nMenu de gestion des salaires");
        System.out.println("\nMerci de faire votre choix");
        System.out.println("--------------------------------------------------\n");
        System.out.println("[0] : Arreter le programme");
        System.out.println("[1] : Retour au menu principal");
        System.out.println("[2] : Recuperation du salaire Mensuel");
        System.out.println("[3] : Recuperation du salaire Annuel");
        choix = Clavier.lireInt();

        switch (choix) {
            case 0:
                quitterLeProgramme();
                break;
            case 1:
                menu();
                break;
            case 2:
                recuperationDuSalaireMensuel();
                menu();
                break;
            case 3:
                recuperationDuSalaireAnnuel();
                menu();
                break;
            default:
                menu();
                break;

        }
    }

}
