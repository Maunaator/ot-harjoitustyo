# Ohjelmistotekniikan harjoitustyö

## Tieteellisten nimien harjoittelusovellus

[Tuntikirjanpito](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaativuusmäärittely](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuuri](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/Maunaator/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

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

Javadoc komennolla:
```
mvn javadoc:javadoc
```
Luettavissa sijainnissa _/target/site/apidocs/index.html_

### Jarin generointi:
Jar-tiedoston generointi komennolla:
```
mvn package
```
Lattarikyselija-1.0-SNAPSHOT.jar syntyy sijaintiin _/target_

Jar-tiedosto voidaan suorittaa sen sijaintikansiosta komennolla:
```
java -jar Lattarikyselija-1.0-SNAPSHOT.jar
```
