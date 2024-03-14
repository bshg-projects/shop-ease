package org.bshg.shopease.webservice.controller.product;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.services.facade.product.ProductService;
import org.bshg.shopease.webservice.converter.product.ProductConverter;
import org.bshg.shopease.webservice.dto.product.ProductDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/product")
public class ProductController extends AbstractRestApi<Product,ProductDto,ProductService,ProductConverter> {
public ProductController( ProductService service, ProductConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<ProductDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<ProductDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<ProductDto> save(@RequestBody ProductDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<ProductDto>> save(@RequestBody List<ProductDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<ProductDto>> update(@RequestBody List<ProductDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<ProductDto> delete(@RequestBody ProductDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<ProductDto>> delete(@RequestBody List<ProductDto> dtos) {
return super.delete(dtos);
}
@Override
@DeleteMapping("/id/{id}")
public ResponseEntity<Long> deleteById(@PathVariable Long id) {
return super.deleteById(id);
}
@Override
@DeleteMapping("/ids")
public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
return super.deleteByIdIn(ids);
}
@DeleteMapping("/category/id/{id}")
public ResponseEntity<Long> deleteByCategoryId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByCategoryId);
}
@GetMapping("/category/id/{id}")
public ResponseEntity<List<ProductDto>> findByCategoryId(@PathVariable Long id){
return super.findListByChildId(id, service::findByCategoryId);
}
}