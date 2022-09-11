<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!  
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
%>

<%
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
			out.println("<a href= 'http://localhost:8888/MyWebProject/jspexamples/Delete.html'>Delete more?</a>");
			out.println("<a href= 'http://localhost:8888/MyWebProject/jspexamples/Home.html'>Home</a>");
		}
		
	}catch(Exception ae) {
		System.out.println("Error in database Connection!!");	
		out.println("error in Delete Page!!");
		ae.printStackTrace();
	}
%>
</body>
</html>