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
6. Open API Restful Swagger.
    * http://localhost:8088/swagger-ui.html
![Swagger!](https://github.com/jrcinco/school-project/blob/master/files/swagger.png)

**=> Run Test:**

1. Compile database module.
    * cd /DBModule
    * mvn clean install
2. Compile web module.
    * cd /WebModule
    * mvn clean install
3. Run server jetty.
    * cd /WebModule
    * mvn jetty:run
4. Test the API Restful.
    * cd /AutomationModule
    * mvn clean test
3. Test the API Restful and Generate the test report.
    * cd /AutomationModule
    * mvn clean site
    * find the report in /AutomationModule/target/site/index.html 
![Report!](https://github.com/jrcinco/school-project/blob/master/files/report.png)

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
7. Generate Report
    * mvn clean site

**=> Test with Postman or other Rest client:**

1. Create a student.

**Json Request:**
```
{
  "name":"jhonny cinco",
  "gender":"M",
  "type":"KINDER",
  "timestamp":"2018104518524523"
}
```

**Json Response:**
```
{}
```
![Post!](https://github.com/jrcinco/school-project/blob/master/files/post.png)

2. Update a student.

**Json Request:**
```
{
  "name":"jhoselin",
  "gender":"F",
  "type":"KINDER",
  "timestamp":"2018104518524523"
}
```

**Json Response:**
```
{}
```
![Put!](https://github.com/jrcinco/school-project/blob/master/files/put.png)

3. Delete a student.

**Json Request:**
```
{}
```

**Json Response:**
```
{}
```
![Put!](https://github.com/jrcinco/school-project/blob/master/files/delete.png)

4. List students by name, type or gender.

For example: 
      * http://localhost:8088/student?name=jhonny
      * http://localhost:8088/student?type=KINDER
      * http://localhost:8088/student?type=KINDER&gender=M

**Json Response:**
```
[
    {
        "id": 5,
        "name": "jhoana4",
        "gender": "M",
        "type": "KINDER",
        "timestamp": "20180216083452"
    },
    {
        "id": 1,
        "name": "jhonnyxxx",
        "gender": "M",
        "type": "KINDER",
        "timestamp": "21453212454"
    },
    {
        "id": 2,
        "name": "jhonny14",
        "gender": "M",
        "type": "KINDER",
        "timestamp": "21453212454"
    },
    {
        "id": 3,
        "name": "jhonny185",
        "gender": "M",
        "type": "KINDER",
        "timestamp": "21453212454"
    },
    {
        "id": 4,
        "name": "jhoana",
        "gender": "M",
        "type": "KINDER",
        "timestamp": "21453212454"
    }
]
```
![Put!](https://github.com/jrcinco/school-project/blob/master/files/get.png)
