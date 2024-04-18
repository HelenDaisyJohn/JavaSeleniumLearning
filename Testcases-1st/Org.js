const { browser } = require("protractor/built");
const { v4: uuidv4 } = require('uuid');
describe ("Organization page ",()=>{
    const fullUUID = uuidv4();
    const DisplayName = fullUUID.slice(0, 4);
    const randomDigits = Math.floor(1000 + Math.random() * 9000);
    const ShortName = `Test-${DisplayName}-${randomDigits}`;
  
    it("Login to the application-testcase-001", async ()=>
    {
        browser.waitForAngularEnabled(false);
        browser.get("https://prism-web-hotfix-stm-prism-xpressbet.preprod.1stbet.com/");
        browser.manage().window().maximize();
        // browser.waitForReact();        
        console.log(await browser.getTitle());    
        expect(browser.getTitle()).toBe("Prism Admin");  
        await element(by.xpath("//*[@id='root']/div/div/div/div[2]/button")).click();
        browser.sleep(2000);
        await element(by.xpath("(//input[@id='Input_Username'])[1]")).sendKeys("admin@1st.com");
        await element(by.xpath("(//input[@id='Input_Password'])[1]")).sendKeys("admin");
        await element(by.xpath("//button[@value='login']")).click();
        console.log("Testcase 001 passed");
            
    });
    it("select organization-Testcase 002",async() =>
    {
        browser.sleep(1000);
        await element(by.xpath("//*[@id='root']/div/div[2]/div/div/div/div[1]/button[1]")).click();
        browser.sleep(1000);
        await element(by.xpath("//p[normalize-space()='Organization']")).click();
        console.log("Testcase 002 passed");
    });
    it("Create a new organization-Testcase 003",async() =>
    {
        browser.sleep(2000);
        await element(by.xpath("//button[@title='Add Organization']")).click();
        await element(by.xpath("//input[@id='Display-Name']")).sendKeys(DisplayName);
        await element(by.xpath("//input[@id='Short-Name']")).sendKeys(ShortName);
        await element(by.xpath("(//button[normalize-space()='Add'])[1]")).click();
        console.log("Testcase 003 passed");

    });
    it("Verify that the heading title-Testcase 004",async() =>
    {
      const columnHeaders = element.all(by.xpath("//div[@role='columnheader']"));
      browser.sleep(2000);
      const expectedheading1= 'Display Name';
      const expectedheading2= 'Short Name';
      const expectedheading3= 'Active/Inactive';
      const displayNameElement = element(by.xpath("//div[contains(text(),'Display Name')]"));
      expect(displayNameElement.getText()).toEqual(expectedheading1);
      console.log("Testcase 004 passed");
    });

    it("Column headers should be present-Testcase-005", async () => {
      const columnHeaders = await element.all(by.xpath("//div[@role='columnheader']"));
      expect(await columnHeaders[0].getText()).toEqual("Display Name");
      expect(await columnHeaders[1].getText()).toEqual("Short Name");
      expect(await columnHeaders[2].getText()).toEqual("Active/Inactive");
      console.log("Testcase 005 passed- Column header are displayed properly");
  });
    
    it("Verify that the display inactive checkbox is selected-Testcase 005",async() =>
    {
        browser.sleep(2000);
        const checkbox = element(by.xpath("(//input[@type='checkbox'])[1]"));
        const isSelected = await checkbox.isSelected();
        expect(isSelected).toBe(false); // If it's not selected
        console.log("Testcase 005 passed");
        
    });
    
    it('should search for an element in a dynamic web table with pagination-Testcase 006', async function () {
        const elementToFind = DisplayName; 
        
        const nextPageButton = element(by.xpath("(//button[@title='Go to next page'])[1]"));
        await browser.executeScript("arguments[0].scrollIntoView();", nextPageButton);
        async function searchElementInTable(elementText) {
          
          const rows = element.all(by.xpath('//div[@role="row"]'));
          
          for (let i = 0; i < rows.count(); i++) {
            const row = rows.get(i);
            // const columns = row.all(by.xpath('//div[@role="row"][1]'));
            
            // for (let j = 0; j < columns.count(); j++) {
              const cellText = await columns.get(i).getText();
              
              if (cellText === elementToFind) {
                return true; // Element found
              }
            }
          
          
          return false; // Element not found on this page
        }
      
        let found = false;
        while (!found) {
          browser.sleep(2000);
          await browser.executeScript('window.scrollTo(0, document.body.scrollHeight)');
          // await nextPageButton.click();
          browser.sleep(2000);
          found = await searchElementInTable(elementToFind);
          if (!found) {
            browser.sleep(3000);
            const nextButtonEnabled = await nextPageButton.isEnabled();
            if (nextButtonEnabled) {
              
              await nextPageButton.click();
              await browser.sleep(3000);
            } else {
              break; // No more pages to search
            }
        }
        }
        expect(found).toBe(true);
        console.log("Testcase 006 passed");
      });
      
    it('should verify that the "Next" button is disabled-Testcase 007', async function () {
      const nextButton = element(by.xpath("//button[@title='Go to next page']"));
    
      // Check if the "Next" button has the "disabled" attribute
      const isDisabled = await nextButton.getAttribute('disabled');
    
      // Assertion to check if the button is disabled
      expect(isDisabled).toBeTruthy(); // Expecting the "disabled" attribute to be present
      console.log("Testcase 007 passed");
      // OR
      // expect(isDisabled).toBe('true'); // Expecting the "disabled" attribute's value to be 'true'
    });
    it("check the searching functionality-Testcase 008",async() =>
    {
        browser.sleep(1000);
        const search = DisplayName;  
        await element(by.xpath("//input[@type='search']")).sendKeys(search);
        browser.sleep(1000);
        await element(by.xpath("//button[@aria-label='more']")).click();
        await element(by.xpath("//li[normalize-space()='Manage']")).click();
        // const getMe=await element(by.xpath("//p[contains(text(),'Test_Org')][1]"));
        
        // let value= await getMe.getAttribute("data-id");
        // console.log(value);
      
        // Assertion to check if the checkbox is selected
        // expect(isSelected).toBe(true); // If it's selected
        // OR
        // expect(isSelected).toBe(false); // If it's not selected
        console.log("Testcase 007 passed");
        
    });
    
    it("check the searching functionality-Testcase 010",async() =>
    {
        browser.sleep(1000);
        // Locate the parent element containing all the <li> options
        let parentElement = element(by.xpath("//ul[@role='menu']"));

// Locate all the <li> elements within the parent element
        let options = parentElement.all(by.tagName('li'));

// Iterate through the options and print their text
      for (let i = 0; i < options.length; i++) {
  // Get the current <li> element
      let option = options.get(i);

  // Retrieve and print its text
      option.getText().then((text) => {
        console.log(text);
      });

    }
    console.log("Testcase 010 passed");

  });
  it("Verify that the user is navigated to unit-Testcase 011",async() =>
    {
        browser.sleep(2000);
        const checkbox = element(by.xpath("(//p[contains(text(),'" + DisplayName + "')])[1]"));
        const isSelected = await checkbox.isSelected();
        expect(isSelected).toBe(false); // If it's not selected
        console.log("Testcase 011 passed");
        
    });
    it("check the searching functionality-Testcase 009",async() =>
    {
        browser.sleep(1000);
        await element(by.xpath("//button[@aria-label='more'][1]")).click();
        browser.sleep(1000);
        await element(by.xpath("(//li[normalize-space()='Add Organization Unit'])[1]")).click();
        await element(by.xpath("(//input[@id='Display-Name'])[1]")).sendKeys("un-0002");
        await element(by.xpath("(//input[@id='Short-Name'])[1]")).sendKeys("un-0002");
        await element(by.xpath("(//div[@id='Type'])[1]")).click();
        await element(by.xpath("//li[normalize-space()='generic']")).click();
        browser.sleep(3000);
        await element(by.xpath("(//button[normalize-space()='Add'])[1]")).click();
        browser.sleep(1000);
        const message = await element(by.xpath("(//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'])[1]")).getText();
        console.log("Testcase 006 passed", message);
        
    });


    



      



    






});
