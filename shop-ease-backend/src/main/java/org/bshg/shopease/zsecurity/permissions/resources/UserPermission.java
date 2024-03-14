package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum UserPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    UserPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "user";
    }

    @Override
    public String authority() {
        return value;
    }
}
