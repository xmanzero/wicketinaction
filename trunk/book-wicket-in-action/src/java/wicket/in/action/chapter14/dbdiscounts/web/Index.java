package wicket.in.action.chapter14.dbdiscounts.web;

import org.apache.wicket.markup.html.WebPage;

public class Index extends WebPage {

  public Index() {
    add(new DiscountsPanel("discounts"));
  }
}
