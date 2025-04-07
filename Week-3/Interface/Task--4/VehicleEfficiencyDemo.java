/*
1. سنبدأ بتعريف واجهة اسمها Vehicle.
   - سنضيف فيها دالة `calculateFuelEfficiency()` التي ستعيد كفاءة الوقود لكل نوع من المركبات.
*/
interface Vehicle {
    void start();  // بدء تشغيل المركبة
    void stop();   // إيقاف المركبة
    String getInfo();  // الحصول على معلومات عن المركبة
    void charge();  // شحن المركبة (إذا كانت كهربائية)
    double calculateFuelEfficiency();  // حساب كفاءة الوقود
}

/*
2. كلاس AbstractVehicle يحتوي على بعض الخصائص المشتركة بين المركبات.
   - كفاءة الوقود ستتغير حسب نوع المركبة.
*/
abstract class AbstractVehicle implements Vehicle {
    String type;  // نوع المركبة
    String fuel;  // نوع الوقود
    String color;  // لون المركبة
    double fuelEfficiency;  // كفاءة الوقود

    // منشئ لتحديد خصائص المركبة
    public AbstractVehicle(String type, String fuel, String color, double fuelEfficiency) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.fuelEfficiency = fuelEfficiency;  // تعيين كفاءة الوقود للمركبة
    }

    // دالة للحصول على معلومات عن المركبة
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }

    // دالة charge للمركبات الغير كهربائية
    public void charge() {
        System.out.println("No possible to charge.");
    }

    // دالة لحساب كفاءة الوقود
    public double calculateFuelEfficiency() {
        return fuelEfficiency;  // إرجاع كفاءة الوقود
    }
}

/*
3. كلاس ElectricCar يمثل سيارة كهربائية.
   - سيحمل كفاءة الوقود كـ kWh لكل كيلومتر.
*/
class ElectricCar extends AbstractVehicle {
    public ElectricCar() {
        super("Electric Car", "Electricity", "Blue", 0.2);  // تعيين كفاءة الطاقة (مثلاً: 0.2 kWh لكل كيلومتر)
    }

    public void start() {
        System.out.println("Electric Car is starting...");
    }

    public void stop() {
        System.out.println("Electric Car is stopping...");
    }

    public void charge() {
        System.out.println("Charging the Electric Car...");
    }
}

/*
4. كلاس ElectricMotorcycle يمثل دراجة نارية كهربائية.
   - سيحمل كفاءة الوقود كـ kWh لكل كيلومتر.
*/
class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle() {
        super("Electric Motorcycle", "Electricity", "Green", 0.1);  // تعيين كفاءة الطاقة (مثلاً: 0.1 kWh لكل كيلومتر)
    }

    public void start() {
        System.out.println("Electric Motorcycle is starting...");
    }

    public void stop() {
        System.out.println("Electric Motorcycle is stopping...");
    }

    public void charge() {
        System.out.println("Charging the Electric Motorcycle...");
    }
}

/*
5. كلاس Car للمركبة العادية (غير كهربائية).
   - كفاءة الوقود هنا ستكون بالميل لكل جالون (MPG).
*/
class Car extends AbstractVehicle {
    public Car() {
        super("Car", "Petrol", "Red", 25.0);  // تعيين كفاءة الوقود (مثلاً: 25 ميل لكل جالون)
    }

    public void start() {
        System.out.println("Car is starting...");
    }

    public void stop() {
        System.out.println("Car is stopping...");
    }

    public void charge() {
        System.out.println("No possible to charge.");
    }
}

/*
6. كلاس Motorcycle للمركبة العادية (غير كهربائية).
   - كفاءة الوقود ستكون بالميل لكل جالون (MPG).
*/
class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        super("Motorcycle", "Gasoline", "Black", 40.0);  // تعيين كفاءة الوقود (مثلاً: 40 ميل لكل جالون)
    }

    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    public void charge() {
        System.out.println("No possible to charge.");
    }
}

/*
7. الكلاس الرئيسي الذي يحتوي على دالة main لاختبار الكود.
   - سنختبر تشغيل المركبات وحساب كفاءة الوقود.
*/
public class VehicleEfficiencyDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Fuel Efficiency Demo\n");

        // إنشاء كائنات من المركبات
        Vehicle electricCar = new ElectricCar();  // سيارة كهربائية
        Vehicle electricMotorcycle = new ElectricMotorcycle();  // دراجة نارية كهربائية
        Vehicle car = new Car();  // سيارة عادية
        Vehicle motorcycle = new Motorcycle();  // دراجة نارية عادية

        // تجربة تشغيل وإيقاف المركبات
        electricCar.start();
        electricCar.stop();
        System.out.println(electricCar.getInfo());
        System.out.println("Fuel Efficiency: " + electricCar.calculateFuelEfficiency() + " kWh/km");

        electricMotorcycle.start();
        electricMotorcycle.stop();
        System.out.println(electricMotorcycle.getInfo());
        System.out.println("Fuel Efficiency: " + electricMotorcycle.calculateFuelEfficiency() + " kWh/km");

        car.start();
        car.stop();
        System.out.println(car.getInfo());
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " MPG");

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());
        System.out.println("Fuel Efficiency: " + motorcycle.calculateFuelEfficiency() + " MPG");
    }
}
