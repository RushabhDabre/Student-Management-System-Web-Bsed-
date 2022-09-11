

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    PreparedStatement pst; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RUSHABH","Wadsa@123");  //for oracle,....
 			pst = con.prepareStatement("update Student set name=?, address=? where roll = ?");
 			System.out.println("database connected");
 			int roll = Integer.parseInt(request.getParameter("roll"));
 			String name=request.getParameter("name");
 			String address=request.getParameter("address");

 			pst.setString(1, name);
 			pst.setString(2, address);
 			pst.setInt(3,roll);

 			int res=pst.executeUpdate();
 			if(res >= 1) {
 				out.println(res+"  record is updated successfully");
 	 			out.println("<a href='http://localhost:8888/MyWebProject/Search.html'>search more?</a>");
 	 			out.println("<a href='http://localhost:8888/MyWebProject/Home.html'>Home Page</a>");
 			}
 		
 		}catch(Exception ae) {
 			System.out.println("Error in database Connection!!");
 			out.println("error in Insert Page!!");
 			ae.printStackTrace();
 		}

	}

}
