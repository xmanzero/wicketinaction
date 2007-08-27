package wicket.in.action.chapter09.locales;

import java.util.Arrays;
import java.util.Locale;

import org.apache.wicket.markup.html.WebPage;

public class SelectLocaleWithResetPage extends WebPage {

  public SelectLocaleWithResetPage() {
    add(new LocaleDropDownWithReset("localeSelect", Arrays
        .asList(new Locale[] { Locale.ENGLISH, Locale.GERMAN,
            Locale.SIMPLIFIED_CHINESE })));
  }
}
