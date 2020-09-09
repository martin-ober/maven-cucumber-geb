package pages

import geb.Page

class IndexPage extends Page {
    static url = ""
    static at = { $("h2").text() == "Hello Foobar!" }

    def clickFooBar() {
        $("a").click()
    }
}