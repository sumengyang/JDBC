import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Base {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		test();
	}
	static void test() throws SQLException{
//		1.ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//			2.��������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
//			3.�������
			Statement st = conn.createStatement();
//			4.ִ�����
			ResultSet rs = st.executeQuery("select * from user");
//			5.������������ѭ����
			while(rs.next()){
				System.out.println(
						 rs.getObject(1) + "\t"
						+rs.getObject(2) + "\t"
						+rs.getObject(3)
						);
			}
			
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}

		
	}

}
