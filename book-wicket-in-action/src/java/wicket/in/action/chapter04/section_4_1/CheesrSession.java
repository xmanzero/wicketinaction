package wicket.in.action.chapter04.section_4_1;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public class CheesrSession extends WebSession {
  private Cart cart = new Cart();

  public CheesrSession(Request request) {
    super(request);
  }

  public Cart getCart() {
    return cart;
  }
}
