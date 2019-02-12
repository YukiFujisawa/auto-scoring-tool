package page.facelook

import geb.Page
import model.User

class FacelookUsersShowPage extends Page {
  static url = "/users/\\d+"
  static at = { title == "users_show" }
  static content = {
    userValue { name -> $("p", text: contains(name)) }
  }
}
