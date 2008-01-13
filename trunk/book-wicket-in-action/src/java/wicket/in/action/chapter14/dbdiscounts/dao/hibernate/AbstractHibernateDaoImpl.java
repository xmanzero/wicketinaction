package wicket.in.action.chapter14.dbdiscounts.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import wicket.in.action.chapter14.dbdiscounts.dao.Dao;
import wicket.in.action.chapter14.dbdiscounts.domain.DomainObject;

public abstract class AbstractHibernateDaoImpl<T extends DomainObject>
    implements Dao<T> {

  private Class<T> domainClass;

  private SessionFactory sessionFactory;

  public AbstractHibernateDaoImpl(Class<T> domainClass) {
    this.domainClass = domainClass;
  }

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory sf) {
    this.sessionFactory = sf;
  }

  public void delete(T object) {
    getCurrentSession().delete(object);
  }

  @SuppressWarnings("unchecked")
  public T load(long id) {
    return (T) getCurrentSession().get(domainClass, id);
  }

  public void save(T object) {
    getCurrentSession().save(object);
  }

  public Session getCurrentSession() {
    // presumes a current session, which we have through the
    // OpenSessionInViewFilter; doesn't work without that
    return sessionFactory.getCurrentSession();
  }
}
