package wicket.in.action.chapter05;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import wicket.in.action.AbstractBasePage;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: dashorst
 * Date: Sep 21, 2007
 * Time: 8:27:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class ModelsPage extends AbstractBasePage {
    public ModelsPage(){
        WebMarkupContainer clocks = new WebMarkupContainer("clocks");
        add(clocks);
//        clocks.setOutputMarkupId(true);
//        clocks.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
        clocks.add(DateLabel.forDatePattern("static", new Model(new Date()), "hh:mm:ss"));
        clocks.add(DateLabel.forDatePattern("dynamic", new Model() {
            public Object getObject() {
                return new Date();
            }
        }, "hh:mm:ss"));
        clocks.add(new Link("refresh"){public void onClick() {}});
    }
}
