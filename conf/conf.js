// An example configuration file.
// require("babel-register")({
//   presets: ["es2015"]
// });
exports.config = {
  directConnect: true,

  // Capabilities to be passed to the webdriver instance.
  capabilities: {
    'browserName': 'firefox'
  },

  // Framework to use. Jasmine is recommended.
  framework: 'jasmine',

  // Spec patterns are relative to the current working directory when
  // protractor is called.
  specs: ['..//Testcases-1st//Encoder.js'],

  // SELENIUM_PROMISE_MANAGER: false,

  // Options to be passed to Jasmine.
  jasmineNodeOpts: {
    defaultTimeoutInterval: 60000
  }
};
