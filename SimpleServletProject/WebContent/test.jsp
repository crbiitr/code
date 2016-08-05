<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Testin JSP</h3>
<%!
public void display () {
	System.out.println("My Name is Chetan Raj Bharti");
}

%>
<%

int a = 1;
int b= 2;
int k=a+b;

out.println("  value of k is :: " + k);

%>


<br>Value of k out side the script <%=k %>

<% for ( int i = 1; i < 5; i++) { %>

<br> i = <%=i %>
<%} %>



</body>
</html>