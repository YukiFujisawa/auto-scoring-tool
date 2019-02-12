package page.facelook

import geb.Page
import model.User

class FacelookUsersShowPage extends Page {
  static url = "/users/\\d+"
  static at = { title == "users_show" }

  String convertToPath(User user) {
    "/${manual.version}/index.html"
  }
}
