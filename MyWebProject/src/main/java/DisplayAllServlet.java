

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

/**
 * Servlet implementation class DisplayAllServlet
 */
@WebServlet("/DisplayAllServlet")
public class DisplayAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    PreparedStatement pst; 
    ResultSet rs; 
 	ResultSetMetaData rsmd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RUSHABH","Wadsa@123");  //for oracle,....
 			out.println("Server is Connected");
 			
 			
				pst = con.prepareStatement("Select * from Student", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = pst.executeQuery();
				rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				int i;
				out.println("<Html><Body><Table Border='10px' bgcolor='blue'><tr>");
				for(i=1; i<= cols; i++) {
					out.println("<td>"+rsmd.getColumnName(i)+"</td>");
				}
				out.println("</tr>");
				
				
				while(rs.next()) {
					out.println("<tr>");
					for(i =1; i<=cols; i++) {
					out.println("<td>"+rs.getString(i)+"</td>");
					}
					out.println("</tr>");
				}
			out.println("</Table></Body></Html>");
			out.println("<a href= 'http://localhost:8888/MyWebProject/Home.html'>Go to Home Page</a>");
 		}catch(Exception ae) {
 			System.out.println("Error in database Connection!!");	
 			out.println("error in Delete Page!!");
 			ae.printStackTrace();
 		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		
	}

}
