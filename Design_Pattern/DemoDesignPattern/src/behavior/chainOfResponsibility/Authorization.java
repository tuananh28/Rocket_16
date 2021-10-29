package behavior.chainOfResponsibility;

public class Authorization implements Handler {

	private Handler handler;

	@Override
	public void handleRequest(String username, String password, String role) throws Exception {
		// success
		if (role.equals("Admin")) {
			if (handler != null) {
				handler.handleRequest(username, password, role);
			}
		} else {
			throw new Exception("Not Admin!");
		}
	}

	@Override
	public void setNext(Handler handler) {
		this.handler = handler;

	}

}
