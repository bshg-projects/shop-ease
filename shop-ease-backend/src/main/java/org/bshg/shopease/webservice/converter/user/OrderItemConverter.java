package org.bshg.shopease.webservice.converter.user;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.webservice.dto.user.OrderItemDto;
import org.bshg.shopease.webservice.converter.product.ProductConverter;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class OrderItemConverter extends AbstractConverter<OrderItem, OrderItemDto> {
@Autowired private OrderConverter orderConverter;
@Autowired private ProductConverter productConverter;
private boolean order = true;
private boolean product = true;
@Override
protected void config() {
config(OrderItem.class, OrderItemDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.orderConverter.setOrderItem(value);
this.productConverter.setOrderItem(value);
}
@Override
protected OrderItem convertToItem(OrderItemDto dto) {
var item = new OrderItem();
item.setId(dto.getId());
item.setQuantity(dto.getQuantity());
item.setUnitPrice(dto.getUnitPrice());
item.setOrder(orderConverter.toItem(dto.getOrder()));
item.setProduct(productConverter.toItem(dto.getProduct()));
return item;
}
@Override
protected OrderItemDto convertToDto(OrderItem item) {
var dto = new OrderItemDto();
dto.setId(item.getId());
dto.setQuantity(item.getQuantity());
dto.setUnitPrice(item.getUnitPrice());
dto.setOrder(order? orderConverter.toDto(item.getOrder()): null);
dto.setProduct(product? productConverter.toDto(item.getProduct()): null);
return dto;
}
public void setOrder(boolean value) {
this.order = value;
}
public void setProduct(boolean value) {
this.product = value;
}
public void setOrderConverter(OrderConverter value) {
this.orderConverter = value;
}
public OrderConverter getOrderConverter() {
return orderConverter;
}
public void setProductConverter(ProductConverter value) {
this.productConverter = value;
}
public ProductConverter getProductConverter() {
return productConverter;
}
}