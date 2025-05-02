package assignment3_virtualpet;

public class PetModel {
    private Pet pet;

    public PetModel() {
        pet = new Pet(100, 100);
    }

    public Pet getPet() {
        return pet;
    }

    public void updatePosition(double newX, double newY) {
        pet.setX(newX);
        pet.setY(newY);
    }
}
