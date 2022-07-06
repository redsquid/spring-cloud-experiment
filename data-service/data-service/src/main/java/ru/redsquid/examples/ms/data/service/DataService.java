package ru.redsquid.examples.ms.data.service;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import ru.redsquid.examples.ms.data.grpc.DataServiceGrpc;
import ru.redsquid.examples.ms.data.grpc.DataServiceOuterClass;

import java.nio.charset.Charset;
import java.util.UUID;

public class DataService extends DataServiceGrpc.DataServiceImplBase {

    @Override
    public void createStorage(DataServiceOuterClass.StorageDetails request, StreamObserver<DataServiceOuterClass.StorageResponse> responseObserver) {

        System.out.println("gRPC CALL: " + request.getOwnerId());
        DataServiceOuterClass.StorageResponse response = DataServiceOuterClass.StorageResponse.newBuilder()
                .setStorageId(UUID.randomUUID().toString() + " : " + request.getOwnerId())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<DataServiceOuterClass.Chunk> upload(StreamObserver<DataServiceOuterClass.Summary> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(DataServiceOuterClass.Chunk chunk) {
                System.out.println("onNext: " + chunk.getData().toStringUtf8());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onComplete");
                responseObserver.onNext(DataServiceOuterClass.Summary.newBuilder().setStored(100500).build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void download(DataServiceOuterClass.StorageDetails request, StreamObserver<DataServiceOuterClass.Chunk> responseObserver) {
        for (int i = 0; i < 10; ++i) {
            DataServiceOuterClass.Chunk chunk = DataServiceOuterClass.Chunk.newBuilder()
                    .setData(ByteString.copyFrom(request.getOwnerId() + " : " + i, Charset.defaultCharset()))
                    .build();
            responseObserver.onNext(chunk);
        }
        responseObserver.onCompleted();
    }
}
