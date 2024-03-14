package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum OrderPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    OrderPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "order";
    }

    @Override
    public String authority() {
        return value;
    }
}
