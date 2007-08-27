package wicket.in.action.chapter01.section_1_4_2.listing03;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

public class LinkCounter extends WebPage {
  /** Counts the number of clicks. */
  private int counter = 0;

  public LinkCounter() {
    add(new Link("link") {
      @Override
      public void onClick() {
        counter++;
      }
    });
    add(new Label("counter", new PropertyModel(this, "counter")));
  }

  public int getCounter() {
    return counter;
  }
}
