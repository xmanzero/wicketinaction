package wicket.in.action.chapter01.section_1_1_2.listing03;

public class EchoForm {
  String msg;

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return msg;
  }
}