package wicket.in.action.chapter012.authdiscounts2;

import wicket.in.action.common.AdminOnly;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

public final class DiscountsPanel extends Panel {

  @AdminOnly
  private class ModeLink extends Link {

    ModeLink(String id) {
      super(id);
      IModel linkLabelModel = new AbstractReadOnlyModel() {
        @Override
        public Object getObject() {
          return inEditMode ? "[display]" : "[edit]";
        }
      };
      add(new Label("linkLabel", linkLabelModel));
    }

    @Override
    public void onClick() {
      inEditMode = !inEditMode;
      setContentPanel();
    }
  }

  private boolean inEditMode = false;

  public DiscountsPanel(String id) {

    super(id);

    add(new DiscountsList("content"));

    add(new ModeLink("modeLink"));
  }

  void setContentPanel() {
    if (inEditMode) {
      addOrReplace(new DiscountsEditList("content"));
    } else {
      addOrReplace(new DiscountsList("content"));
    }
  }
}