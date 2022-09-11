

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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
 	PreparedStatement pst;
 	ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
 			pst = con.prepareStatement("insert into Student values(?,?,?)");
 			int roll = Integer.parseInt(request.getParameter("roll"));
 			System.out.println("database connected");
 			String name=request.getParameter("name");
 			String address=request.getParameter("address");
 			pst.setInt(1,roll);
 			pst.setString(2, name);
 			pst.setString(3, address);
 			int res=pst.executeUpdate();
 			if(res >= 1) {
 				out.println("record is inserted successfully");
 				out.println("<a href= 'http://localhost:8888/MyWebProject/Insert.html'>Insert more?</a>");
 				out.println("<a href= 'http://localhost:8888/MyWebProject/Home.html'>Home</a>");
 			}
 		
 		}catch(Exception ae) {
 			System.out.println("Error in database Connection!!");
 			out.println("error in Insert Page!!");
 			ae.printStackTrace();
 		}
	}

}
