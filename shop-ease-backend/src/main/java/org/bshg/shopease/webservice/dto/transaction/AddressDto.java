package org.bshg.shopease.webservice.dto.transaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import org.bshg.shopease.webservice.dto.user.UserDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto extends AuditBaseDto {
public AddressDto() {
super();
}
private String street;
private String city;
private String postalCode;
private String country;
private List<UserDto> users;
public String getStreet() {
return street;
}
public void setStreet(String value) {
this.street = value;
}
public String getCity() {
return city;
}
public void setCity(String value) {
this.city = value;
}
public String getPostalCode() {
return postalCode;
}
public void setPostalCode(String value) {
this.postalCode = value;
}
public String getCountry() {
return country;
}
public void setCountry(String value) {
this.country = value;
}
public List<UserDto> getUsers() {
return users;
}
public void setUsers(List<UserDto> value) {
this.users = value;
}
}