package software.thewillyhuman.rnm.persistence;

import software.thewillyhuman.rnm.model.ResourceName;

import java.util.List;
import java.util.Optional;

public interface ResourceNamesRepository {

    /**
     * Saves or updates the given resource name in the persistence layer.
     *
     * @param resourceName to save or update.
     * @return the saved or updated resource name object.
     */
    ResourceName save(ResourceName resourceName);

    /**
     * Gets a list with all the resource names in the persistence layer.
     *
     * @return a list that contains all the resource name objects in the storage.
     */
    List<ResourceName> getAll();

    /**
     * Gets a list with all the resource names registered by the given account id.
     *
     * @param accountId to filter the resource names.
     * @return a list with all the resource names registered by the given account id.
     */
    List<ResourceName> getAllByAccountId(String accountId);

    /**
     * Gets a list with all the resource names registered by the given service.
     *
     * @param service to filter the resource names.
     * @return a list with all the resource names registered by the given service.
     */
    List<ResourceName> getAllByAccountService(String service);

    /**
     * Gets all the the information about the resourcename for the given qualified resource name.
     *
     * @param qualifiedResourceName to filter.
     * @return an option object that might
     */
    Optional<ResourceName> getResourceNameByQualifiedName(String qualifiedResourceName);
}
