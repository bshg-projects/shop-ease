package org.bshg.shopease.webservice.converter.user;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.webservice.dto.user.CartDto;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CartConverter extends AbstractConverter<Cart, CartDto> {
@Autowired private UserConverter userConverter;
@Autowired private CartItemConverter cartItemConverter;
private boolean cartItem = true;
private boolean user = true;
@Override
protected void config() {
config(Cart.class, CartDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.userConverter.setCarts(value);
this.cartItemConverter.setCart(value);
}
@Override
protected Cart convertToItem(CartDto dto) {
var item = new Cart();
item.setId(dto.getId());
item.setStatus(dto.isStatus());
item.setCreationDate(dto.getCreationDate());
item.setCartItem(cartItemConverter.toItem(dto.getCartItem()));
item.setUser(userConverter.toItem(dto.getUser()));
return item;
}
@Override
protected CartDto convertToDto(Cart item) {
var dto = new CartDto();
dto.setId(item.getId());
dto.setStatus(item.isStatus());
dto.setCreationDate(item.getCreationDate());
dto.setCartItem(cartItem? cartItemConverter.toDto(item.getCartItem()): null);
dto.setUser(user? userConverter.toDto(item.getUser()): null);
return dto;
}
public void setCartItem(boolean value) {
this.cartItem = value;
}
public void setUser(boolean value) {
this.user = value;
}
public void setUserConverter(UserConverter value) {
this.userConverter = value;
}
public UserConverter getUserConverter() {
return userConverter;
}
public void setCartItemConverter(CartItemConverter value) {
this.cartItemConverter = value;
}
public CartItemConverter getCartItemConverter() {
return cartItemConverter;
}
}