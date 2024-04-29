# stock-api

* This project is  a part of a Financial Data Management Service

## This project uses:

* Java 21
* SpringBoot V3.2.5
* Gradle
* intelliJ (as IDE)

### To install Java 21 in Linux systems you can run the following command: 
```
$ sudo apt-get install openjdk-21-jdk
```

## Clone the repo

```
$ git clone https://github.com/cesarnflores/stock-api.git
```

## Compiling 

```
$ cd stock-api
$ ./gradlew build
$ java -jar build/libs/stock-api-0.0.1-SNAPSHOT.jar
```


## Checking

```
curl http://localhost:8091/api/actuator/health | json_pp
```

When executing the curl command you should receive a response like this: 

```
{
   "components":{
      "db":{
         "details":{
            "database":"H2",
            "validationQuery":"isValid()"
         },
         "status":"UP"
      },
      "diskSpace":{
         "details":{
            "exists":true,
            "free":247341584384,
            "path":"/home/cesarflores/misrepos/stock-api/.",
            "threshold":10485760,
            "total":419643809792
         },
         "status":"UP"
      },
      "ping":{
         "status":"UP"
      }
   },
   "status":"UP"
}
```


When in local environment you will have access to the H2 Database console : 

```
http://localhost:8091/api/h2-console/
```





