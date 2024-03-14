package org.bshg.shopease.webservice.converter.user;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.webservice.dto.user.CartItemDto;
import org.bshg.shopease.webservice.converter.product.ProductConverter;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CartItemConverter extends AbstractConverter<CartItem, CartItemDto> {
@Autowired private ProductConverter productConverter;
@Autowired private CartConverter cartConverter;
private boolean cart = true;
private boolean product = true;
@Override
protected void config() {
config(CartItem.class, CartItemDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.productConverter.setCartItem(value);
this.cartConverter.setCartItem(value);
}
@Override
protected CartItem convertToItem(CartItemDto dto) {
var item = new CartItem();
item.setId(dto.getId());
item.setQuantity(dto.getQuantity());
item.setCart(cartConverter.toItem(dto.getCart()));
item.setProduct(productConverter.toItem(dto.getProduct()));
return item;
}
@Override
protected CartItemDto convertToDto(CartItem item) {
var dto = new CartItemDto();
dto.setId(item.getId());
dto.setQuantity(item.getQuantity());
dto.setCart(cart? cartConverter.toDto(item.getCart()): null);
dto.setProduct(product? productConverter.toDto(item.getProduct()): null);
return dto;
}
public void setCart(boolean value) {
this.cart = value;
}
public void setProduct(boolean value) {
this.product = value;
}
public void setProductConverter(ProductConverter value) {
this.productConverter = value;
}
public ProductConverter getProductConverter() {
return productConverter;
}
public void setCartConverter(CartConverter value) {
this.cartConverter = value;
}
public CartConverter getCartConverter() {
return cartConverter;
}
}