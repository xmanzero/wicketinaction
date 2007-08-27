package wicket.in.action.chapter01.section_1_4_4;

import wicket.in.action.AbstractBasePage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Index extends AbstractBasePage {
  public Index() {
    super("1.4.4 Looping through lists");
    add(new BookmarkablePageLink(
        "listing01",
        wicket.in.action.chapter01.section_1_4_4.listing01.Repeater.class));
    add(new BookmarkablePageLink(
        "listing02",
        wicket.in.action.chapter01.section_1_4_4.listing02.ColorList.class));
    add(new BookmarkablePageLink(
        "listing03",
        wicket.in.action.chapter01.section_1_4_4.listing03.ColorList.class));
  }
}
