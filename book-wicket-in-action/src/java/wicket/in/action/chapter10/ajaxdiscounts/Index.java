package wicket.in.action.chapter10.ajaxdiscounts;

import org.apache.wicket.markup.html.WebPage;

public class Index extends WebPage {

  public Index() {
    add(new DiscountsPanel("discounts"));
  }
}
