package wicket.in.action.chapter03.section_3_3_1.listing01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ContactDao {
  private static final List<Contact> contacts = Collections
      .synchronizedList(new ArrayList<Contact>());

  private static String[][] data = {
      { "Doe, John", "206", "555", "1234" },
      { "Hilton, Paris", "207", "555", "4412" },
      { "Bush, George", "502", "911", "4532" }, };

  static {
    // populate our list of contacts with data
    for (int i = 0; i < data.length; i++) {
      PhoneNumber number = new PhoneNumber();
      number.setAreaCode(Integer.valueOf(data[i][1]));
      number.setPrefix(Integer.valueOf(data[i][2]));
      number.setSuffix(Integer.valueOf(data[i][3]));

      Contact contact = new Contact();
      contact.setName(data[i][0]);
      contact.setNumber(number);
      contacts.add(contact);
    }
  }

  public static List getContacts() {
    return contacts;
  }

  public static void save(Contact contact) {
    if (!contacts.contains(contact)) {
      contacts.add(contact);
    }
  }

  public static void delete(Contact contact) {
    contacts.remove(contact);
  }
}
