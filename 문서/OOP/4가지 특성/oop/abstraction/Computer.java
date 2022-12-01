package oop.abstraction;

public abstract class Computer {
	public void turnOn() {
		System.out.println("전원 켜기");
	}
	public void turnOff() {
		System.out.println("전원 끄기");
	}
	
	public abstract void runOs();
}
