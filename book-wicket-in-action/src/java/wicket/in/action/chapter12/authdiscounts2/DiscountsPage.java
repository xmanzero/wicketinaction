package wicket.in.action.chapter12.authdiscounts2;

import org.apache.wicket.markup.html.WebPage;

public class DiscountsPage extends WebPage {

  public DiscountsPage() {
    add(new UserPanel("userPanel", Index.class));
    add(new DiscountsPanel("discounts"));
  }
}
