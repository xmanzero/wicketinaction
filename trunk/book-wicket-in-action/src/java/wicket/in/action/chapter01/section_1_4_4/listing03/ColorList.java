package wicket.in.action.chapter01.section_1_4_4.listing03;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.Loop;

public class ColorList extends WebPage {
  private static final String[] colors = { "red", "green", "blue" };

  public ColorList() {
    add(new Loop("colors", colors.length) {
      @Override
      protected void populateItem(LoopItem item) {
        String color = colors[item.getIteration()];
        item.add(new Label("color", color));
      }
    });
  }
}
