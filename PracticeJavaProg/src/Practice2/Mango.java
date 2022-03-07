package Practice2;

public abstract class Mango implements Fruit{
	
	String name;
	
	Mango ( String name) {
		this.name = name;
	}
	
	public void getName() {
		System.out.println("Name :" + name);
	}
	
	public void getColour() {
		System.out.println("Colour: yellow");
	}

}
