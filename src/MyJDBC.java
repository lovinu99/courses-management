import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
	public static void main(String args[]) {
		try {
	
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsv?useSSL=false", "root",
					"root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			con.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
}