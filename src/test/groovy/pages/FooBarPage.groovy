package pages

import geb.Page

class FooBarPage extends Page {
    static url = "foobar.jsp"
    static at = { $("h2").text() == "Foobar" }
    static content = {
        form { $("form") }
        foo { form.find("input[name='foo']") }
        bar { form.find("input[name='bar']") }
        submit { form.find("input[type='submit']") }
    }

    def foobar(foo1, bar1) {
        foo = foo1
        bar = bar1
        submit.click()
    }
}