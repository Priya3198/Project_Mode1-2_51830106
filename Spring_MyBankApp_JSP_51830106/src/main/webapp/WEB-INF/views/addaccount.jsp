<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="addaccount" method="post" modelAttribute="account" >

Enter account Balance:<form:input path="balance"/><br/>
Enter account blocked:<form:input path="blocked"/><br/>

Enter customer name:<form:input path="name"/><br/>
Enter customer address:<form:input path="address"/><br/>
Enter customer city:<form:input path="city"/><br/>
Enter customer email:<form:input path="email"/><br/>

Enter customer country:<form:input path="country"/><br/>
Enter customer phone:<form:input path="phone"/><br/>



<input type="submit">
</form:form>

</body>
</html>