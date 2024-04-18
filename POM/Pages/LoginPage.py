import time

from selenium import webdriver
from selenium.webdriver.common.by import By


class LoginPage():

    def __init__(self,driver):
        self.driver = driver
        self.driver_Login_xpath="//*[@id='root']/div/div/div/div[2]/button"
        self.button_login_xpath = "//*[@id='root']/div/div/div/div[2]/button"
        self.textbox_username_xpath="(//input[@id='Input_Username'])[1]"
        self.textbox_password_xpath = "(//input[@id='Input_Password'])[1]"
        self.button_submit_xpath = "//button[@value='login']"


    def LoginURL(self,LoginURL):
        self.driver.get(LoginURL)
        time.sleep(2)

    def Login(self):
        self.driver.find_element(By.XPATH, self.driver_Login_xpath).click()
        time.sleep(3)
        # self.driver.find_element(By.XPATH, self.button_login_xpath).click()
        # time.sleep(2)

    def loginwithValidData(self,email,password):
        self.driver.find_element(By.XPATH, self.textbox_username_xpath).send_keys(email)
        time.sleep(2)
        self.driver.find_element(By.XPATH, self.textbox_password_xpath).send_keys(password)
        time.sleep(2)

    def clickLoginButton(self):
        self.driver.find_element(By.XPATH, self.button_submit_xpath).click()



