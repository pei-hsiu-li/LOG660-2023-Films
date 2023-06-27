# Pour utiliser

1. Set up database dans Intellij -> [Étape 2.2](https://www.alwa.info/2017/How-to-install-Hibernate-in-IntelliJ-IDEA.html)
   
1. Run test.java, devrait voir les noms de films et leurs pays

# Pour créer le projet

1. Set up JavaFX project
2. Add to pom.xml
```xml
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.1.6.Final</version>
        </dependency>
        <dependency>
            <groupId>com.oracle.ojdbc</groupId>
            <artifactId>ojdbc8</artifactId>
            <version>19.3.0.0</version>
        </dependency>
```
3. Refresh maven
4. https://www.alwa.info/2017/How-to-install-Hibernate-in-IntelliJ-IDEA.html

### Info DB
Host:  `log660ora12c.logti.etsmtl.ca`
Port: `1521`
SID: `LOG660`

User: `EQUIPE112`
PW: par courriel ets
