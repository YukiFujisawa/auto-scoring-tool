package module.facelook

import geb.Module

class FacelookHeaderMenuModule extends Module {
  static content = {
    signUpLink { $(class: "sign_up_link") }
  }
}
