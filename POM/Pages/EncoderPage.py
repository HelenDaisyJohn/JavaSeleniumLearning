import time
import self as self
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


class Encoder_page():
    def __init__(self, driver):

        self.driver = driver
        self.button_hamburger_xpath = "//*[name()='path' and contains(@d,'M3 18h18v-')]"
        self.button_video_xpath = "//span[normalize-space()='Video']"
        self.button_videoEncoder_xpath = "//p[normalize-space()='Video Encoder']"
        self.button_organization_xpath = "(//div[@id=':r1a:'])[1]"
        self.button_organizationUnit_xpath = "//div[@id=':r1b:']"
        self.pageTitle_xpath = "(//h6[normalize-space()='Video Encoder'])[1]"

    def navigateToEncoder(self, driver):
        driver = self.driver
        self.driver.find_element(By.XPATH, self.button_hamburger_xpath).click()
        self.driver.find_element(By.XPATH, self.button_video_xpath).click()
        self.driver.find_element(By.XPATH, self.button_videoEncoder_xpath).click()
        time.sleep(5)

    def selectOrg(self, Org):
        drop = Select(self.driver.find_element(By.XPATH, self.button_organization_xpath))
        drop.select_by_visible_text(Org)
        time.sleep(5)

    def selectOrgUnit(self, Unit):
        drop = Select(self.driver.find_element(By.XPATH, self.button_organizationUnit_xpath))
        drop.select_by_visible_text(Unit)
        time.sleep(5)

    def verifyTitle(self, BaseURL):
        driver = self.driver
        driver.get(BaseURL)
        self.actualTitle = "Video Encoder"
        self.expectedTitle = driver.find_element(By.XPATH, self.pageTitle_xpath).text
        print(self.expectedTitle)

    if self.actualTitle == self.expectedTitle:
        assert True
        print("Assertion Passed")
    else:
        assert False
        print("Assertion is not Passed")
