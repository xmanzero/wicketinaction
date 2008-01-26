package wicket.in.action.chapter15.section_15_1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.TestPanelSource;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wicket.in.action.chapter04.section_4_1.Cart;
import wicket.in.action.chapter04.section_4_1.Cheese;
import wicket.in.action.chapter04.section_4_1.CheesrApplication;
import wicket.in.action.chapter04.section_4_1.CheesrSession;
import wicket.in.action.chapter04.section_4_3.Checkout;
import wicket.in.action.chapter04.section_4_3.ShoppingCartPanel;

public class HelloWorldTest {
  private static WicketTester tester;

  @BeforeClass
  public static void setupTester() {
  }

  @Before
  public void setupTest() {
    tester = new WicketTester();
    tester.setupRequestAndResponse();
  }

  @Test
  public void labelContainsHelloWorld() {
    tester.startPage(HelloWorld.class);
    tester.assertLabel("message", "Hello, World!");
    tester.assertContains("H[ae]llo, (were|Wor)ld!");
    tester.assertModelValue("message", "Hello, World!");
    assertEquals("Hello, World!", tester.getTagByWicketId("message")
        .getValue());
  }

  @Test
  public void labelContainsHelloWorldInFrench() {
    tester.getWicketSession().setLocale(Locale.FRENCH);
    tester.startPage(HelloWorld.class);
    tester.assertLabel("message", "Bonjour tout le monde!");
    tester.assertModelValue("message", "Bonjour tout le monde!");
  }

  @Test
  public void labelContainsHelloWorldInDutch() {
    tester.getWicketSession().setLocale(new Locale("nl"));
    tester.startPage(HelloWorld.class);
    tester.assertLabel("message", "Hallo, wereld!");
  }

  @Test
  public void helloWorldPanelTest() {
    tester.setupRequestAndResponse();
    tester.startPanel(HelloWorldPanel.class);
    tester.assertLabel("panel:message", "Hello, World!");
  }

  @Test
  public void countingLinkClickTest() {
    tester.setupRequestAndResponse();
    tester
        .startPage(wicket.in.action.chapter01.section_1_3.Index.class);
    tester.assertModelValue("label", 0);
    tester.clickLink("link");
    tester.assertModelValue("label", 1);
  }

  @Test
  public void countingAjaxLinkClickTest() {
    tester.setupRequestAndResponse();
    tester
        .startPage(wicket.in.action.chapter01.section_1_3.Index.class);
    tester.assertModelValue("ajaxlabel", 0);
    tester.clickLink("ajaxlink", true);
    tester.assertComponentOnAjaxResponse("ajaxlabel");
    tester.assertModelValue("ajaxlabel", 1);
    tester.setupRequestAndResponse(true);
    tester.getComponentFromLastRenderedPage("ajaxlabel")
        .setModelObject(1000);
    tester.clickLink("ajaxlink", true);
    tester.assertComponentOnAjaxResponse("ajaxlabel");
    tester.assertModelValue("ajaxlabel", 1001);
  }

  @Test
  public void echoFormTest() {
    tester.setupRequestAndResponse();
    tester
        .startPage(wicket.in.action.chapter01.section_1_3.Index.class);
    tester.assertLabel("echo", "");
    FormTester formTester = tester.newFormTester("form");
    assertEquals("", formTester.getTextComponentValue("field"));
    formTester.setValue("field", "Echo message");
    formTester.submit("button");
    tester.assertLabel("echo", "Echo message");
    assertEquals("", formTester.getTextComponentValue("field"));

    // get a new form tester as the old one is 'depleted'
    formTester = tester.newFormTester("form");
    formTester.setValue("field", "Echo message2");
    formTester.submit("button");
    tester.assertLabel("echo", "Echo message2");
    assertEquals("", formTester.getTextComponentValue("field"));
  }

  private CheesrSession session;

  @Test
  public void checkoutTest() {
    tester = new WicketTester(new CheesrApplication());
    tester.startPage(Checkout.class);

    FormTester formTester = tester.newFormTester("form");
    tester.assertNoErrorMessage();
    tester.assertNoInfoMessage();
    formTester.submit("order");
    tester.assertRenderedPage(Checkout.class);
    tester
        .assertErrorMessages(new String[] {
            "Field 'name' is required.",
            "Field 'street' is required.",
            "Field 'zipcode' is required.",
            "Field 'city' is required." });
  }

  @Test
  public void checkoutTestNl() {
    tester = new WicketTester(new CheesrApplication());
    tester.setupRequestAndResponse();
    tester.getWicketSession().setLocale(new Locale("nl"));
    tester.startPage(Checkout.class);

    FormTester formTester = tester.newFormTester("form");
    tester.assertNoErrorMessage();
    tester.assertNoInfoMessage();
    formTester.submit("order");
    tester.assertRenderedPage(Checkout.class);
    tester
        .assertErrorMessages(new String[] {
            "veld 'name' is verplicht.",
            "veld 'street' is verplicht.",
            "veld 'zipcode' is verplicht.",
            "veld 'city' is verplicht." });
  }

  @Test
  public void checkoutTest2() {
    tester = new WicketTester(new CheesrApplication());
    tester.startPage(Checkout.class);
    FormTester formTester = tester.newFormTester("form");
    formTester.setValue("name", "Pietje Puk");
    formTester.setValue("street", "Leidsestraat 11");
    formTester.setValue("zipcode", "abcdef");
    formTester.setValue("city", "Leiden");
    formTester.submit("order");
    tester.assertRenderedPage(Checkout.class);
    tester
        .assertErrorMessages(new String[] { "'abcdef' is not a valid Integer." });
  }

  @Test
  public void emptyShoppingCartPanel() {
    final Cart cart = new Cart();
    tester.startPanel(new TestPanelSource() {
      public Panel getTestPanel(String panelId) {
        return new ShoppingCartPanel(panelId, cart);
      }
    });

    tester.assertListView("panel:cart", Collections.EMPTY_LIST);
    tester.assertLabel("panel:total", "$0.00");
  }

  @Test
  public void filledShoppingCartPanel() {
    final Cart cart = new Cart();
    Cheese gouda = new Cheese("Gouda", "Gouda", 1.99);
    Cheese edam = new Cheese("Edam", "Edam", 2.99);
    cart.getCheeses().add(gouda);
    cart.getCheeses().add(edam);

    tester.startPanel(new TestPanelSource() {
      public Panel getTestPanel(String panelId) {
        return new ShoppingCartPanel(panelId, cart);
      }
    });

    tester.assertListView("panel:cart", Arrays.asList(gouda, edam));
    tester.assertLabel("panel:total", "$4.98");
    tester.assertLabel("panel:cart:0:name", "Gouda");
    
    tester.clickLink("panel:cart:0:remove");

    tester.assertListView("panel:cart", Arrays.asList(edam));
    tester.assertLabel("panel:total", "$2.99");
    tester.assertLabel("panel:cart:0:name", "Edam");
  }

  @Test
  public void autoLinkTest() {
    tester.setupRequestAndResponse();
    tester.startPage(AutoLinksPage.class);
    TagTester tagTester = tester.getTagById("menu");
    TagTester child = tagTester
        .getChild(
            "href",
            "?wicket:bookmarkablePage=%3Awicket.in.action.chapter15.section_15_1.HelloWorld");
  }
}
