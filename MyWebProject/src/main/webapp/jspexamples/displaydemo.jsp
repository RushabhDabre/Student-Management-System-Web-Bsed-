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
 	ResultSetMetaData rsmd;
%>

<%
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
	out.println("<a href= 'http://localhost:8888/MyWebProject/jspexamples/Home.html'>Go to Home Page</a>");
	}catch(Exception ae) {
		System.out.println("Error in database Connection!!");	
		out.println("error in Delete Page!!");
		ae.printStackTrace();
	}

%>
</body>
</html>