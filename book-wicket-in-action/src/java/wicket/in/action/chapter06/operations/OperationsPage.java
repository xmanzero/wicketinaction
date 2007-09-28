package wicket.in.action.chapter06.operations;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.RepeatingView;

/**
 * Created by IntelliJ IDEA.
 * User: dashorst
 * Date: Sep 20, 2007
 * Time: 11:56:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class OperationsPage extends WebPage {
    public OperationsPage() {
        WebMarkupContainer example1 = new WebMarkupContainer("example1");

        example1.add(new Label("label1", "label 1"));
        example1.add(new Label("label2", "label 2"));
        example1.add(new Label("label3", "label 3"));
        example1.add(new Label("label4", "label 4"));

        add(example1);

        example1.get("label3").setVisible(false);
        example1.get("label4").setVisible(false);

        WebMarkupContainer example2 = new WebMarkupContainer("example2");

        example2.add(new Label("label1", "label 1"));
        example2.add(new Label("label2", "label 2"));
        WebMarkupContainer wmc = new WebMarkupContainer("wmc");
        example2.add(wmc);
        wmc.add(new Label("label3", "label 3"));
        wmc.add(new Label("label4", "label 4"));

        add(example2);

        wmc.setVisible(false);

        WebMarkupContainer example3 = new WebMarkupContainer("example3");
        example3.add(new Label("label1", "label 1"));
        example3.add(new Label("label2", "label 2"));
        example3.add(new Label("label3", "label 3"));
        example3.add(new Label("label4", "label 4"));

        add(example3);

        example3.get("label3").setVisible(false);
        example3.get("label4").setVisible(false);

        WebMarkupContainer example4 = new WebMarkupContainer("example4");

        example4.add(new Label("label", "Some text").add(new SimpleAttributeModifier("style", "color:red")));
        Link link = new Link("link") {
            public void onClick() {
                System.out.println("Clicked!");
            }
        };
        example4.add(link);
        link.add(new SimpleAttributeModifier("onclick", "return confirm('Are you sure?');"));
        add(example4);

        RepeatingView rv = new RepeatingView("foo");
        wmc = new WebMarkupContainer(rv.newChildId());
        rv.add(wmc);
        rv.add(new Label("a", "foo"));
        rv.add(new Label("b", "bar"));
        add(rv);
    }
}
