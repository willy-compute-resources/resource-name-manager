package software.thewillyhuman.rnm;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import software.thewillyhuman.rnm.grpc.ResourceNameManagerService;

import java.io.IOException;

public class ResourceNameServer {

    private static final int PORT = Integer.parseInt(System.getenv("SERVER_PORT") !=null ? System.getenv("SERVER_PORT"): "5000");

    private final Server grpcServer;

    public ResourceNameServer() {
        this.grpcServer = ServerBuilder
                .forPort(PORT)
                .addService(new ResourceNameManagerService())
                .build();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Server starting on port " + PORT);

        ResourceNameServer server = new ResourceNameServer();
        server.startGRPServer();

        System.out.println("Server started on port " + PORT);
    }

    private void blockUntilShutdown() throws InterruptedException {
        this.grpcServer.awaitTermination();
    }

    private void startGRPServer() throws IOException {
        this.grpcServer.start();
    }

}
