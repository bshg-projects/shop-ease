package org.bshg.shopease.zsecurity.config;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.bshg.shopease.zsecurity.permissions.resources.*;
import org.bshg.shopease.zsecurity.permissions.RoleEnum;
import static org.springframework.http.HttpMethod.*;
public class RequestConfig {
private RequestConfig() {}
private static HttpSecurity http;
public static void set(HttpSecurity http) throws Exception {
if (RequestConfig.http == null) RequestConfig.http = http;
userAuthorizeHttpRequests();
cartItemAuthorizeHttpRequests();
cartAuthorizeHttpRequests();
orderItemAuthorizeHttpRequests();
orderAuthorizeHttpRequests();
productAuthorizeHttpRequests();
imageAuthorizeHttpRequests();
categoryAuthorizeHttpRequests();
paymentAuthorizeHttpRequests();
paymentMethodAuthorizeHttpRequests();
addressAuthorizeHttpRequests();
userAuthorizeHttpRequests();
roleAuthorizeHttpRequests();
defaultAuthorizeHttpRequests();
}
private static void userAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/v1/user/**").hasAnyAuthority(UserPermission.READ.authority())
.requestMatchers(POST, "/api/v1/user/**").hasAnyAuthority(UserPermission.CREATE.authority())
.requestMatchers(PUT, "/api/v1/user/**").hasAnyAuthority(UserPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/v1/user/**").hasAnyAuthority(UserPermission.DELETE.authority())
.requestMatchers("/api/v1/user/**").hasAnyRole(RoleEnum.ADMIN.name())
);
}
private static void roleAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/v1/role/**").hasAnyAuthority(RolePermission.READ.authority())
.requestMatchers(POST, "/api/v1/role/**").hasAnyAuthority(RolePermission.CREATE.authority())
.requestMatchers(PUT, "/api/v1/role/**").hasAnyAuthority(RolePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/v1/role/**").hasAnyAuthority(RolePermission.DELETE.authority())
.requestMatchers("/api/v1/role/**").hasAnyRole(RoleEnum.ADMIN.name())
);
}
private static void userAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/user/**").hasAnyAuthority(UserPermission.READ.authority())
.requestMatchers(POST, "/api/user/**").hasAnyAuthority(UserPermission.CREATE.authority())
.requestMatchers(PUT, "/api/user/**").hasAnyAuthority(UserPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/user/**").hasAnyAuthority(UserPermission.DELETE.authority())
.requestMatchers("/api/user/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void cartItemAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/cartitem/**").hasAnyAuthority(CartItemPermission.READ.authority())
.requestMatchers(POST, "/api/cartitem/**").hasAnyAuthority(CartItemPermission.CREATE.authority())
.requestMatchers(PUT, "/api/cartitem/**").hasAnyAuthority(CartItemPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/cartitem/**").hasAnyAuthority(CartItemPermission.DELETE.authority())
.requestMatchers("/api/cartitem/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void cartAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/cart/**").hasAnyAuthority(CartPermission.READ.authority())
.requestMatchers(POST, "/api/cart/**").hasAnyAuthority(CartPermission.CREATE.authority())
.requestMatchers(PUT, "/api/cart/**").hasAnyAuthority(CartPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/cart/**").hasAnyAuthority(CartPermission.DELETE.authority())
.requestMatchers("/api/cart/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void orderItemAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/orderitem/**").hasAnyAuthority(OrderItemPermission.READ.authority())
.requestMatchers(POST, "/api/orderitem/**").hasAnyAuthority(OrderItemPermission.CREATE.authority())
.requestMatchers(PUT, "/api/orderitem/**").hasAnyAuthority(OrderItemPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/orderitem/**").hasAnyAuthority(OrderItemPermission.DELETE.authority())
.requestMatchers("/api/orderitem/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void orderAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/order/**").hasAnyAuthority(OrderPermission.READ.authority())
.requestMatchers(POST, "/api/order/**").hasAnyAuthority(OrderPermission.CREATE.authority())
.requestMatchers(PUT, "/api/order/**").hasAnyAuthority(OrderPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/order/**").hasAnyAuthority(OrderPermission.DELETE.authority())
.requestMatchers("/api/order/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void productAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/product/**").hasAnyAuthority(ProductPermission.READ.authority())
.requestMatchers(POST, "/api/product/**").hasAnyAuthority(ProductPermission.CREATE.authority())
.requestMatchers(PUT, "/api/product/**").hasAnyAuthority(ProductPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/product/**").hasAnyAuthority(ProductPermission.DELETE.authority())
.requestMatchers("/api/product/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void imageAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/image/**").hasAnyAuthority(ImagePermission.READ.authority())
.requestMatchers(POST, "/api/image/**").hasAnyAuthority(ImagePermission.CREATE.authority())
.requestMatchers(PUT, "/api/image/**").hasAnyAuthority(ImagePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/image/**").hasAnyAuthority(ImagePermission.DELETE.authority())
.requestMatchers("/api/image/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void categoryAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/category/**").hasAnyAuthority(CategoryPermission.READ.authority())
.requestMatchers(POST, "/api/category/**").hasAnyAuthority(CategoryPermission.CREATE.authority())
.requestMatchers(PUT, "/api/category/**").hasAnyAuthority(CategoryPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/category/**").hasAnyAuthority(CategoryPermission.DELETE.authority())
.requestMatchers("/api/category/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void paymentAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/payment/**").hasAnyAuthority(PaymentPermission.READ.authority())
.requestMatchers(POST, "/api/payment/**").hasAnyAuthority(PaymentPermission.CREATE.authority())
.requestMatchers(PUT, "/api/payment/**").hasAnyAuthority(PaymentPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/payment/**").hasAnyAuthority(PaymentPermission.DELETE.authority())
.requestMatchers("/api/payment/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void paymentMethodAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/paymentmethod/**").hasAnyAuthority(PaymentMethodPermission.READ.authority())
.requestMatchers(POST, "/api/paymentmethod/**").hasAnyAuthority(PaymentMethodPermission.CREATE.authority())
.requestMatchers(PUT, "/api/paymentmethod/**").hasAnyAuthority(PaymentMethodPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/paymentmethod/**").hasAnyAuthority(PaymentMethodPermission.DELETE.authority())
.requestMatchers("/api/paymentmethod/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void addressAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/address/**").hasAnyAuthority(AddressPermission.READ.authority())
.requestMatchers(POST, "/api/address/**").hasAnyAuthority(AddressPermission.CREATE.authority())
.requestMatchers(PUT, "/api/address/**").hasAnyAuthority(AddressPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/address/**").hasAnyAuthority(AddressPermission.DELETE.authority())
.requestMatchers("/api/address/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.USER.name(),RoleEnum.SELLER.name())
);
}
private static void defaultAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers("/login").permitAll()
.requestMatchers("/api/login").permitAll()
.requestMatchers("/api/**").authenticated()
.anyRequest().authenticated());
}
}