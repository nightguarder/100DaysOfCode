## Lecture 2 - První projekt
- Struktura projektu, namespaces, Maven/Gradle

### 1. Jak dělíme projekt?

• **Kód**: viz níže..

• **Knihovny (závislosti)** : spravují se pomocí Maven a Gradle

• **Statické Soubory** : které nejsou součástí kódu, ale jsou potřebné pro běh aplikace, jako jsou obrázky, CSS, JavaScript atd. např. */main/src/static*

• **Konfig** :  např. *application.properties , logback.xml..*

### 2. Jak dělit kód (soubory)?

• **Nedělit - jednoúčelové skripty :**  *např. build-and-release.sh, develop.sh ...*

• **Dělení do jmenných prostorů :**  Kód je organizován do balíčků podle funkčnosti nebo vrstvy např. *com.example.service, com.example.controller.*

•**Dělení do podprojektů/modulů :** Projekt je rozdělen do menších modulů nebo podprojektů, které mohou být vyvíjeny a nasazovány nezávisle. [example na obrazku](#3-struktura-projektu)

• **Mikro služby (VMS, Docker) :**  Aplikace je rozdělena na malé, nezávislé služby, které jsou nasazovány a škálovány samostatně pomocí kontejnerů jako Docker.

### 3. Struktura projektu
- Gradle uses same directory structure as maven. Although instead of *build.gradle* it has *pom.xml*
![gradle-project-structure](/img/Gradle-structure.png)

### 4. Namespaces
- Na souborovém systému se tváří zpravidla jako složky. 
- Pojmenování vznikne „obrácením“ URL schématu
*utils.fm.tul.cz -> cz.tul.fm.utils*
- Zamezení a řešení kolizí při pojmenování více knihoven: *java.io.ImportantClass --> cyril.project.ImportantClass* (můžeme pojmenovat stejně, ale /path je jiná)

- __Výhody:__
    - **Žádné kolize při pojmenování**: viz výše..
    - **Dělení na logické komponenty**: např. *cz.tul.utils, cz.tul.utils.db*
    - **Kontrola nad přístupem: (package /private):** Jasná definice externího API -> jednodušší změny uvnitř prostoru
- __Nevýhody:__   
    - **Praticky žádné :** Pokud použijeme správný syntax.. *cz.tul.db.mongodb.MyLittlePony ?*
    - Je třeba dobře zvážit rozdělení složek pro velké projekty

### 5. Moduly
- Samostatné programy v projektu, které jsou testovány nezávisle na sobě. 
- Dělení na moduly zvyšuje přehlednost, znovupoužitelnost a udržovatelnost kódu.

__Rozdělení modulů:__
- Závisí na rozsahu projektu a aplikaci

**Jeden modul :**
- Test
- MySQL Java konektor

**Dva moduly :**
- Test
- Obvyklé např. pro webové aplikace
    - Appserver (webové api) *frontend*
    - Core (jádro aplikace,) *backend*

**Desítky modulů :**
    - Mikroslužby - *logback, service, utils*
    - Spring framework - *mikroslužby, databáze, web (frontend)*


__Vytvoření modulů:__
- v /root adresáři konfigurace *pom.xml*
```xml
 <modules>
        <module>frontend</module>
        <module>backend</module>
</modules>
```
### 6. Maven

- __[Developing Your First Spring Boot Application](https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application.pom)__

add to: ``pom.xml``
```xml
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent
            <artifactId>
		<version>3.3.2</version>
</parent>
````

- Proceed to run  with ``mvn package``
- [Introduction to Maven ](https://www.softpost.org/maven/introduction-to-maven)

### 7. Gradle
- __[Developing Your First Spring Boot Application](https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application.gradle)__

- [Introduction to Gradle](https://www.softpost.org/gradle/introduction-to-gradle)