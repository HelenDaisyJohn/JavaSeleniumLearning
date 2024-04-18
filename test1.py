import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By


#driver = webdriver.Chrome("C:\\Drivers\\chromedriver")
serv_obj = Service("C:\\Driver\\chromedriver")
driver = webdriver.Chrome(service=serv_obj)
print("sample test case started")
driver.maximize_window()
driver.get("https://prism-web.dev.1stbet.com/")
