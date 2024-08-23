package Wise;

class Parent {
	public void walk() {
		System.out.println("Parent Walk");
	}

	public void run() {
		System.out.println("Parent run");
	}
}

class Child extends Parent {
	public void walk() {
		System.out.println("Child Walk");
	}

	public void run() {
		System.out.println("Child run");
		super.run();
	}
}

public class Demo {
	public static void main(String[] args) {
		Parent p = new Child();

		p.run();
	}

}
