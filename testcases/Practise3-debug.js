
const { driver } = require("protractor");

describe("Sampletest",() =>{
     it("open", async () =>
    {
        await browser.get("https://letcode.in/edit");
        await browser.manage().window().maximize();
        
    });
    it("Enter name", async () =>
    {       
        await element(by.id("fullName")).sendKeys("Helen");
        
    });
    it("Append the TAB",async() =>
    {
        await element.all(by.id("join")).sendKeys("Helen", protractor.Key.TAB);
        
    });
    it("Get the value",async() =>
    {
        let getMe= await element(by.id("getMe"));
        let value= await getMe.getAttribute("value");
        console.log(value);
    });
    it("Clear the value",async() =>
    {
        await element(by.id("clearMe")).clear();
        browser.sleep(5000);
    });
    it("Disabled value",async() =>
    {
        let isEditable= await element(by.id("noEdit")).isEnabled();
        
        console.log(await isEditable);
        expect (isEditable).toBe(false);
        
    });



})