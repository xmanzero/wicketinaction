package wicket.in.action;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.target.coding.BookmarkablePageRequestTargetUrlCodingStrategy;
import org.apache.wicket.request.target.coding.HybridUrlCodingStrategy;
import org.apache.wicket.request.target.coding.IndexedHybridUrlCodingStrategy;
import org.apache.wicket.request.target.coding.IndexedParamUrlCodingStrategy;
import org.apache.wicket.request.target.coding.MixedParamUrlCodingStrategy;
import org.apache.wicket.settings.ISecuritySettings;
import org.apache.wicket.util.io.IObjectStreamFactory;
import org.apache.wicket.util.lang.Objects;
import org.apache.wicket.util.lang.PackageName;

import wicket.in.action.chapter06.links.BookmarkableMountedCheeseDetailsPage;
import wicket.in.action.chapter06.links.HybridMountedCheeseDetailsPage;
import wicket.in.action.chapter06.links.IndexedHybridMountedCheeseDetailsPage;
import wicket.in.action.chapter06.links.IndexedMountedCheeseDetailsPage;
import wicket.in.action.chapter06.links.LinksPage;
import wicket.in.action.chapter06.links.MixedMountedCheeseDetailsPage;
import wicket.in.action.chapter07.Chapter07;
import wicket.in.action.chapter07.section_7_1.FormsPage;
import wicket.in.action.chapter07.section_7_2.FormProcessingPage;
import wicket.in.action.chapter07.section_7_3.TextComponentsPage;
import wicket.in.action.chapter07.section_7_4.SelectionComponentsPage;
import wicket.in.action.chapter07.section_7_5.SubmitComponentsPage;
import wicket.in.action.chapter07.section_7_6.ValidationsPage;
import wicket.in.action.chapter07.section_7_7.FeedbackPage;
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
    mountBookmarkablePage("/signin", SigninPage.class);

    mountBookmarkablePage("/examples-7.1", FormsPage.class);
    mountBookmarkablePage("/examples-7.2", FormProcessingPage.class);
    mountBookmarkablePage("/examples-7.3", TextComponentsPage.class);
    mountBookmarkablePage("/examples-7.4", SelectionComponentsPage.class);
    mountBookmarkablePage("/examples-7.5", SubmitComponentsPage.class);
    mountBookmarkablePage("/examples-7.6", ValidationsPage.class);
    mountBookmarkablePage("/examples-7.7", FeedbackPage.class);

    mountBookmarkablePage("/chapter-6/links", LinksPage.class);
    mount(new BookmarkablePageRequestTargetUrlCodingStrategy("/chapter-6/details1", BookmarkableMountedCheeseDetailsPage.class, null));
    mount(new IndexedParamUrlCodingStrategy("/chapter-6/details2", IndexedMountedCheeseDetailsPage.class));
    mount(new MixedParamUrlCodingStrategy("/chapter-6/details3", MixedMountedCheeseDetailsPage.class, new String[]{"id"}));
    mount(new HybridUrlCodingStrategy("/chapter-6/details4", HybridMountedCheeseDetailsPage.class));
    mount(new IndexedHybridUrlCodingStrategy("/chapter-6/details5", IndexedHybridMountedCheeseDetailsPage.class));
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