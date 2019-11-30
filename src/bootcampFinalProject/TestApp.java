package bootcampFinalProject;

public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Neighbours scarlett = new Neighbours("Scarlett", 35);
		scarlett.addHealth(10);
		scarlett.changeName("Anna");
		scarlett.info();
		scarlett.bakeCake();
		scarlett.info();
	}

}
