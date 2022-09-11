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
		pst = con.prepareStatement("select * from userdetails where username = ? and password = ?");
		System.out.println("database connected");
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		pst.setString(1, uname);
		pst.setString(2, password);
		rs=pst.executeQuery();
		if(rs.next()) {
			response.sendRedirect("http://localhost:8888/MyWebProject/jspexamples/Home.html");
		}
		else {
			response.sendRedirect("http://localhost:8888/MyWebProject/jspexamples/loginError.html");
		}

	}catch(Exception ae) {
		System.out.println("Error in Connection!!");
		out.println("error in database connection");
		ae.printStackTrace();
	}


%>

</body>
</html>