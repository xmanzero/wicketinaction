package wicket.in.action.chapter11.authdiscounts;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Index extends WebPage {

  public Index() {
    add(new BookmarkablePageLink("toDiscounts", DiscountsPage.class));
  }
}
