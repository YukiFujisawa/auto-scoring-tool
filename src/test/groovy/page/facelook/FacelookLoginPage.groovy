package page.facelook

import geb.Page
import module.facelook.FacelookHeaderMenuModule

class FacelookLoginPage extends Page {
  static url = "/sessions/new"
  static at = { title == "login" }
  static content = {
    headerMenu { module(FacelookHeaderMenuModule) }
    userForm(cache: true) { $("form") }
    userInput { inputName -> userForm.$("input", name: inputName) }
    emailInput { userInput("session[email]") }
    passwordInput { userInput("session[password]") }
    submitButton { userForm.$("input", type: "submit") }
  }
}
