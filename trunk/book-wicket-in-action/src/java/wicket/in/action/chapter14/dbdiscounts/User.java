package wicket.in.action.chapter14.dbdiscounts;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  private boolean admin = false;

  private String fullname;

  private String wiaPassword;

  private String wiaUsername;

  public User() {
  }

  public User(String username, String password, String fullname,
      boolean isAdmin) {
    this.wiaUsername = username;
    this.wiaPassword = password;
    this.fullname = fullname;
    this.admin = isAdmin;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public String getWiaPassword() {
    return wiaPassword;
  }

  public String getWiaUsername() {
    return wiaUsername;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public void setWiaPassword(String password) {
    this.wiaPassword = password;
  }

  public void setWiaUsername(String username) {
    this.wiaUsername = username;
  }
}
