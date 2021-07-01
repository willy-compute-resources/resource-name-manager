package software.thewillyhuman.rnm.grpc;

import io.grpc.stub.StreamObserver;
import software.thewillyhuman.rnm.ResourceNameManagerServiceGrpc;
import software.thewillyhuman.rnm.ResourceNameManagerServices;
import software.thewillyhuman.rnm.model.ResourceNameBuilder;
import software.thewillyhuman.rnm.persistence.ResourceNamesRepository;

public class ResourceNameManagerService extends ResourceNameManagerServiceGrpc.ResourceNameManagerServiceImplBase {

    private ResourceNamesRepository repository;

    @Override
    public void requestResourceName(ResourceNameManagerServices.RequestResourceNameRequest request, StreamObserver<ResourceNameManagerServices.RequestResourceNameResponse> responseObserver)
    {
        var resourceName = ResourceNameBuilder.aResourceName()
                .withAccountId(request.getAccountId())
                .withService(request.getService())
                .withRegion(request.getRegion())
                .withAccountId(request.getAccountId())
                .build();

        repository.save(resourceName);

        var response = ResourceNameManagerServices.RequestResourceNameResponse.newBuilder()
                .setResourceName(resourceName.getQualifiedResourceName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getResourceForResourceName(ResourceNameManagerServices.GetResourceForResourceNameRequest request, StreamObserver<ResourceNameManagerServices.GetResourceForResourceNameResponse> responseObserver)
    {

    }
}
