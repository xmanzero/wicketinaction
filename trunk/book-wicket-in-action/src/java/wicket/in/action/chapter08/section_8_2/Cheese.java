package wicket.in.action.chapter08.section_8_2;

import java.io.Serializable;

public class Cheese implements Serializable {
  private String name;

  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
