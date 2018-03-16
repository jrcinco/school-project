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

**=> Test with Postman or other Rest client:**

1. Create a student.

**Json Request:**
```
{
   "cmd":"CreateStudent",
   "content":"{\"name\":\"jhonny\",\"type\":\"Kinder\",\"gender\":\"M\"}",
   "timestamp":"1427081028856",
   "observation":"null"
}
```

**Json Response:**
```
{
    "cmd": "CreateStudent",
    "content": null,
    "timestamp": 1427081028856,
    "observation": "The student was created!",
    "result": "success"
}
```
![Post!](https://github.com/jrcinco/school-project/blob/master/files/post.png)
Note: cmd, timestamp and observation are informative fields.

2. Update a student.

**Json Request:**
```
{
   "cmd":"UpdateStudent",
   "content":"{\"name\":\"jhonny\",\"type\":\"Kinder\",\"gender\":\"M\"}",
   "timestamp":"1427081028856",
   "observation":"null"
}
```

**Json Response:**
```
{
    "cmd": "UpdateStudent",
    "content": null,
    "timestamp": 1427081028856,
    "observation": "The student was updated!",
    "result": "success"
}
```
![Put!](https://github.com/jrcinco/school-project/blob/master/files/put.png)
Note: cmd, timestamp and observation are informative fields.

3. Delete a student.

**Json Request:**
```
{
   "cmd":"DeleteStudent",
   "content":"",
   "timestamp":"1427081028856",
   "observation":"null"
}
```

**Json Response:**
```
{
    "cmd": "DeleteStudent",
    "content": null,
    "timestamp": 1427081028856,
    "observation": "The student was deleted!",
    "result": "success"
}
```
![Put!](https://github.com/jrcinco/school-project/blob/master/files/delete.png)
Note: cmd, timestamp and observation are informative fields.

4. List students by name, type or gender.

For example: 
      * http://localhost:8088/student?name=jhonny
      * http://localhost:8088/student?type=kinder
      * http://localhost:8088/student?type=kinder&gender=M``

**Json Response:**
```
[
    {
        "id": 5,
        "name": "jhoana4",
        "gender": "M",
        "type": "Kinder",
        "timestamp": "20180216083452"
    },
    {
        "id": 1,
        "name": "jhonnyxxx",
        "gender": "M",
        "type": "Kinder",
        "timestamp": "21453212454"
    },
    {
        "id": 2,
        "name": "jhonny14",
        "gender": "M",
        "type": "Kinder",
        "timestamp": "21453212454"
    },
    {
        "id": 3,
        "name": "jhonny185",
        "gender": "M",
        "type": "Kinder",
        "timestamp": "21453212454"
    },
    {
        "id": 4,
        "name": "jhoana",
        "gender": "M",
        "type": "Kinder",
        "timestamp": "21453212454"
    }
]
```
![Put!](https://github.com/jrcinco/school-project/blob/master/files/get.png)
