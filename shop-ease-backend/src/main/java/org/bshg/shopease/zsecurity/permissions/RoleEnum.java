package org.bshg.shopease.zsecurity.permissions;
import org.bshg.shopease.zsecurity.entity.Permission;
import org.bshg.shopease.zsecurity.entity.Role;
import org.bshg.shopease.zsecurity.permissions.resources.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
public enum RoleEnum {
ADMIN(
UserPermission.values(),
RolePermission.values(),
UserPermission.values(),
CartItemPermission.values(),
CartPermission.values(),
OrderItemPermission.values(),
OrderPermission.values(),
ProductPermission.values(),
ImagePermission.values(),
CategoryPermission.values(),
PaymentPermission.values(),
PaymentMethodPermission.values(),
AddressPermission.values()
),
USER(
UserPermission.EDIT,UserPermission.READ,
CartItemPermission.EDIT,CartItemPermission.CREATE,CartItemPermission.READ,
CartPermission.EDIT,CartPermission.CREATE,CartPermission.READ,
OrderItemPermission.EDIT,OrderItemPermission.CREATE,OrderItemPermission.READ,
OrderPermission.EDIT,OrderPermission.CREATE,OrderPermission.READ,
ProductPermission.READ,
ImagePermission.READ,
CategoryPermission.READ,
PaymentPermission.READ,
PaymentMethodPermission.READ,
AddressPermission.READ
),
SELLER(
UserPermission.EDIT,UserPermission.READ,
CartItemPermission.EDIT,CartItemPermission.CREATE,CartItemPermission.READ,
CartPermission.EDIT,CartPermission.CREATE,CartPermission.READ,
OrderItemPermission.EDIT,OrderItemPermission.CREATE,OrderItemPermission.READ,
OrderPermission.EDIT,OrderPermission.CREATE,OrderPermission.READ,
ProductPermission.values(),
ImagePermission.values(),
CategoryPermission.values(),
PaymentPermission.values(),
PaymentMethodPermission.values(),
AddressPermission.values()
),
;
private Set<PermissionResource> permissions = null;
RoleEnum() {}
RoleEnum(Object... permissionsList) {
this.permissions = Arrays.stream(permissionsList)
.flatMap(o -> {
if (o instanceof PermissionResource[]) {
return Arrays.stream((PermissionResource[]) o);
} else if (o instanceof PermissionResource) {
return Arrays.stream(new PermissionResource[]{(PermissionResource) o});
} else {
throw new IllegalArgumentException("Unsupported type in permissionsList");
}
}).collect(Collectors.toUnmodifiableSet());
}
public Set<PermissionResource> getPermissions() {
return permissions;
}
public Role getRole() {
var result = new Role();
result.setName(this.name());
result.setPermissions(
this.getPermissions().stream()
.map(p -> new Permission(p.authority()))
.collect(Collectors.toSet())
);
return result;
}
}