package com.flyhtml.payment;

import java.io.IOException;
import java.util.logging.Logger;

import com.flyhtml.payment.service.PaymentServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Created by xiaowei on 17-2-20.
 */
public class PaymentServer {

    private static final Logger logger = Logger.getLogger(PaymentServer.class.getName());

    /* The port on which the server should run */
    private int                 port   = 50051;
    private Server              server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port).addService(new PaymentServiceImpl()).build().start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            PaymentServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final PaymentServer server = new PaymentServer();
        server.start();
        server.blockUntilShutdown();
    }

}