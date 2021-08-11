package trainTicket;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class TicketApplication {

	public static void  main(String[] args) {
		
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter the train number:");
	int trainNo=sc.nextInt();
	
	TrainDAO  trainDAO=new TrainDAO();
	Train train = null;
	try {
		train = trainDAO.findTrain(trainNo);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	sc.nextLine();
	System.out.println("Enter the travel Date ");
	String[] arr =sc.nextLine().split("/");
	//date.getYear();
	LocalDate travelDate= LocalDate.of(Integer.parseInt(arr[2]),Integer.parseInt(arr[1]),Integer.parseInt(arr[0]));
	LocalDate Today=LocalDate.now();
	
	
	
		
		
	Ticket ticket =new Ticket(travelDate, train);
	
	System.out.println("Enter the number of passangers");
	int no_of_passangers=sc.nextInt();
	
	
	
	for(int i=0;i<no_of_passangers;i++) {
		//passanger.add(sc.nextLine)
		System.out.println("Enter the name of passanger"+ (i+1));
		
		String name=sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter the age of passanger "+(i+1));
		
		int age= sc.nextInt();
		System.out.println("Enter the gender of passanger");
		char G=sc.next().charAt(0);
		
		ticket.addPassanger(name, age, G);
		
	}
	try {
		ticket.writeTicket();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	System.out.println(ticket.getPnr());
	
	
	}
}
