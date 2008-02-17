package wicket.in.action.chapter05.section_5_6;

import java.util.Calendar;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import wicket.in.action.AbstractBasePage;

/**
 * This page shows the examples for section 6.4
 */
public class Index extends AbstractBasePage {
  public Index() {
    createExample6_4_1();
    createExample6_4_2();
    createExample6_4_3();
  }

  private void createExample6_4_1() {
    // use a webmarkupcontainer to isolate the examples
    WebMarkupContainer example641 = new WebMarkupContainer("examples-6.4.1");

    Label label1 = new Label("label1", "label 1");
    example641.add(label1.setVisible(false));
    example641.add(new Label("label2", "label 2").setVisible(!label1
        .isVisible()));

    example641.add(new Label("label", "Now I'm visible!") {
      @Override
      public boolean isVisible() {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        return day != Calendar.SATURDAY && day != Calendar.SUNDAY;
      }
    });

    add(example641);
  }

  private void createExample6_4_2() {
    // use a webmarkupcontainer to isolate the examples
    WebMarkupContainer example642 = new WebMarkupContainer("examples-6.4.2");
    example642.add(new Label("message1", "Hello, World!") {
      @Override
      protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.put("style", "color:red");
      }
    });
    example642.add(new Label("message2", "Some text")
        .add(new SimpleAttributeModifier("style", "color:red")));
    Link link = new Link("link") {
      public void onClick() {
        System.out.println("Clicked!");
      }
    };
    example642.add(link);
    link.add(new SimpleAttributeModifier("onclick",
        "return confirm('Are you sure?');"));
    add(example642);
  }

  private void createExample6_4_3() {
    // use a webmarkupcontainer to isolate the examples
    WebMarkupContainer example642 = new WebMarkupContainer("examples-6.4.3");
    add(example642);
    
    example642.add(new Label("message", "Hello, World!").setRenderBodyOnly(true));
  }
}
