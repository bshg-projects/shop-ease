package org.bshg.shopease.webservice.dto.transaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto extends AuditBaseDto {
public PaymentDto() {
super();
}
private LocalDateTime paymentDate;
private float amount;
private PaymentMethodDto paymentMethod;
public LocalDateTime getPaymentDate() {
return paymentDate;
}
public void setPaymentDate(LocalDateTime value) {
this.paymentDate = value;
}
public float getAmount() {
return amount;
}
public void setAmount(float value) {
this.amount = value;
}
public PaymentMethodDto getPaymentMethod() {
return paymentMethod;
}
public void setPaymentMethod(PaymentMethodDto value) {
this.paymentMethod = value;
}
}