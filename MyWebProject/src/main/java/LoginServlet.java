

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
import javax.swing.JOptionPane;
import java.sql.*;
/**
 * Servlet implementation
 *  class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
 	PreparedStatement pst;
 	ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 3* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
//		doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RUSHABH","Wadsa@123");  //for oracle,....
 			pst = con.prepareStatement("select * from userdetails where username = ? and password = ?");
 			System.out.println("database connected");
 			String uname=request.getParameter("username");
 			String password=request.getParameter("password");
 			pst.setString(1, uname);
 			pst.setString(2, password);
 			rs=pst.executeQuery();
 			if(rs.next()) {
 				response.sendRedirect("http://localhost:8888/MyWebProject/Home.html");
 			}
 			else {
 				response.sendRedirect("http://localhost:8888/MyWebProject/loginError.html");
 			}

 		}catch(Exception ae) {
 			System.out.println("Error in Connection!!");
 			out.println("error in database connection");
 			ae.printStackTrace();
 		}
	}

}
