package bootcampFinalProject;

public class Neighbours {

	private String name;
	private int age;
	private int health;
	private int happiness;
	private int hunger;
	private int cakeAmount;
	private static final int MIN_VALUE_AGE = 0;
	private static final int CAKE_VALUE = 100;
	private static final int MAX_VALUE_HEALTH = 100;
	private static final int MIN_VALUE_HEALTH = 0;
	private static final int MAX_VALUE_HAPPINESS = 100;
	private static final int MIN_VALUE_HAPPINESS = 0;
	private static final int MAX_VALUE_HUNGER = 100;
	private static final int MIN_VALUE_HUNGER = 0;
	private static final int DEFAULT_CAKE_AMOUNT = 0;

	public Neighbours(String name, int age, int health, int happiness,
			int hunger, int cakeAmount) {
		this.name = name;
		if (age >= MIN_VALUE_AGE) {
			this.age = age;
		} else {
			this.age = MIN_VALUE_AGE;
			System.out.println("Age is set to 0");
		}
		this.health = health;
		this.happiness = happiness;
		this.hunger = hunger;
		this.cakeAmount = cakeAmount;
	}

	public Neighbours(String name, int age) {
		this(name, age, MAX_VALUE_HEALTH, MAX_VALUE_HAPPINESS,
				MIN_VALUE_HUNGER, DEFAULT_CAKE_AMOUNT);
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
					/*
					 * System.out.println("Neighbour's health increased by " +
					 * amount + " , total health is " + this.health);
					 */
				} else {
					this.health = MAX_VALUE_HEALTH;
					/*
					 * System.out.println("Neighbour's health increased by " +
					 * amount + " , total health is " + this.health);
					 */
				}
			} else {
				System.out.println(this.name + " is dead");
				isAlive();
			}
		} else {
			System.out.println("Health amount to add must be positive");
		}
	}

	public void removeHealth(int amount) {
		if (amount > 0) {
			if (isAlive()) {
				if (this.health - amount > MIN_VALUE_HEALTH) {
					this.health = this.health - amount;
					/*
					 * System.out.println("Neighbour's health decreased by " +
					 * amount + " , total health is " + this.health);
					 */
				} else {
					System.out.println(this.name + " is dead");
					this.health = MIN_VALUE_HEALTH;
				}
			} else {
				System.out.println(this.name + " is dead");
				this.health = MIN_VALUE_HEALTH;
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
					/*
					 * System.out.println("Neighbour's happiness increased by "
					 * + amount + " , total happiness is " + this.happiness);
					 */
				} else {
					this.happiness = MAX_VALUE_HAPPINESS;
					/*
					 * System.out .println(
					 * "Neighbour is super duper happy!!=) Total happiness is "
					 * + this.happiness);
					 */
				}
			} else {
				System.out.println(this.name + " is dead");
			}
		} else {
			System.out.println("Happiness amount to add must be positive");
		}
	}

	public void removeHappiness(int amount) {
		if (amount > 0) {
			if (isAlive()) {
				if (this.happiness - amount > MIN_VALUE_HAPPINESS) {
					this.happiness = this.happiness - amount;
					/*
					 * System.out.println("Neighbour's happiness decreased by "
					 * + amount + " , total happiness is " + this.happiness);
					 */
				} else {
					// System.out.println("Neighbour is depressed");
					this.happiness = MIN_VALUE_HAPPINESS;
				}
			} else {
				System.out.println(this.name + " is dead");
				this.health = MIN_VALUE_HEALTH;
			}
		} else {
			System.out.println("Happiness amount to add must be positive");
		}
	}

	public void addHunger(int amount) {
		if (amount > 0) {
			if (isAlive()) {
				if (this.hunger + amount <= MAX_VALUE_HUNGER) {
					this.hunger = this.hunger + amount;
					/*
					 * System.out.println("Neighbour's hunger increased by " +
					 * amount + " , total hunger is " + this.hunger);
					 */
				} else {
					this.hunger = MAX_VALUE_HUNGER;
					/*
					 * System.out
					 * .println("Neighbour is super duper hangry. Total hunger is "
					 * + this.hunger);
					 */
				}
			} else {
				System.out.println(this.name + " is dead");
				this.health = MIN_VALUE_HEALTH;
			}
		} else {
			System.out.println("Hunger amount to add must be positive");
		}
	}

	public void removeHunger(int amount) {
		if (amount > 0) {
			if (isAlive()) {
				if (this.hunger - amount > MIN_VALUE_HUNGER) {
					this.hunger = this.hunger - amount;
					/*
					 * System.out.println("Neighbour's hunger decreased by " +
					 * amount + " , total hunger is " + this.hunger);
					 */
				} else {
					// System.out.println("Neighbour is super happy and well fed");
					this.hunger = MIN_VALUE_HUNGER;
				}
			} else {
				System.out.println(this.name + " is dead");
				this.health = MIN_VALUE_HEALTH;
			}
		} else {
			System.out.println("Hunger amount to add must be positive");
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

	public void addAge() {
		if (isAlive()) {
			this.age++;
			/*
			 * System.out.println("Neighbour " + this.name +
			 * " has aged for one year. Current age is: " + this.age);
			 */
		} else {
			System.out.println("Neighbour is dead");
			this.health = MIN_VALUE_HEALTH;
		}
	}

	public void bakeCake() {
		if (isAlive()) {
			this.cakeAmount++;
			this.health = this.health - 10;
			this.addHappiness(20);
			System.out.println("Neighbour " + this.name
					+ " has baked a cake. Happiness= " + this.happiness
					+ ", health= " + this.health);
		} else {
			System.out.println("Neighbour is dead");
			this.health = MIN_VALUE_HEALTH;
		}
	}

	public void watchTVshow(int minutes) {
		if (minutes > 0) {
			addHappiness(minutes);
			removeHunger(minutes);
			System.out.println("Neigbour " + this.name + " has watched TV for "
					+ minutes + " minutes.\nCurrent happiness: "
					+ this.happiness + " , current hunger: " + this.hunger);
		} else {
			System.out.println("Minutes must be positive");
		}
	}

	public void eatDinner(int mealSize) {
		if (mealSize > 0) {
			removeHunger(mealSize);
			System.out.println("Neighbour " + this.name
					+ " has eaten dinner. Current hunger: " + this.hunger);
		} else {
			System.out.println("Meal size must be positive");
		}
	}

	public void fight(Neighbours other, int minutes) {
		if (this.isAlive() && other.isAlive()) {
			System.out.println(this.name + " had a fight with " + other.name + " for " + minutes + " minutes.");
			this.addHunger(minutes);
			this.removeHappiness(minutes);
			this.removeHealth(minutes);
			other.addHunger(minutes);
			other.removeHappiness(minutes);
			other.removeHealth(minutes);
			this.info();
			other.info();
		} else {
			System.out.println(name + " is already dead");
		}
	}
	
	public void giveCakeToNeighbour(Neighbours other){
		if (this.isAlive() && other.isAlive()) {
			if (this.cakeAmount>0){
			this.cakeAmount--;
			other.removeHunger(CAKE_VALUE);
			System.out.println(this.name + " has given cake to " + other.name);
			other.info();
			}else{
				System.out.println(this.name + " has no cake");
			}
			
		}else {
			System.out.println(name + " is already dead");
		}
	}
	
	public void dinnerWithNeighbour(Neighbours other, int mealSize){
		if (this.isAlive() && other.isAlive()) {
			if (mealSize > 0) {
				this.removeHunger(mealSize);
				other.removeHunger(mealSize);
				System.out.println("Neighbours " + this.name + " and " + other.name+
						 " have eaten dinner.\n Current hunger for " +this.name +" is "+ this.hunger + ". Current hunger for " +other.name +" is "+ other.hunger);
			} else {
				System.out.println("Meal size must be positive");
			}
		}else {
			System.out.println(name + " is already dead");
		}
	}

	public void info() {
		System.out.println("Neighbours [name=" + name + ", age=" + age
				+ ", health=" + health + ", happiness=" + happiness
				+ ", hunger=" + hunger + ", cakeAmount=" + cakeAmount + "]");

	}
	
	public static Neighbours getNeighbour(String name, int age) {
		return new Neighbours(name, age);
	}
}
