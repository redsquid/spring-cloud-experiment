package ru.redsquid.examples.ms.data;

import ru.redsquid.examples.ms.data.grpc.GrpcServer;

public class Main {

    public static void main(String[] args) {
        GrpcServer server = GrpcServer.create(5000);
        server.start();
    }

}
