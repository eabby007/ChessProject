<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chess Input</title>
</head>
<body>

<b>Welcome to  N - Queens : </b>
<br/>
<form action="<%=request.getContextPath()%>/chessInput" method="post">
Enter Your Name: <input type="text" name="userName"/>
<br/>
Enter no. of Queens: <input type="text" name="noOfQueens"/>
<br/>
<input type="radio" name="noOfSolutions" value="true">One Solution</input>
<input type="radio" name="noOfSolutions" value="false">All Solution</input>
<br/>
<input type="submit" value=" View Solutions"/>
</form>

</body>
</html>