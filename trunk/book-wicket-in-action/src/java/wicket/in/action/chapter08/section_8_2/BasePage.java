package wicket.in.action.chapter08.section_8_2;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * @author dashorst
 */
public class BasePage extends WebPage {
  private WebMarkupContainer wrapper;

  public BasePage() {
    wrapper = new WebMarkupContainer("wrapper") {
      @Override
      public boolean isTransparentResolver() {
        return true;
      }
    };
    wrapper.setOutputMarkupId(true);
    add(wrapper);

    add(new AjaxFallbackLink("refresh") {
      @Override
      public void onClick(AjaxRequestTarget target) {
        target.addComponent(wrapper);
      }
    });
  }
}
