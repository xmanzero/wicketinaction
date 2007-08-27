package wicket.in.action.chapter09.locales;

import org.apache.wicket.markup.html.WebPage;

public class CurrentLocaleLabelPage extends WebPage {

  public CurrentLocaleLabelPage() {
    add(new CurrentLocaleLabel("label"));
  }
}
