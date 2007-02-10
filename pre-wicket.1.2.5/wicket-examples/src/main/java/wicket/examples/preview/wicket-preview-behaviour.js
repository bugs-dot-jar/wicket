dojo.require("dojo.io.*");

function insertPreview(element, url) {
  dojo.io.bind({
    url: url,
    load: function(type, data, evt) { 
      if (url.indexOf('/') != -1) {
        var path = url.substring(0, url.lastIndexOf('/') + 1);
        data = data.replace(/wicket:preview=\"/g, "wicket:preview=\"" + path);
      }
      element.innerHTML = data;

      //remove attribute to prevent infinite recursion
      element.removeAttribute('wicket:preview');

      //apply rules to newly included components
      Behaviour.apply();
    },
    mimetype: "text/plain"
  });
}

var myrules = {
  'div': function(element) {
    var url = element.getAttribute('wicket:preview');
    if (url) {
      insertPreview(element, url);
    }
  }
};

Behaviour.register(myrules);



