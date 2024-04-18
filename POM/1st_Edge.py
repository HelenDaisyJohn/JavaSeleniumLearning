

from selenium import webdriver
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.by import By
import time

#driver = webdriver.Chrome("C:\\Drivers\\chromedriver")
serv_obj = Service("C:\\Driver\\EdgeDriver\\msedgedriver")
driver = webdriver.Edge(service=serv_obj)
print("sample test case started")
driver.maximize_window()
driver.get("https://prism-web.dev.1stbet.com/")
time.sleep(5)
driver.maximize_window()

driver.find_element(By.XPATH,"//*[@id='root']/div/div/div/div[2]/button").click()
time.sleep(2)
driver.find_element(By.XPATH,"//input[@placeholder='Username']").send_keys("admin@1st.com")
driver.find_element(By.XPATH, "//input[@placeholder='Password']").send_keys("admin")
driver.find_element(By.XPATH, "//button[@value='login']").click()
time.sleep(2)
driver.find_element(By.XPATH,"//button[@aria-label='menu']//*[name()='svg']").click()
time.sleep(2)
driver.find_element(By.XPATH,"//span[normalize-space()='Core']").click()
time.sleep(2)
driver.find_element(By.XPATH,'//p[normalize-space()="Organization"]').click()
time.sleep(2)
driver.find_element(By.XPATH,"//button[@title='Add Organization']").click()
time.sleep(2)
driver.find_element(By.XPATH,"//input[@id='Display-Name']").send_keys("Org_32100")
time.sleep(2)
driver.find_element(By.XPATH,"//input[@id='Short-Name']").send_keys("Org_321023")
time.sleep(2)
driver.find_element(By.XPATH,"(//button[normalize-space()='Add'])[1]").click()
time.sleep(1)
Alert=driver.find_element(By.XPATH,"(//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'])[1]")
# Alert = driver.switch_to.alert
print (Alert.text)
Title =driver.find_element(By.XPATH,"(//h1[normalize-space()='Prism Core Platform'])[1]")
print(Title)
time.sleep(2)
driver.close()



time.sleep(2)
