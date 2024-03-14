package org.bshg.shopease.webservice.dto.user;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import org.bshg.shopease.webservice.dto.product.ProductDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemDto extends AuditBaseDto {
public CartItemDto() {
super();
}
private int quantity;
private CartDto cart;
private ProductDto product;
public int getQuantity() {
return quantity;
}
public void setQuantity(int value) {
this.quantity = value;
}
public CartDto getCart() {
return cart;
}
public void setCart(CartDto value) {
this.cart = value;
}
public ProductDto getProduct() {
return product;
}
public void setProduct(ProductDto value) {
this.product = value;
}
}