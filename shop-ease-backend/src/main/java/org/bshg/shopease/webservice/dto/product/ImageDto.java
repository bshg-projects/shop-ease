package org.bshg.shopease.webservice.dto.product;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDto extends AuditBaseDto {
public ImageDto() {
super();
}
private String url;
private ProductDto product;
public String getUrl() {
return url;
}
public void setUrl(String value) {
this.url = value;
}
public ProductDto getProduct() {
return product;
}
public void setProduct(ProductDto value) {
this.product = value;
}
}