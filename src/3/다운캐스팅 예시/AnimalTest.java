package chapter8;

import java.util.ArrayList;

class Animal {
    public void move() {
        System.out.println("동물이 걷습니다.");
    }
}

class Human extends Animal{
    public void move() {
        System.out.println("사람이 두발로 걷습니다.");
    }
    public void readBook() {
        System.out.println("사람이 책을 읽습니다.");
    }
}

class Tiger extends Animal{
    public void move() {
        System.out.println("호랑이가 네발로 걷습니다.");
    }
    public void hunting() {
        System.out.println("호랑이가 사냥을 합니다.");
    }
}

class Eagle extends Animal{
    public void move() {
        System.out.println("독수리가 날아갑니다.");
    }
    public void flying() {
        System.out.println("독수리가 비행합니다.");
    }
}

public class AnimalTest {
    static public void main(String[] args) {
        ArrayList<Animal> AnimalList = new ArrayList<>();
        AnimalTest t = new AnimalTest();
        t.moveAnimal(new Human());
        t.moveAnimal(new Tiger());
        t.moveAnimal(new Eagle());
    }

    public void moveAnimal(Animal animal) {
        animal.move();
        if(animal instanceof Human) {
            Human human = (Human) animal;
            human.readBook();
        } else if(animal instanceof Tiger) {
            Tiger tiger = (Tiger) animal;
            tiger.hunting();
        } else if(animal instanceof Eagle) {
            Eagle eagle = (Eagle) animal;
            eagle.flying();
        }

    }
}
