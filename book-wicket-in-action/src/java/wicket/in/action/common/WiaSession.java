package wicket.in.action.common;

import java.util.Locale;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

public class WiaSession extends WebSession {

  public static WiaSession get() {
    return (WiaSession) Session.get();
  }

  private User user;

  public WiaSession(Request request) {
    super(request);
    setLocale(Locale.ENGLISH);
  }

  public User getUser() {
    return user;
  }

  public boolean isAuthenticated() {
    return (user != null);
  }

  public void setUser(User user) {
    this.user = user;
  }
}
