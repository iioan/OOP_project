## SINGLETON LA DATA
- asigură faptul că o clasă creeaza o singură instanță și furnizează un punct
  global de acces la ea
- de ce? pentru a exista doar o singura baza de date intr-o aplicatie.
- are date pentru streameri, streamuri si useri
- atunci cand vrem sa o accesam apelam ```getinstance()```.

## FACADE LA DATA SI COMMAND
- ofera o interfata simplificata unui sistem complex
- de ce? pentru a ascunde complexitatea sistemului de deasupra prin crearea unei
  interfete unificate pentru accesarea acestuia.
- ```Datafacade```/```CommandFacade``` ofera o interfata simplificata pentru citirea datelor/
  executarea comenzilor. Fiecare contine obiecte ale claselor pentru procesarea
  datelor.
- avantaje:
    - ascunde complexitatea: mai sus
    - face sistemul mai modular și mai ușor de înțeles
    - devine mai usor sa testam parti din cod
    - face subsistemul mai usor de utilizat
    - facilitează întreținerea codului și aducerea modificărilor acestuia în
      viitor (de ex putem crea noi implementari: sa trimitem datele undv online, sa
      cream o interfata grafica, etc.)


## COMMAND
- încapsulează cererea ca obiect
- il folosim pentru ca dorim ca obiectele sa realizeze diferite actiuni
- structurarea sistemului in jurul unor operatii de nivel inalt, contruite pe
  baza operatiilor primtive
- DECI AVEM:
    - interfata command cu ```execute()```
    - ```commandinvoker``` - receptorul care realizeaza operatii
    - clientul (class ```CommandsExecutor```) care creaza obiecte de tipul ComandaConcerta
    - ComandaConcerta (```AddStreamCommand```, ```ListCommand```, etc) - care implemen
      teaza interfata command cu metoda ```execute()```
    - clientul specifica receptorul
    - invokerul trimite o cerere prin apelul executa() -> se duce la comanda
      concreta
    - ComandaConcreta invocă operații asupra receptorului pentru realizarea
      cererilor

## BUILDER PT FIECARE CLASA:
- pt a crea obiecte complexe, prin intermediul unui proces incremental
- permite construirea obiectelor in mod modular, ai aceastea sa poata fi create
  si utilizate usor.
- scapam de constructori lungi

## FACTORY:
- defineste o interfata pentru crearea unui obiect, dar lasa subclasele sa
  decida ce clasa sa instantieze.
- Metoda ```getCommand``` returnează un obiect de tip ```Command```
- de ce?
  - Clasa ```CommandsExecutor``` iterează corect peste lista de comenzi și invocă
    fiecare comandă prin clasa CommandInvoker. Clasa ```CommandInvoker``` reține
    corect comanda și o execută atunci când i se cere. Clasa ```CommandFactory```
    returnează corect obiectul de comandă corect bazat pe ```CommandName```.
