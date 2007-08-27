package wicket.in.action.chapter01.section_1_4_5;

import wicket.in.action.AbstractBasePage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Index extends AbstractBasePage {
  public Index() {
    super("1.4.5 Editing with forms");
    add(new BookmarkablePageLink(
        "listing01",
        wicket.in.action.chapter01.section_1_4_5.listing01.Forms.class));
    add(new BookmarkablePageLink(
        "listing02",
        wicket.in.action.chapter01.section_1_4_5.listing02.Forms.class));
    add(new BookmarkablePageLink(
        "listing03",
        wicket.in.action.chapter01.section_1_4_5.listing03.Forms.class));
    add(new BookmarkablePageLink(
        "listing04",
        wicket.in.action.chapter01.section_1_4_5.listing04.Forms.class));
  }
}
