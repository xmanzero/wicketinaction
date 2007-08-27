package wicket.in.action.chapter01.section_1_4_5.listing04;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

public class Forms extends WebPage {
  private static final List<String> messages = new ArrayList<String>();

  static {
    messages.add("Hello, world!");
    messages.add("How are you today?");
  }

  private String message;

  public Forms() {
    add(new ListView("messages", messages) {
      @Override
      protected void populateItem(ListItem item) {
        item.add(new Label("message", item.getModel()));
      }
    });
    Form form = new Form("form") {
      @Override
      protected void onSubmit() {
        messages.add(0, message);
      }
    };
    add(form);
    form.add(new TextField("field",
        new PropertyModel(this, "message")));
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
