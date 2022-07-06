package ru.redsquid.examples.ms.data.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: data-service.proto")
public final class DataServiceGrpc {

  private DataServiceGrpc() {}

  public static final String SERVICE_NAME = "DataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<DataServiceOuterClass.StorageDetails,
          DataServiceOuterClass.StorageResponse> getCreateStorageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStorage",
      requestType = DataServiceOuterClass.StorageDetails.class,
      responseType = DataServiceOuterClass.StorageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DataServiceOuterClass.StorageDetails,
          DataServiceOuterClass.StorageResponse> getCreateStorageMethod() {
    io.grpc.MethodDescriptor<DataServiceOuterClass.StorageDetails, DataServiceOuterClass.StorageResponse> getCreateStorageMethod;
    if ((getCreateStorageMethod = DataServiceGrpc.getCreateStorageMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getCreateStorageMethod = DataServiceGrpc.getCreateStorageMethod) == null) {
          DataServiceGrpc.getCreateStorageMethod = getCreateStorageMethod =
              io.grpc.MethodDescriptor.<DataServiceOuterClass.StorageDetails, DataServiceOuterClass.StorageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStorage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DataServiceOuterClass.StorageDetails.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DataServiceOuterClass.StorageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("CreateStorage"))
              .build();
        }
      }
    }
    return getCreateStorageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DataServiceOuterClass.Chunk,
          DataServiceOuterClass.Summary> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Upload",
      requestType = DataServiceOuterClass.Chunk.class,
      responseType = DataServiceOuterClass.Summary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<DataServiceOuterClass.Chunk,
          DataServiceOuterClass.Summary> getUploadMethod() {
    io.grpc.MethodDescriptor<DataServiceOuterClass.Chunk, DataServiceOuterClass.Summary> getUploadMethod;
    if ((getUploadMethod = DataServiceGrpc.getUploadMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUploadMethod = DataServiceGrpc.getUploadMethod) == null) {
          DataServiceGrpc.getUploadMethod = getUploadMethod =
              io.grpc.MethodDescriptor.<DataServiceOuterClass.Chunk, DataServiceOuterClass.Summary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DataServiceOuterClass.Chunk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DataServiceOuterClass.Summary.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("Upload"))
              .build();
        }
      }
    }
    return getUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DataServiceOuterClass.StorageDetails,
          DataServiceOuterClass.Chunk> getDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Download",
      requestType = DataServiceOuterClass.StorageDetails.class,
      responseType = DataServiceOuterClass.Chunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<DataServiceOuterClass.StorageDetails,
          DataServiceOuterClass.Chunk> getDownloadMethod() {
    io.grpc.MethodDescriptor<DataServiceOuterClass.StorageDetails, DataServiceOuterClass.Chunk> getDownloadMethod;
    if ((getDownloadMethod = DataServiceGrpc.getDownloadMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getDownloadMethod = DataServiceGrpc.getDownloadMethod) == null) {
          DataServiceGrpc.getDownloadMethod = getDownloadMethod =
              io.grpc.MethodDescriptor.<DataServiceOuterClass.StorageDetails, DataServiceOuterClass.Chunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Download"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DataServiceOuterClass.StorageDetails.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DataServiceOuterClass.Chunk.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("Download"))
              .build();
        }
      }
    }
    return getDownloadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceStub>() {
        @Override
        public DataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceStub(channel, callOptions);
        }
      };
    return DataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub>() {
        @Override
        public DataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceBlockingStub(channel, callOptions);
        }
      };
    return DataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub>() {
        @Override
        public DataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceFutureStub(channel, callOptions);
        }
      };
    return DataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DataServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createStorage(DataServiceOuterClass.StorageDetails request,
                              io.grpc.stub.StreamObserver<DataServiceOuterClass.StorageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateStorageMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<DataServiceOuterClass.Chunk> upload(
        io.grpc.stub.StreamObserver<DataServiceOuterClass.Summary> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUploadMethod(), responseObserver);
    }

    /**
     */
    public void download(DataServiceOuterClass.StorageDetails request,
                         io.grpc.stub.StreamObserver<DataServiceOuterClass.Chunk> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateStorageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      DataServiceOuterClass.StorageDetails,
                      DataServiceOuterClass.StorageResponse>(
                  this, METHODID_CREATE_STORAGE)))
          .addMethod(
            getUploadMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                      DataServiceOuterClass.Chunk,
                      DataServiceOuterClass.Summary>(
                  this, METHODID_UPLOAD)))
          .addMethod(
            getDownloadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                      DataServiceOuterClass.StorageDetails,
                      DataServiceOuterClass.Chunk>(
                  this, METHODID_DOWNLOAD)))
          .build();
    }
  }

  /**
   */
  public static final class DataServiceStub extends io.grpc.stub.AbstractAsyncStub<DataServiceStub> {
    private DataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceStub(channel, callOptions);
    }

    /**
     */
    public void createStorage(DataServiceOuterClass.StorageDetails request,
                              io.grpc.stub.StreamObserver<DataServiceOuterClass.StorageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStorageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<DataServiceOuterClass.Chunk> upload(
        io.grpc.stub.StreamObserver<DataServiceOuterClass.Summary> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void download(DataServiceOuterClass.StorageDetails request,
                         io.grpc.stub.StreamObserver<DataServiceOuterClass.Chunk> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataServiceBlockingStub> {
    private DataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public DataServiceOuterClass.StorageResponse createStorage(DataServiceOuterClass.StorageDetails request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStorageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<DataServiceOuterClass.Chunk> download(
        DataServiceOuterClass.StorageDetails request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDownloadMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataServiceFutureStub> {
    private DataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DataServiceOuterClass.StorageResponse> createStorage(
        DataServiceOuterClass.StorageDetails request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStorageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_STORAGE = 0;
  private static final int METHODID_DOWNLOAD = 1;
  private static final int METHODID_UPLOAD = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_STORAGE:
          serviceImpl.createStorage((DataServiceOuterClass.StorageDetails) request,
              (io.grpc.stub.StreamObserver<DataServiceOuterClass.StorageResponse>) responseObserver);
          break;
        case METHODID_DOWNLOAD:
          serviceImpl.download((DataServiceOuterClass.StorageDetails) request,
              (io.grpc.stub.StreamObserver<DataServiceOuterClass.Chunk>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.upload(
              (io.grpc.stub.StreamObserver<DataServiceOuterClass.Summary>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DataServiceOuterClass.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataService");
    }
  }

  private static final class DataServiceFileDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier {
    DataServiceFileDescriptorSupplier() {}
  }

  private static final class DataServiceMethodDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataServiceFileDescriptorSupplier())
              .addMethod(getCreateStorageMethod())
              .addMethod(getUploadMethod())
              .addMethod(getDownloadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
