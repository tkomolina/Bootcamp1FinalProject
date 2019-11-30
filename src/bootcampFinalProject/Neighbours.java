package bootcampFinalProject;

public class Neighbours {

	private String name;
	private int age;
	private int health;
	private int happiness;
	private int hunger;
	private int cakeAmount;
	private static final int CAKE_VALUE = 100;
	private static final int MAX_VALUE_HEALTH = 100;
	private static final int MIN_VALUE_HEALTH = 0;
	private static final int MAX_VALUE_HAPPINESS=100;
	private static final int MIN_VALUE_HAPPINESS=0;
	private static final int MAX_VALUE_HUNGER=100;
	private static final int MIN_VALUE_HUNGER=0;
	private static final int DEFAULT_CAKE_AMOUNT=0;

	public Neighbours(String name, int age, int health, int happiness,
			int hunger, int cakeAmount) {
		this.name = name;
		this.age = age;
		this.health = health;
		this.happiness = happiness;
		this.hunger = hunger;
		this.cakeAmount = cakeAmount;
	}

	public Neighbours(String name, int age) {
		this(name, age, MAX_VALUE_HEALTH, MAX_VALUE_HAPPINESS, MIN_VALUE_HUNGER, DEFAULT_CAKE_AMOUNT);
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
		return health > 0;
	}

	public void addHealth(int amount) {
		if (amount > 0) {
			if (isAlive()) {
				if (this.health + amount <= MAX_VALUE_HEALTH) {
					this.health = this.health + amount;
					System.out.println("Neighbour's health increased by "
							+ amount + " , total health is " + this.health);
				} else {
					this.health = MAX_VALUE_HEALTH;
					System.out.println("Neighbour's health increased by "
							+ amount + " , total health is " + this.health);
				}
			} else {
				System.out.println("Neighbour is dead");
			}
		} else {
			System.out.println("Health amount to add must be positive");
		}
	}

	public void addHappiness(int amount) {
		if (amount > 0) {
			if (isAlive()) {
				if (this.happiness + amount <= MAX_VALUE_HAPPINESS) {
					this.happiness = this.happiness + amount;
					System.out.println("Neighbour's happiness increased by "
							+ amount + " , total happiness is " + this.happiness);
				} else {
					this.happiness = MAX_VALUE_HAPPINESS;
					System.out.println("Neighbour's happiness increased by "
							+ amount + " , total happiness is " + this.happiness);
				}
			} else {
				System.out.println("Neighbour is dead");
			}
		} else {
			System.out.println("Happiness amount to add must be positive");
		}
	}

	public void changeName(String name) {
		if (this.age >= 15) {
			System.out.println("Neighbour's " + this.name
					+ " name has been changed to " + name);
			this.name = name;
		} else {
			System.out
					.println("It is not possible to change name because age is less than 15");
		}
	}

	public void bakeCake() {
		this.cakeAmount++;
		this.health = this.health - 10;
		this.addHappiness(20);
		System.out.println("Neighbour " + this.name
				+ " has baked a cake. Happiness= " + this.happiness
				+ ", health= " + this.health);
	}

	public void info() {
		System.out.println("Neighbours [name=" + name + ", age=" + age
				+ ", health=" + health + ", happiness=" + happiness
				+ ", hunger=" + hunger + ", cakeAmount=" + cakeAmount + "]");

	}
}
