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
<center><h3>ALL ACCOUNT </h3></center>
<center><table border="1" >

		<thead>
			<tr>
				<th>accountNumber</th>
				
				
				<th>name</th>
				<th>address</th>
				<th>city</th>
				<th>country</th>
				<th>email</th>
				<th>phone</th>
				<th>balance</th>
				<th>blocked</th>
				
				<!-- <th>update</th>
				<th>delete</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
			   <tr>
				<td>${account.accountNumber }</td>
				<td>${account.customer.name }</td>
				<td>${account.customer.address }</td>
				<td>${account.customer.city }</td>
				<td>${account.customer.country }</td>
				<td>${account.customer.email }</td>
				<td>${account.customer.phone }</td>
				<td>${account.balance}</td>
				<td>${account.blocked }</td>
			
				<%-- <td><a href="update?id=${account.accountNumber}">update</a></td>
				<td><a href="delete?id=${account.accountNumber}">delete</a></td> --%>
			   </tr>
			</c:forEach>
		</tbody>
	</table>
	</center>
	<center><a href="transfer">transfer</a></center><br/>
	<center><a href="deposit">deposit</a></center><br/>
	
	<center><a href="withdraw">withdraw</a></center><br/>
	<center><a href="addaccount">addaccount</a></center><br/>
	<center><a href="alltransaction">tranction history</a></center><br/>
	<center><a href="logout">logout</a></center>
	
	
	
	
</body>
</html>