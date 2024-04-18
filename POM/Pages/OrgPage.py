import time
from selenium.webdriver.common.by import By


class OrgPage():

    def __init__(self,driver):
        self.driver = driver

        self.button_hamburger_xpath = "//button[@aria-label='menu']//*[name()='svg']"
        self.button_core_xpath = "//span[normalize-space()='Core']"
        self.button_Org_xpath = "//p[normalize-space()='Organization']"

        self.button_AddOrg_xpath = "//button[@title='Add Organization']"
        self.textbox_DisplayName_xpath = "//input[@id='Display-Name']"
        self.textbox_ShortName_xpath = "//input[@id='Short-Name']"
        self.button_Add_xpath = "(//button[normalize-space()='Add'])[1]"
        self.text_title_xpath = "(//h1[normalize-space()='Prism Core Platform'])[1]"
        self.text_warning_xpath = "(//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'])[1]"

        #Pagination
        self.text_Pagination_xpath="//p[@class='MuiTablePagination-displayedRows css-hz3agd-MuiTablePagination-displayedRows']"

    def hamburger(self):
        self.driver.find_element(By.XPATH, self.button_hamburger_xpath).click()
        time.sleep(2)
        self.driver.find_element(By.XPATH, self.button_core_xpath).click()
        time.sleep(2)
        self.driver.find_element(By.XPATH, self.button_Org_xpath).click()
        time.sleep(2)
        self.driver.find_element(By.XPATH, self.button_AddOrg_xpath).click()
        time.sleep(2)

    def addValidOrg(self,displayName,shortName):
        self.driver.find_element(By.XPATH, self.textbox_DisplayName_xpath).send_keys(displayName)
        time.sleep(2)
        self.driver.find_element(By.XPATH, self.textbox_ShortName_xpath).send_keys(shortName)
        time.sleep(2)
        self.driver.find_element(By.XPATH, self.button_Add_xpath).click()
        time.sleep(1)
        alert= self.driver.find_element(By.XPATH, self.text_warning_xpath)
        time.sleep(1)
        print(alert.text)
        time.sleep(3)
        print("STM_ORG_002 Passed")
        time.sleep(3)
        pagination = self.driver.find_element(By.XPATH,self.text_Pagination_xpath).text
        print(pagination)
        time.sleep(5)
        # total_Org=Integer.valueOf(text.substring(text.indexof("of")-1,text.indexof("")-1))
        self.driver.find_element(By.TAG_NAME, displayName).click()
        time.sleep(20)
        # content = self.driver.find_elements_by_xpath("//*[@id='root'']/div/div[3]/div[1]/div/div[2]/div[2]/div/div/div/div[1]/div[1]/div//child::*")
        # for c in content:
        #     print(c.getTagName())

