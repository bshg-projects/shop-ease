package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum AddressPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    AddressPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "address";
    }

    @Override
    public String authority() {
        return value;
    }
}
