package spec.facelook

import fixture.factory.UserFactory
import geb.spock.GebReportingSpec
import helper.GebDebugUtil
import model.User
import page.facelook.FacelookTopPage
import page.facelook.FacelookUsersNewPage
import page.facelook.FacelookUsersShowPage

class FacelookBasicSpec extends GebReportingSpec {

  def "Basic case"() {
    setup:
    User userDefault = UserFactory.create()

    expect: "トップ画面から開始"
    to FacelookTopPage

    when: "ログインリンクをクリックした場合"
    headerMenu.loginLink.click()

    then: "ユーザー新規ページに遷移すること"
    waitFor { at FacelookUsersNewPage }

    when:
    inputForm(userDefault)
    submitButton.click()

    then:
    waitFor { at FacelookUsersShowPage }
  }
}