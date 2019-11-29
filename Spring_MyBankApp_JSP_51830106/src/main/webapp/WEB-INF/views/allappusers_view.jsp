<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AppUser management</title>
</head>
<body>
<center><h3>ALL APP_USERS</h3></center>
<center><table border="1">

		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<!-- <th>password</th> -->
				<th>phone</th>
				<th>address</th>
				<th>roles</th>
				<th>active</th>
				<!-- <th>update</th>
				<th>delete</th> -->
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
			   <tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.email}</td>
				<%-- <td>${user.password}</td> --%>
				<td>${user.phone}</td>
				<td>${user.address}</td>
				<td>
				<c:forEach var="temp" items="${user.roles}">
        			<c:out value="${temp}"></c:out>
    			</c:forEach>
				</td>
				
				<td>${user.active}</td>
				<%-- <td><a href="update?id=${user.id}">update</a></td>
				<td><a href="delete?id=${user.id}">delete</a></td> --%>
			   </tr>
			</c:forEach>
		</tbody>
	</table>
	</center>
	
	<center><a href="allaccounts_view">all accounts</a></center><br/>
	<%-- <center><a href="addappuser">add new app user</a></center><br/>
	<center><a href="logout">logout</a></center><br/> --%>
</body>
</html>