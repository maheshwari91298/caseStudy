package trainTicket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TrainDAO {

	public Train findTrain(int trainNo) throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");
		Statement statement = connection.createStatement();
		
		String query = "SELECT * FROM TRAINS WHERE TRAIN_NO = " + trainNo;
		ResultSet trainSet = statement.executeQuery(query);
		boolean flag = trainSet.next();
		try {
			if(!flag) {
				throw new TrainNotFoundException();
			}
		}catch(TrainNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		if(flag) {
			String trainName = trainSet.getString(2);
			String source = trainSet.getString(3);
			String destination = trainSet.getString(4);
			double ticketPrice = trainSet.getDouble(5);
			return new Train(trainNo, trainName, source, destination, ticketPrice);
		}
		connection.close();
		return null;
		

	}
}
