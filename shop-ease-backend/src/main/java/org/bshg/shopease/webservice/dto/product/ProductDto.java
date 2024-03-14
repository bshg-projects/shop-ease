package org.bshg.shopease.webservice.dto.product;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import org.bshg.shopease.webservice.dto.category.CategoryDto;
import org.bshg.shopease.webservice.dto.user.OrderItemDto;
import org.bshg.shopease.webservice.dto.user.CartItemDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends AuditBaseDto {
public ProductDto() {
super();
}
private String name;
private String description;
private float price;
private int quantityInStock;
private List<ImageDto> images;
private List<CartItemDto> cartItem;
private List<OrderItemDto> orderItem;
private CategoryDto category;
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
public String getDescription() {
return description;
}
public void setDescription(String value) {
this.description = value;
}
public float getPrice() {
return price;
}
public void setPrice(float value) {
this.price = value;
}
public int getQuantityInStock() {
return quantityInStock;
}
public void setQuantityInStock(int value) {
this.quantityInStock = value;
}
public List<ImageDto> getImages() {
return images;
}
public void setImages(List<ImageDto> value) {
this.images = value;
}
public List<CartItemDto> getCartItem() {
return cartItem;
}
public void setCartItem(List<CartItemDto> value) {
this.cartItem = value;
}
public List<OrderItemDto> getOrderItem() {
return orderItem;
}
public void setOrderItem(List<OrderItemDto> value) {
this.orderItem = value;
}
public CategoryDto getCategory() {
return category;
}
public void setCategory(CategoryDto value) {
this.category = value;
}
}