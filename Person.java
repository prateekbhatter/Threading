package collection;

public class Person {
	private String name;
	private long birthdate;
	private float weight;

	public Person() {
		name = "noname";
		birthdate = 0;
		weight = 0;
	}

	public Person(String name, long birthdate, float weight) {
		this.name = name;
		this.birthdate = birthdate;
		this.weight = weight;
	}

	public String title() {
		return "Person:";
	}

	public void printData() // no linefeed
	{
		System.out.printf("name: %s, birthdate: %d, weight:%6.1f", name, birthdate, weight);
	}

	public void print() {
		System.out.printf("%s\n", title());
		printData();
		System.out.printf("\n");
	}
}

