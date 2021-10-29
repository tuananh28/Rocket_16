package behavior.chainOfResponsibility;

public class JWT implements Handler {

	private Handler handler;

	@Override
	public void handleRequest(String username, String password, String role) throws Exception {
		// success
		if (username.endsWith("JWT")) {
			if (handler != null) {
				handler.handleRequest(username, password, role);
			}
		} else {
			throw new Exception("Cannot Parse JWT!");
		}

	}

	@Override
	public void setNext(Handler handler) {
		this.handler = handler;
	}

}
