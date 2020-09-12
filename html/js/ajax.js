
function ajax(url, callback){
  var req = new XMLHttpRequest();
  req.responseType = 'json';
  req.open("get", url);
  req.addEventListener("load", function (){
    if (req.status >= 200 && req.status < 400){
      callback(req.response);
    }
    else{
      console.error(req.status + " " + req.statusText + " " + url);
      return false;
    }
  });
  req.addEventListener("error", function (){
    console.error("Erreur réseau avec l'URL " + url);
  });
  req.send(null);
  return true;
}

function ajaxSubmit(url,callback, jsonData){
  var req = new XMLHttpRequest();
  req.responseType = 'json';
  req.open("post", url);
  req.setRequestHeader("Content-Type", "application/json")
  req.addEventListener("load", function ()
  {
    if (req.status >= 200 && req.status < 400){
      callback(req.response);
    }else{
      console.error(req.status + " " + req.statusText + " " + url);
      return false;
    }
  });
  req.addEventListener("error", function (){
    console.error("Erreur réseau avec l'URL " + url);
  });
  if (jsonData) req.send(JSON.stringify(jsonData));
  else req.send(null);
  return true;
}
