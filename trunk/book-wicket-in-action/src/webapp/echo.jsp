<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><title>Echo Servlet</title></head>
  <body>
  <% String msg = request.getParameter("msg"); %>
    Hello! Your message is: <h3><%= (msg != null) ? msg : "Welcome" %></h3>
    <form action="<% request.getRequestURL(); %>">
      <input type="text" name="msg" value="<%= (msg != null) ? msg : "" %>" />
      <input type="submit" value="set message" />
    </form>
  </body>
</html>