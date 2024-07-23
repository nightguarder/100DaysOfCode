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
- [Introduction to Maven ](https://www.softpost.org/maven/introduction-to-maven)
- Make sure you have Maven installed: ``mvn --version ```
- ``brew install maven``

- __[Developing Your First Spring Boot Application](https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application.pom)__

#### 1. Building pom.xml (Project settings)
add to: ``pom.xml``
```xml
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent
            <artifactId>
		<version>3.3.2</version>
</parent>
```

- Proceed to run  with ``mvn package``

#### 2. Adding classpath dependencies 
- basically add another maven built application(libraries) that are needed to run your App
- add a ``spring-boot-starter-web dependency`` to ``pom.xml``
- *optional*
    - add ``<scope>test<scope>`` to only include these libraries in your test environment

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
</dependencies>
```
#### 3. Configuring the App
- Create a Main .java file under ``src/main/java/MyApp.java``
- With the following code:
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // our class is a web @Controller, so Spring considers it when handling incoming web requests.
@SpringBootApplication
//This annotation has @EnableAutoConfiguration which tells Spring Boot to “guess” how you want to configure Spring, based on the jar dependencies that you have added
public class MyApplication {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

}
```
#### 4. Running and Building the App
- Type ``mvn spring-boot:run`` from the root project directory to start the application.
- Open ``localhost:8080`` to see the result:

```REST
http://localhost:8080/ 
Spring Boot Maven Project is running!
```
### 7. Gradle
- [Introduction to Gradle](https://www.softpost.org/gradle/introduction-to-gradle)
- Make sure you have Gradle installed: ``gradle --version ``
- ``brew install gradle``

#### 1. Configurating build.gradle (Build script)

- add to: ``build.gradle``
```xml
plugins {
	id 'java'
	id 'org.springframework.boot' version '3.3.2'
}

apply plugin: 'io.spring.dependency-management'

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

repositories {
	mavenCentral()
    //If using Snapshot or Milestone
	<!-- maven { url 'https://repo.spring.io/milestone' }
	maven { url 'https://repo.spring.io/snapshot' } -->
}

dependencies {
}
```
- Test run it with ``gradle classes``

#### 2. Add Classpath Dependencies

add to ``build.gradle:```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
}

- Test run it with ``gradle dependencies``

#### 3. Configuring the App
- Same setup as in [Maven setup](#3-configuring-the-app)

#### 4. Running and building the App
- check your dependencies and classes first: ``gradle dependencies``and ``gradle classes``
- to build the app ``gradle build``
- to start the springboot app : ``gradle bootRun``
- You should get the following: 
: Tomcat started on port 8080 (http) with context path '/'

- Open ``localhost:8080`` to see the result:

- __[Developing Your First Spring Boot Application](https://docs.spring.io/spring-boot/tutorial/first-application/index.html#getting-started.first-application.gradle)__
