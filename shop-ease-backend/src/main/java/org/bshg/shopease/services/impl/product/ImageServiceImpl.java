
package org.bshg.shopease.services.impl.product;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.repository.product.ImageDao;
import org.bshg.shopease.services.facade.product.ImageService;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.services.facade.product.ProductService;
import org.bshg.shopease.zutils.service.ServiceImpl;
import org.bshg.shopease.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ImageServiceImpl extends ServiceImpl<Image, ImageDao> implements ImageService {
public ImageServiceImpl(ImageDao dao) {
super(dao);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByProductId(Long id){
if (id == null) return 0;
return dao.deleteByProductId(id);
}
@Override
public List<Image> findByProductId(Long id){
return dao.findByProductId(id);
}
@Lazy @Autowired private ProductService productService;
}