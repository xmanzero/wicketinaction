package wicket.in.action.chapter15.section_15_1;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author dashorst
 */
public class HelloWorldPanel extends Panel {

  public HelloWorldPanel(String id) {
    super(id);
    add(new Label("message", "Hello, World!"));
  }
}

