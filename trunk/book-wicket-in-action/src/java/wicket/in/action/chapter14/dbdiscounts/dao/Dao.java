package wicket.in.action.chapter14.dbdiscounts.dao;

import org.springframework.transaction.annotation.Transactional;

import wicket.in.action.chapter14.dbdiscounts.domain.DomainObject;

public interface Dao<T extends DomainObject> {

  @Transactional
  void delete(T o);

  public T load(long id);

  @Transactional
  void save(T o);
}