/**
 * 
 */
package wicket.in.action.chapter10.ajaxdiscounts;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.extensions.ajax.markup.html.AjaxEditableLabel;
import wicket.in.action.common.DataBase;
import wicket.in.action.common.Discount;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;

public class EditLabel extends AjaxEditableLabel {

  private final FeedbackPanel feedbackPanel;

  public EditLabel(String id, FeedbackPanel feedbackPanel) {
    super(id);
    this.feedbackPanel = feedbackPanel;
  }

  @Override
  protected FormComponent newEditor(MarkupContainer parent,
      String componentId, IModel model) {
    FormComponent editor = super
        .newEditor(parent, componentId, model);
    Object object = model.getObject();
    if (Number.class.isAssignableFrom(object.getClass())) {
      editor.add(new SimpleAttributeModifier("size", "5"));
    }
    return editor;
  }

  @Override
  protected void onError(AjaxRequestTarget target) {
    super.onError(target);
    target.addComponent(feedbackPanel);
  }

  @Override
  protected void onSubmit(AjaxRequestTarget target) {

    super.onSubmit(target);
    target.addComponent(feedbackPanel);
    Discount discount = (Discount) getParent().getModelObject();
    DataBase.getInstance().update(discount);
  }
}