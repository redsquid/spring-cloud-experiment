package ru.redsquid.examples.ms.data.client;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");

        DataClient client = DataClient.create("127.0.0.1", 5000);

//        client.createStorage();

//        client.download();

        client.upload();


        Thread.sleep(2000);

        System.out.println("stop");
    }

}
