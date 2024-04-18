import unittest
import time
from selenium.webdriver.chrome.service import Service
from selenium import webdriver
from POM.Pages.LoginPage import LoginPage
from POM.Pages.OrgPage import OrgPage

class LoginTestCase(unittest.TestCase):
    LoginURL = "https://prism-web.dev.1stbet.com/"
    email = "admin@1st.com"
    password = "admin"
    displayName= "Org_Test4"
    shortName= "Org_Test4"
    serv_obj = Service("C:\\Driver\\ChromeDriver\\chromedriver.exe")
    driver = webdriver.Chrome(service=serv_obj)
    driver.implicitly_wait(3)

    @classmethod
    def setUpClass(cls):
        cls.driver.get(cls.LoginURL)
        cls.driver.maximize_window()

    def test_login(self):
        lp = LoginPage(self.driver)
        time.sleep(4)
        lp.clickLogin()
        time.sleep(2)
        lp.loginwithEmail(self.email)
        time.sleep(1)
        lp.loginwithPassword(self.password)
        time.sleep(1)
        lp.clickLoginButton()
        time.sleep(2)

    #def test_Org(self):
        ap= OrgPage(self.driver)
        time.sleep(2)
        ap.hamburger()
        time.sleep(2)
        ap.navigateToCore()
        time.sleep(2)
        ap.navigateToOrg()
        time.sleep(2)
        ap.navigateToAddOrg()
        time.sleep(2)
        ap.displayName(self.displayName)
        ap.shortName(self.shortName)
        time.sleep(2)
        ap.addOrg()
        time.sleep(2)

    @classmethod
    def tearDown(cls):
        cls.driver.close()

if __name__ == '__main__':
    unittest.main()