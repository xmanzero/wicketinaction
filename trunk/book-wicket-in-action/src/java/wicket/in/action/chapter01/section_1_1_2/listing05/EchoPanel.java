/*
 * $Id: HelloWorld.java 4942 2006-03-14 22:38:34 -0800 (Tue, 14 Mar 2006)
 * ivaynberg $ $Revision: 1.2 $ $Date: 2006-03-14 22:38:34 -0800 (Tue, 14 Mar
 * 2006) $
 * 
 * ==================================================================== Licensed
 * under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the
 * License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.in.action.chapter01.section_1_1_2.listing05;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * The simple echo form as a reusable panel.
 * 
 * @author Eelco Hillenius
 */
public class EchoPanel extends Panel {

  /**
   * Constructor.
   * 
   * @param id
   *          the component's id
   * @param messageModel
   *          the model to operate on
   */
  public EchoPanel(String id, IModel messageModel) {

    super(id);
    add(new Label("msg", messageModel));
    Form form = new Form("form");
    add(form);
    form.add(new TextField("msgInput", messageModel));
  }
}