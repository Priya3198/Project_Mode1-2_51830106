<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bank app</title>
</head>
<body>
<br/>
<center>
User : <sec:authentication property="principal.username"/><br/>
User : <sec:authentication property="principal.authorities"/><br/>
</center>

<br/>
<center>
<sec:authorize access="hasAnyRole('ADMIN')">
App user management: <a href="admin/allusers">user management</a><br/>
</sec:authorize>
view appuser and account: <a href="clerk/allappusers">view appuser and account</a><br/>
Account management: <a href="mgr/all_accounts">account management</a><br/>
</center>

<center><a href="logout">logout</a></center>
</body>
</html>







