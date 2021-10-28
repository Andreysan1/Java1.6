/**
 * Java 1. Homework 6
 *
 * @author Andrey Usmanov
 * @version 27.10.2021
 */
class Lesson6 {
    public static void main(String[] args) {
        Cat cat = new Cat(200, -1);
        Dog dog = new Dog(500, 10);
        
        IAnimal[] animals = {cat, dog};
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.run(100));
            System.out.println(animal.run(350));
            System.out.println(animal.run(600));
            System.out.println(animal.swim(10));
            System.out.println(animal.swim(20));
        }
        System.out.println("Animals were created: " + Animal.getCountOfAnimals());
    }
}

class Cat extends Animal {
    Cat(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
    @Override
    public String swim(int distance) {
        return getClassName() + " can't swim";
    }
}

class Dog extends Animal {
    Dog(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
}

abstract class Animal implements IAnimal {
    private int runLimit;
    private int swimLimit;
    private String className;
    private static int countOfAnimals = 0;

    Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();
        countOfAnimals++;
    }
    
    public String getClassName() {
        return className;
    }

    public static int getCountOfAnimals() {
        return countOfAnimals;
    }

    @Override
    public String run(int distance) {
        if (distance > runLimit) {
            return className + " couldn't run " + distance;
        } else {
            return className + " successfully run " + distance;
        }
    }

    @Override
    public String swim(int distance) {
        if (distance > swimLimit) {
            return className + " couldn't swim " + distance;
        } else {
            return className + " successfully swim " + distance;
        }
    }
    
    @Override
    public String toString() {
        return className + ". runLimit: " + runLimit + ". swimLimit: " + swimLimit;
    }
}

interface IAnimal {
    String run(int distance);
    String swim(int distance);
}