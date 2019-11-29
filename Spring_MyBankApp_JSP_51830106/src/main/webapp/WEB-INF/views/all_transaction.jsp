<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Account details</title>
</head>
<body >
<center><h3>ALL TRANSACTION HISTORY</h3></center>
<center><table border="1" >

		<thead>
			<tr>
				<th>id</th>
				
				
				<th>timeStamp</th>
				<th>fromAccount</th>
				<th>toAccount</th>
				<th>txType</th>
				<th>txAmount</th>
				<th>authorityName</th>
				<th>status</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transactions}" var="transaction">
			   <tr>
				<td>${transaction.id }</td>
				<td>${transaction.timeStamp }</td>
				<td>${transaction.fromAccount}</td>
				<td>${transaction.toAccount }</td>
				<td>${transaction.txType}</td>
				<td>${transaction.txAmount }</td>
				<td>${transaction.authorityName }</td>
				<td>${transaction.status}</td>
				
			   </tr>
			</c:forEach>
		</tbody>
	</table>
	</center>
	
	
	
	
	
</body>
</html>