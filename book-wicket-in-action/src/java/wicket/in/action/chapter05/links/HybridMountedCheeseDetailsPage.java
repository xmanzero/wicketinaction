package wicket.in.action.chapter05.links;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.link.Link;

/**
 * Created by IntelliJ IDEA.
 * User: dashorst
 * Date: Sep 17, 2007
 * Time: 12:34:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class HybridMountedCheeseDetailsPage extends CheeseDetailsPage {
    public HybridMountedCheeseDetailsPage(PageParameters parameters) {
        super(parameters);
        add(new Link("link") {
            public void onClick() {
                setResponsePage(new LinksPage());
            }

            protected boolean getStatelessHint() {
                return false;
            }
        });
    }
}