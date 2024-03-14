package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum OrderItemPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    OrderItemPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "orderItem";
    }

    @Override
    public String authority() {
        return value;
    }
}
