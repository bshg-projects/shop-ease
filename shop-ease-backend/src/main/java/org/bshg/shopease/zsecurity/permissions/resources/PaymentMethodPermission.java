package org.bshg.shopease.zsecurity.permissions.resources;
import org.bshg.shopease.zsecurity.permissions.PermissionResource;

public enum PaymentMethodPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    PaymentMethodPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "paymentMethod";
    }

    @Override
    public String authority() {
        return value;
    }
}
