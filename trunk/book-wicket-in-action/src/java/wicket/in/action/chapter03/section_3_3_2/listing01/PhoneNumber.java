package wicket.in.action.chapter03.section_3_3_2.listing01;

public final class PhoneNumber {
  private Integer areaCode;

  private Integer prefix;

  private Integer suffix;

  public PhoneNumber() {
  }

  public Integer getAreaCode() {
    return areaCode;
  }

  public Integer getPrefix() {
    return prefix;
  }

  public Integer getSuffix() {
    return suffix;
  }

  public void setAreaCode(Integer areaCode) {
    this.areaCode = areaCode;
  }

  public void setPrefix(Integer prefix) {
    this.prefix = prefix;
  }

  public void setSuffix(Integer suffix) {
    this.suffix = suffix;
  }

  @Override
  public String toString() {
    return "(" + areaCode + ") " + prefix + "-" + suffix;
  }
}
