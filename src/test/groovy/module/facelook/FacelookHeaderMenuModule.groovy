package module.facelook

import geb.Module

class FacelookHeaderMenuModule extends Module {
  static content = {
    loginLink { $(autotest: "login_link") }
  }
}
