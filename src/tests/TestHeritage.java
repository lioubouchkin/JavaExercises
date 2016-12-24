package tests;

public class TestHeritage {
	
	static class Animal {
		public void voice() {
			System.out.println("Animal voice");
		}
	}
	
	static class Pet extends Animal {
		public void call() {
			System.out.println("Call any Pet");
		}
		@Override
		public void voice() {
			System.out.println("Pet voice");
		}
	}
	static class Cat extends Pet{
		public void call() {
			System.out.println("Call Cat");
		}
		@Override
		public void voice() {
			System.out.println("miaoo");
		}
	}
	static class Dog extends Pet{
		public void call() {
			System.out.println("Call Dag");
		}
		@Override
		public void voice() {
			System.out.println("gav");
		}
	}
	
	public static void main(String[] args) {
		Animal a = new Animal();
		Pet p = new Pet();
		Cat c = new Cat();
		Dog d = new Dog();

/*		a = new Pet();
		System.out.println(a.getClass());
		System.out.println("a instanceof Animal :" + (a instanceof Animal));
		System.out.println("a instanceof Pet :" + (a instanceof Pet));
		System.out.println("a instanceof Cat :" + (a instanceof Cat));
		a.voice();	// Pet obj
		System.out.println();
		/////////////////////////
		a = p;
		System.out.println(a.getClass());
		a.voice();	// Pet obj
		System.out.println();
		
//		p = a;			// Compile TypeMismatchError
		p = (Pet)a;		// 'Animal a' points on Pet 
		System.out.println(a.getClass());
		System.out.println("p instanceof Animal :" + (p instanceof Animal));
		System.out.println("p instanceof Pet :" + (p instanceof Pet));
		System.out.println("p instanceof Cat :" + (p instanceof Cat));
		p.call();	// Pet obj
		p.voice();	// ClassCastException 
		System.out.println();
		
		a = new Animal();
		p = new Pet();
		System.out.println("a instanceof Animal :" + (a instanceof Animal));	// true
		System.out.println("a instanceof Pet :" + (a instanceof Pet));			// false
		System.out.println("a instanceof Cat :" + (a instanceof Cat));			// false
		a = new Cat();
		System.out.println("a = new Cat()");
		System.out.println("a instanceof Animal :" + (a instanceof Animal));	// true
		System.out.println("a instanceof Pet :" + (a instanceof Pet));			// false
		System.out.println("a instanceof Cat :" + (a instanceof Cat));			// false
		a.voice();	// Cat obj
//		p = (Pet)a;		// ClassCastException
*/		
	}
}
