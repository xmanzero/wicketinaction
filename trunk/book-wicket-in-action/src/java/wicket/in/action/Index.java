package wicket.in.action;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Index extends AbstractBasePage {
  public Index() {
    super("");
    add(new BookmarkablePageLink("chapter01.section.1.1.2",
        wicket.in.action.chapter01.section_1_1_2.Index.class));
    add(new BookmarkablePageLink("chapter01.section.1.4.1",
        wicket.in.action.chapter01.section_1_4_1.Index.class));
    add(new BookmarkablePageLink("chapter01.section.1.4.2",
        wicket.in.action.chapter01.section_1_4_2.Index.class));
    add(new BookmarkablePageLink("chapter01.section.1.4.3",
        wicket.in.action.chapter01.section_1_4_3.Index.class));
    add(new BookmarkablePageLink("chapter01.section.1.4.4",
        wicket.in.action.chapter01.section_1_4_4.Index.class));
    add(new BookmarkablePageLink("chapter01.section.1.4.5",
        wicket.in.action.chapter01.section_1_4_5.Index.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter09.customcomponents",
        wicket.in.action.chapter09.locales.Index.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter09.cheeseoffers",
        wicket.in.action.chapter09.discounts.Index.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter10.ajaxdiscounts",
        wicket.in.action.chapter011.ajaxdiscounts.Index.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter10.ajax.dojo",
        wicket.in.action.chapter011.ajax.dojo.Index.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter11.authdiscounts.Index",
        wicket.in.action.chapter012.authdiscounts.Index.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter11.authdiscounts2.Index",
        wicket.in.action.chapter012.authdiscounts2.Index.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter12.resdiscounts.Index",
        wicket.in.action.chapter010.resdiscounts.DiscountsPage.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter12.resdiscounts2.Index",
        wicket.in.action.chapter010.resdiscounts2.DiscountsPage.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter12.resdiscounts3.Index",
        wicket.in.action.chapter010.resdiscounts3.DiscountsPage.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter12.jcaptcha.JCaptcha",
        wicket.in.action.chapter010.jcaptcha.JCaptcha.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter12.jcaptchacomp.JCaptcha",
        wicket.in.action.chapter010.jcaptchacomp.CaptchaPage.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter13.locdiscounts.Index",
        wicket.in.action.chapter13.locdiscounts.Index.class));
    add(new BookmarkablePageLink(
        "wicket.in.action.chapter13.locdiscounts2.Index",
        wicket.in.action.chapter13.locdiscounts2.Index.class));
  }
}