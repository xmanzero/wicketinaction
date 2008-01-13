package wicket.in.action.chapter14.dbdiscounts.dao;

public interface GenericDao {

  <T> T load(Class<T> type, long id);
}
