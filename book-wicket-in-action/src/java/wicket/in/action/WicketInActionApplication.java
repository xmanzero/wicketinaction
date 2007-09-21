package wicket.in.action;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.ISecuritySettings;
import org.apache.wicket.util.io.IObjectStreamFactory;
import org.apache.wicket.util.lang.Objects;

import wicket.in.action.chapter012.authdiscounts2.DiscountsPage;
import wicket.in.action.common.SigninPage;
import wicket.in.action.common.WiaAuthorizationStrategy;
import wicket.in.action.common.WiaSession;

public class WicketInActionApplication extends WebApplication {

  @Override
  public Class<? extends Page> getHomePage() {
    return Index.class;
  }

  @Override
  public Session newSession(Request request, Response response) {
    return new WiaSession(request);
  }

  @Override
  protected void init() {

    Objects
        .setObjectStreamFactory(new IObjectStreamFactory.DefaultObjectStreamFactory());

    getDebugSettings().setAjaxDebugModeEnabled(false);
    getMarkupSettings().setStripWicketTags(true);
    getResourceSettings().setThrowExceptionOnMissingResource(false);

    WiaAuthorizationStrategy authStrat = new WiaAuthorizationStrategy();
    ISecuritySettings securitySettings = getSecuritySettings();
    securitySettings.setAuthorizationStrategy(authStrat);
    securitySettings
        .setUnauthorizedComponentInstantiationListener(authStrat);

    // securitySettings.setEnforceMounts(true);
    mountBookmarkablePage("/discounts", DiscountsPage.class);
    mountBookmarkablePage("/signin", SigninPage.class);

    addComponentInstantiationListener(new IComponentInstantiationListener() {
      public void onInstantiation(final Component component) {
        if (!getSecuritySettings().getAuthorizationStrategy()
            .isInstantiationAuthorized(component.getClass())) {
          getSecuritySettings()
              .getUnauthorizedComponentInstantiationListener()
              .onUnauthorizedInstantiation(component);
        }
      }
    });
  }
}