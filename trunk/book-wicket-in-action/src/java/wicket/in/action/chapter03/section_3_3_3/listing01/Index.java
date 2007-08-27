package wicket.in.action.chapter03.section_3_3_3.listing01;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

public class Index extends WebPage {
  private static final long serialVersionUID = 1L;

  public Index() {
    PageableListView lv = new PageableListView("contact", ContactDao
        .getContacts(), 2) {
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
    };
    add(lv);
    add(new PagingNavigator("navigator", lv));
  }
}
