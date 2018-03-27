package collection;

public class PersonThread extends Thread {

	private Person person;

	public PersonThread(Person person) {
		super();
		this.person = person;
	}

	@Override
	public void run() {
		person.print();
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PersonThread[] threads = { new PersonThread(new Person("John", 11011999, 70)), 
								   new PersonThread(new Person("Jack", 12011998, 80)), 
								   new PersonThread(new Person("Jason", 10011995, 90))};

		for (PersonThread thread : threads) {
			thread.start();
		}
	}
}

