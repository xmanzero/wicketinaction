package wicket.in.action.chapter05.links;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;

import wicket.in.action.AbstractBasePage;

/**
 * Created by IntelliJ IDEA.
 * User: dashorst
 * Date: Sep 16, 2007
 * Time: 4:20:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinksPage extends AbstractBasePage {
    public LinksPage() {
        add(new ExternalLink("recipelink", "http://www.basic-recipes.com/meatsmd/lasag/index.htm"));

        add(new BookmarkablePageLink("cheese1", CheeseDetailsPage.class, new PageParameters("id=1,name=gouda")));
        add(new BookmarkablePageLink("cheese2", BookmarkableMountedCheeseDetailsPage.class, new PageParameters("id=2,name=edam")));
        add(new BookmarkablePageLink("cheese3", IndexedMountedCheeseDetailsPage.class, new PageParameters("0=3,1=old amsterdam")));
        add(new BookmarkablePageLink("cheese4", MixedMountedCheeseDetailsPage.class, new PageParameters("id=1,name=gouda")));
        add(new BookmarkablePageLink("cheese5", HybridMountedCheeseDetailsPage.class, new PageParameters("id=2,name=edam")));
        add(new BookmarkablePageLink("cheese6", IndexedHybridMountedCheeseDetailsPage.class, new PageParameters("0=3,1=old amsterdam")));

        PageParameters pars = new PageParameters();
        pars.put("multi", new String[]{"value1", "value2", "value3"});
        pars.add("integer", String.valueOf(1234));
        pars.put("text", "The quick fox jumps over the lazy dog.");
        add(new BookmarkablePageLink("parameters", ParametersPage.class, pars));

        add(new Link("link"){
            public void onClick() {
                setResponsePage(LinksPage.this);
            }
            @Override
            protected boolean getStatelessHint() {
              return false;
            }
        });
        add(new Link("stateless"){
          public void onClick() {
              setResponsePage(LinksPage.this);
          }
          @Override
          protected boolean getStatelessHint() {
            return true;
          }
      });
    }
}
