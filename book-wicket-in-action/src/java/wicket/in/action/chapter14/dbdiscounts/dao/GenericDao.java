package wicket.in.action.chapter14.dbdiscounts.dao;

public interface GenericDao {

  public <T> T load(Class<T> type, long id);
}
