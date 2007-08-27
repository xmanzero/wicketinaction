package wicket.in.action.chapter01.section_1_4_2.listing01;

import org.apache.wicket.markup.html.WebPage;

public class LinkCounter extends WebPage {
  /** Counts the number of clicks. */
  private int counter = 0;

  public LinkCounter() {
  }

  public int getCounter() {
    return counter;
  }
}
