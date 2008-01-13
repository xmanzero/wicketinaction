package wicket.in.action.chapter14.dbdiscounts.web;

import java.util.Iterator;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import wicket.in.action.chapter14.dbdiscounts.dao.DiscountDao;
import wicket.in.action.chapter14.dbdiscounts.model.DomainModelIteratorAdaptor;
import wicket.in.action.common.DateFmtLabel;
import wicket.in.action.common.Discount;
import wicket.in.action.common.PercentLabel;

public class DiscountsList extends Panel {

  @SpringBean
  private DiscountDao discountDao;

  public DiscountsList(String id) {

    super(id);
    add(new RefreshingView("discounts") {

      @Override
      protected Iterator getItemModels() {
        return new DomainModelIteratorAdaptor<Discount>(discountDao
            .findAll().iterator()) {
          @Override
          protected IModel model(Object object) {
            return new CompoundPropertyModel((Discount) object);
          }
        };
      }

      @Override
      protected void populateItem(Item item) {
        item.add(new Label("cheese.name"));
        item.add(new PercentLabel("discount"));
        item.add(new Label("description"));
        item.add(new DateFmtLabel("until"));
      }
    });
  }
}