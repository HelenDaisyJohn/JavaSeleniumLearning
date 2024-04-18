import unittest
import time

from selenium.webdriver.chrome.service import Service
from selenium import webdriver
from POM.Pages.EncoderPage import Encoder_page


class EncoderTestCase(unittest.TestCase):

    Org = "Org_01"
    Unit="Unit_01"
    BaseURL="https://prism-web.dev.1stbet.com/"
    serv_obj = Service("C:\\Driver\\ChromeDriver\\chromedriver.exe")
    driver = webdriver.Chrome(service=serv_obj)
    driver.implicitly_wait(5)

    @classmethod
    def setUpClass(cls):
        cls.driver.get(cls.BaseURL)
        cls.driver.maximize_window()


    def test_navigateToEncoder(self):
        lp=Encoder_page(self.driver)
        time.sleep(3)
        lp.navigateToEncoder(self.driver)
        time.sleep(3)
        lp.selectOrg(self.Org)
        time.sleep(3)
        lp.selectOrgUnit(self.Unit)
        time.sleep(3)
        lp.verifyTitle(self.BaseURL)


    @classmethod
    def tearDown(cls):
        cls.driver.close()

if __name__ == '__main__':
    unittest.main()