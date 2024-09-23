# 100 DaysOfCode - Java Course
- This repository contains my journey of learning Java & Spring Boot through the 100DaysOfCode course and university Lectures!

## Table of Contents
- [Lecture 1: Basics](#lecture-1-basics)
- [Lecture 2: Data Types](#lecture-2---správa-projektu-pomocí-maven)
- [Lecture 3: Control Flow](#lecture-3-control-flow)
- [Lecture 4: Methods](#lecture-4-methods)

## Progress
*Track your learning progress...*
- [x] Prezentace 1 - Úvod (Bytecode)
- [x] Prezentace 1 - JVM
- [x] Prezentace 2 - Správa projektu pomocí Maven
- [ ] Prezentace 3 - Spring framework

## Learning
*Complimentary learning videos, tutorials and Docs...*
- **[Java Full Course Bro](https://www.youtube.com/watch?v=xk4_1vDrzzo)**
- **[100DaysOfCode](https://www.100daysofcode.io/learn/java)**
- **[Baeuldung Java](https://www.baeldung.com/get-started-with-java-series)**
- **[Codecademy Course](https://www.codecademy.com/enrolled/courses/learn-java)

## Lecture 1: Basics
### Description:
 - Jak je java přeložena do bytekódu, jak se kompiluje a funguje JVM Zásobníky.Jak funguje Garbage Collector a co zapříčiní memory leak.

### Topics Covered:
 **JVM, Bytecode, Zásobníky, JNI Stack a JVM Stack, Garbage Collector, Memory Leak**
 - JNI Stack pro nativní knihovny v .c
 - JVM Stack pro interpretované metody
 - JVM jako funguje jako LIFO zásobník
 - Garbage Collector a MemoryLeak


### Notes: 
[Lecture 1 Notes](.notes/Lecture%201)
### PPT: 
[Prezentace 1 Úvod a JVM](PDF/PPJ_01_Úvod_a_JVM.pdf)
### Lectures:
[Java programs](/Lectures/Lecture1%20-%20Basics/)
### Exercises: 
[100DaysOfCode programs](/Exercise/Day1.java)

## Lecture 2 - Správa projektu pomocí Maven
### Description
- Základy jmenné prostory, struktura projektu a build tools Apache Maven a Gradle. 
### Topics Covered:
**Dělení na služby  a moduly, Jmenné prostory, POM, Maven a Gradle**
- Jmenné prostory: *cz.tul.ddrapp*
- Struktura a konfigurace projektu: *moduly a služby*
- Testování před nasazením a build *test a build-release.sh*
- **Apache Maven (XML)** nebo **Gradle (Groovy)**
    - lepší je Gradle jelikož řeší problémy předchozích verzí nástrojů Apache(XML) 
- Maven --> Jenkins server

### Notes:
[Lecture 2 notes](.notes/Lecture2)
### PPT:
[Prezentace 2 Správa projektu](/PDF/PPJ_02_Správa_projektu_Maven.pdf)
### Lectures:
[using Namespaces](/Lectures/Lecture2/Lecture2.java)

### Exercises: