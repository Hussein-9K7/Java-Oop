/*
هذا البرنامج يوضح مفهوم الوراثة في Java من خلال إنشاء فئة `Bus` المشتقة من `Car`.

- `Car` تمثل مركبة عادية بميزات التسارع والتباطؤ.
- `Bus` ترث `Car` ولكن بإمكانية حمل الركاب وإدارتهم من خلال وظائف `passengerEnter()` و `passengerExit()`.

فئة `CarDriver` تختبر الفئات عن طريق تشغيل السيارة العادية والحافلة وإجراء عمليات على الركاب.
*/

class Car {
    protected int speed;
    protected int fuel;
    protected static final int MIN_SPEED = 0;
    protected static final int MAX_SPEED = 120;

    public Car() {
        this.speed = 0;
        this.fuel = 100;
    }

    public void accelerate() {
        if (fuel > 0) {
            speed += 10;
            if (speed > MAX_SPEED) {
                speed = MAX_SPEED;
            }
            fuel -= 5;
            System.out.println("Car speed: " + speed + " km/h, Fuel: " + fuel + "%");
        } else {
            System.out.println("Out of fuel!");
        }
    }

    public void decelerate() {
        speed -= 5;
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }
        System.out.println("Car speed: " + speed + " km/h");
    }
}

class Bus extends Car {
    private int passengers;
    private static final int MAX_PASSENGERS = 50;

    public Bus() {
        super();
        this.passengers = 0;
    }

    public void passengerEnter() {
        if (passengers < MAX_PASSENGERS) {
            passengers++;
            System.out.println("Passenger entered. Total passengers: " + passengers);
        } else {
            System.out.println("Bus is full! No more passengers can enter.");
        }
    }

    public void passengerExit() {
        if (passengers > 0) {
            passengers--;
            System.out.println("Passenger exited. Total passengers: " + passengers);
        } else {
            System.out.println("No passengers in the bus.");
        }
    }
}

public class CarDriver {
    public static void main(String[] args) {
        System.out.println("Testing Car:");
        Car myCar = new Car();
        myCar.accelerate();
        myCar.decelerate();

        System.out.println("\nTesting Bus:");
        Bus myBus = new Bus();
        myBus.accelerate();
        myBus.passengerEnter();
        myBus.passengerEnter();
        myBus.passengerExit();
        myBus.decelerate();
    }
}