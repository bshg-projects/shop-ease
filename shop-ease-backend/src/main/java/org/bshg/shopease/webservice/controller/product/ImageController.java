package org.bshg.shopease.webservice.controller.product;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.services.facade.product.ImageService;
import org.bshg.shopease.webservice.converter.product.ImageConverter;
import org.bshg.shopease.webservice.dto.product.ImageDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/image")
public class ImageController extends AbstractRestApi<Image,ImageDto,ImageService,ImageConverter> {
public ImageController( ImageService service, ImageConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<ImageDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<ImageDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<ImageDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<ImageDto> save(@RequestBody ImageDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<ImageDto>> save(@RequestBody List<ImageDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<ImageDto> update(@RequestBody ImageDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<ImageDto>> update(@RequestBody List<ImageDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<ImageDto> delete(@RequestBody ImageDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<ImageDto>> delete(@RequestBody List<ImageDto> dtos) {
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
@DeleteMapping("/product/id/{id}")
public ResponseEntity<Long> deleteByProductId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByProductId);
}
@GetMapping("/product/id/{id}")
public ResponseEntity<List<ImageDto>> findByProductId(@PathVariable Long id){
return super.findListByChildId(id, service::findByProductId);
}
}