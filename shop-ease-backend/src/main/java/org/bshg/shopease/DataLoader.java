package org.bshg.shopease;
import org.bshg.shopease.zsecurity.entity.AppUser;
import org.bshg.shopease.zsecurity.entity.Role;
import org.bshg.shopease.zsecurity.service.facade.UserService;
import org.bshg.shopease.zsecurity.service.facade.RoleService;
import org.bshg.shopease.zsecurity.permissions.RoleEnum;
import org.bshg.shopease.services.facade.user.UserService;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.services.facade.user.CartItemService;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.services.facade.user.CartService;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.services.facade.user.OrderItemService;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.services.facade.user.OrderService;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.services.facade.product.ProductService;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.services.facade.product.ImageService;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.services.facade.category.CategoryService;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.services.facade.transaction.PaymentService;
import org.bshg.shopease.entity.core.transaction.Payment;
import org.bshg.shopease.services.facade.transaction.PaymentMethodService;
import org.bshg.shopease.entity.core.transaction.PaymentMethod;
import org.bshg.shopease.services.facade.transaction.AddressService;
import org.bshg.shopease.entity.core.transaction.Address;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;
@Component
public class DataLoader implements ApplicationRunner {
@Value("${app.data-loader.load}")
private boolean load;
@Override
public void run(ApplicationArguments args) throws Exception {
if (load) {
System.out.println("Data Loading...");
generatePermission();
generateAdminAccount();
generateUserAccount();
generateSellerAccount();
generateUser();
generateCartItem();
generateCart();
generateOrderItem();
generateOrder();
generateProduct();
generateImage();
generateCategory();
generatePayment();
generatePaymentMethod();
generateAddress();
System.out.println("Data Loaded!");
}
}
private void generatePermission() {
for (RoleEnum role : RoleEnum.values()) {
var roleEntity = role.getRole();
roleService.save(roleEntity);
}
}
private void generateAdminAccount() {
AppUser user = new AppUser("admin");
user.setPassword("123");
Role role = new Role();
role.setName(RoleEnum.ADMIN.name());
user.setRoles(new ArrayList<>());
user.getRoles().add(role);
userService.save(user);
System.out.println("One Account For ADMIN role is created: 'admin' :: '123'");
}
private void generateUserAccount() {
AppUser user = new AppUser("user");
user.setPassword("123");
Role role = new Role();
role.setName(RoleEnum.USER.name());
user.setRoles(new ArrayList<>());
user.getRoles().add(role);
userService.save(user);
System.out.println("One Account For USER role is created: 'user' :: '123'");
}
private void generateSellerAccount() {
AppUser user = new AppUser("seller");
user.setPassword("123");
Role role = new Role();
role.setName(RoleEnum.SELLER.name());
user.setRoles(new ArrayList<>());
user.getRoles().add(role);
userService.save(user);
System.out.println("One Account For SELLER role is created: 'seller' :: '123'");
}
private void generateUser() {
for (int i = 0; i < 50; i++) {
User item = new User();
item.setPhone("phone " + i);
item.setFirstName("firstName " + i);
item.setLastName("lastName " + i);
item.setUsername("User " + i);
item.setPassword(userService.cryptPassword("User " + i));
List<Role> savedRoles = roleService.save(item.getRoles());
item.setRoles(savedRoles);
userService.create(item);
}
System.out.println("Data For User Generated!");
}
private void generateCartItem() {
for (int i = 0; i < 50; i++) {
CartItem item = new CartItem();
cartItemService.create(item);
}
System.out.println("Data For CartItem Generated!");
}
private void generateCart() {
for (int i = 0; i < 50; i++) {
Cart item = new Cart();
cartService.create(item);
}
System.out.println("Data For Cart Generated!");
}
private void generateOrderItem() {
for (int i = 0; i < 50; i++) {
OrderItem item = new OrderItem();
orderItemService.create(item);
}
System.out.println("Data For OrderItem Generated!");
}
private void generateOrder() {
for (int i = 0; i < 50; i++) {
Order item = new Order();
orderService.create(item);
}
System.out.println("Data For Order Generated!");
}
private void generateProduct() {
for (int i = 0; i < 50; i++) {
Product item = new Product();
item.setName("name " + i);
item.setDescription("description " + i);
productService.create(item);
}
System.out.println("Data For Product Generated!");
}
private void generateImage() {
for (int i = 0; i < 50; i++) {
Image item = new Image();
item.setUrl("url " + i);
imageService.create(item);
}
System.out.println("Data For Image Generated!");
}
private void generateCategory() {
for (int i = 0; i < 50; i++) {
Category item = new Category();
item.setName("name " + i);
item.setDescription("description " + i);
categoryService.create(item);
}
System.out.println("Data For Category Generated!");
}
private void generatePayment() {
for (int i = 0; i < 50; i++) {
Payment item = new Payment();
paymentService.create(item);
}
System.out.println("Data For Payment Generated!");
}
private void generatePaymentMethod() {
for (int i = 0; i < 50; i++) {
PaymentMethod item = new PaymentMethod();
item.setName("name " + i);
paymentMethodService.create(item);
}
System.out.println("Data For PaymentMethod Generated!");
}
private void generateAddress() {
for (int i = 0; i < 50; i++) {
Address item = new Address();
item.setStreet("street " + i);
item.setCity("city " + i);
item.setPostalCode("postalCode " + i);
item.setCountry("country " + i);
addressService.create(item);
}
System.out.println("Data For Address Generated!");
}
@Autowired private UserService userService;
@Autowired private CartItemService cartItemService;
@Autowired private CartService cartService;
@Autowired private OrderItemService orderItemService;
@Autowired private OrderService orderService;
@Autowired private ProductService productService;
@Autowired private ImageService imageService;
@Autowired private CategoryService categoryService;
@Autowired private PaymentService paymentService;
@Autowired private PaymentMethodService paymentMethodService;
@Autowired private AddressService addressService;
@Autowired private UserService userService;
@Autowired private RoleService roleService;
}