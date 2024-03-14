package org.bshg.shopease.webservice.converter.user;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.webservice.dto.user.OrderDto;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class OrderConverter extends AbstractConverter<Order, OrderDto> {
@Autowired private UserConverter userConverter;
@Autowired private OrderItemConverter orderItemConverter;
private boolean orderItem = true;
private boolean user = true;
@Override
protected void config() {
config(Order.class, OrderDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.userConverter.setOrders(value);
this.orderItemConverter.setOrder(value);
}
@Override
protected Order convertToItem(OrderDto dto) {
var item = new Order();
item.setId(dto.getId());
item.setTotalAmount(dto.getTotalAmount());
item.setStatus(dto.getStatus());
item.setOrderDate(dto.getOrderDate());
item.setOrderItem(orderItemConverter.toItem(dto.getOrderItem()));
item.setUser(userConverter.toItem(dto.getUser()));
return item;
}
@Override
protected OrderDto convertToDto(Order item) {
var dto = new OrderDto();
dto.setId(item.getId());
dto.setTotalAmount(item.getTotalAmount());
dto.setStatus(item.getStatus());
dto.setOrderDate(item.getOrderDate());
dto.setOrderItem(orderItem? orderItemConverter.toDto(item.getOrderItem()): null);
dto.setUser(user? userConverter.toDto(item.getUser()): null);
return dto;
}
public void setOrderItem(boolean value) {
this.orderItem = value;
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
public void setOrderItemConverter(OrderItemConverter value) {
this.orderItemConverter = value;
}
public OrderItemConverter getOrderItemConverter() {
return orderItemConverter;
}
}