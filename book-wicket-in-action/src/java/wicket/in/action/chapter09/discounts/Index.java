package wicket.in.action.chapter09.discounts;

import wicket.in.action.AbstractBasePage;

public class Index extends AbstractBasePage {

  public Index() {
    add(new DiscountsPanel("discounts"));
  }
}
