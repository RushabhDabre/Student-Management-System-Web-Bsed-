

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    PreparedStatement pst; 
    ResultSet rs;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
			pst = con.prepareStatement("Select * from student where roll=?");
			System.out.println("database connected");	
			 int roll=Integer.parseInt(request.getParameter("roll"));
			pst.setInt(1, roll);
 			
			rs = pst.executeQuery();
 			if(rs.next()) {
 				int roll1 = rs.getInt(1);
 				String name = rs.getString(2);
 				String address = rs.getString(3);

				out.println("Record is found!!");
				out.println("<html>");
		 		out.println("<head>SEARCH Page</head>");
		 		out.println("<body>");
		 		out.println("<form action='http://localhost:8888/MyWebProject/UpdateServlet' method='post'>");
		 		out.println("<table border='5px' bgcolor='PINK'>><table border='5px' bgcolor='PINK'>");
		 		out.println("<tr><td>ROLL NO </td><td><input type='text' name='roll' value="+roll1+"></td><br>");
		 		out.println("<tr><td>NAME </td><td><input type='text' name='name' value="+name+"></td><br>");
		 		out.println("<tr><td>ADDRESS </td><td><input type='text' name='address' value="+address+"></td><br>");
		 		out.println("<tr><td><br></td><td><input type='submit' value='UPDATE'><input type='button' value='HOME'></td>");
		 		out.println("</tr>");
		 		out.println("</table>");
		 		out.println("</form>");
		 		out.println("</body>");
		 		out.println("</html>");
			}
			else {
				out.println("no Record found!!");
 				out.println("<a href= 'http://localhost:8888/MyWebProject/Search.html'>Go to Search Page</a>");

			}
 			
 		
	
		}catch(Exception ae) {
			System.out.println("Error in database Connection!!");
			out.println("Error in search page!!");	
			ae.printStackTrace();
		}
	}

}
