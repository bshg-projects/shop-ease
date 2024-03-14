package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum ImagePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    ImagePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "image";
    }

    @Override
    public String authority() {
        return value;
    }
}
