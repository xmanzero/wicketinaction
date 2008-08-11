package wicket.in.action.chapter05.section_5_3;

import java.util.Map;
import java.util.Set;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.string.StringList;

/**
 * Created by IntelliJ IDEA.
 * User: dashorst
 * Date: Sep 18, 2007
 * Time: 11:03:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class ParametersPage extends WebPage {
    public ParametersPage(PageParameters pars) {
        RepeatingView view = new RepeatingView("pars");
        add(view);
        Set<Map.Entry> entries = pars.entrySet();
        for (Map.Entry entry : entries) {
            WebMarkupContainer wmc = new WebMarkupContainer(view.newChildId(), new CompoundPropertyModel(entry));
            view.add(wmc);
            wmc.add(new Label("key"));
            String[] values = (String[])entry.getValue();
            if(values.length > 1) {
                wmc.add(new Label("value", StringList.valueOf(values).toString()));
            }
            else wmc.add(new Label("value", values[0]));
        }
    }
}
