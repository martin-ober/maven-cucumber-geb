import io.github.bonigarcia.wdm.config.DriverManagerType
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

baseUrl = "http://localhost:8080/test-webapp/"

// FIXME environments not working -- don't know why ????
//environments {
//
//    firefox {
//        println 'creating firefox ...'
//        //createFirefoxBrowser(false)
//    }
//
//    firefoxhl {
//        println 'creating firefox headless ...'
//        createFirefoxBrowser(true)
//    }
//}
// FIXME simulating environments programatic
println "geb.env ... " + System.getProperty("geb.env")
createFirefoxBrowser(true)
switch (System.getProperty("geb.env")) {
    case 'firefox':
        createFirefoxBrowser(false)
        return
    case 'firefoxhl':
        return
    default:
        println '!!! kein Parameter geb.env gefunden ... using firefox headless!!!'
}

def createFirefoxBrowser(headlessMode) {
    println 'creating firefox driver ...'
    WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup()
    driver = {new FirefoxDriver(firefoxOptions(headlessMode))}
}


def firefoxOptions(headlessMode) {
    FirefoxOptions ffOptions = new FirefoxOptions()
    if (headlessMode) {
        ffOptions.addArguments("-headless", "--window-size=1280,1696")
    }
    return ffOptions
}
