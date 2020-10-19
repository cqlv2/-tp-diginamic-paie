id=(window.location.search.replace("?id=",""))
// ajax("http://localhost:8080/bulletin_salaire/affichage/"+id, getBulletin);

ajax("https://gestionaire-paie-cql.herokuapp.com/bulletin_salaire/affichage/"+id, getBulletin);

function getBulletin(data){
document.getElementById("periodeStart").innerHTML=data.periode.dateDebut;
document.getElementById("periodeEnd").innerHTML=data.periode.dateFin;
document.getElementById("matricule").innerHTML=data.matricule;
document.getElementById("entrepriseNom").innerHTML=data.nomEntreprise;
document.getElementById("numSiret").innerHTML=data.siretEntreprise;

document.getElementById("salaireBase").innerHTML=data.baseHoraire;
document.getElementById("tauxSalarial").innerHTML=data.tauxSalarial;
document.getElementById("montantSalarial").innerHTML=data.salaireBase;
document.getElementById("primeExep").innerHTML=data.primeExceptionnelle;
document.getElementById("salaireBrute").innerHTML=data.salaireBrut;

var tableCoti=document.getElementById("tableCotisation");
for (var i = 0; i < data.cotisations.length; i++) {

var ligne=document.createElement("tr");
var libelle = document.createElement("td");
libelle.innerHTML=data.cotisations[i].libelle.replace(" ", "&nbsp")
ligne.appendChild(libelle);
var base = document.createElement("td");
base.innerHTML=data.cotisations[i].base
ligne.appendChild(base);
var tauxSalarial = document.createElement("td");
tauxSalarial.innerHTML=data.cotisations[i].tauxSalarial
ligne.appendChild(tauxSalarial);
var montantSalarial = document.createElement("td");
montantSalarial.innerHTML=data.cotisations[i].montantSalarial
ligne.appendChild(montantSalarial);
var tauxPatronal = document.createElement("td");
tauxPatronal.innerHTML=data.cotisations[i].tauxPatronal
ligne.appendChild(tauxPatronal);
var cotisationPatronal = document.createElement("td");
cotisationPatronal.innerHTML=data.cotisations[i].cotisationPatronal
ligne.appendChild(cotisationPatronal);

tableCoti.appendChild(ligne);

}
var ligne=document.createElement("tr");
for (var i = 0; i < 6; i++) {
  var empty = document.createElement("td");
  ligne.appendChild(empty);

}
tableCoti.appendChild(ligne);

var ligne=document.createElement("tr");
var td = document.createElement("td");
td.innerHTML="Total retenue";
ligne.appendChild(td);

var empty = document.createElement("td");
ligne.appendChild(empty);
var empty = document.createElement("td");
ligne.appendChild(empty);
var td = document.createElement("td");
td.innerHTML=data.totalCotisationSalarial;
ligne.appendChild(td);
var empty = document.createElement("td");
ligne.appendChild(empty);
var td = document.createElement("td");
td.innerHTML=data.totalCotisationPatronal;
ligne.appendChild(td);

tableCoti.appendChild(ligne);

document.getElementById("netImpo").innerHTML=data.netImposable;

var cotisationImposable=document.getElementById("cotisationImposable");
for (var i = 0; i < data.cotisationsImposable.length; i++) {

var ligne=document.createElement("tr");
var libelle = document.createElement("td");
libelle.innerHTML=data.cotisationsImposable[i].libelle.replace(" ", "&nbsp")
ligne.appendChild(libelle);
var base = document.createElement("td");
base.innerHTML=data.cotisationsImposable[i].base
ligne.appendChild(base);
var tauxSalarial = document.createElement("td");
tauxSalarial.innerHTML=data.cotisationsImposable[i].tauxSalarial
ligne.appendChild(tauxSalarial);
var montantSalarial = document.createElement("td");
montantSalarial.innerHTML=data.cotisationsImposable[i].montantSalarial
ligne.appendChild(montantSalarial);
var tauxPatronal = document.createElement("td");
ligne.appendChild(tauxPatronal);
var cotisationPatronal = document.createElement("td");
ligne.appendChild(cotisationPatronal);

cotisationImposable.appendChild(ligne);

}

document.getElementById("netAPayer").innerHTML=data.netAPayer;



}
