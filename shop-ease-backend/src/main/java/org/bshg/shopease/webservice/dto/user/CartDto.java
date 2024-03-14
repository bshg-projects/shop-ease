package org.bshg.shopease.webservice.dto.user;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto extends AuditBaseDto {
public CartDto() {
super();
}
private boolean status;
private LocalDateTime creationDate;
private List<CartItemDto> cartItem;
private UserDto user;
public boolean isStatus() {
return status;
}
public void setStatus(boolean value) {
this.status = value;
}
public LocalDateTime getCreationDate() {
return creationDate;
}
public void setCreationDate(LocalDateTime value) {
this.creationDate = value;
}
public List<CartItemDto> getCartItem() {
return cartItem;
}
public void setCartItem(List<CartItemDto> value) {
this.cartItem = value;
}
public UserDto getUser() {
return user;
}
public void setUser(UserDto value) {
this.user = value;
}
}