package stepdefs

import pages.FooBarPage
import pages.FooBarSubmittedPage
import pages.IndexPage

import static io.cucumber.groovy.EN.*

Given(~"I'm at the index page") { ->
    println('calling index page')
    to IndexPage
    at IndexPage
    println('index page called')
}
When(~"I click 'Foobar'") { ->
    println('clicking foobar')
    page.clickFooBar()
}
Then(~"I see the foobar page") { ->
    at FooBarPage
}
Given(~"I'm at the foobar page") { ->
    to FooBarPage
    at FooBarPage
}
When("^I enter (.*) (.*)") { foo, bar ->
    at FooBarPage
    page.foobar(foo, bar)
}
Then(~"I see the foobar submit page") { ->
    at FooBarSubmittedPage
}
Then("^I see on page foobar submit the value (.*) for (.*)") { value, field->
    at FooBarSubmittedPage
    println 'field: ' + field
    println 'value: ' + value
    println page.foo.text()
    println page.bar.text()
    if (field == 'foo') {
        assert page.foo.text() == field + ': ' + value
    } else if (field == 'bar') {
        assert page.bar.text() == field + ': ' + value
    } else {
        assert false, 'field ' + field + ' unknown'
    }
}