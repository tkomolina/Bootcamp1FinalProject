package bootcampFinalProject;

public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Neighbours scarlett = new Neighbours("Scarlett", 20);
		Neighbours gabriela = new Neighbours("Gabriela", 30);
		scarlett.addHunger(100);
		scarlett.info();
		gabriela.info();
		gabriela.bakeCake();
		gabriela.giveCakeToNeighbour(scarlett);
		scarlett.addHunger(50);
		gabriela.addHunger(50);
		gabriela.dinnerWithNeighbour(scarlett, 20);
	//	scarlett.fight(gabriela, 10);
	//	scarlett.fight(gabriela, 95);
		
		
		
	}

}
