package behavior.chainOfResponsibility;

public interface Handler {

	public void handleRequest(String username, String password, String role) throws Exception;

	public void setNext(Handler handler);
}
