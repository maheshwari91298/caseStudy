package trainTicket;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ticket {

	public static int counter=100;
	private String pnr;
	private LocalDate travelDate;
	private Train train;
	private TreeMap<Passanger,Integer> passangerMap= new TreeMap<>();
	//LocalDate travel_date1 = LocalDate.now();
	
	//Train train =new Train();
	
	public Ticket(LocalDate travelDate,Train train) {
		
		LocalDate today=LocalDate.now();
		boolean flag1=today.isBefore(travelDate);
		try {
			if(!flag1) {
				throw new dateCanNotBe();
			}
		}catch(dateCanNotBe e) {
			System.out.println(e.getMessage());
			
			System.exit(0);
		}
		this.travelDate=travelDate;
		this.train=train;
	}
	public Ticket() {
		travelDate=null;
		train=null;
	}
	public String generatePNR() throws IOException {
		StringBuilder sb=new StringBuilder("");
		
		//counter = Integer.parseInt(sb.toString());
		
		
		
		this.pnr = String.valueOf(this.getTrain().getSource().charAt(0)) + String.valueOf(this.getTrain().getDestination().charAt(0)) + "_" + this.travelDate.getYear() + String.format("%02d",this.travelDate.getMonthValue()) + String.format("%02d",this.travelDate.getDayOfMonth()) + "_" + counter;
		counter++;
		
		
		
		String str = String.valueOf(counter);
		//String fileName = "counter.txt";
		//FileOutputStream fos = new FileOutputStream(fileName);
		//PrintWriter pr = new PrintWriter(fos);
		//pr.write(str);
		//pr.close();
		System.out.println(counter+" "+str); 

		return this.pnr;
		
		
	}
	
	public double calculatePassangerFare(Passanger passanger) {
		double fare=this.getTrain().getTicketPrice();
		if(passanger.getAge()<=12)
			fare=fare/2;
		else if(passanger.getAge()>=60)
			fare=fare*(3/5);
		else {
			if(passanger.getGender()=='F')
				fare=fare*(3/4);
		}
		return fare;
		}
	
	public void addPassanger(String name, int age, char gender) {
		Passanger passanger = new Passanger(name,age,gender);
		double fare=calculatePassangerFare(passanger);
		this.passangerMap.put(passanger, (int)fare);
	}
	
	public  double calculateTotalTicketPrice() {
		int sum=0;
		for(Passanger passanger:this.passangerMap.keySet()) 
			{
				sum=sum+this.passangerMap.get(passanger);
			}
			
		return sum;
		}
	
	
	public StringBuilder newgenerateTicket() throws IOException {
		StringBuilder sb= new StringBuilder("");
		sb.append("PNR :"+ this.generatePNR()+"\n");
		sb.append("Train No: " + this.train.getTrainNo() + "\n");
		sb.append("Train Name: " + this.train.getTrainName() + "\n");
		sb.append("From:" + this.train.getSource() + "\n");
		sb.append("To: " + this.train.getDestination() + "\n");
		sb.append("Travel Date: " + this.travelDate.getDayOfMonth() + "/" + this.travelDate.getMonthValue() + "/" + this.travelDate.getYear() + "\n\n");
		sb.append("Passengers" + "\n");
		sb.append("Name\tAge\tGender\tFare\n");
		for(Passanger passenger : this.passangerMap.keySet()) {
			sb.append("\t"+passenger.getName() + "\t" + passenger.getAge() + "\t" + passenger.getGender() + "\t" +calculatePassangerFare(passenger)+ "\n");
		}
		sb.append("Total Price: " + this.calculateTotalTicketPrice()); 
		return sb;
	}
	
	public void writeTicket() throws IOException  {
		 
		String str = this.newgenerateTicket().toString();
		String fileName =this.pnr+".txt";
		FileOutputStream fos= new FileOutputStream(fileName);
		PrintWriter pr=new PrintWriter(fos);
		pr.write(str);
		pr.close();
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public LocalDate getTravel_date1() {
		return travelDate;
	}

	public void setTravel_date1(LocalDate travel_date1) {
		this.travelDate = travel_date1;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Map<Passanger, Integer> getPassangerMap() {
		return passangerMap;
	}

	public void setPassangerMap(TreeMap<Passanger, Integer> passangerMap) {
		this.passangerMap = passangerMap;
	}
	
	
}
