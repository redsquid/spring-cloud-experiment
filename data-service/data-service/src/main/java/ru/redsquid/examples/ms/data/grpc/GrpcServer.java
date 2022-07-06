package ru.redsquid.examples.ms.data.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ru.redsquid.examples.ms.data.service.DataService;

import java.io.IOException;

public class GrpcServer {

    private final Server server;

    private GrpcServer(Server server) {
        this.server = server;
    }

    public static GrpcServer create(int port) {
        Server server = ServerBuilder.forPort(port).addService(new DataService()).build();
        return new GrpcServer(server);
    }

    public void start() {
        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
