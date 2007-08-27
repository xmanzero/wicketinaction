package wicket.in.action.chapter01.section_1_1_2;

import wicket.in.action.AbstractBasePage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Index extends AbstractBasePage {
  public Index() {
    super("1.1.2 How can a framework help you?");
    add(new BookmarkablePageLink("echo",
        wicket.in.action.chapter01.section_1_1_2.listing04.Echo.class));
    add(new BookmarkablePageLink("echopanel",
        wicket.in.action.chapter01.section_1_1_2.listing05.Echo.class));
  }
}
