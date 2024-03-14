package org.bshg.shopease.services.facade.product;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.zutils.service.IService;
import java.util.List;
public interface ImageService extends IService<Image> {
int deleteByProductId(Long id);
List<Image> findByProductId(Long id);
}