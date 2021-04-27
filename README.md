# Ohjelmistotekniikan harjoitustyö

## Tieteellisten nimien harjoittelusovellus

[Tuntikirjanpito](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaativuusmäärittely](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuuri](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

## Komentorivitoiminnot

Suoritetaan kansiossa _/Lattarikyselija_

###
Ohjelman voi suorittaa komennolla
```
mvn compile exec:java -Dexec.mainClass=lattarikyselija.Main
```
### Testit

Testit komennolla:
```
mvn test
```
Testikattavuusraportti komennolla:
```
mvn test jacoco:report
```
Luettavissa sijainnissa _/target/site/jacoco/index.html_

Checstyle-raportti komennolla:
```
mvn jxr:jxr checkstyle:checkstyle
```
Luettavissa sijainnissa _/target/site/checkstyle.html_

### Jarin generointi:
Jarin generointi komennolla:
```
mvn package
```
Lattarikyselija-1.0-SNAPSHOT.jar syntyy sijaintiin _/target_

