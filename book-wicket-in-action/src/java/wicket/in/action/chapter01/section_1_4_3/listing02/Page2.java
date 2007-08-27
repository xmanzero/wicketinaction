package wicket.in.action.chapter01.section_1_4_3.listing02;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;

public class Page2 extends WebPage {
  public Page2() {
    add(new PageLink("linkToPage1", Page1.class));
  }
}
