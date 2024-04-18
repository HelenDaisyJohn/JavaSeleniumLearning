import unittest
import time

from selenium.webdriver.chrome.service import Service
from selenium import webdriver
from POM.Pages.Login import LoginPage

class LoginTestCase(unittest.TestCase):
    BaseURL="https://prism-web.dev.1stbet.com/"
    serv_obj = Service("C:\\Driver\\ChromeDriver\\chromedriver.exe")
    driver = webdriver.Chrome(service=serv_obj)
    driver.implicitly_wait(5)

    @classmethod
    def setUpClass(cls):
        cls.driver.get("https://prism-web.dev.1stbet.com/")
        cls.driver.maximize_window()

    @classmethod
    def tearDown(cls):
        cls.driver.close()


if __name__ == '__main__':
    unittest.main()