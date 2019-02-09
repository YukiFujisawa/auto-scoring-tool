/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

waiting {
	timeout = 4
}

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = {
			new ChromeDriver(new ChromeOptions().addArguments('headless'))
		}
	}

	// run via “./gradlew chromeHeadlessTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chromeGui {
		driver = {
			new ChromeDriver()
		}
	}
}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://gebish.org"
