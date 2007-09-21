package wicket.in.action.chapter11.ajaxdiscounts;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.IAjaxCallDecorator;
import org.apache.wicket.ajax.calldecorator.AjaxCallDecorator;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import wicket.in.action.common.DataBase;
import wicket.in.action.common.Discount;

public final class DiscountsPanel extends Panel {

  private class DiscountsListView extends PropertyListView {

    private class RemoveLink extends AjaxLink {
      private final Discount discount;

      private RemoveLink(String id, IModel model) {
        super(id, model);
        this.discount = (Discount) getModelObject();
      }

      @Override
      public void onClick(AjaxRequestTarget target) {
        DataBase.getInstance().remove(discount);
        DiscountsListView.this.setList(DataBase.getInstance()
            .listDiscounts());
        DiscountsListView.this.removeAll();
        target.addComponent(rows);
      }

      @Override
      protected IAjaxCallDecorator getAjaxCallDecorator() {
        return new AjaxCallDecorator() {
          @Override
          public CharSequence decorateScript(CharSequence script) {
            return "if(!confirm('remove discount for "
                + discount.getCheese().getName()
                + " ?')) return false;" + script;
          }
        };
      }
    }

    public DiscountsListView(String id) {
      super(id, DataBase.getInstance().listDiscounts());
    }

    @Override
    protected void populateItem(ListItem item) {

      item.add(new Label("cheese.name"));
      EditLabel editLabel = new EditLabel("discount", feedbackPanel);
      item.add(editLabel);
      editLabel.setType(Integer.class);
      editLabel.setRequired(true);
      item.add(new EditLabel("description", feedbackPanel));
      item.add(new RemoveLink("remove", item.getModel()));
    }
  }

  private final FeedbackPanel feedbackPanel;

  private WebMarkupContainer rows;

  public DiscountsPanel(String id) {

    super(id);
    add(rows = new WebMarkupContainer("rows"));
    rows.setOutputMarkupId(true);
    rows.add(feedbackPanel = new FeedbackPanel("feedback"));
    feedbackPanel.setOutputMarkupId(true);
    rows.add(new DiscountsListView("discounts"));
  }
}