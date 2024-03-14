package org.bshg.shopease.webservice.dto.user;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zsecurity.ws.dto.UserDto;
import org.bshg.shopease.webservice.dto.transaction.AddressDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto extends UserDto {
public UserDto() {
super();
}
private String phone;
private String firstName;
private String lastName;
private List<OrderDto> orders;
private List<CartDto> carts;
private AddressDto address;
public String getPhone() {
return phone;
}
public void setPhone(String value) {
this.phone = value;
}
public String getFirstName() {
return firstName;
}
public void setFirstName(String value) {
this.firstName = value;
}
public String getLastName() {
return lastName;
}
public void setLastName(String value) {
this.lastName = value;
}
public List<OrderDto> getOrders() {
return orders;
}
public void setOrders(List<OrderDto> value) {
this.orders = value;
}
public List<CartDto> getCarts() {
return carts;
}
public void setCarts(List<CartDto> value) {
this.carts = value;
}
public AddressDto getAddress() {
return address;
}
public void setAddress(AddressDto value) {
this.address = value;
}
}