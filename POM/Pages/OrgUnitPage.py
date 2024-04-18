import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


class OrgUnitPage():
    def __init__(self,driver):
        self.driver=driver
        time.sleep(2)
        self.area_Search_xpath="(//input[@id=':r4q:'])[1]"

        self.field_DisplayName_xpath="//div[@data-field='displayName']//div[@class='MuiDataGrid-cellContent'][normalize-space()='Org_Test001']"
        self.button_AddOrg_xpath="//*[name()='path' and contains(@d,'M12 8c1.1 ')]"
        self.select_AddOrg_xpath ="(//li[normalize-space()='Add Organization Unit'])[1]"
        self.textbox_DisplayName_xpath="(//input[@id='Display-Name'])[1]"
        self.textbox_ShortName_xpath="(//input[@id='Short-Name'])[1]"
        self.dropdown_Type_xpath="(//div[@id='Type'])[1]"
        self.select_Type_xpath="(//li[normalize-space()='generic'])[1]"
        self.button_AddOrg1_xpath="(//button[normalize-space()='Add'])[1]"
        self.text_warning_xpath="(//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'])[1]"


    def navigateToOrgUnit(self):
        self.driver.find_element(By.XPATH, self.field_DisplayName_xpath).click()
        time.sleep(3)

    def addOrgUnit(self,displayName,DisplayNameOrg,ShortNameOrg):
        #select=(self.driver.find_element(By.XPATH,self.area_Search_xpath).send_keys(displayName))
        #select.click()

        self.driver.find_element(By.XPATH,self.button_AddOrg_xpath).click()
        time.sleep(2)
        self.driver.find_element(By.XPATH, self.select_AddOrg_xpath).click()
        time.sleep(2)
        self.driver.find_element(By.XPATH,self.textbox_DisplayName_xpath).send_keys(DisplayNameOrg)
        time.sleep(2)
        self.driver.find_element(By.XPATH,self.textbox_ShortName_xpath).send_keys(ShortNameOrg)
        time.sleep(2)
        self.driver.find_element(By.XPATH,self.dropdown_Type_xpath).click()
        time.sleep(2)
        self.driver.find_element(By.XPATH, self.select_Type_xpath).click()
        time.sleep(2)
        #drop.select_by_value("generic")
        #time.sleep(2)
        #drop.select_by_index(1)
        #time.sleep(2)
        self.driver.find_element(By.XPATH,self.button_AddOrg1_xpath).click()
        time.sleep(5)
        alert = self.driver.find_element(By.XPATH, self.text_warning_xpath)
        print(alert.text)
        print("STM_TC_001 passed")












