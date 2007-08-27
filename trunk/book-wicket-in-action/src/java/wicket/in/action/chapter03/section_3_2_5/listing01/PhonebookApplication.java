package wicket.in.action.chapter03.section_3_2_5.listing01;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class PhonebookApplication extends WebApplication {
  public PhonebookApplication() {
  }

  @Override
  public Class<? extends Page> getHomePage() {
    return null;
  }
}
