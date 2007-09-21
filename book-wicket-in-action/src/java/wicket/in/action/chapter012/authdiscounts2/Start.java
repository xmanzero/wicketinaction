/*
 * $Id: Start.java,v 1.3 2006/06/12 04:53:34 hillenius Exp $
 * $Revision: 1.3 $
 * $Date: 2006/06/12 04:53:34 $
 * 
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.in.action.chapter012.authdiscounts2;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.security.HashUserRealm;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Seperate startup class for people that want to run the examples
 * directly.
 */
public class Start {

  /**
   * Main function, starts the jetty server.
   * 
   * @param args
   */
  public static void main(String[] args) {

    Server server = new Server(8080);
    WebAppContext ctx = new WebAppContext("./src/webapp",
        "/wicket-in-action");
    server.addHandler(ctx);

    HashUserRealm realm = new HashUserRealm();
    realm.addUserToRole("user", "user");
    realm.addUserToRole("admin", "admin");

    // ETC... forget about this now. Not that important for the book

    try {
      server.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
