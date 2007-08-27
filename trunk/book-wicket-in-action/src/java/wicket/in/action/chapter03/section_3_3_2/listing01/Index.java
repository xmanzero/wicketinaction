package wicket.in.action.chapter03.section_3_3_2.listing01;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class Index extends WebPage {
  private static final long serialVersionUID = 1L;

  public Index() {
    add(new ListView("contact", ContactDao.getContacts()) {
      @Override
      protected void populateItem(ListItem item) {
        Contact contact = (Contact) item.getModelObject();
        item.add(new Label("name", contact.getName()));
        item.add(new Label("number", contact.getNumber().toString()));
      }
    });
  }
}
