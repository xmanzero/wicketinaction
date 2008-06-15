package wicket.in.action.chapter09.resdiscounts;

import wicket.in.action.AbstractBasePage;

public class DiscountsPage extends AbstractBasePage {

  public DiscountsPage() {
    add(new DiscountsPanel("discounts"));
  }
}
