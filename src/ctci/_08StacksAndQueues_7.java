package ctci;

import java.util.LinkedList;

/*Implementation of CTCI 3.7*/
public class _08StacksAndQueues_7{

	public static void main(String[] args) {
		Shelter shelter=new Shelter();
		shelter.enQueue("Dog");
		shelter.enQueue("Dog");
		shelter.enQueue("Cat");
		shelter.enQueue("Dog");
		shelter.enQueue("Cat");
		shelter.enQueue("Dog");
		shelter.enQueue("Cat");
		System.out.println(shelter.deQueueDog());
		System.out.println(shelter.deQueueDog());
		System.out.println(shelter.deQueueAny());
		System.out.println(shelter.deQueueDog());
		System.out.println(shelter.deQueueCat());
	}
}
class Shelter{
	LinkedList<Animal> dogList=new LinkedList<Animal>();
	LinkedList<Animal> catList=new LinkedList<Animal>();
	private static int animalAge=0;
	public Shelter() {
		dogList=new LinkedList<Animal>();
		catList=new LinkedList<Animal>();
	}
	public void enQueue(String type){
		if(type.toLowerCase().contentEquals("dog")){
			dogList.add(new Animal("Dog",animalAge));
		}
		else{
			catList.add(new Animal("Cat",animalAge));
		}
		animalAge++;
	}
	public String deQueueAny(){
		int value=0;
		if(catList.get(0).age<dogList.get(0).age)
		{
			value=catList.get(0).age;
			catList.removeFirst();
			return "Cat : "+value;
		}
		else{
			value=dogList.get(0).age;
			dogList.removeFirst();
			return "Dog : "+value;
		}
		

	}
	public String deQueueDog(){
		int value=dogList.get(0).age;
		dogList.removeFirst();
		return "Dog : "+value;
	}
	public String deQueueCat(){
		int value=catList.get(0).age;
		catList.removeFirst();
		return "Cat : "+value;
	}
}
class Animal{
	String type;
	int age;
	public Animal(String type,int age) {
		this.type=type;
		this.age=age;
	}

}
