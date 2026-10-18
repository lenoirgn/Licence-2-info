# exemple du cours du 29 septembre 2025

Gestion de dates de la forme *jour mois année*.

## Génération de la documentation

```
javadoc -sourcepath src -subpackages poo -d docs
```

NB : il y a des warnings sur les valeurs du type énuméré `Month` et de la classe `DateMain`. Warnings acceptables.

## Compilation

```
javac -sourcepath src src/poo/*.java -d classes
```

## Compilation des tests

sous linux : 
```
javac -classpath classes:junit-console.jar test/poo/*.java
```

sous windows :
```
javac -classpath "classes;junit-console.jar" test/poo/*.java
```

## Exécution des tests

sous linux : 
```
java -jar junit-console.jar -classpath test:classes -scan-classpath
```

sous windows :
```
java -jar junit-console.jar -classpath "test;classes" -scan-classpath
```

## Exécution du programme

```
java -classpath classes poo.DateMain <n>
```
avec *<n>* un entier positif utilisé pour appeler `nbDaysAfter()`. En cas d'absence ou de mauvaise valeur fournie, la valeur 100 est utilisée par défaut.

exemples de trace :
```bash
$ java -classpath classes poo.DateMain 45
---------tomorrow-------------
tomorrow for 31 march 2015 -> 1 april 2015
tomorrow for 31 december 2015 -> 1 january 2016
tomorrow de 30 september 2024 -> 1 october 2024
---------nbDaysAfter-------------
date 45 after 30 september 2024 = 14 november 2024

$ java -classpath classes poo.DateMain
---------tomorrow-------------
tomorrow for 31 march 2015 -> 1 april 2015
tomorrow for 31 december 2015 -> 1 january 2016
tomorrow de 30 september 2024 -> 1 october 2024
---------nbDaysAfter-------------
 ** NB : You can give a positive int as argument.
 ** e.g. : java -classpath classes date.DateMain 5
 ** If no value is provided then 100 is used
date 100 after 30 september 2024 = 8 january 2025

$ java -classpath classes poo.DateMain abc
---------tomorrow-------------
tomorrow for 31 march 2015 -> 1 april 2015
tomorrow for 31 december 2015 -> 1 january 2016
tomorrow de 30 september 2024 -> 1 october 2024
---------nbDaysAfter-------------
 ** NB : You can give a positive int as argument.
 ** e.g. : java -classpath classes date.DateMain 5
 ** If no value is provided then 100 is used
date 100 after 30 september 2024 = 8 january 2025
```