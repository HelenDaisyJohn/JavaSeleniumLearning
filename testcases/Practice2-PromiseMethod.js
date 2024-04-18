
const { browser } = require("protractor/built");

describe ("Promise Method ",()=>{
    it("async awit", async ()=>
    {
        browser.waitForAngularEnabled(false);
        browser.get("https://prism-web.dev.1stbet.com/");
        // browser.waitForReact();        
        console.log(await browser.getTitle());           
    })
});