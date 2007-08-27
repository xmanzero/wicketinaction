package wicket.in.action.chapter09.locales;

import java.util.Arrays;
import java.util.Locale;

import org.apache.wicket.markup.html.WebPage;

public class SelectLocalePage extends WebPage {

  public SelectLocalePage() {
    add(new LocaleDropDown("localeSelect", Arrays
        .asList(new Locale[] { Locale.ENGLISH, Locale.GERMAN,
            Locale.SIMPLIFIED_CHINESE })));
  }
}
