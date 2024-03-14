package org.bshg.shopease.webservice.converter.product;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.webservice.dto.product.ProductDto;
import org.bshg.shopease.webservice.converter.user.CartItemConverter;
import org.bshg.shopease.webservice.converter.user.OrderItemConverter;
import org.bshg.shopease.webservice.converter.category.CategoryConverter;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductConverter extends AbstractConverter<Product, ProductDto> {
@Autowired private CategoryConverter categoryConverter;
@Autowired private OrderItemConverter orderItemConverter;
@Autowired private CartItemConverter cartItemConverter;
@Autowired private ImageConverter imageConverter;
private boolean images = true;
private boolean cartItem = true;
private boolean orderItem = true;
private boolean category = true;
@Override
protected void config() {
config(Product.class, ProductDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.categoryConverter.setProducts(value);
this.orderItemConverter.setProduct(value);
this.cartItemConverter.setProduct(value);
this.imageConverter.setProduct(value);
}
@Override
protected Product convertToItem(ProductDto dto) {
var item = new Product();
item.setId(dto.getId());
item.setName(dto.getName());
item.setDescription(dto.getDescription());
item.setPrice(dto.getPrice());
item.setQuantityInStock(dto.getQuantityInStock());
item.setImages(imageConverter.toItem(dto.getImages()));
item.setCartItem(cartItemConverter.toItem(dto.getCartItem()));
item.setOrderItem(orderItemConverter.toItem(dto.getOrderItem()));
item.setCategory(categoryConverter.toItem(dto.getCategory()));
return item;
}
@Override
protected ProductDto convertToDto(Product item) {
var dto = new ProductDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setDescription(item.getDescription());
dto.setPrice(item.getPrice());
dto.setQuantityInStock(item.getQuantityInStock());
dto.setImages(images? imageConverter.toDto(item.getImages()): null);
dto.setCartItem(cartItem? cartItemConverter.toDto(item.getCartItem()): null);
dto.setOrderItem(orderItem? orderItemConverter.toDto(item.getOrderItem()): null);
dto.setCategory(category? categoryConverter.toDto(item.getCategory()): null);
return dto;
}
public void setImages(boolean value) {
this.images = value;
}
public void setCartItem(boolean value) {
this.cartItem = value;
}
public void setOrderItem(boolean value) {
this.orderItem = value;
}
public void setCategory(boolean value) {
this.category = value;
}
public void setCategoryConverter(CategoryConverter value) {
this.categoryConverter = value;
}
public CategoryConverter getCategoryConverter() {
return categoryConverter;
}
public void setOrderItemConverter(OrderItemConverter value) {
this.orderItemConverter = value;
}
public OrderItemConverter getOrderItemConverter() {
return orderItemConverter;
}
public void setCartItemConverter(CartItemConverter value) {
this.cartItemConverter = value;
}
public CartItemConverter getCartItemConverter() {
return cartItemConverter;
}
public void setImageConverter(ImageConverter value) {
this.imageConverter = value;
}
public ImageConverter getImageConverter() {
return imageConverter;
}
}