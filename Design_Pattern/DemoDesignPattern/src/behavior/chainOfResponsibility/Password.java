package behavior.chainOfResponsibility;

public class Password implements Handler {

	private Handler handler;

	@Override
	public void handleRequest(String username, String password, String role) throws Exception {
		// success
		if (username.equals("duynn03JWT") && password.endsWith("123456JWT")) {
			if (handler != null) {
				handler.handleRequest(username, password, role);
			}
		} else {
			throw new Exception("Password Or User is invalid!");
		}
	}

	@Override
	public void setNext(Handler handler) {
		this.handler = handler;
	}

}
