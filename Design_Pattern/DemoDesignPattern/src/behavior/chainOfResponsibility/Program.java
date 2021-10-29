package behavior.chainOfResponsibility;

public class Program {
	public static void main(String[] args) throws Exception {
		// call request
		AuthenticationChain chain = new AuthenticationChain();
		chain.initChain();
		chain.authen("duynn03JWT", "123456JWT", "Admin");
		System.out.println("Authen Success!");
	}
}
