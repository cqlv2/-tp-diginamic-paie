
ajax("http://localhost:8080/entreprise",setEntreprise);
ajax("http://localhost:8080/profil_remuneration",setProfil);
ajax("http://localhost:8080/grade",setGrade);

function setEntreprise(data){
  var entrepriseSelect = document.getElementById("entrepriseId");
  for (var i = 0; i < data.length; i++) {
    var opt=document.createElement("option");
    opt.setAttribute("value",data[i].id);
    opt.innerHTML=data[i].denomination;
    entrepriseSelect.appendChild(opt);
  }
}

function setProfil(data){
  var profilSelect = document.getElementById("profileId");
  for (var i = 0; i < data.length; i++) {
    var opt=document.createElement("option");
    opt.setAttribute("value",data[i].id);
    opt.innerHTML=data[i].code;
    profilSelect  .appendChild(opt);
  }
}

function setGrade(data){
  var gradeSelect = document.getElementById("gradeId");
  for (var i = 0; i < data.length; i++) {
    var opt=document.createElement("option");
    opt.setAttribute("value",data[i].id);
    opt.innerHTML=data[i].code;
    gradeSelect.appendChild(opt);
  }
}

function sendForm(){
  var formJson=
  {
      "matricule" : document.querySelector("input#matricule").value,
      "entrepriseId" : document.querySelector("select#entrepriseId").value,
      "profilRemunerationId" : document.querySelector("select#profileId").value,
      "gradeId" : document.querySelector("select#gradeId").value
  }
  ajaxSubmit("http://localhost:8080/remuneration_employer",confirm, formJson);

}

function confirm(){
  console.log("enregistrer");
}
