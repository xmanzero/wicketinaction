package wicket.in.action.chapter01.section_1_1_2.listing01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EchoServlet extends HttpServlet {

  public EchoServlet() {
    super();
  }

  @Override
  public void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // get the msg parameter if any
    String msg = request.getParameter("msg");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docype = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">";
    out.println(docype);
    out.println("<html>");
    out
        .println("\t<title>Echo Servlet</title></head>");
    out.println("\t");
    out.print("\tHello! Your message is: <h3>");
    if (msg != null) {
      out.print(msg);
    } else {
      out.print("Welcome");
    }
    out.println("</h3>");
    out.print("<form action=\"");
    out.print(request.getRequestURL());
    out.println("\">");
    out
        .print("\t\t<input type=\"text\" name=\"msg\" value=\"");
    if (msg != null) {
      out.print(msg);
    }
    out
        .println("\" /><input type=\"submit\" value=\"set message\" />");
    out.println("\t</form>");
    out.println("</body>");
    out.println("</html>");
    out.flush();
    out.close();
  }

  @Override
  protected void doPost(HttpServletRequest req,
      HttpServletResponse resp) throws ServletException,
      IOException {
    // for the sake of simplicity, just pass on to doGet
    doGet(req, resp);
  }
}
