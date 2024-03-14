package org.bshg.shopease.webservice.converter.transaction;
import org.bshg.shopease.entity.core.transaction.PaymentMethod;
import org.bshg.shopease.webservice.dto.transaction.PaymentMethodDto;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class PaymentMethodConverter extends AbstractConverter<PaymentMethod, PaymentMethodDto> {
@Override
protected void config() {
config(PaymentMethod.class, PaymentMethodDto.class);
}
@Override
protected PaymentMethod convertToItem(PaymentMethodDto dto) {
var item = new PaymentMethod();
item.setId(dto.getId());
item.setName(dto.getName());
return item;
}
@Override
protected PaymentMethodDto convertToDto(PaymentMethod item) {
var dto = new PaymentMethodDto();
dto.setId(item.getId());
dto.setName(item.getName());
return dto;
}
}