package spec.facelook

import fixture.factory.UserFactory
import geb.spock.GebReportingSpec
import model.User
import page.facelook.FacelookTopPage
import page.facelook.FacelookUsersNewPage
import page.facelook.FacelookUsersShowPage
import spock.lang.Stepwise

@Stepwise
class FacelookBasicSpec extends GebReportingSpec {

  def "会員登録のテスト"() {
    setup:
    User userDefault = UserFactory.create()

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
    !userValue(userDefault.mail).isEmpty()
  }
}