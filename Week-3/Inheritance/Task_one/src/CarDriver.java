/*
هذا البرنامج يوضح مفهوم الوراثة في Java.
يعرّف فئة `Car` الأساسية وفئة `SportsCar` المشتقة.

- `Car` تمثل سيارة عادية بسرعات وتسارع عادي.
- `SportsCar` ترث `Car` ولكن بتسارع أسرع وتباطؤ أقوى واستهلاك وقود أعلى.

فئة `CarDriver` تختبر كلتا الفئتين عن طريق تشغيل السيارة العادية والسيارة الرياضية.
*/

class Car {
    protected int speed;
    protected int fuel;
    protected static final int MIN_SPEED = 0;
    protected static final int MAX_SPEED = 150;

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

class SportsCar extends Car {
    public SportsCar() {
        super();
    }

    @Override
    public void accelerate() {
        if (fuel > 0) {
            speed += 20;
            if (speed > MAX_SPEED) {
                speed = MAX_SPEED;
            }
            fuel -= 10;
            System.out.println("SportsCar speed: " + speed + " km/h, Fuel: " + fuel + "%");
        } else {
            System.out.println("Out of fuel!");
        }
    }

    @Override
    public void decelerate() {
        speed -= 10;
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }
        System.out.println("SportsCar speed: " + speed + " km/h");
    }
}

public class CarDriver {
    public static void main(String[] args) {
        System.out.println("Testing Car:");
        Car myCar = new Car();
        myCar.accelerate();
        myCar.decelerate();

        System.out.println("\nTesting SportsCar:");
        SportsCar mySportsCar = new SportsCar();
        mySportsCar.accelerate();
        mySportsCar.decelerate();
    }
}
