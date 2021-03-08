package core;

public class Camera {
    public static Car getNextCar() {
        String randomNumber = Double.toString(Math.random()).substring(2, 5); // genère es chiffres aléatoires --random--
        int randomHeight = (int) (1000 + 3500. * Math.random());
        double randomWeight = 600 + 10000 * Math.random();

        Car car = new Car();
        car.number = randomNumber;
        car.height = randomHeight;
        car.weight = randomWeight;
        car.hasVehicle = Math.random() > 0.5; // probabilité 50% pour avoir une remorque
        car.isSpecial = Math.random() < 0.15; // probabilité 15% pour vehicule special

        return car;
    }
}