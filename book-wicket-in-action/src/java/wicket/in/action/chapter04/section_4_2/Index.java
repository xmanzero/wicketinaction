package wicket.in.action.chapter04.section_4_2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import wicket.in.action.AbstractBasePage;

/**
 * Created by IntelliJ IDEA. User: dashorst Date: Sep 21, 2007 Time:
 * 8:27:57 PM To change this template use File | Settings | File
 * Templates.
 */
public class Index extends AbstractBasePage {
  public static class Address {
    private String street;

    /**
     * @return the street
     */
    public String getStreet() {
      return street;
    }

    /**
     * @param street
     *          the street to set
     */
    public void setStreet(String street) {
      this.street = street;
    }
  }

  public static class Customer {
    private String firstName;

    private String lastName;

    private Address address = new Address();

    /**
     * @return the firstName
     */
    public String getFirstName() {
      return firstName;
    }

    /**
     * @param firstName
     *          the firstName to set
     */
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
      return lastName;
    }

    /**
     * @param lastName
     *          the lastName to set
     */
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
      return address;
    }

    /**
     * @param address
     *          the address to set
     */
    public void setAddress(Address address) {
      this.address = address;
    }
  }

  public Index() {
    Customer customer = new Customer();
    customer.setFirstName("John");
    customer.setLastName("Doe");
    customer.getAddress().setStreet("Some street");

    add(new Label("firstname0", customer.getFirstName()));
    add(new Label("lastname0", customer.getLastName()));
    add(new Label("street0", customer.getAddress().getStreet()));

    add(new Label("firstname1", new Model(customer.getFirstName())));
    add(new Label("lastname1", new Model(customer.getLastName())));
    add(new Label("street1", new Model(customer.getAddress()
        .getStreet())));

    SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
    String time = df.format(new Date());
    Model staticClock = new Model(time);
    add(new Label("static", staticClock));

    Model dynamicClock = new Model() {
      @Override
      public Object getObject() {
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        String time = df.format(new Date());
        return time;
      }
    };
    add(new Label("dynamic", dynamicClock));

    add(new Link("refresh") {
      public void onClick() {
      }
    });
  }
}
