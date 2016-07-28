# wildfly-swarm-concurrency-utilities-demo

## Run the app
 
``` sh
$ ./mvnw clean wildfly-swarm:run
```

## Access Async API 

``` sh
$ curl http://localhost:8080
{"value":"Async Hello"}
```

You should get the response right away, but an async task is doing in the background.
 
See console.

``` sh
2016-07-28 21:11:40,326 INFO  [stdout] (default task-1) Before execute
2016-07-28 21:11:40,331 INFO  [stdout] (default task-1) After execute
2016-07-28 21:11:40,332 INFO  [stdout] (EE-ManagedExecutorService-default-Thread-1) Async Task is start.
2016-07-28 21:11:40,332 INFO  [stdout] (EE-ManagedExecutorService-default-Thread-1) Async Task is waiting.
# 5 seconds.
2016-07-28 21:11:45,333 INFO  [stdout] (EE-ManagedExecutorService-default-Thread-1) Async Task is end.
```

## Related

* [EEFraction and problem with Resource ManagedExecutorService](https://groups.google.com/forum/#!msg/wildfly-swarm/jwFsk053HvI/4YQ3siZbBAAJ)