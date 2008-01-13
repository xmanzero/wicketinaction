package wicket.in.action.chapter14.dbdiscounts.dao.hibernate;

import wicket.in.action.chapter14.dbdiscounts.dao.DiscountDao;
import wicket.in.action.chapter14.dbdiscounts.domain.Discount;

public class DiscountDaoImpl extends
    AbstractHibernateDaoImpl<Discount> implements DiscountDao {

  public DiscountDaoImpl() {
    super(Discount.class);
  }
}
