package wicket.in.action.chapter01.section_1_4_5.listing01;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;

public class Forms extends WebPage {
  private static final List<String> messages = new ArrayList<String>();

  static {
    messages.add("Hello, world!");
    messages.add("How are you today?");
  }

  public Forms() {
  }
}
