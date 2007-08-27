package wicket.in.action.chapter01.section_1_4_3;

import wicket.in.action.AbstractBasePage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Index extends AbstractBasePage {
  public Index() {
    super("1.4.3 An application with multiple pages");
    add(new BookmarkablePageLink(
        "listing01",
        wicket.in.action.chapter01.section_1_4_3.listing01.Page1.class));
    add(new BookmarkablePageLink(
        "listing02",
        wicket.in.action.chapter01.section_1_4_3.listing02.Page1.class));
  }
}
