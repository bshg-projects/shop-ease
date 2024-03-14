package org.bshg.shopease.webservice.controller.user;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.services.facade.user.CartService;
import org.bshg.shopease.webservice.converter.user.CartConverter;
import org.bshg.shopease.webservice.dto.user.CartDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cart")
public class CartController extends AbstractRestApi<Cart,CartDto,CartService,CartConverter> {
public CartController( CartService service, CartConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<CartDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<CartDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<CartDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<CartDto> save(@RequestBody CartDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<CartDto>> save(@RequestBody List<CartDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<CartDto> update(@RequestBody CartDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<CartDto>> update(@RequestBody List<CartDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<CartDto> delete(@RequestBody CartDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<CartDto>> delete(@RequestBody List<CartDto> dtos) {
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
@DeleteMapping("/user/id/{id}")
public ResponseEntity<Long> deleteByUserId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByUserId);
}
@GetMapping("/user/id/{id}")
public ResponseEntity<List<CartDto>> findByUserId(@PathVariable Long id){
return super.findListByChildId(id, service::findByUserId);
}
}