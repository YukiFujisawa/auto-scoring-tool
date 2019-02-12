package fixture.factory

import model.User

class UserFactory {
  static create(String type = null) {
    User user = createDefault()
    if (type == null) {
      return user
    }
  }

  static private createDefault() {
    return new User(
        userName: "user_name_default",
        mail: "user_mail_default@exmple.com",
        password: "password",
        passwordConfirm: "password"
    )
  }
}
