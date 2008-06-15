package wicket.in.action.chapter09.resdiscounts3;

import org.apache.wicket.markup.html.WebPage;

public class DiscountsPage extends WebPage {

  public DiscountsPage() {
    add(new DiscountsPanel("discounts"));
  }
}
