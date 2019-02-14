package module.facelook

import geb.Module

class FacelookHeaderMenuModule extends Module {
  static content = {
    showUserLink { $(class: "show_user_link") }
    loginLink { $(class: "login_link") }
    logoutLink { $(class: "logout_link") }
    signUpLink { $(class: "sign_up_link") }
    quitLink { $(class: "quit_link") }
    feedsLink { $(class: "feeds_link") }
  }
}
