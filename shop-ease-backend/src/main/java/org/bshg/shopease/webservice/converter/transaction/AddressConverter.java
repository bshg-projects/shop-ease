package org.bshg.shopease.webservice.converter.transaction;
import org.bshg.shopease.entity.core.transaction.Address;
import org.bshg.shopease.webservice.dto.transaction.AddressDto;
import org.bshg.shopease.webservice.converter.user.UserConverter;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class AddressConverter extends AbstractConverter<Address, AddressDto> {
@Autowired private UserConverter userConverter;
private boolean users = true;
@Override
protected void config() {
config(Address.class, AddressDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.userConverter.setAddress(value);
}
@Override
protected Address convertToItem(AddressDto dto) {
var item = new Address();
item.setId(dto.getId());
item.setStreet(dto.getStreet());
item.setCity(dto.getCity());
item.setPostalCode(dto.getPostalCode());
item.setCountry(dto.getCountry());
item.setUsers(userConverter.toItem(dto.getUsers()));
return item;
}
@Override
protected AddressDto convertToDto(Address item) {
var dto = new AddressDto();
dto.setId(item.getId());
dto.setStreet(item.getStreet());
dto.setCity(item.getCity());
dto.setPostalCode(item.getPostalCode());
dto.setCountry(item.getCountry());
dto.setUsers(users? userConverter.toDto(item.getUsers()): null);
return dto;
}
public void setUsers(boolean value) {
this.users = value;
}
public void setUserConverter(UserConverter value) {
this.userConverter = value;
}
public UserConverter getUserConverter() {
return userConverter;
}
}