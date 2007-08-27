package wicket.in.action;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public abstract class AbstractBasePage extends WebPage {
  public AbstractBasePage(final String title) {
    add(new Label("title", new Model() {
      @Override
      public Object getObject() {
        if ("".equals(title.trim())) {
          return "Wicket in Action";
        } else {
          return "Wicket in Action - " + title;
        }
      }
    }));
    add(new Label("heading", new Model() {
      @Override
      public Object getObject() {
        if ("".equals(title.trim())) {
          return "Wicket in Action";
        } else {
          return title;
        }
      }
    }));
  }
}
