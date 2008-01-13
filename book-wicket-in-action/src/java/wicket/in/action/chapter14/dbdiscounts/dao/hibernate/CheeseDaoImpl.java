package wicket.in.action.chapter14.dbdiscounts.dao.hibernate;

import wicket.in.action.chapter14.dbdiscounts.dao.CheeseDao;
import wicket.in.action.chapter14.dbdiscounts.domain.Cheese;

public class CheeseDaoImpl extends AbstractHibernateDaoImpl<Cheese>
    implements CheeseDao {

  public CheeseDaoImpl() {
    super(Cheese.class);
  }
}
