package bootcampFinalProject;

public class Neighbours {

	private String name;
	private int age;
	private int health = 100;
	private int happiness = 100;
	private int hunger = 0;
	private int cakeAmount = 0;
	private static int cakeValue = 100;

	public Neighbours(String name, int age, int health, int happiness,
			int hunger) {
		this.name = name;
		this.age = age;
		this.health = health;
		this.happiness = happiness;
		this.hunger = hunger;
	}

	public Neighbours(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getHealth() {
		return health;
	}

	public int getHappiness() {
		return happiness;
	}

	public int getHunger() {
		return hunger;
	}

	public int getCakeAmount() {
		return cakeAmount;
	}

	private boolean isAlive() {
		return health>0;
	}

	public void addHealth(int amount) {
		if (amount > 0) {
			if (isAlive()) {
				if (this.health+amount <= 100) {
					this.health = this.health+amount;
					System.out.println("Neighbour's health increased by " + amount + " , total health is " + this.health);
				} else {
					this.health = 100;
					System.out.println("Neighbour's health increased by " + amount + " , total health is " + this.health);
				}
			} else {
				System.out.println("Neighbour is dead");
			}
		}else{
			System.out.println("Health amount to add must be positive");
		}
	}
	
	public void changeName(String name){
		System.out.println("Neighbour's " + this.name + " name has been changed to " + name);
		this.name=name;
	}
	
	public void bakeCake(){
		this.cakeAmount++;
		this.health=this.health -10;
		this.happiness =this.happiness+20;
		System.out.println("Neighbour " + this.name + " has baked a cake. Happiness= " + this.happiness + ", health= "+ this.health);
	}
	
	
	public void info(){
		System.out.println("Neighbours [name=" + name + ", age=" + age + ", health="
				+ health + ", happiness=" + happiness + ", hunger=" + hunger
				+ ", cakeAmount=" + cakeAmount + "]");
	
	}
}
