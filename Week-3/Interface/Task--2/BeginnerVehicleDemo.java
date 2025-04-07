interface Vehicle {
    void start();
    void stop();
    String getInfo();
}

abstract class AbstractVehicle implements Vehicle {
    String type;
    String fuel;
    String color;

    public AbstractVehicle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    public String getInfo() {
        return type + " Information:\nType: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }
}

class Car extends AbstractVehicle {
    public Car() {
        super("Car", "Petrol", "Red");
    }

    public void start() {
        System.out.println("Car is starting...");
    }

    public void stop() {
        System.out.println("Car is stopping...");
    }
}

class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        super("Motorcycle", "Gasoline", "Black");
    }

    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }
}

class Bus extends AbstractVehicle {
    int capacity;

    public Bus() {
        super("Bus", "Diesel", "White");
        this.capacity = 40;
    }

    public String getInfo() {
        return super.getInfo() + "\nCapacity: " + capacity + " passengers";
    }

    public void start() {
        System.out.println("Bus is starting...");
    }

    public void stop() {
        System.out.println("Bus is stopping...");
    }
}

public class BeginnerVehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        Vehicle bus = new Bus();

        car.start();
        car.stop();
        System.out.println(car.getInfo() + "\n");

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo() + "\n");

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo() + "\n");
    }
}
