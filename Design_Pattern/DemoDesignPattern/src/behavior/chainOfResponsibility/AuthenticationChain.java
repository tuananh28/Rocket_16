package behavior.chainOfResponsibility;

public class AuthenticationChain {

	// JWT --> Password --> Authorization
	private Handler firstHandler;

	public void initChain() {
		Handler authorization = new Authorization();
		Handler password = new Password();
		Handler jwt = new JWT();

		// set chain
		password.setNext(jwt);
		jwt.setNext(authorization);

		// start
		firstHandler = password;
	}

	public void authen(String username, String password, String role) throws Exception {
		firstHandler.handleRequest(username, password, role);
	}

}
