package com.shahramatrian.intuit;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: protos/personal_logger.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PersonLoggerGrpc {

  private PersonLoggerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "intuit.PersonLogger";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.shahramatrian.intuit.PersonInfoRequest,
      com.shahramatrian.intuit.Response> getLogPersonalInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogPersonalInfo",
      requestType = com.shahramatrian.intuit.PersonInfoRequest.class,
      responseType = com.shahramatrian.intuit.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.shahramatrian.intuit.PersonInfoRequest,
      com.shahramatrian.intuit.Response> getLogPersonalInfoMethod() {
    io.grpc.MethodDescriptor<com.shahramatrian.intuit.PersonInfoRequest, com.shahramatrian.intuit.Response> getLogPersonalInfoMethod;
    if ((getLogPersonalInfoMethod = PersonLoggerGrpc.getLogPersonalInfoMethod) == null) {
      synchronized (PersonLoggerGrpc.class) {
        if ((getLogPersonalInfoMethod = PersonLoggerGrpc.getLogPersonalInfoMethod) == null) {
          PersonLoggerGrpc.getLogPersonalInfoMethod = getLogPersonalInfoMethod =
              io.grpc.MethodDescriptor.<com.shahramatrian.intuit.PersonInfoRequest, com.shahramatrian.intuit.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LogPersonalInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.shahramatrian.intuit.PersonInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.shahramatrian.intuit.Response.getDefaultInstance()))
              .setSchemaDescriptor(new PersonLoggerMethodDescriptorSupplier("LogPersonalInfo"))
              .build();
        }
      }
    }
    return getLogPersonalInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonLoggerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonLoggerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonLoggerStub>() {
        @java.lang.Override
        public PersonLoggerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonLoggerStub(channel, callOptions);
        }
      };
    return PersonLoggerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonLoggerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonLoggerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonLoggerBlockingStub>() {
        @java.lang.Override
        public PersonLoggerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonLoggerBlockingStub(channel, callOptions);
        }
      };
    return PersonLoggerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonLoggerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonLoggerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonLoggerFutureStub>() {
        @java.lang.Override
        public PersonLoggerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonLoggerFutureStub(channel, callOptions);
        }
      };
    return PersonLoggerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void logPersonalInfo(com.shahramatrian.intuit.PersonInfoRequest request,
        io.grpc.stub.StreamObserver<com.shahramatrian.intuit.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLogPersonalInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PersonLogger.
   */
  public static abstract class PersonLoggerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PersonLoggerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PersonLogger.
   */
  public static final class PersonLoggerStub
      extends io.grpc.stub.AbstractAsyncStub<PersonLoggerStub> {
    private PersonLoggerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonLoggerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonLoggerStub(channel, callOptions);
    }

    /**
     */
    public void logPersonalInfo(com.shahramatrian.intuit.PersonInfoRequest request,
        io.grpc.stub.StreamObserver<com.shahramatrian.intuit.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLogPersonalInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PersonLogger.
   */
  public static final class PersonLoggerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PersonLoggerBlockingStub> {
    private PersonLoggerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonLoggerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonLoggerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.shahramatrian.intuit.Response logPersonalInfo(com.shahramatrian.intuit.PersonInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLogPersonalInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PersonLogger.
   */
  public static final class PersonLoggerFutureStub
      extends io.grpc.stub.AbstractFutureStub<PersonLoggerFutureStub> {
    private PersonLoggerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonLoggerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonLoggerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.shahramatrian.intuit.Response> logPersonalInfo(
        com.shahramatrian.intuit.PersonInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLogPersonalInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOG_PERSONAL_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOG_PERSONAL_INFO:
          serviceImpl.logPersonalInfo((com.shahramatrian.intuit.PersonInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.shahramatrian.intuit.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getLogPersonalInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.shahramatrian.intuit.PersonInfoRequest,
              com.shahramatrian.intuit.Response>(
                service, METHODID_LOG_PERSONAL_INFO)))
        .build();
  }

  private static abstract class PersonLoggerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonLoggerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.shahramatrian.intuit.PersonProtos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonLogger");
    }
  }

  private static final class PersonLoggerFileDescriptorSupplier
      extends PersonLoggerBaseDescriptorSupplier {
    PersonLoggerFileDescriptorSupplier() {}
  }

  private static final class PersonLoggerMethodDescriptorSupplier
      extends PersonLoggerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PersonLoggerMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonLoggerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonLoggerFileDescriptorSupplier())
              .addMethod(getLogPersonalInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
