package wicket.in.action.chapter03.section_3_2_7.listing01;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class Launcher {

  public static void main(String[] args) {
    Server server = new Server(8080);
    WebAppContext ctx = new WebAppContext("./src/webapp",
        "/wicket-in-action");
    server.addHandler(ctx);
    try {
      server.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}