package wicket.in.action.chapter14.dbdiscounts.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

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

  @SuppressWarnings("unchecked")
  public List<T> findAll() {
    Criteria criteria = getCurrentSession().createCriteria(
        domainClass);
    return (List<T>) criteria.list();
  }

  public int countAll() {
    Criteria criteria = getCurrentSession().createCriteria(
        domainClass);
    criteria.setProjection(Projections.rowCount());
    return (Integer) criteria.uniqueResult();
  }

  public Session getCurrentSession() {
    // presumes a current session, which we have through the
    // OpenSessionInViewFilter; doesn't work without that
    return sessionFactory.getCurrentSession();
  }
}
