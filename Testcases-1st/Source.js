const { browser, element, by } = require("protractor/built");

describe ("Source page ",()=>{
  const DisplayName="A Source-06";
  

    it("Login to the application-testcase-001", async ()=>
    {
        browser.waitForAngularEnabled(false);
        browser.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
        browser.manage().window().maximize();
        console.log(await browser.getTitle());    
        expect(browser.getTitle()).toBe("Prism Admin");  
        await element(by.xpath("//*[@id='root']/div/div/div/div[2]/button")).click();
        browser.sleep(2000);
        await element(by.xpath("(//input[@id='Input_Username'])[1]")).sendKeys("admin@1st.com");
        await element(by.xpath("(//input[@id='Input_Password'])[1]")).sendKeys("admin");
        await element(by.xpath("//button[@value='login']")).click();
        console.log("Testcase 001 passed");
            
    });
    it("Navigated to Source page-testcase-002", async ()=>
    {
        browser.sleep(1000);
        await element(by.xpath("//*[@id='root']/div/div[2]/div/div/div/div[1]/button[2]")).click();
        browser.sleep(1000);
        await element(by.xpath("//p[normalize-space()='Video Source']")).click();
        console.log("Testcase 002 passed");
        browser.sleep(1000);     
    });

    it("Select the org and unit-Testcase-006", async () => {
      await element(by.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall css-niyuos'])[1]")).click();
      browser.sleep(1000);
      const optionToSelectOrg = "Test_Org";
      const allOrgs = element.all(by.xpath("(//li[@role='option'])"));
      browser.sleep(1000);
      allOrgs.each(function (orgElement) {
        orgElement.getText().then(function (orgName) {
          if (orgName === optionToSelectOrg) {
            orgElement.click();
          }
        });
      });

      browser.sleep(1000);
      await element(by.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/ul/div/form[2]/div/div/div/div")).click();
      browser.sleep(1000);
      const optionToSelectUnit = "Unit-01";
      browser.sleep(1000);
      const allOrgUnit = element.all(by.xpath("(//li[@role='option'])"));
      allOrgUnit.each(function (unitElement) {
        unitElement.getText().then(function (unitName) {
          if (unitName === optionToSelectUnit) {
            unitElement.click();
          }
        });
      });
      console.log("Testcase 006 passed-Suceessfully selected org and unit");
  });
  
    it("Add a new Source-testcase-004", async ()=>
    {
        browser.sleep(1000);
        const allOrg= element(by.xpath("//button[@title='Add Video Source']")).click();
        browser.sleep(2000);
        await element(by.xpath("//input[@id='Display-Name']")).sendKeys(DisplayName);
        browser.sleep(2000);
        await element(by.xpath("(//div[@id='Angle'])[1]")).click();
        await element(by.xpath("//li[normalize-space()='Backside']")).click();
        browser.sleep(4000);
        await element(by.xpath("(//div[@id='Video Encoder Display Name'])[1]")).click();
        await element(by.xpath("//li[@role='option'][1]")).click();
        browser.sleep(4000);
        await element(by.xpath("(//input[@id=':rbm:'])[1]")).sendKeys("01:02:03");
        browser.sleep(4000);
        await element(by.xpath("(//input[@id=':rbo:'])[1]")).sendKeys("01:02:03");
        browser.sleep(4000);
        await element(by.xpath("(//button[normalize-space()='Add'])[1]")).click();
        browser.sleep(1000);
        console.log("Testcase 004 passed");
    });
    it("Verify that the Updated the Sources - testcase-005", async () => {
        browser.sleep(1000);
        const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
        await firstMenu.click();
        browser.sleep(1000);
        element(by.xpath("//li[normalize-space()='Edit']")).click();
        await element(by.xpath("//input[@id='Source-Name']")).sendKeys("123");
        await element(by.xpath("//input[@id='Source-ID']")).sendKeys("werr");
        browser.sleep(2000);
        await element(by.xpath("(//button[normalize-space()='Update'])[1]")).click();
        browser.sleep(1000);
        console.log("Updated successfully");
        const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
        const successMessageText = await successMessage.getText();
        console.log(successMessageText);
        expect(successMessageText).toBe("Video Source Successfully Updated");
        console.log("Testcase 006 passed");
      });
  
    it("List all options in the console-testcase 006", async () => {
        browser.sleep(2000);
        const EC = protractor.ExpectedConditions;
        const elementToWaitFor =await element(by.xpath("(//div[@role='menu'])[1]"));
        await browser.wait(EC.visibilityOf(elementToWaitFor), 10000); // Wait up to 10 seconds for visibility
        await elementToWaitFor.click();
        const optionElements = element.all(by.xpath("//li[@role='menuitem']"));
        optionElements.each(async (optionElement) => {
          const optionText = await optionElement.getText();
          browser.sleep(2000);
          console.log(optionText);
        })
          browser.sleep(2000);

    });
    
    it("Verify that the disable functionality is working - testcase-007", async () => {
        const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
        await firstMenu.click();
        const confirmationMenuItem = element(by.xpath("//li[normalize-space()='Disable']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(confirmationMenuItem), 5000, 'Confirmation menu item is not visible');
        await confirmationMenuItem.click();
        const yesButton = element(by.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]"));
        await yesButton.click();
        console.log("Disabled successfully");
        const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
        const successMessageText = await successMessage.getText();
        console.log(successMessageText);
        expect(successMessageText).toBe("Video Source Successfully Disabled");
      });
      it("Verify that the Active/Inactive Sources - testcase-008", async () => {
        await element(by.xpath("//input[@name='gilad']")).click();
        console.log("All the active/Inactive Sources are visible");
      });
      it("Verify that the enable functionality is working - testcase-009", async () => {
        const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
        await firstMenu.click();
        browser.sleep(2000);
        const confirmationMenuItem = element(by.xpath("//li[normalize-space()='Enable']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(confirmationMenuItem), 5000, 'Confirmation menu item is not visible');
        await confirmationMenuItem.click();
        const yesButton = element(by.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]"));
        await yesButton.click();
        console.log("Enabled successfully");
        const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
        const successMessageText = await successMessage.getText();
        console.log(successMessageText);
        expect(successMessageText).toBe("Video Source Successfully Enabled");
      });
      it("Verify that the delete functionality is working - testcase-010", async () => {
        const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
        await firstMenu.click();
        browser.sleep(2000);
        const confirmationMenuItem = element(by.xpath("//li[normalize-space()='Delete']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(confirmationMenuItem), 5000, 'Confirmation menu item is not visible');
        await confirmationMenuItem.click();
        const yesButton = element(by.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]"));
        await yesButton.click();
        console.log("Deleted successfully");
        const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
        const successMessageText = await successMessage.getText();
        console.log(successMessageText);
        expect(successMessageText).toBe("Video Source Successfully Deleted");
      });
        
});
      





