package creational.singleton;

public class JDBC {

	private static JDBC instance;

	private JDBC() {
	}

	public static JDBC getInstance() {
		if (instance == null) {
			instance = new JDBC();
		}

		return instance;
	}

}
