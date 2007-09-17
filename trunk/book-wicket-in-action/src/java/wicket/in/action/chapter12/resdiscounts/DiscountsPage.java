package wicket.in.action.chapter12.resdiscounts;

import org.apache.wicket.markup.html.WebPage;

public class DiscountsPage extends WebPage {

  public DiscountsPage() {
    add(new DiscountsPanel("discounts"));
  }
}
