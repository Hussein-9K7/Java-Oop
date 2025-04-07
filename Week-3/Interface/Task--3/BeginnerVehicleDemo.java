/*
1. تعريف واجهة ElectricVehicle التي تحتوي على دالة charge().
   - هذه الواجهة تحتوي على دالة charge() التي تتيح للمركبات الكهربائية شحنها.
   - المركبات الغير كهربائية ستقوم بتطبيق دالة charge() بطريقة مختلفة.
*/
interface ElectricVehicle {
    void charge();  // المركبات الكهربائية تحتاج هذه الدالة لتحديد طريقة الشحن
}

/*
2. كلاس AbstractVehicle الآن ينفذ واجهتي Vehicle و ElectricVehicle
   - الكلاس المجرد AbstractVehicle يطبق واجهتي Vehicle و ElectricVehicle، وبالتالي يشترك في خصائص ومميزات المركبات العادية والكهربائية.
   - يحتوي على خصائص مشتركة مثل النوع، الوقود، اللون.
   - يحتوي أيضًا على دالة charge() التي تطبع رسالة تقول "No possible to charge." لأن المركبات غير الكهربائية لا تدعم الشحن.
*/
abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    String type;
    String fuel;
    String color;

    // مُنشئ لتحديد الخصائص الأساسية للمركبة
    public AbstractVehicle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    // دالة getInfo التي توفر معلومات عن المركبة
    public String getInfo() {
        return type + " Information:\nType: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }

    // دالة charge المُطبقة في الكلاس المجرد والتي تطبع رسالة في حالة عدم شحن المركبة الكهربائية
    public void charge() {
        System.out.println("No possible to charge.");
    }
}

/*
3. الكلاس ElectricCar يمثل سيارة كهربائية ويرث من AbstractVehicle
   - هذا الكلاس يحدد كيفية تشغيل وتوقف السيارة الكهربائية.
   - كما يتم تطبيق دالة charge() التي تطبع "Charging the Electric Car..." لأن هذه المركبة كهربائية ويمكن شحنها.
*/
class ElectricCar extends AbstractVehicle {
    public ElectricCar() {
        super("Electric Car", "Electricity", "Blue");
    }

    // تنفيذ دالة start للطباعة عند بدء تشغيل السيارة الكهربائية
    public void start() {
        System.out.println("Electric Car is starting...");
    }

    // تنفيذ دالة stop للطباعة عند توقف السيارة الكهربائية
    public void stop() {
        System.out.println("Electric Car is stopping...");
    }

    // تنفيذ دالة charge للطباعة عند شحن السيارة الكهربائية
    public void charge() {
        System.out.println("Charging the Electric Car...");
    }
}

/*
4. الكلاس ElectricMotorcycle يمثل دراجة نارية كهربائية ويرث من AbstractVehicle
   - هذا الكلاس يحدد كيفية تشغيل وتوقف الدراجة النارية الكهربائية.
   - كما يتم تطبيق دالة charge() التي تطبع "Charging the Electric Motorcycle..." لأن هذه المركبة كهربائية ويمكن شحنها.
*/
class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle() {
        super("Electric Motorcycle", "Electricity", "Green");
    }

    // تنفيذ دالة start للطباعة عند بدء تشغيل الدراجة النارية الكهربائية
    public void start() {
        System.out.println("Electric Motorcycle is starting...");
    }

    // تنفيذ دالة stop للطباعة عند توقف الدراجة النارية الكهربائية
    public void stop() {
        System.out.println("Electric Motorcycle is stopping...");
    }

    // تنفيذ دالة charge للطباعة عند شحن الدراجة النارية الكهربائية
    public void charge() {
        System.out.println("Charging the Electric Motorcycle...");
    }
}

/*
5. كلاس Car للمركبة العادية (غير كهربائية) يبقى كما هو
   - هذا الكلاس يحدد كيفية تشغيل وتوقف السيارة العادية.
   - دالة charge() تطبع "No possible to charge." لأن السيارة عادية ولا يمكن شحنها.
*/
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

    // لا داعي لتنفيذ دالة charge لأن السيارة غير كهربائية
    public void charge() {
        System.out.println("No possible to charge.");
    }
}

/*
6. كلاس Motorcycle للمركبة العادية (غير كهربائية) يبقى كما هو
   - هذا الكلاس يحدد كيفية تشغيل وتوقف الدراجة النارية العادية.
   - دالة charge() تطبع "No possible to charge." لأن الدراجة النارية عادية ولا يمكن شحنها.
*/
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

    // لا داعي لتنفيذ دالة charge لأن الدراجة النارية غير كهربائية
    public void charge() {
        System.out.println("No possible to charge.");
    }
}

/*
7. الكلاس الرئيسي يحتوي على دالة main لاختبار الكود
   - في هذا الكلاس، نختبر كل المركبات (الكهربائية والعادية).
   - ننشئ كائنات من أنواع المركبات المختلفة ونختبر دوال start(), stop(), getInfo(), charge().
*/
public class BeginnerVehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        // 8. إنشاء الكائنات وتجربة تشغيل المركبات
        Vehicle electricCar = new ElectricCar();  // مركبة كهربائية
        Vehicle electricMotorcycle = new ElectricMotorcycle();  // دراجة نارية كهربائية
        Vehicle car = new Car();  // سيارة عادية
        Vehicle motorcycle = new Motorcycle();  // دراجة نارية عادية

        // تشغيل وإيقاف المركبات العادية والكهربائية
        electricCar.start();
        electricCar.stop();
        System.out.println(electricCar.getInfo());
        electricCar.charge();  // شحن المركبة الكهربائية

        electricMotorcycle.start();
        electricMotorcycle.stop();
        System.out.println(electricMotorcycle.getInfo());
        electricMotorcycle.charge();  // شحن الدراجة النارية الكهربائية

        car.start();
        car.stop();
        System.out.println(car.getInfo());
        car.charge();  // لا يمكن شحن السيارة العادية

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());
        motorcycle.charge();  // لا يمكن شحن الدراجة النارية العادية
    }
}
