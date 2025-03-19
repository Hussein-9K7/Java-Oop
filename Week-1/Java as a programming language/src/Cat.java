public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create instances of the Cat class with names
        Cat cat1 = new Cat("Whiskers");
        Cat cat2 = new Cat("Rex");

        // Call the meow method on the cat instances
        cat1.meow();
        cat1.meow();
        cat2.meow();
        cat1.meow();
    }
}
