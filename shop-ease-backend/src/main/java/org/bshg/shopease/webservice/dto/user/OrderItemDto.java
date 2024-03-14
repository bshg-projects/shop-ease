package org.bshg.shopease.webservice.dto.user;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import org.bshg.shopease.webservice.dto.product.ProductDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDto extends AuditBaseDto {
public OrderItemDto() {
super();
}
private int quantity;
private float unitPrice;
private OrderDto order;
private ProductDto product;
public int getQuantity() {
return quantity;
}
public void setQuantity(int value) {
this.quantity = value;
}
public float getUnitPrice() {
return unitPrice;
}
public void setUnitPrice(float value) {
this.unitPrice = value;
}
public OrderDto getOrder() {
return order;
}
public void setOrder(OrderDto value) {
this.order = value;
}
public ProductDto getProduct() {
return product;
}
public void setProduct(ProductDto value) {
this.product = value;
}
}