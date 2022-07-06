package ru.redsquid.examples.ms.data.client;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ru.redsquid.examples.ms.data.grpc.DataServiceGrpc;
import ru.redsquid.examples.ms.data.grpc.DataServiceOuterClass;

import java.util.Iterator;

public class DataClient {

    private final DataServiceGrpc.DataServiceBlockingStub blockingStub;

    private final DataServiceGrpc.DataServiceStub asyncStub;

    private DataClient(DataServiceGrpc.DataServiceBlockingStub blockingStub, DataServiceGrpc.DataServiceStub asyncStub) {
        this.blockingStub = blockingStub;
        this.asyncStub = asyncStub;
    }

    public static DataClient create(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 5000)
                .usePlaintext()
                .build();

        return new DataClient(DataServiceGrpc.newBlockingStub(channel), DataServiceGrpc.newStub(channel));
    }

    public void createStorage() {
        DataServiceOuterClass.StorageDetails details = DataServiceOuterClass.StorageDetails.newBuilder().setOwnerId("12345").build();
        DataServiceOuterClass.StorageResponse response = blockingStub.createStorage(details);
        System.out.println("gRPC CALL RESULT: " + response.getStorageId());
    }

    public void upload() {

        StreamObserver<DataServiceOuterClass.Summary> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(DataServiceOuterClass.Summary summary) {
                System.out.println("onNext SUMMARY: " + summary.getStored());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onCompleted() {
                System.out.println("onComplete");
            }
        };


        StreamObserver<DataServiceOuterClass.Chunk> requestObserver = asyncStub.upload(responseObserver);
        for (int i = 0; i < 5; i++) {
            DataServiceOuterClass.Chunk chunk = DataServiceOuterClass.Chunk.newBuilder()
                    .setData(ByteString.copyFromUtf8(Integer.toString(i)))
                    .build();
            requestObserver.onNext(chunk);
        }
        requestObserver.onCompleted();
    }

    public void download() {
        DataServiceOuterClass.StorageDetails details = DataServiceOuterClass.StorageDetails.newBuilder().setOwnerId("ABC").build();
        Iterator<DataServiceOuterClass.Chunk> chunks = blockingStub.download(details);

        while (chunks.hasNext()) {
            System.out.println(chunks.next().getData().toStringUtf8());
        }
    }
}
