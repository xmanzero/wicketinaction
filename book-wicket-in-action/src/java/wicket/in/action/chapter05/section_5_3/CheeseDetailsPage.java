package wicket.in.action.chapter05.section_5_3;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Created by IntelliJ IDEA.
 * User: dashorst
 * Date: Sep 16, 2007
 * Time: 10:51:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CheeseDetailsPage extends WebPage {
    // bookmarkable constructor
    public CheeseDetailsPage(PageParameters parameters) {
        this(getCheese(parameters));
    }
    // non-bookmarkable constructor
    public CheeseDetailsPage(Cheese cheese) {
        // do cheesy stuff with the cheese

        add(new Label("name", cheese.getName()));
        add(new Label("description", cheese.getDescription()));
        add(new BookmarkablePageLink("back", Index.class));
    }
    /** Retrieves a cheese object based on the ‘id’ parameter. */
    public static Cheese getCheese(PageParameters parameters) {
        Long id = parameters.getLong("id", -1);
        CheeseDao dao = new CheeseDao();
        if(id < 0) return new Cheese();
        return dao.getCheese(id);
    }
}
