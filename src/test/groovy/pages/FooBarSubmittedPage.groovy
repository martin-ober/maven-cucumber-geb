package pages

import geb.Page
import org.openqa.selenium.By

class FooBarSubmittedPage extends Page {
    static url = "foobarsubmit.jsp"
    static at = { $("h2").text() == "Foobar submitted!" }
    static content = {
        foo { $(By.id("foo")) }
        bar { $(By.id("bar")) }
    }

    def clickFooBar() {
        $("a").click()
    }

/*    def foo() {
        return foo.text()
    }

    def bar() {
        return bar.text()
    }*/
}