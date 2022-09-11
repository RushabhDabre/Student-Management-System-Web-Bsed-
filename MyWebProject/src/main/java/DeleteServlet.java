

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
 	PreparedStatement pst;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
 			out.println("Server is Connected");
 			pst = con.prepareStatement("Delete from student where roll=?");
 			int roll = Integer.parseInt(request.getParameter("roll"));
 			
 			out.println("database connected");
 			pst.setInt(1,roll);
 			int res=pst.executeUpdate();
 			if(res >= 1) {
 				out.println(res+" record is deleted successfully");
 				out.println("<a href= 'http://localhost:8888/MyWebProject/Delete.html'>Delete more?</a>");
 				out.println("<a href= 'http://localhost:8888/MyWebProject/Home.html'>Home</a>");
 			}
 			
 		}catch(Exception ae) {
 			System.out.println("Error in database Connection!!");	
 			out.println("error in Delete Page!!");
 			ae.printStackTrace();
 		}
	}
}
