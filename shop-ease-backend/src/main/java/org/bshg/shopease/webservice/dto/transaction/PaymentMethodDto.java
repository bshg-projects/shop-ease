package org.bshg.shopease.webservice.dto.transaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethodDto extends AuditBaseDto {
public PaymentMethodDto() {
super();
}
private String name;
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
}