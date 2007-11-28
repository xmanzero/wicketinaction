package wicket.in.action.chapter04.section_4_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;

public class CheesrApplication extends WebApplication {
  private List<Cheese> cheeses = Arrays.asList(new Cheese("Gouda",
      "Gouda is a yellowish Dutch[...]", 1.65), new Cheese("Edam",
      "Edam (Dutch Edammer) is a D[...]", 1.05), new Cheese(
      "Maasdam", "Maasdam cheese is a Dutc[...]", 2.35), new Cheese(
      "Brie", "Brie is a soft cows' milk c[...]", 3.15), new Cheese(
      "Buxton Blue", "Buxton Blue cheese i[...]", 0.99), new Cheese(
      "Parmesan", "Parmesan is a grana, a [...]", 1.99), new Cheese(
      "Cheddar", "Cheddar cheese is a hard[...]", 2.95), new Cheese(
      "Roquefort", "Roquefort is a ewe's-m[...]", 1.67), new Cheese(
      "Boursin", "Boursin Cheese is a soft[...]", 1.33), new Cheese(
      "Camembert", "Camembert is a soft, c[...]", 1.69), new Cheese(
      "Emmental", "Emmental is a yellow, m[...]", 2.39), new Cheese(
      "Reblochon", "Reblochon is a French [...]", 2.99));

  /**
   * Constructor
   */
  public CheesrApplication() {
  }

  @Override
  protected void init() {
    // some mount magic to make the transition from the wicket in
    // action application to the cheesr application seemless.
    mountBookmarkablePage("/section_4_1", wicket.in.action.chapter04.section_4_1.Index.class);
    mountBookmarkablePage("/section_4_2", wicket.in.action.chapter04.section_4_2.Index.class);
    mountBookmarkablePage("/section_4_3", wicket.in.action.chapter04.section_4_3.Index.class);
  }
  public static CheesrApplication get() {
    return (CheesrApplication) Application.get();
  }
  @Override
  public Session newSession(Request request, Response response) {
    return new CheesrSession(request);
  }

  @Override
  public Class<? extends Page> getHomePage() {
    return Index.class;
  }

  public List<Cheese> getCheeses() {
    return Collections.unmodifiableList(cheeses);
  }
}
