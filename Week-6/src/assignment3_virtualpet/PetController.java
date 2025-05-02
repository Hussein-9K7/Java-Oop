package assignment3_virtualpet;

public class PetController {
    private PetModel model;
    private double speed = 2;

    public PetController(PetModel model) {
        this.model = model;
    }

    public void moveTowards(double targetX, double targetY) {
        Pet pet = model.getPet();
        double dx = targetX - pet.getX();
        double dy = targetY - pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < speed) {
            model.updatePosition(targetX, targetY);
        } else {
            double ratio = speed / distance;
            double newX = pet.getX() + dx * ratio;
            double newY = pet.getY() + dy * ratio;
            model.updatePosition(newX, newY);
        }
    }
}
