package page.facelook

import geb.Page
import geb.module.TextInput
import model.User
import module.facelook.FacelookHeaderMenuModule

class FacelookUsersNewPage extends Page {
  static url = "/users/new"
  static at = { title == "users_new" }
  static content = {
    headerMenu { module(FacelookHeaderMenuModule) }
    userForm(cache: true) { $("form") }
    userInput { inputName -> userForm.$("input", name: inputName) }
    userNameInput { userInput("user[name]") }
    emailInput { userInput("user[email]") }
    passwordInput { userInput("user[password]") }
    passwordConfirmInput { userInput("user[password_confirmation]") }
    submitButton { userForm.$("input", type: "submit") }
  }

  void inputForm(User user) {
    userNameInput = user.userName
    emailInput = user.mail
    passwordInput = user.password
    passwordConfirmInput = user.passwordConfirm
  }
}
