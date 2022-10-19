<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form method ="post" action="Login.jsp">
   User Name:
   <input type="text" name="userName"/> <br/><br/>
   password:
   <input type="password" name="passWord" /> <br/><br/>
   <input type="submit" value="Login" />
   </form>
   <c:if test="${param.userName != null && param.passWord!=null}">
   <jsp:useBean id="beanLibusers" class="com.infinite.LibraryProjectHib.Libusers" />
   <jsp:setProperty property="*" name="beanLibusers" />
   <jsp:useBean id="beanDao" class="com.infinite.LibraryProjectHib.LibraryDAO" />
   <c:set var="user" value="${param.userName}" />
   <c:set var="pwd" value="${param.passWord}" />
   <c:set var="count" value="${beanDao.loginCheck(user,pwd)}" />
   <c:out value="${count}" />
   </c:if>
</body>
</html>