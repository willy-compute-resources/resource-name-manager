package software.thewillyhuman.rnm.model;

public final class ResourceNameBuilder {
    private String partition;
    private String service;
    private String region;
    private String accountId;

    private ResourceNameBuilder() {}

    public static ResourceNameBuilder aResourceName() {
        return new ResourceNameBuilder();
    }

    public ResourceNameBuilder withPartition(String partition) {
        this.partition = partition;
        return this;
    }

    public ResourceNameBuilder withService(String service) {
        this.service = service;
        return this;
    }

    public ResourceNameBuilder withRegion(String region) {
        this.region = region;
        return this;
    }

    public ResourceNameBuilder withAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public ResourceName build() {
        return new ResourceName(partition, service, region, accountId);
    }
}
