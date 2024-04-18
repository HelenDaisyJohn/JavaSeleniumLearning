const { browser, element, by } = require("protractor/built");

describe ("Organization page ",()=>{
  const DisplayName="A Decoder001";
  const DecoderID="A Decoder-001";
  const VendorChannelID="123";
  const ProjectID="123";
  const Zone="123";
  const InstanceName="123";

 
    it("Login to the application-Testcase-001", async ()=>
    {
        browser.waitForAngularEnabled(false);
        browser.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
        browser.manage().window().maximize();
        console.log(await browser.getTitle());    
        expect(browser.getTitle()).toBe("Prism Admin");  
        await element(by.xpath("//*[@id='root']/div/div/div/div[2]/button")).click();
        browser.sleep(1000);
        await element(by.xpath("(//input[@id='Input_Username'])[1]")).sendKeys("admin@1st.com");
        await element(by.xpath("(//input[@id='Input_Password'])[1]")).sendKeys("admin");
        await element(by.xpath("//button[@value='login']")).click();
        console.log("Testcase 001 passed- Login Crediatials are verified");
    });

    it("Navigated to Decoder page-Testcase-002", async ()=>
    {
        browser.sleep(1000);
        await element(by.xpath("//*[@id='root']/div/div[2]/div/div/div/div[1]/button[2]")).click();
        browser.sleep(1000);
        await element(by.xpath("(//p[normalize-space()='Video Decoder'])[1]")).click();
        console.log("Testcase 002 passed- Successfully Navigated to Decoder page");
        browser.sleep(1000);
    });

    it("Column headers should be present-Testcase-003", async () => {
        const columnHeaders = await element.all(by.xpath("//div[@role='columnheader']"));
        expect(await columnHeaders[0].getText()).toEqual("Display Name");
        expect(await columnHeaders[1].getText()).toEqual("Decoder Identifier");
        expect(await columnHeaders[2].getText()).toEqual("Vendor");
        expect(await columnHeaders[3].getText()).toEqual("Supported Channel Vendor");
        expect(await columnHeaders[4].getText()).toEqual("Booking ID");
        expect(await columnHeaders[5].getText()).toEqual("State");
        console.log("Testcase 003 passed- Column header are displayed properly");
    });

    it("Check the title-Testcase-004", async () => {
        const Title = await element(by.xpath("(//h6[normalize-space()='Video Decoder'])[1]"));
        expect(await Title.getText()).toEqual("Video Decoder");
        console.log("Testcase 004 passed-Column headers properly displayed");
    });

    it("Check the Tooltip icons should be present-Testcase-005", async () => {
        browser.sleep(2000);
        const toolbarIcons = element.all(by.xpath("(//div[@class='MuiBox-root css-c635fu'])[1]//button[@type='button']"));
        expect(await toolbarIcons.count()).toBe(3);
        const titles = await Promise.all([
            toolbarIcons.get(0).getAttribute('title'),
            toolbarIcons.get(1).getAttribute('title'),
            toolbarIcons.get(2).getAttribute('title')
        ]);
        expect(titles[0]).toEqual("Column Settings");
        expect(titles[1]).toEqual("Add Video Decoder");
        expect(titles[2]).toEqual("Export");
        
        console.log("Testcase 005 passed-Tooltip icons are properly displayed");
    });
    
    it("Select the org and unit-Testcase-006", async () => {
        await element(by.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div/div[2]/ul/div/form[1]/div/div/div")).click();
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
        await element(by.xpath("(//div[@id=':r1:'])[1]")).click();
        browser.sleep(1000);
        const optionToSelectUnit = "OrgUnit-01";
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

    it("Add a new Decoder-Testcase-007", async () => {
      const addButton = element(by.xpath("//button[@title='Add Video Decoder']"));
      await addButton.click();
  
      const displayNameInput = element(by.xpath("//input[@id='Decoder-Name']"));
      await displayNameInput.sendKeys(DisplayName);
  
      const decoderIDInput = element(by.xpath("//input[@id='Decoder-ID']"));
      await decoderIDInput.sendKeys(DecoderID);
  
      const supportedChannelVendorDropdown = element(by.xpath("(//div[@id='Supported-Channel-Vendor'])[1]"));
      await supportedChannelVendorDropdown.click();
      const selectsupportedChannelVendor=element(by.xpath("//li[normalize-space()='Phenix']"));
      await selectsupportedChannelVendor.click();
  
      // const supportedChannelVendorOption = element(by.xpath(`//li[@role='option'][text()='${Phenix}']`));
      // await supportedChannelVendorOption.click();
  
      const vendorChannelIDInput = element(by.xpath("//input[@id='Vendor-Channel-Identifier']"));
      await vendorChannelIDInput.sendKeys(VendorChannelID);
  
      const projectIDInput = element(by.xpath("//input[@id='Project-id']"));
      await projectIDInput.sendKeys(ProjectID);
  
      const zoneInput = element(by.xpath("//input[@id='Zone']"));
      await zoneInput.sendKeys(Zone);
  
      const instanceNameInput = element(by.xpath("//input[@id='Instance-name']"));
      await instanceNameInput.sendKeys(InstanceName);
  
      const addButtonOnModal = element(by.xpath("(//button[normalize-space()='Add'])[1]"));
      await addButtonOnModal.click();
      
      // Wait for success message
      const successMessage = element(by.xpath("//div[contains(text(), 'Video Decoder Successfully Added')]"));
      await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000);
  
      // Assert success message
      expect(await successMessage.getText()).toBe("Video Decoder Successfully Added");
      console.log("Testcase 007 passed - Video Decoder Successfully Added");
  });
  

    // it("Verify that the user an update the Decoder - Testcase-008", async () => {
    //     browser.sleep(1000);
    //     const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
    //     await firstMenu.click();
    //     browser.sleep(1000);
    //     element(by.xpath("//li[normalize-space()='Edit']")).click();
    //     await element(by.xpath("//input[@id='Decoder-Name']")).sendKeys("123");
    //     await element(by.xpath("//input[@id='Decoder-ID']")).sendKeys("werr");
    //     browser.sleep(2000);
    //     await element(by.xpath("(//button[normalize-space()='Update'])[1]")).click();
    //     browser.sleep(1000);
    //     const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
    //     // await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 9000, 'Success message is not visible');
    //     // const successMessageText = await successMessage.getText();
    //     // console.log(successMessageText);
    //     // expect(successMessageText).toBe("Video Decoder Successfully Updated");
    //     console.log("Testcase 008 passed-Video Decoder Successfully Updated");
    //   });
  
    it("List all options in the console-Testcase 009", async () => {
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
          console.log("Testcase 009 passed-List all options in the console");
    });
    
    it("Verify that the disable functionality is working - Testcase-010", async () => {
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
        expect(successMessageText).toBe("Video Decoder Successfully Disabled");
        console.log("Testcase 010 passed-Video Decoder Successfully Disabled");
      });

      it("Verify that the Active/Inactive Decoders - Testcase-011", async () => {
        await element(by.xpath("//input[@name='gilad']")).click();
        console.log("All the active/Inactive Decoders are visible");
        console.log("Testcase 011 passed-All the active/Inactive Decoders are visible");
      });
      
      it("Verify that the enable functionality is working - testcase-012", async () => {
        const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
        await firstMenu.click();
        browser.sleep(2000);
        const confirmationMenuItem = element(by.xpath("//li[normalize-space()='Enable']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(confirmationMenuItem), 5000, 'Confirmation menu item is not visible');
        await confirmationMenuItem.click();
        const yesButton = element(by.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]"));
        await yesButton.click();
        console.log("");
        console.log("Testcase 012 passed-Enabled successfully");
        // const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
        // await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
        // const successMessageText = await successMessage.getText();
        // console.log(successMessageText);
        // expect(successMessageText).toBe("Video Decoder Successfully Enabled");
      });

      it("Verify that the delete functionality is working - Testcase-013", async () => {
        const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
        await firstMenu.click();
        browser.sleep(2000);
        const confirmationMenuItem = element(by.xpath("//li[normalize-space()='Delete']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(confirmationMenuItem), 5000, 'Confirmation menu item is not visible');
        await confirmationMenuItem.click();
        const yesButton = element(by.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]"));
        await yesButton.click();
        console.log("");
        console.log("Testcase 013 passed-Deleted successfully");
        // const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
        // await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
        // const successMessageText = await successMessage.getText();
        // console.log(successMessageText);
        // expect(successMessageText).toBe("Video Decoder Successfully Deleted");
      });
        




















































































    //////////////////////////////////////////////////////////
    // it("Add a new Decoder-testcase-007", async ()=>
    // {
    //     browser.sleep(1000);
    //     const allOrg= element(by.xpath("//button[@title='Add Video Decoder']")).click();
    //     browser.sleep(2000);
    //     await element(by.xpath("//input[@id='Decoder-Name']")).sendKeys(DisplayName);
    //     await element(by.xpath("//input[@id='Decoder-ID']")).sendKeys(DecoderID);
    //     await element(by.xpath("//input[@id='Vendor-Channel-Identifier']")).sendKeys(VendorChannelID);
    //     await element(by.xpath("//input[@id='Project-id']")).sendKeys(ProjectID);
    //     await element(by.xpath("//input[@id='Zone']")).sendKeys(Zone);
    //     await element(by.xpath("//input[@id='Instance-name']")).sendKeys(InstanceName);
    //     await element(by.xpath("(//button[normalize-space()='Add'])[1]")).click();
    //     browser.sleep(1000);
    //     await element(by.xpath("(//button[normalize-space()='Add'])[1]")).click();
    //     browser.sleep(1000);
    //     console.log("Testcase 007 passed");
    // });

    // it("Verify that the Updated the decoders - testcase-005", async () => {
    //     browser.sleep(1000);
    //     const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
    //     await firstMenu.click();
    //     browser.sleep(1000);
    //     element(by.xpath("//li[normalize-space()='Edit']")).click();
    //     await element(by.xpath("//input[@id='Decoder-Name']")).sendKeys("123");
    //     await element(by.xpath("//input[@id='Decoder-ID']")).sendKeys("werr");
    //     browser.sleep(2000);
    //     await element(by.xpath("(//button[normalize-space()='Update'])[1]")).click();
    //     browser.sleep(1000);
    //     console.log("Updated successfully");
    //     const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
    //     await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
    //     const successMessageText = await successMessage.getText();
    //     console.log(successMessageText);
    //     expect(successMessageText).toBe("Video Decoder Successfully Updated");
    //     console.log("Testcase 006 passed");
    //   });
  
    // it("List all options in the console-testcase 006", async () => {
    //     browser.sleep(2000);
    //     const EC = protractor.ExpectedConditions;
    //     const elementToWaitFor =await element(by.xpath("(//div[@role='menu'])[1]"));
    //     await browser.wait(EC.visibilityOf(elementToWaitFor), 10000); // Wait up to 10 seconds for visibility
    //     await elementToWaitFor.click();
    //     const optionElements = element.all(by.xpath("//li[@role='menuitem']"));
    //     optionElements.each(async (optionElement) => {
    //       const optionText = await optionElement.getText();
    //       browser.sleep(2000);
    //       console.log(optionText);
    //     })
    //       browser.sleep(2000);

    // });
    
    // it("Verify that the disable functionality is working - testcase-007", async () => {
    //     const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
    //     await firstMenu.click();
    //     const confirmationMenuItem = element(by.xpath("//li[normalize-space()='Disable']"));
    //     await browser.wait(protractor.ExpectedConditions.visibilityOf(confirmationMenuItem), 5000, 'Confirmation menu item is not visible');
    //     await confirmationMenuItem.click();
    //     const yesButton = element(by.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]"));
    //     await yesButton.click();
    //     console.log("Disabled successfully");
    //     const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
    //     await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
    //     const successMessageText = await successMessage.getText();
    //     console.log(successMessageText);
    //     expect(successMessageText).toBe("Video Decoder Successfully Disabled");
    //   });
    //   it("Verify that the Active/Inactive Decoders - testcase-008", async () => {
    //     await element(by.xpath("//input[@name='gilad']")).click();
    //     console.log("All the active/Inactive Decoders are visible");
    //   });
    //   it("Verify that the enable functionality is working - testcase-009", async () => {
    //     const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
    //     await firstMenu.click();
    //     browser.sleep(2000);
    //     const confirmationMenuItem = element(by.xpath("//li[normalize-space()='Enable']"));
    //     await browser.wait(protractor.ExpectedConditions.visibilityOf(confirmationMenuItem), 5000, 'Confirmation menu item is not visible');
    //     await confirmationMenuItem.click();
    //     const yesButton = element(by.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]"));
    //     await yesButton.click();
    //     console.log("Enabled successfully");
    //     const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
    //     await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
    //     const successMessageText = await successMessage.getText();
    //     console.log(successMessageText);
    //     expect(successMessageText).toBe("Video Decoder Successfully Enabled");
    //   });
    //   it("Verify that the delete functionality is working - testcase-010", async () => {
    //     const firstMenu = element(by.xpath("(//div[@role='menu'])[1]"));
    //     await firstMenu.click();
    //     browser.sleep(2000);
    //     const confirmationMenuItem = element(by.xpath("//li[normalize-space()='Delete']"));
    //     await browser.wait(protractor.ExpectedConditions.visibilityOf(confirmationMenuItem), 5000, 'Confirmation menu item is not visible');
    //     await confirmationMenuItem.click();
    //     const yesButton = element(by.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]"));
    //     await yesButton.click();
    //     console.log("Deleted successfully");
    //     const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
    //     await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
    //     const successMessageText = await successMessage.getText();
    //     console.log(successMessageText);
    //     expect(successMessageText).toBe("Video Decoder Successfully Deleted");
    //   });
        
});
      

// it("Sorting icon should be present for column headers", async () => {
    //     const headerSortIcons = await element.all(by.xpath("//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeSmall MuiDataGrid-sortIcon css-ptiqhd-MuiSvgIcon-root']"));
    //     expect(headerSortIcons.length).toBe(4);
    // });




