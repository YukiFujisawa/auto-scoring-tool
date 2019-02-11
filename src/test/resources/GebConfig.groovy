/*
	This is the Geb configuration file.
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

waiting {
    timeout = 4
}

driver = {
    new ChromeDriver()
    // new ChromeDriver(new ChromeOptions().addArguments('headless'))
}
environments {
    Facelook {
        baseUrl = "http://0.0.0.0:3000"
    }
    Gebish {
        baseUrl = "http://gebish.org"
    }
}

