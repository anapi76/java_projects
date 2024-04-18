import solid.Animal;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Cat("Danny", 28);
        Animal.animalFlightDistance(animal);
        Animal.animalSound(animal);
        Animal.animalTeeths(animal);
    }

    public static void animalSound(Animal animal) {
        String sound = animal.getSound();
        String name = animal.getName();
        System.out.println("El sonido que hace " + name + " es " + sound);
    }

    public static void animalTeeths(Animal animal) {
        int totalTeeth = animal.getTeeth();
        String name = animal.getName();
        System.out.println(name + " tiene " + totalTeeth + " dientes");
    }

    public static void animalflightDistance(Animal animal) {
        int flightMeters = animal.getFlightDistance();
        String name = animal.getName();

        System.out.println(name + " puede volar " + flightMeters + " metros");
    }
}