package trainTicket;

public class TrainNotFoundException extends Exception {
@Override
public String getMessage() {
	return "Train not found";
}
}
