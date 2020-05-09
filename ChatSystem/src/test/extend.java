package test;
import java.util.*;
public class extend {
	public static void main(String args[]) {
		Student xm = new Student();
		xm.id = 888;
		System.out.println(String.format("%.0f", xm.id));
		xm.Fuck();
	}
}
abstract class People{
	protected float id;
	protected float highth;
	
}


interface Do{
	void Fuck();
	void Drink();
	void Pee();
}

class Student extends People implements Do{
	float getPeopleId(){
		return super.id;
	}

	@Override
	public void Fuck() {
		System.out.println("You have fucked a Person fafadadadad");
	}

	@Override
	public void Drink() {
		
	}

	@Override
	public void Pee() {
		
	}
}

class Man extends People{
	
}