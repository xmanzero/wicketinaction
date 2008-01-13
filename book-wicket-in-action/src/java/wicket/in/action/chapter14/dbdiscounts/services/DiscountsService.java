package wicket.in.action.chapter14.dbdiscounts.services;

import java.util.List;

import wicket.in.action.chapter14.dbdiscounts.domain.Cheese;
import wicket.in.action.chapter14.dbdiscounts.domain.Discount;
import wicket.in.action.chapter14.dbdiscounts.domain.User;

public interface DiscountsService {

  <T> T load(Class<T> type, long id);

  List<Cheese> findAllCheeses();

  List<User> findAllUsers();

  List<Discount> findAllDiscounts();

  void saveCheese(Cheese cheese);

  void saveUser(User user);

  void saveDiscount(Discount discount);

  void deleteCheese(Cheese cheese);

  void deleteUser(User user);

  void deleteDiscount(Discount discount);
}
