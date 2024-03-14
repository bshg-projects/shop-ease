package org.bshg.shopease.repository.product;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ImageDao extends Repository<Image, Long> {
int deleteByProductId(Long id);
List<Image> findByProductId(Long id);
}