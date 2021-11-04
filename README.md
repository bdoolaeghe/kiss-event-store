# simple-eventstore
A simple eventstore based on a Postgres DB

## Usage
1. Install the library in your repository :
```shell
# mvn clean install
```
2. import the library in your event sourced project :
```xml
<dependency>
    <groupId>fr.soat</groupId>
    <artifactId>simple-event-store</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
And load `DbEventStoreConfiguration` spring configuration in your Spring application.

3. Start the event store :
```shell
# make db/up
```
## Reset
To reset the event store (clear all data):
```shell
# make db/reset
```

