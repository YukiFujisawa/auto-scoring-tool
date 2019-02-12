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
        userName: "test_user_default",
        mail: "test_user_default@exmple.com",
        password: "password",
        passwordConfirm: "password"
    )
  }
}
