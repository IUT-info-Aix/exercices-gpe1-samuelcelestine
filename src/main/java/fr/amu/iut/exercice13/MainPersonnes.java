package fr.amu.iut.exercice3;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class MainPersonnes {

    private static ObservableList<fr.amu.iut.exercice3.Personne> lesPersonnes;

    private static ListChangeListener<fr.amu.iut.exercice3.Personne> unChangementListener;
    private static ListChangeListener<fr.amu.iut.exercice3.Personne> plusieursChangementsListener;

    public static void main(String[] args) {

        // Pour écouter les changements internes comme ageProperty()
        lesPersonnes = FXCollections.observableArrayList(
                personne -> new Observable[]{personne.ageProperty()}
        );

        // Premier listener : ajout et suppression + écoute de l'âge
        unChangementListener = change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (fr.amu.iut.exercice3.Personne p : change.getAddedSubList()) {
                        System.out.println("Ajouté : " + p.getNom());
                        // Écouter le changement d'âge
                        p.ageProperty().addListener((obs, oldVal, newVal) ->
                                System.out.println(p.getNom() + " a maintenant " + newVal + " ans")
                        );
                    }
                }
                if (change.wasRemoved()) {
                    for (fr.amu.iut.exercice3.Personne p : change.getRemoved()) {
                        System.out.println("Supprimé : " + p.getNom());
                    }
                }
            }
        };

        // Listener pour plusieurs changements à la fois
        plusieursChangementsListener = change -> {
            System.out.println("Début des changements :");
            while (change.next()) {
                if (change.wasAdded()) {
                    for (fr.amu.iut.exercice3.Personne p : change.getAddedSubList()) {
                        System.out.println("Ajouté : " + p.getNom());
                        p.ageProperty().addListener((obs, oldVal, newVal) ->
                                System.out.println(p.getNom() + " a maintenant " + newVal + " ans")
                        );
                    }
                }
                if (change.wasRemoved()) {
                    for (fr.amu.iut.exercice3.Personne p : change.getRemoved()) {
                        System.out.println("Supprimé : " + p.getNom());
                    }
                }
            }
            System.out.println("Fin des changements.\n");
        };

        // Choisir quel listener utiliser
        lesPersonnes.addListener(unChangementListener); // Utilise ceci pour question1, 2, 3
        // lesPersonnes.addListener(plusieursChangementsListener); // Utilise ceci pour question5

        // Appel de la question à tester
        question3();
        // question5();
    }

    public static void question1() {
        fr.amu.iut.exercice3.Personne pierre = new fr.amu.iut.exercice3.Personne("Pierre", 20);
        fr.amu.iut.exercice3.Personne paul = new fr.amu.iut.exercice3.Personne("Paul", 40);
        fr.amu.iut.exercice3.Personne jacques = new fr.amu.iut.exercice3.Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        fr.amu.iut.exercice3.Personne pierre = new fr.amu.iut.exercice3.Personne("Pierre", 20);
        fr.amu.iut.exercice3.Personne paul = new fr.amu.iut.exercice3.Personne("Paul", 40);
        fr.amu.iut.exercice3.Personne jacques = new fr.amu.iut.exercice3.Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        fr.amu.iut.exercice3.Personne pierre = new fr.amu.iut.exercice3.Personne("Pierre", 20);
        fr.amu.iut.exercice3.Personne paul = new fr.amu.iut.exercice3.Personne("Paul", 40);
        fr.amu.iut.exercice3.Personne jacques = new fr.amu.iut.exercice3.Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        fr.amu.iut.exercice3.Personne pierre = new fr.amu.iut.exercice3.Personne("Pierre", 20);
        fr.amu.iut.exercice3.Personne paul = new fr.amu.iut.exercice3.Personne("Paul", 40);
        fr.amu.iut.exercice3.Personne jacques = new fr.amu.iut.exercice3.Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (fr.amu.iut.exercice3.Personne p : lesPersonnes)
            p.setAge(p.getAge() + 10);
        lesPersonnes.removeAll(paul, pierre);
    }
}
