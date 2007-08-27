package wicket.in.action.chapter13.locdiscounts2;

import java.util.Arrays;
import java.util.Locale;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;

import wicket.in.action.chapter09.locales.LocaleDropDown;
import wicket.in.action.common.SignOut;
import wicket.in.action.common.User;
import wicket.in.action.common.WiaSession;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

public class UserPanel extends Panel {

  public UserPanel(String id, Class<? extends Page> logoutToPageClass) {

    super(id);
    IModel userModel = new LoadableDetachableModel() {
      @Override
      protected User load() {
        return WiaSession.get().getUser();
      }
    };
    IModel nameModel = new PropertyModel(userModel, "fullname");
    add(new Label("fullname", nameModel));
    PageParameters parameters = new PageParameters();
    parameters.add(SignOut.REDIRECTPAGE_PARAM, logoutToPageClass
        .getName());
    add(new BookmarkablePageLink("signout", SignOut.class, parameters));
    add(new LocaleDropDown("localeSelect", Arrays
        .asList(new Locale[] { Locale.ENGLISH, new Locale("nl"),
            new Locale("th") })));
  }

  @Override
  public boolean isVisible() {
    return WiaSession.get().isAuthenticated();
  }
}
