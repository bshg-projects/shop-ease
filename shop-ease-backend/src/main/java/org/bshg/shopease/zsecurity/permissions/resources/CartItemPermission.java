package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum CartItemPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CartItemPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "cartItem";
    }

    @Override
    public String authority() {
        return value;
    }
}
