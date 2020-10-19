
var page=0;
ajax("https://gestionaire-paie-cql.herokuapp.com/bulletin_salaire/liste?size=10&page="+page, getList);

function getList(data){
  console.log(data[0]);


  var listTr=document.querySelectorAll("tr");
  for (var i = 1; i < listTr.length; i++) {
    listTr[i].querySelector("td:nth-Child(1)").innerHTML="";
    listTr[i].querySelector("td:nth-Child(2)").innerHTML="";
    listTr[i].querySelector("td:nth-Child(3)").innerHTML="";
    listTr[i].querySelector("td:nth-Child(4)").innerHTML="";
    listTr[i].querySelector("td:nth-Child(5)").innerHTML="";
    listTr[i].querySelector("td:nth-Child(6)").innerHTML="";
    listTr[i].querySelector("td:nth-Child(7)").innerHTML="";
    if(data[i-1]){
      listTr[i].querySelector("td:nth-Child(1)").innerHTML="null";
      listTr[i].querySelector("td:nth-Child(2)").innerHTML="Du "+data[i-1].periode.dateDebut+" au "+data[i-1].periode.dateFin;
      listTr[i].querySelector("td:nth-Child(3)").innerHTML=data[i-1].matricule;
      listTr[i].querySelector("td:nth-Child(4)").innerHTML=data[i-1].salaireBrut;
      listTr[i].querySelector("td:nth-Child(5)").innerHTML=data[i-1].netImposable;
      listTr[i].querySelector("td:nth-Child(6)").innerHTML=data[i-1].netAPayer;
      var lien=document.createElement("a");
      lien.setAttribute("href","afficher.html?id="+data[i-1].id);
      lien.innerHTML="Afficher";
      listTr[i].querySelector("td:nth-Child(7)").appendChild(lien);
    }
  }
  var pagination=document.querySelector("span").innerHTML=page+1;
}


function nextPage(){
page++;
console.log(page);
ajax("http://localhost:8080/bulletin_salaire/liste?size=10&page="+page, getList);

}
function prevPage(){
  if(page>0){
    page--;
    ajax("http://localhost:8080/bulletin_salaire/liste?size=10&page="+page, getList);
  }
}
