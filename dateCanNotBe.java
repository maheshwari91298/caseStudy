package trainTicket;

public class dateCanNotBe extends Exception {
	@Override
	public String getMessage() {
		return "Date invalid";
	}
}
