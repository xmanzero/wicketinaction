package wicket.in.action.chapter01.section_1_4_4.listing01;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.list.Loop;

public class Repeater extends WebPage {
  public Repeater() {
    add(new Loop("repeatme", 10) {
      @Override
      protected void populateItem(LoopItem item) {
      }
    });
  }
}
