package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum CartPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CartPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "cart";
    }

    @Override
    public String authority() {
        return value;
    }
}
