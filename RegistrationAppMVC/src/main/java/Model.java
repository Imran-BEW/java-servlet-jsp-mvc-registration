//1.import statement.
import java.sql.*;
public class Model {
	//2. attributes.
	int rows;
	String uname;
	String uemail;
	String upassword;
	String ucity;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	//3.get and set the parameters.
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	public int registerInfo() {
		try {
		//4.create connection.
		conn = Utility.getconnect();
		
		//5.create a statement.
		String sql = "INSERT INTO userinfo (uname, email, upassword, ucity) VALUES(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		
		//6.set the parameters for PrepareStatements.
		pstmt.setString(1, uname);
		pstmt.setString(2, uemail);
		pstmt.setString(3, upassword);
		pstmt.setString(4, ucity);
		
		//7.process the query
		rows = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Utility.closeConnection(pstmt, conn);
			} catch(SQLException e) {
				e.printStackTrace();;
			}
		}
		return rows;
	}
}
