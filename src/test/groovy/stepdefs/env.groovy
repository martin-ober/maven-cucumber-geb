package stepdefs

import geb.Browser
import geb.binding.BindingUpdater

import org.openqa.selenium.OutputType
import org.openqa.selenium.WebDriverException

import static io.cucumber.groovy.Hooks.After
import static io.cucumber.groovy.Hooks.Before

def testBrowser

Before() { scenario ->
    println('env.groovy: before ... ' + scenario.name)
    testBrowser = new Browser()
    println(testBrowser)
    bindingUpdater = new BindingUpdater(binding, testBrowser)
    bindingUpdater.initialize()
}

After() { scenario ->
    println('env.groovy: after  ... success: ' + !scenario.failed)
    println(testBrowser)
    bindingUpdater.remove()

    if(scenario.failed) {
        try {
            scenario.embed(testBrowser.driver.getScreenshotAs(OutputType.BYTES), "image/png")
        } catch(WebDriverException e) {
            e.printStacktrace()
            // sometime firefox runs out of memory trying to take a screenshot, not a big deal so ignore
        } catch(MissingMethodException e) {
            // HTMLUnit doesn't support screenshots
            println('env.groovy: after  HTMLUnit doesn\'t support screenshots: ')
        }
    }
}