package core;

public class Car {
    public String number;
    public int height; // hauteur
    public double weight; // poids
    public boolean hasVehicle; // avec remorque
    public boolean isSpecial; // police pompiers samu...

    public String toString() { // Methode
        String special = isSpecial ? "POLICE, POMPIERS, SAMU... " : "";
        return "\n=========================================\n" + // passe a la ligne
            special + "La voiture numéro " + number +
            ":\n\tHauteur: " + height + " мм\n\tPoids: " + weight + " Kilo";
    }
}