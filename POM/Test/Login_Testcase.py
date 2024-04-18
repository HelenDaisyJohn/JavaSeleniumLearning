import unittest
import time
from selenium.webdriver.chrome.service import Service
from selenium import webdriver
from POM.Pages.LoginPage import LoginPage
from POM.Pages.OrgPage import OrgPage
from POM.Pages.OrgUnitPage import OrgUnitPage

class LoginTestCase(unittest.TestCase):
    LoginURL = "https://prism-web.dev.1stbet.com/"
    email = "admin@1st.com"
    password = "admin"
    displayName= "Org_Test3"
    shortName= "Org_Test3"
    DisplayNameOrg ="Unit_14"
    ShortNameOrg ="Unit_14"
    serv_obj = Service("C:\\Driver\\ChromeDriver\\chromedriver.exe")
    driver = webdriver.Chrome(service=serv_obj)
    driver.implicitly_wait(3)

    @classmethod
    def setUpClass(cls):
        cls.driver.get(cls.LoginURL)
        cls.driver.maximize_window()

    def test_login(self):
        lp = LoginPage(self.driver)
        time.sleep(3)
        lp.Login()
        lp.loginwithValidData(self.email,self.password)
        lp.clickLoginButton()


        ap= OrgPage(self.driver)
        time.sleep(2)
        ap.hamburger()
        ap.addValidOrg(self.displayName,self.shortName)
        time.sleep(2)


        op=OrgUnitPage(self.driver)
        time.sleep(2)
        op.navigateToOrgUnit()
        time.sleep(2)
        op.addOrgUnit(self.displayName, self.DisplayNameOrg, self.ShortNameOrg)



    @classmethod
    def tearDown(cls):
        cls.driver.close()

if __name__ == '__main__':
    unittest.main()