package wicket.in.action.chapter01.section_1_4_2;

import wicket.in.action.AbstractBasePage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Index extends AbstractBasePage {
  public Index() {
    super("1.4.2 Having fun with links");
    add(new BookmarkablePageLink(
        "listing01",
        wicket.in.action.chapter01.section_1_4_2.listing01.LinkCounter.class));
    add(new BookmarkablePageLink(
        "listing02",
        wicket.in.action.chapter01.section_1_4_2.listing02.LinkCounter.class));
    add(new BookmarkablePageLink(
        "listing03",
        wicket.in.action.chapter01.section_1_4_2.listing03.LinkCounter.class));
  }
}
