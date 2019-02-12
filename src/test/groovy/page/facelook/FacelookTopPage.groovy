package page.facelook

import geb.Page
import module.facelook.FacelookHeaderMenuModule

class FacelookTopPage extends Page {
  static url = "/"
  static at = { title == "top" }
  static content = {
    headerMenu { module(FacelookHeaderMenuModule) }
  }


}
