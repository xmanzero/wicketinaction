package wicket.in.action.chapter01.section_1_4_5.listing02;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class Forms extends WebPage {
  private static final List<String> messages = new ArrayList<String>();

  static {
    messages.add("Hello, world!");
    messages.add("How are you today?");
  }

  public Forms() {
    add(new ListView("messages", messages) {
      @Override
      protected void populateItem(ListItem item) {
        item.add(new Label("message", item.getModel()));
      }
    });
  }
}
