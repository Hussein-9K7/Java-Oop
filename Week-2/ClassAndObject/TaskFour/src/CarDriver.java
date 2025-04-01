// Simple Car class with Cruise Control feature
// This class allows setting a target speed, turning cruise control on/off,
// and automatically adjusting speed to match the target.
//
// CarDriver class tests the cruise control feature.
//
// Author: Beginner Student
// Date: April 2025

class Car {
    private int speed; // Current speed of the car
    private int targetSpeed; // Target speed for cruise control
    private boolean cruiseControlOn; // Status of cruise control (on/off)
    private static final int MIN_SPEED = 30; // Minimum allowed speed
    private static final int MAX_SPEED = 150; // Maximum allowed speed

    // Constructor initializes the car with default values
    public Car() {
        this.speed = 0;
        this.targetSpeed = 0;
        this.cruiseControlOn = false;
    }

    // Set target speed if within valid range
    public void setTargetSpeed(int targetSpeed) {
        if (targetSpeed >= MIN_SPEED && targetSpeed <= MAX_SPEED) {
            this.targetSpeed = targetSpeed;
            System.out.println("Target speed set to: " + targetSpeed + " km/h");
        } else {
            System.out.println("Error: Target speed must be between " + MIN_SPEED + " and " + MAX_SPEED + " km/h.");
        }
    }

    // Get the current target speed
    public int getTargetSpeed() {
        return targetSpeed;
    }

    // Turn on cruise control if target speed is valid
    public boolean turnOnCruiseControl() {
        if (targetSpeed >= MIN_SPEED && targetSpeed <= MAX_SPEED) {
            cruiseControlOn = true;
            System.out.println("Cruise control activated. Adjusting speed...");
            adjustSpeed();
            return true;
        } else {
            System.out.println("Cruise control cannot be activated. Invalid target speed.");
            cruiseControlOn = false;
            return false;
        }
    }

    // Turn off cruise control
    public void turnOffCruiseControl() {
        cruiseControlOn = false;
        System.out.println("Cruise control deactivated.");
    }

    // Adjust the car's speed to reach the target speed
    private void adjustSpeed() {
        while (cruiseControlOn && speed != targetSpeed) {
            if (speed < targetSpeed) {
                speed++;
            } else if (speed > targetSpeed) {
                speed--;
            }
            System.out.println("Current speed: " + speed + " km/h");
        }
        if (speed == targetSpeed) {
            System.out.println("Cruise control: Target speed reached!");
        }
    }
}

// CarDriver class to test the Car's cruise control
public class CarDriver {
    public static void main(String[] args) {
        Car myCar = new Car(); // Create a new car object

        myCar.setTargetSpeed(100); // Set target speed
        boolean cruiseActivated = myCar.turnOnCruiseControl(); // Try to activate cruise control

        if (!cruiseActivated) {
            System.out.println("Failed to activate cruise control.");
        }
    }
}
