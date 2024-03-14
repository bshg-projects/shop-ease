package org.bshg.shopease.webservice.converter.product;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.webservice.dto.product.ImageDto;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ImageConverter extends AbstractConverter<Image, ImageDto> {
@Autowired private ProductConverter productConverter;
private boolean product = true;
@Override
protected void config() {
config(Image.class, ImageDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.productConverter.setImages(value);
}
@Override
protected Image convertToItem(ImageDto dto) {
var item = new Image();
item.setId(dto.getId());
item.setUrl(dto.getUrl());
item.setProduct(productConverter.toItem(dto.getProduct()));
return item;
}
@Override
protected ImageDto convertToDto(Image item) {
var dto = new ImageDto();
dto.setId(item.getId());
dto.setUrl(item.getUrl());
dto.setProduct(product? productConverter.toDto(item.getProduct()): null);
return dto;
}
public void setProduct(boolean value) {
this.product = value;
}
public void setProductConverter(ProductConverter value) {
this.productConverter = value;
}
public ProductConverter getProductConverter() {
return productConverter;
}
}