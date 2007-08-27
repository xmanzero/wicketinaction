<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
  <head><title>Echo Servlet</title></head>
  <body>
  
    Hello! Your message is: <h3><c:out value="msg" default="Welcome"/></h3>
    
    <form action="<% request.getRequestURL(); %>">
      <input type="text" name="msg" value="<%= (msg != null) ? msg : "" %>" />
      <input type="submit" value="set message" />
    </form>
  </body>
</html>