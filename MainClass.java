
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SecretAgent agent = new SecretAgent();
		System.out.println("Enter a message:");
		String inputMessage = System.console().readLine();
		String decodedMessage = agent.decode(inputMessage);
		System.out.println(decodedMessage);

	}

}
