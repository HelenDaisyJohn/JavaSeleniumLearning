const { browser, element, by } = require("protractor/built");
describe('why to use protractor', ()=>{
    it('super calculator',async ()=>{
        browser.get("https://juliemr.github.io/protractor-demo/");
        await element(by.xpath("//input[@ng-model='first']")).sendKeys("10");
        await element(by.xpath("//input[@ng-model='second']")).sendKeys("5");
        await element(by.id("gobutton")).click();
        let result= await element(by.tagName("h2")).getText();
        console.log("The result is:"+result);
        

    })
    
})