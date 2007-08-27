package wicket.in.action.chapter01.section_1_4_3.listing02;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;

public class Page1 extends WebPage {
  public Page1() {
    add(new PageLink("linkToPage2", Page2.class));
  }
}
