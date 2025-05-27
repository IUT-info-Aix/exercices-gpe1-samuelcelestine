package fr.amu.iut.exercice4;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

@SuppressWarnings("Duplicates")
public class MainPersonnes {

    private static SimpleListProperty<fr.amu.iut.exercice4.Personne> lesPersonnes;
    private static IntegerProperty ageMoyen;
    private static IntegerProperty nbParisiens;

    private static IntegerBinding calculAgeMoyen;
    private static IntegerBinding calculnbParisiens;

    public static void main(String[] args) {
        lesPersonnes = new SimpleListProperty<>(FXCollections.observableArrayList());
        ageMoyen = new SimpleIntegerProperty(0);
        nbParisiens = new SimpleIntegerProperty(0);


        calculAgeMoyen = new IntegerBinding() {
            {
                super.bind(lesPersonnes);
            }

            @Override
            protected int computeValue() {
                if (lesPersonnes.isEmpty())
                    return 0;

                int total = 0;
                for (fr.amu.iut.exercice4.Personne p : lesPersonnes)
                    total += p.getAge();
                return total / lesPersonnes.size();
            }
        };

        lesPersonnes.addListener((InvalidationListener) (change) -> {
            calculAgeMoyen.invalidate();
            for (fr.amu.iut.exercice4.Personne p : lesPersonnes)
                p.ageProperty().addListener((obs, oldVal, newVal) -> calculAgeMoyen.invalidate());
        });

        ageMoyen.bind(calculAgeMoyen);

        question1();

        calculnbParisiens = new IntegerBinding() {
            {
                super.bind(lesPersonnes);
            }

            @Override
            protected int computeValue() {
                int count = 0;
                for (fr.amu.iut.exercice4.Personne p : lesPersonnes) {
                    if ("Paris".equalsIgnoreCase(p.getVilleDeNaissance()))
                        count++;
                }
                return count;
            }
        };

        lesPersonnes.addListener((InvalidationListener) (change) -> {
            calculnbParisiens.invalidate();
            for (fr.amu.iut.exercice4.Personne p : lesPersonnes)
                p.villeDeNaissanceProperty().addListener((obs, oldVal, newVal) -> calculnbParisiens.invalidate());
        });
        nbParisiens.bind(calculnbParisiens);

       question2();
    }

    public static void question1() {
        System.out.println("1 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        fr.amu.iut.exercice4.Personne pierre = new fr.amu.iut.exercice4.Personne("Pierre", 20);
        lesPersonnes.add(pierre);
        System.out.println("2 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        fr.amu.iut.exercice4.Personne paul = new fr.amu.iut.exercice4.Personne("Paul", 40);
        lesPersonnes.add(paul);
        System.out.println("3 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        fr.amu.iut.exercice4.Personne jacques = new fr.amu.iut.exercice4.Personne("Jacques", 60);
        lesPersonnes.add(jacques);
        System.out.println("4 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        paul.setAge(100);
        System.out.println("5 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        lesPersonnes.remove(paul);
        System.out.println("6 - L'age moyen est de " + ageMoyen.getValue() + " ans");
    }

    public static void question2() {
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
        lesPersonnes.get(0).setVilleDeNaissance("Marseille");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
        lesPersonnes.get(1).setVilleDeNaissance("Montpellier");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisien");
        for (fr.amu.iut.exercice4.Personne p : lesPersonnes)
            p.setVilleDeNaissance("Paris");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
    }


}

