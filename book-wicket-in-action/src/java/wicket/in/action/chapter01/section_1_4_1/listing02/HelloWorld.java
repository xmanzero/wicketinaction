package wicket.in.action.chapter01.section_1_4_1.listing02;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HelloWorld extends WebPage {
  public HelloWorld() {
    add(new Label("message", "Hello, World!"));
  }
}
