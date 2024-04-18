package solid;

public class Animal extends {
    protected String name;
    protected String sound;
    protected int teeth;
    protected int flightDistance;

    public Animal(String name, int teeth) {
        this.name = name;
        this.teeth=teeth;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getTeeth() {
        return teeth;
    }

    public void setTeeth(int teeth) {
        this.teeth = teeth;
    } 

    public int getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(int flightDistance) {
        this.flightDistance = flightDistance;
    }
    
    /* public String makeSound(String animalType) {
        switch (animalType) {
            case "cat" -> {
                return "Meaw";
            }
            case "dog" -> {
                return "Woof! Woof!";
            }
            case "chicken" -> {
                return "Cluck";
            }
            case "duck" -> {
                return "Quack";
            }
            default -> {
                return "This is not an animal";
            }
        }
    }

    public int flightDistance(String animalType) {
        switch (animalType) {
            case "cat" -> {
                return 0;
            }
            case "dog" -> {
                return 0;
            }
            case "chicken" -> {
                return 0;
            }
            case "duck" -> {
                return 5000;
            }
            default -> {
                return 0;
            }
        }
    } 

    public int getNumberOfTeeths(String animalType) {
        switch (animalType) {
            case "cat" -> {
                return 24;
            }
            case "dog" -> {
                return 30;
            }
            case "chicken" -> {
                return 0;
            }
            case "duck" -> {
                return 0;
            }
            default -> {
                return 0;
            }
        }
        
    }*/

    

  
}
