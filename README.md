# PROGETTO TASSI MARTELLI
Progetto per l'esame di Gennaio 2021 di Programmazione ad oggetti, realizzato da Andrea Tassi e Stefano Martelli

## Introduzione
_**Open Weather Martelli Tassi**_ è un Web Service che tramite un Client ti permette di avere le termperature, attuali e non, di dieci principali città marchigiane:
* Ancona;
* Pesaro;
* Fano;
* Ascoli Piceno;
* San Benedetto del Tronto;
* Senigallia;
* Civitanova Marche;
* Macerata;
* Jesi;
* Fermo.

Più di preciso esso ti permette, tramite delle chiamate API, di avere:
 1. La temperatura attuale di una città, con massima e minima sempre attuale;
 2. La temperatura di un giorno relativo ad una città, fra venti giorni disponibili;
 3. La temperatura e statistiche sempre relative ad una città, ma con un range personalizzabile(Max. 20 giorni);
 4. Statistiche di tutte le città in un range personalizzabile.

## Istruzioni all'uso
Per iniziare ad utilizzare il Web Service occorre:
* Scaricare il codice;
* Importarlo dentro un ambiente di svilupppo;
* Avviare il programma con SpringBootApp (porta http://localhost8080);
* Aprire un Client(es. Postman) utilizzando le chiamate descritte di seguito per ricevere i dati voluti.

Tipo | Rotta | Parametri/Body | Return
------------ | ------------- | ------------ | -------------
`GET` | /actualy | "nome" | Temperatura attuale. temperatura massima, minima e varianza massima del giorno odierno
`POST` | /singolo_giorno_casuale | "n1" - "nome"| Temperatura media del giorno scelto
`POST` | /range_personalizzabile_singolo | "n1" - "n2" - "nome" | Temperatura media, massima, minima e varianza di una città, non attuali 
`POST` | /range_personalizzabile_totale | "n1" - "n2" | Temperatura media, massima, minima e varianza ma di tutte le città, non attuali

> Per "nome" si intende il nome della città, per "n1" e "n2" invece si intende il range dei giorni richiesti(ad eccezione di "/singolo_giorno_casuale" che si utilizza solo "n1")

Appena fatta richiesta tramite il Client, verranno riportati i dati richiesti tramite formato JSON.


Dopo che il programma viene avviato, ogni ora ci sarà una scrittura dei dati attuali di tutte le città su un file chiamato "Dati_giornalieri.JSON", presente nella cartella del progetto, e ciò che verrà inserito dentro al file viene stampanto in console per una quesione di praticità e comodità.

### Use Case Diagram
![Casi D'uso](https://imagizer.imageshack.com/img924/2258/2S6Sms.jpg)



## Funzionamento
Il lavoro è stato diviso in 3 grandi macro aree, cioè la raccolta dei dati, la lavorazione di essi e la gestione dello Spring; Di conseguenza avremo 3 packages principali:
 1. `RaccoltaDati`: In _**"RaccoltaDati"**_ ci sono le classi che attingono i dati, da una chiamata API o da un file JSON, pronti per essere inseriti dentro dei vettori per poi essere lavorati;

 ![RaccoltaDati](https://imagizer.imageshack.com/img923/4843/cBVwYL.jpg)
 
 2. `GestioneDati`:  In _**"GestioneDati"**_ sono presenti le classi che ci permettono di svolgere calcoli su vettori;
 
 ![GestioneDati](https://imagizer.imageshack.com/img924/828/NJIiIF.jpg)
 
 3. `SpringBootApp`: Qui invece abbiamo due sotto packages(e la classe di avvio di Spring fuori da essi), cioè "Operazioni",che presenta al suo interno classi che prendono i vettori con i dati e creano le statistiche desiderate e la classe per la scrittura sul un file JSON, e "Controller", con internamente la classe "Main" che raccoglie i dati e statistiche manipolate, li inserisce in dei JSONObjects e li manda nell'altra classe di questo sotto-Package "SimpleRestController", che collega tutto a Spring.
  
 ![SpringBootApp](https://imagizer.imageshack.com/img924/9144/ymLY9E.jpg)
 

Nel progetto abbiamo anche implementanto JavaDOC(con JavaDOC in HTML) ed una classe di JUnit Test che ci ha permesso di testare il funzionamento di varie classi. Il JavaDoc in HTML è presente nella cartella "doc" e la classe di Test si trova nella cartella "src/test/Java" nel package "JUnit_Test".




## Autori e divisione lavoro

[_**Andrea Tassi**_](https://github.com/GitAndreaHub): 50%.
[_**Stefano Martelli**_](https://github.com/Martelli00): 50%.
