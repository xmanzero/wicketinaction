package wicket.in.action.chapter03.section_3_2_5.listing03;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.time.Duration;

public class PhonebookApplication extends WebApplication {
  public PhonebookApplication() {
    getResourceSettings().setResourcePollFrequency(
        Duration.ONE_SECOND);
  }

  @Override
  public Class<? extends Page> getHomePage() {
    return Index.class;
  }
}
