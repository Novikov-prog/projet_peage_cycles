import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController { // une classe ne peut contenir que les variables et les methodes
    private static double passengerCarMaxWeight = 3500.0; // kg
    private static int passengerCarMaxHeight = 2000; // mm
    private static int controllerMaxHeight = 4000; // mm

    private static int passengerCarPrice = 15; // euro
    private static int cargoCarPrice = 25; // euro
    private static int vehicleAdditionalPrice = 5; // euro

    public static void main(String[] args) { // Methode commence ici
        System.out.println("Combien de voitures à générer?");

        Scanner scanner = new Scanner(System.in); // les donneés de la console
        int carsCount = scanner.nextInt();

        for (int i = 0; i < carsCount; i++) { // le cycle va être repeter au taut de fois que nous avons écris dans la console carsCount
            Car car = Camera.getNextCar(); // la variable car generé par la methode getNextCar de la class Camera
            System.out.println(car);

            //Le passage autorisé pour les vehicules speciaux
            if (car.isSpecial) {
                openWay(); // appel de la methode openWay si --True--
                continue;
            }

            //Verification de la heuteur et du poids, decrementation du tarif
            int price = calculatePrice(car);
            if (price == -1) {
                continue;
            }

            System.out.println("La somme totale à regler: " + price + " euros.");
        }
    }

    /**
     * Calcul du tarif en fonction du poids et de la taille du vehicule
     */
    private static int calculatePrice(Car car) {
        int carHeight = car.height;
        int price = 0;
        if (carHeight > controllerMaxHeight) {
            blockWay("La hauteur de votre vehicule depasse les normes autorisés!");
            return -1;
        } else if (carHeight > passengerCarMaxHeight) {
            double weight = car.weight;
            //Vehicule Poids Lourd
            if (weight > passengerCarMaxWeight) {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Voiture simple
            else {
                price = cargoCarPrice;
            }
        } else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Ouverture de la barrière
     */
    private static void openWay() {
        System.out.println("Ouverture de la barière... Bonne route!");
    }

    /**
     * Message du refus
     */
    private static void blockWay(String reason) {
        System.out.println("Imposible de passer: " + reason);
    }
}