package org.bshg.shopease.webservice.controller.user;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.services.facade.user.CartItemService;
import org.bshg.shopease.webservice.converter.user.CartItemConverter;
import org.bshg.shopease.webservice.dto.user.CartItemDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cartitem")
public class CartItemController extends AbstractRestApi<CartItem,CartItemDto,CartItemService,CartItemConverter> {
public CartItemController( CartItemService service, CartItemConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<CartItemDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<CartItemDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<CartItemDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<CartItemDto> save(@RequestBody CartItemDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<CartItemDto>> save(@RequestBody List<CartItemDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<CartItemDto> update(@RequestBody CartItemDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<CartItemDto>> update(@RequestBody List<CartItemDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<CartItemDto> delete(@RequestBody CartItemDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<CartItemDto>> delete(@RequestBody List<CartItemDto> dtos) {
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
@DeleteMapping("/cart/id/{id}")
public ResponseEntity<Long> deleteByCartId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByCartId);
}
@GetMapping("/cart/id/{id}")
public ResponseEntity<List<CartItemDto>> findByCartId(@PathVariable Long id){
return super.findListByChildId(id, service::findByCartId);
}
@DeleteMapping("/product/id/{id}")
public ResponseEntity<Long> deleteByProductId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByProductId);
}
@GetMapping("/product/id/{id}")
public ResponseEntity<List<CartItemDto>> findByProductId(@PathVariable Long id){
return super.findListByChildId(id, service::findByProductId);
}
}