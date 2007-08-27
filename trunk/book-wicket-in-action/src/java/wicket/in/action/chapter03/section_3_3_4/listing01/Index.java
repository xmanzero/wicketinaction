package wicket.in.action.chapter03.section_3_3_4.listing01;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;

public class Index extends WebPage {
  private static final long serialVersionUID = 1L;

  public Index() {
    add(new PageableListView("contact", ContactDao.getContacts(), 2) {
      @Override
      protected void populateItem(ListItem item) {
        Contact contact = (Contact) item.getModelObject();
        item.add(new Label("name", contact.getName()));
        item.add(new Label("number", contact.getNumber().toString()));
        item.add(new Link("delete", item.getModel()) {
          @Override
          public void onClick() {
            Contact c = (Contact) getModelObject();
            ContactDao.delete(c);
          }
        });
      }
    });
    add(new Link("add") {
      @Override
      public void onClick() {
        setResponsePage(new EditContactPage(new Contact()));
      }
    });
  }
}
