/*
    فئة CoffeeMaker تمثل ماكينة القهوة، تحتوي على:
    - زر تشغيل/إيقاف (powerSwitch)
    - إمكانية تحديد نوع القهوة (setCoffeeType)
    - إمكانية تحديد كمية القهوة (setCoffeeAmount)
    - عرض إعدادات القهوة (displaySettings)

    فئة CoffeeMakerDriver تستخدم لاختبار عمل ماكينة القهوة، حيث تقوم بـ:
    - تشغيل الماكينة
    - ضبط نوع القهوة وكمية القهوة
    - عرض الإعدادات الحالية
    - إيقاف الماكينة
*/

class CoffeeMaker {
    private boolean isOn = false;
    private String coffeeType = "normal";
    private int coffeeAmount = 10;

    public void powerSwitch() {
        isOn = !isOn;
        System.out.println("Coffee maker is " + (isOn ? "on" : "off"));
    }

    public void setCoffeeType(String type) {
        if (isOn) {
            coffeeType = type;
        }
    }

    public void setCoffeeAmount(int amount) {
        if (isOn && amount >= 10 && amount <= 80) {
            coffeeAmount = amount;
        }
    }

    public void displaySettings() {
        if (isOn) {
            System.out.println("Coffee type is " + coffeeType);
            System.out.println("Coffee amount is " + coffeeAmount + " ml");
        }
    }
}

public class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker myCoffeeMaker = new CoffeeMaker();

        myCoffeeMaker.powerSwitch();
        myCoffeeMaker.setCoffeeType("espresso");
        myCoffeeMaker.setCoffeeAmount(50);
        myCoffeeMaker.displaySettings();
        myCoffeeMaker.powerSwitch();
    }
}
