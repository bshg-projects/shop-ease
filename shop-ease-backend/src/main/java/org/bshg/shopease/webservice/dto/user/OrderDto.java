package org.bshg.shopease.webservice.dto.user;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import org.bshg.shopease.entity.enums.OrderStatusEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto extends AuditBaseDto {
public OrderDto() {
super();
}
private float totalAmount;
private OrderStatusEnum status;
private LocalDateTime orderDate;
private List<OrderItemDto> orderItem;
private UserDto user;
public float getTotalAmount() {
return totalAmount;
}
public void setTotalAmount(float value) {
this.totalAmount = value;
}
public OrderStatusEnum getStatus() {
return status;
}
public void setStatus(OrderStatusEnum value) {
this.status = value;
}
public LocalDateTime getOrderDate() {
return orderDate;
}
public void setOrderDate(LocalDateTime value) {
this.orderDate = value;
}
public List<OrderItemDto> getOrderItem() {
return orderItem;
}
public void setOrderItem(List<OrderItemDto> value) {
this.orderItem = value;
}
public UserDto getUser() {
return user;
}
public void setUser(UserDto value) {
this.user = value;
}
}