package wicket.in.action.chapter05.section_5_2;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;

import wicket.in.action.AbstractBasePage;

import java.io.Serializable;

/**
 */
public class Index extends AbstractBasePage {
    public static class Person implements Serializable {
        private String name = "Johnson";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Index() {
        // add label to span tags in the body
        add(new Label("message", "Hello, World!"));

        Person person = new Person();
        setModel(new CompoundPropertyModel(person));

        add(new Label("label1", "Hello, World!"));
        add(new Label("label2", new PropertyModel(person, "name")));
        add(new Label("label3", new ResourceModel("key", "default value")));
        add(new Label("label4", "Wicket in Action"));
        add(new Label("name"));

        add(new Label("replacer", "All of it gone"));

        add(new Label("label", "Hello,\nWorld!\nIÕm super!"));
        add(new MultiLineLabel("multiline", "Hello,\nWorld!\nIÕm super!"));

        add(new Label("markup1", "<h1>Hello!</h1>"));
        add(new Label("markup2", "<h1>Hello!</h1>").setEscapeModelStrings(false));
        add(new Label("markup3", "<h1 onclick='alert(\"clicked!\");'>Click me</h1>").setEscapeModelStrings(false));
    }
}
