package software.thewillyhuman.rnm.model;

import java.util.UUID;

public class ResourceName {

    private final String partition;
    private final String service;
    private final String region;
    private final String accountId;
    private final String resourceId;
    private final long creationDate;

    protected ResourceName(final String partition, final String service, final String region, final String accountId)
    {
        this.partition = partition;
        this.service = service;
        this.region = region;
        this.accountId = accountId;
        this.resourceId = UUID.randomUUID().toString();
        this.creationDate = System.currentTimeMillis();
    }

    public String getPartition() {
        return partition;
    }

    public String getService() {
        return service;
    }

    public String getRegion() {
        return region;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public String getQualifiedResourceName() {
        return "rn:" + this.partition + ":"
                + this.service + ":"
                + this.region + ":"
                + this.accountId + ":"
                + this.resourceId;
    }

    @Override
    public String toString() {
        return "ResourceName{" +
                "partition='" + partition + '\'' +
                ", service='" + service + '\'' +
                ", region='" + region + '\'' +
                ", accountId='" + accountId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", fullyQualifiedName='" + getQualifiedResourceName() + '\'' +
                '}';
    }
}
