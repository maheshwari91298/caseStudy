package trainTicket;

public class Passanger implements Comparable<Passanger>{
	private String name;
	private int age;
	private char gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Passanger(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Passanger()
	{
		name="AAA";
		age=100;
		gender='f';
	}
	@Override
	public int compareTo(Passanger passanger) {
		// TODO Auto-generated method stub
		
		return this.getAge()-passanger.getAge();
	}
}
