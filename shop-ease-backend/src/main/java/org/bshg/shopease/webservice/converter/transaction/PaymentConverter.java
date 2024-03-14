package org.bshg.shopease.webservice.converter.transaction;
import org.bshg.shopease.entity.core.transaction.Payment;
import org.bshg.shopease.webservice.dto.transaction.PaymentDto;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class PaymentConverter extends AbstractConverter<Payment, PaymentDto> {
@Autowired private PaymentMethodConverter paymentMethodConverter;
private boolean paymentMethod = true;
@Override
protected void config() {
config(Payment.class, PaymentDto.class);
}
@Override
protected void convertersConfig(boolean value) {
}
@Override
protected Payment convertToItem(PaymentDto dto) {
var item = new Payment();
item.setId(dto.getId());
item.setPaymentDate(dto.getPaymentDate());
item.setAmount(dto.getAmount());
item.setPaymentMethod(paymentMethodConverter.toItem(dto.getPaymentMethod()));
return item;
}
@Override
protected PaymentDto convertToDto(Payment item) {
var dto = new PaymentDto();
dto.setId(item.getId());
dto.setPaymentDate(item.getPaymentDate());
dto.setAmount(item.getAmount());
dto.setPaymentMethod(paymentMethod? paymentMethodConverter.toDto(item.getPaymentMethod()): null);
return dto;
}
public void setPaymentMethod(boolean value) {
this.paymentMethod = value;
}
public void setPaymentMethodConverter(PaymentMethodConverter value) {
this.paymentMethodConverter = value;
}
public PaymentMethodConverter getPaymentMethodConverter() {
return paymentMethodConverter;
}
}