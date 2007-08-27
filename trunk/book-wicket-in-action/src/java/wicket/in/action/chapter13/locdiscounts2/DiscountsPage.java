package wicket.in.action.chapter13.locdiscounts2;

import wicket.in.action.common.ProtectedPage;

public class DiscountsPage extends ProtectedPage {

  public DiscountsPage() {
    add(new UserPanel("userPanel", Index.class));
    add(new DiscountsPanel("discounts"));
  }
}
