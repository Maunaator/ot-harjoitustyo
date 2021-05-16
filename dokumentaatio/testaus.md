# Testausdokumentti

## Yksikkö- ja integraatiotestaus

Sovelluslogiikan 
[lattarikyselija.logiikka](https://github.com/Maunaator/ot-harjoitustyo/blob/master/Lattarikyselija/src/main/java/lattarikyselija/logiikka/) ja tiedonhallinan
[lattarikyselija.data](https://github.com/Maunaator/ot-harjoitustyo/blob/master/Lattarikyselija/src/main/java/lattarikyselija/data/)
pakkauksien luokkia testataan integraatiotestillä 
[LattariTest](https://github.com/Maunaator/ot-harjoitustyo/blob/master/Lattarikyselija/src/test/java/LattariTest.java/).

Pakkauksen [lattarikyselija.data](https://github.com/Maunaator/ot-harjoitustyo/blob/master/Lattarikyselija/src/main/java/lattarikyselija/data/) luokan [Laji](https://github.com/Maunaator/ot-harjoitustyo/blob/master/Lattarikyselija/src/main/java/lattarikyselija/data/Laji.java/) equals- ja hash-metodit testataan yksikkötestillä 
[LajiTest](https://github.com/Maunaator/ot-harjoitustyo/blob/master/Lattarikyselija/src/test/java/LajiTest.java/).

Testauksessa simuloidaan käyttöliittymän pakkauksen 
[lattarikyselija.ui](https://github.com/Maunaator/ot-harjoitustyo/blob/master/Lattarikyselija/src/main/java/lattarikyselija/ui/) luokkien toimintaa.

### Testikattavuus

Käyttöliittymän pakkaus [lattarikyselija.ui](https://github.com/Maunaator/ot-harjoitustyo/blob/master/Lattarikyselija/src/main/java/lattarikyselija/ui/) 
poislukien testauksen rivikattavuus on 92% ja haarautumiskattuvuus on 86%.

<img src="https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kattavuus.png " width="800">

## Järjestelmätestaus

Sovellus on järjestelmätestattu manuaaliseti.

Sovellus on haettu ja suoritettu [käyttöohjeen](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/käyttoohje.md) mukaisesti Linux-käyttöjärjestelmässä.

[Määrittelydokumentin](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) ja [käyttöohjeen](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/käyttoohje.md) toiminnallisuudet on käyty läpi. Kyselynäkymässä on kokeiltu antaa virheellisiä tai tyhjiä vatauksia.

## Sovellukseen jääneet ongelmat

Toivottavaa olisi ollut saada toteutettua enemmän jatkokehitysideoita [määrittelydokumentista.](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

Sovelluksessa on vain lyhyet esimerkkiaineistot kahdesta lajiryhmästä.
