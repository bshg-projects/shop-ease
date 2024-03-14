package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum ProductPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    ProductPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "product";
    }

    @Override
    public String authority() {
        return value;
    }
}
