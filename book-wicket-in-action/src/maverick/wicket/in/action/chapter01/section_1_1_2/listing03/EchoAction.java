package wicket.in.action.chapter01.section_1_1_2.listing03;

import org.infohazard.maverick.ctl.FormBeanUser;
import org.infohazard.maverick.flow.ControllerContext;

public class EchoAction extends FormBeanUser {

  @Override
  protected Object makeFormBean(ControllerContext cctx) {
    return new EchoForm();
  }

  @Override
  protected String perform(Object formBean, ControllerContext cctx)
      throws Exception {
    return SUCCESS;
  }
}
