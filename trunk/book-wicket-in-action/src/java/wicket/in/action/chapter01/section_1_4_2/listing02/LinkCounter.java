package wicket.in.action.chapter01.section_1_4_2.listing02;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

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
  }

  public int getCounter() {
    return counter;
  }
}
