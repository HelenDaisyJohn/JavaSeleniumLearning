const { browser } = require("protractor/built");
const { v4: uuidv4 } = require('uuid');
describe ("Organization page ",()=>{
    const fullUUID = uuidv4();
    // const DisplayName = fullUUID.slice(0, 4);
    // const ShortName = DisplayName;
    DisplayName= "Test_Org";
    const UnitName = fullUUID.slice(0, 4);
    EncoderDisplayName="EncoderDisplayName";
    const EncoderID = fullUUID.slice(0, 4);
    DecoderID="DecoderID";
    VendorChannelID="VendorChannelID";
    ProjectID="ProjectID";
    Zone="Zone";
    InstanceName="InstanceName";
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
    // it("Create a new organization-Testcase 003",async() =>
    // {
    //     browser.sleep(2000);
    //     await element(by.xpath("//button[@title='Add Organization']")).click();
    //     await element(by.xpath("//input[@id='Display-Name']")).sendKeys(DisplayName);
    //     await element(by.xpath("//input[@id='Short-Name']")).sendKeys(ShortName);
    //     await element(by.xpath("(//button[normalize-space()='Add'])[1]")).click();
    //     console.log("Testcase 003 passed");

    // });
    it("check the searching functionality-Testcase 008",async() =>
    {
        browser.sleep(1000);
        const search = DisplayName;  
        await element(by.xpath("//input[@type='search']")).sendKeys(search);
        browser.sleep(1000);
        console.log("Testcase 007 passed");
        
    });
    it("Verify that the user is navigated to unit-Testcase 011",async() =>
    {
        browser.sleep(2000);
        const checkbox = element(by.xpath("(//p[contains(text(),'" + DisplayName + "')])[1]"));
        browser.sleep(1000);
        await checkbox.click();
        // expect(isSelected).toBe(false); // If it's not selected
        console.log("Testcase 005 passed");
        browser.sleep(1000);
        
    });
    it("Verify that the user can create a new unit-Testcase 011",async() =>
    {
        browser.sleep(3000);
        await element(by.xpath("(//button[@aria-label='more'])[1]")).click();
        browser.sleep(3000);
        await element(by.xpath("(//li[@role='menuitem'][normalize-space()='Add Organization Unit'])[1]")).click();
        browser.sleep(3000);
        await element(by.xpath("//input[@id='Display-Name']")).sendKeys(UnitName);
        browser.sleep(3000);
        await element(by.xpath("(//input[@id='Short-Name'])[1]")).sendKeys(UnitName);
        browser.sleep(3000);
        await element(by.xpath("(//div[@id='Type'])[1]")).click();
        browser.sleep(3000);
        await element(by.xpath("(//li[normalize-space()='generic'])[1]")).click();
        browser.sleep(3000);
        await element(by.xpath("(//button[normalize-space()='Add'])[1]")).click();
        console.log("Testcase 003 passed");
    });
    it("Navigated to Encoder page-testcase-002", async ()=>
    {
        browser.sleep(1000);
        await element(by.xpath("//*[@id='root']/div/div[2]/div/div/div/div[1]/button[2]")).click();
        browser.sleep(1000);
        await element(by.xpath("//p[normalize-space()='Video Encoder']")).click();
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
    it("Add a new Encoder-Testcase-007", async ()=>
    {
        browser.sleep(2000);
        const allOrg= element(by.xpath("//button[@title='Add Video Encoder']")).click();
        // browser.sleep(1000);
        await element(by.xpath("//input[@id='Encoder-Name']")).sendKeys(EncoderDisplayName);
        // browser.sleep(1000);
        await element(by.xpath("(//input[@id='Encoder-ID'])[1]")).sendKeys(EncoderID);
        // browser.sleep(1000);
        await element(by.xpath("(//button[normalize-space()='Add'])[1]")).click();
        browser.sleep(1000);
        const successMessage = element(by.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']"));
        await browser.wait(protractor.ExpectedConditions.visibilityOf(successMessage), 5000, 'Success message is not visible');
        const successMessageText = await successMessage.getText();
        console.log(successMessageText);
        expect(successMessageText).toBe("Video Encoder Successfully Added");
        console.log("Testcase 007 passed-Video Encoder Successfully Added");
    });
    it("Navigated to Decoder page-testcase-002", async ()=>
    {
        browser.sleep(1000);
        await element(by.xpath("//*[@id='root']/div/div[2]/div/div/div/div[1]/button[2]")).click();
        browser.sleep(1000);
        await element(by.xpath("//p[normalize-space()='Video Decoder']")).click();
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







})