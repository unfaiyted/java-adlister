let path = "./src/main/webapp/js/"


const lib = require("./common/library.js");
const AdCategoriesLoader = require("./module/AdCategories.js");

(function() {

    AdCategoriesLoader.init();
  // SomeOtherModule.init();

    console.log(AdCategoriesLoader.test());

})();