package spec.facelook

import fixture.factory.UserFactory
import geb.spock.GebReportingSpec
import model.User
import page.facelook.FacelookLoginPage
import page.facelook.FacelookTopPage
import page.facelook.FacelookUsersNewPage
import page.facelook.FacelookUsersShowPage
import spock.lang.Shared
import spock.lang.Stepwise

@Stepwise
class FacelookBasicSpec extends GebReportingSpec {

  @Shared
  User userDefault = UserFactory.create();

  def "会員登録機能のテスト"() {

    expect: "テスト開始"
    to FacelookTopPage

    when: "トップページ：ログインリンクをクリックした場合"
    headerMenu.signUpLink.click()

    then: "新規会員登録ページに遷移すること"
    waitFor { at FacelookUsersNewPage }

    when: "新規会員登録ページ：登録フォームに入力＆送信した場合"
    inputForm(userDefault)
    submitButton.click()

    then: "会員詳細ページに遷移すること"
    waitFor { at FacelookUsersShowPage }

    and: "入力した情報が表示されていること"
    !userValue(userDefault.userName).isEmpty()
    !userValue(userDefault.email).isEmpty()

    when: "会員詳細ページ：ログアウトリンクをクリックした場合"
    headerMenu.logoutLink.click()

    then: "ログインページに遷移すること"
    waitFor { at FacelookLoginPage }
  }

  def "会員退会機能のテスト"() {
    expect: "テスト開始"
    to FacelookLoginPage

    when: "ログインページ：ログイン処理した場合"
    emailInput = userDefault.email
    passwordInput = userDefault.password
    submitButton.click()

    then: "ユーザー詳細画面に遷移すること"
    waitFor { at FacelookUsersShowPage }

    when: "会員詳細：退会リンクをクリック"
    headerMenu.quitLink.click()

    and: "ログインページに遷移してログイン処理した場合"
    to FacelookLoginPage
    emailInput = userDefault.email
    passwordInput = userDefault.password
    submitButton.click()

    then: "ログインできないこと"
    waitFor { at FacelookLoginPage }
  }
}