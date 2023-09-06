
# gRPC Demo
This repo includes a source for a gRPC C++ server and a gRPC Java client.
It includes a Spring boot app that exposes a RESTful API to set Personal Info of a user. The service takes the payload, enriches it with a timestamp, 
and sets it in-memory in a C++ server fronted by gRPC. When the C++ server sets it, it prints a log indicating that. The client receives a NoContent response code if all goes well.

## Build Java Client
The Java client can be built with Maven. I haven't used the **maven protobuf plugin** though because I wanted the proto to be shared with ease between 
the client and the server

## Build C++ Server
To build the C++ server you can use cmake as follows:
```
$ mkdir -p cmake/build
$ pushd cmake/build
$ cmake -DCMAKE_PREFIX_PATH=$MY_INSTALL_DIR ../..
$ make -j 4
```



## UML diagrams
Simplified sequence diagram:

```mermaid
sequenceDiagram
Rest Client ->> Spring Boot Service: Add a User
Spring Boot Service-->>PersonLoggerClient: sendPersonalInfo
PersonLoggerClient-->>PersonLoggerServer: logPersonalInfo
PersonLoggerServer-->>PersonLoggerClient: sendResponse