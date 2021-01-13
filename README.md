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
`POST` | /range_personalizzabile_singolo | "n1" - "n2" - "nome" | Temperatura media, massima, minima e varianza 
`POST` | /range_personalizzabile_totale | "n1" - "n2" | Temperatura media, massima, minima e varianza ma di tutte le città

> Per "nome" si intende il nome della città, per "n1" e "n2" invece si intende il range dei giorni richiesti(ad eccezione di "/singolo_giorno_casuale" che si utilizza solo "n1")

Appena fatta richiesta tramite il Client, verranno riportati i dati richiesti tramite formato JSON.
Quando si utilizza la chiamata "/actualy", ogni ora ci sarà una scrittura dei dati attuali di tutte le città su un file chiamato "Dati_Giornalieri", presente nella cartella del progetto.



## Funzionamento





### Use Case Diagram

![Casi D'uso](https://imagizer.imageshack.com/img924/2258/2S6Sms.jpg)


