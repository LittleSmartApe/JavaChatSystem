package test;

import java.util.*;
public class extend {
	public static void main(String args[]) throws PeeException {
		Student xm = new Student();
		xm.id = 888;
		System.out.println(String.format("%.0f", xm.id));
		xm.Fuck();
		try {
			xm.Fuck();
		}catch(Exception e){
			System.out.println("There is nothing to fuck!");
		}finally {
			System.out.println("Go fuck your self!");
		}
		try {
			xm.Pee(0);
		}catch(PeeException e){
			System.out.println(e.getMessage());
		}
		xm.Pee(1);
		xm.Pee(0);
		
	}
}
abstract class People{
	protected float id;
	protected float highth;
	
}


interface Do{
	void Fuck();
	void Drink();
	void Pee(int a) throws PeeException;
}

class Student extends People implements Do{
	float getPeopleId(){
		return super.id;
	}

	@Override
	public void Fuck() {
		System.out.println("You have fucked a People and her got pregnanted ");
	}

	@Override
	public void Drink() {
		
	}
	@Override
	public void Pee(int a) throws PeeException {
		if (a == 1) System.out.println("You pee!");
		else throw new PeeException("You can't Pee!");	
		
	}

}
class PeeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeeException(String a) {
		super(a);
	}
}
class Man extends People{
	
}