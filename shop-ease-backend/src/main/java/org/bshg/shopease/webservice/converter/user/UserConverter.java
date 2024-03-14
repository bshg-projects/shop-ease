package org.bshg.shopease.webservice.converter.user;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.webservice.dto.user.UserDto;
import org.bshg.shopease.zsecurity.ws.converter.UserConverter;
import org.bshg.shopease.webservice.converter.transaction.AddressConverter;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UserConverter extends AbstractConverter<User, UserDto> {
@Autowired private UserConverter userConverter;
@Autowired private OrderConverter orderConverter;
@Autowired private AddressConverter addressConverter;
@Autowired private CartConverter cartConverter;
private boolean orders = true;
private boolean carts = true;
private boolean address = true;
@Override
protected void config() {
config(User.class, UserDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.orderConverter.setUser(value);
this.addressConverter.setUsers(value);
this.cartConverter.setUser(value);
}
@Override
protected User convertToItem(UserDto dto) {
var item = new User();
userConverter.convertToChildItem(dto, item);
item.setPhone(dto.getPhone());
item.setFirstName(dto.getFirstName());
item.setLastName(dto.getLastName());
item.setOrders(orderConverter.toItem(dto.getOrders()));
item.setCarts(cartConverter.toItem(dto.getCarts()));
item.setAddress(addressConverter.toItem(dto.getAddress()));
return item;
}
@Override
protected UserDto convertToDto(User item) {
var dto = new UserDto();
userConverter.convertToChildDto(item, dto);
dto.setPhone(item.getPhone());
dto.setFirstName(item.getFirstName());
dto.setLastName(item.getLastName());
dto.setOrders(orders? orderConverter.toDto(item.getOrders()): null);
dto.setCarts(carts? cartConverter.toDto(item.getCarts()): null);
dto.setAddress(address? addressConverter.toDto(item.getAddress()): null);
return dto;
}
public void setOrders(boolean value) {
this.orders = value;
}
public void setCarts(boolean value) {
this.carts = value;
}
public void setAddress(boolean value) {
this.address = value;
}
public void setOrderConverter(OrderConverter value) {
this.orderConverter = value;
}
public OrderConverter getOrderConverter() {
return orderConverter;
}
public void setAddressConverter(AddressConverter value) {
this.addressConverter = value;
}
public AddressConverter getAddressConverter() {
return addressConverter;
}
public void setCartConverter(CartConverter value) {
this.cartConverter = value;
}
public CartConverter getCartConverter() {
return cartConverter;
}
}