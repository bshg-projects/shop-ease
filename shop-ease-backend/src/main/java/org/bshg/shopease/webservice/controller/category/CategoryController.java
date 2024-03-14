package org.bshg.shopease.webservice.controller.category;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.services.facade.category.CategoryService;
import org.bshg.shopease.webservice.converter.category.CategoryConverter;
import org.bshg.shopease.webservice.dto.category.CategoryDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/category")
public class CategoryController extends AbstractRestApi<Category,CategoryDto,CategoryService,CategoryConverter> {
public CategoryController( CategoryService service, CategoryConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<CategoryDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<CategoryDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<CategoryDto>> save(@RequestBody List<CategoryDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<CategoryDto>> update(@RequestBody List<CategoryDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<CategoryDto> delete(@RequestBody CategoryDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<CategoryDto>> delete(@RequestBody List<CategoryDto> dtos) {
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
}