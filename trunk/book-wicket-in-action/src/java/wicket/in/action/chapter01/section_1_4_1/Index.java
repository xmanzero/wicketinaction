package wicket.in.action.chapter01.section_1_4_1;

import wicket.in.action.AbstractBasePage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Index extends AbstractBasePage {
  public Index() {
    super("1.4.1 Hello, World!");
    add(new BookmarkablePageLink(
        "listing01",
        wicket.in.action.chapter01.section_1_4_1.listing01.HelloWorld.class));
    add(new BookmarkablePageLink(
        "listing02",
        wicket.in.action.chapter01.section_1_4_1.listing02.HelloWorld.class));
  }
}
