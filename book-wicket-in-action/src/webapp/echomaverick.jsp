<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="wicket.in.action.chapter01.section_1_1_2.listing03.*" %>
<html>
  <head><title>Echo Maverick</title></head>
  <body>
  <% EchoForm model = (EchoForm)request.getAttribute("model"); %>
  <% boolean msgNotNull = (model != null && model.getMsg() != null);  %>
    Hello! Your message is: <h3><%= (msgNotNull) ? model.getMsg() : "Welcome" %></h3>
    <form action="echo.m">
      <input type="text" name="msg" value="<%= (msgNotNull) ? model.getMsg() : "" %>" />
      <input type="submit" value="set message" />
    </form>
  </body>
</html>