# PROGETTO TASSI MARTELLI
Progetto per l'esame di Gennaio 2021 di Programmazione ad oggetti, realizzato da Andrea Tassi e Stefano Martelli

# Introduzione
*nome del progetto* è un Web Service che tramite un Client ti permette di avere le termperature, attuali e non, di dieci principali città marchigiane:
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
 1. La temperatura attuale di una città, con massima e minima smpre attuale;
 2. La temperatura di un giorno relativo ad una città, fra venti giorni disponibili;
 3. La temperatura e statistiche sempre relativo ad una città, ma con un range personalizzabile(Max. 20 giorni);
 4. Statistiche di tutte le città in un range personalizzabile.

![Casi D'uso](https://imagizer.imageshack.com/img924/2156/AzzHoo.jpg)

GET/POST | Chiamata | Parametri/Body | Descrizione
------------ | ------------- | ------------ | -------------
Get | /actualy | "city"(String) | Chiamata Temperatura attuale(Punto 1)
Post | /singolo_giorno_casuale |
Post | /range_personalizzabile_singolo |
Post | /range_personalizzabile_totale |
