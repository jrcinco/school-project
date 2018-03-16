**School Project**
=====================================
The School project is a RestFul Sever with a student CRUD.

**=> Environment requeriments:**

* Java version: 1.7+
* Apache Maven 3.3.9+
* MySQL 5.6.28

**=> Run application:**

1. Create a database in mysql.
2. Set user and password mysql on files:
    * /DBModule/src/main/resources/hibernate-generation.cfg.xml
    * /DBModule/src/main/resources/registerdb-context.xml
3. Compile database module.
    * cd /DBModule
    * mvn clean install
4. Compile web module.
    * cd /WebModule
    * mvn clean install
5. Run server jetty.
    * cd /WebModule
    * mvn jetty:run

**=> Special commands:**

1. Clean, Test and Compile
    * mvn clean install
2. Compile and Skip Test
    * mvn clean install -Dmaven.test.skip=true
3. Reverse engineering
    * mvn hibernate3:hbm2java
4. Creation tables from POJOs
    * mvn test-compile hibernate3:hbm2ddl
5. Run jetty server
    * mvn clean jetty:run
6. Skip test
    * mvn install -Dmaven.test.skip=true
7. Generate WAR file
    * mvn war:war
