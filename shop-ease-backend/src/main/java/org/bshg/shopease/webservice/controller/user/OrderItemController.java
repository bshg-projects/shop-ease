package org.bshg.shopease.webservice.controller.user;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.services.facade.user.OrderItemService;
import org.bshg.shopease.webservice.converter.user.OrderItemConverter;
import org.bshg.shopease.webservice.dto.user.OrderItemDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/orderitem")
public class OrderItemController extends AbstractRestApi<OrderItem,OrderItemDto,OrderItemService,OrderItemConverter> {
public OrderItemController( OrderItemService service, OrderItemConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<OrderItemDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<OrderItemDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<OrderItemDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<OrderItemDto> save(@RequestBody OrderItemDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<OrderItemDto>> save(@RequestBody List<OrderItemDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<OrderItemDto> update(@RequestBody OrderItemDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<OrderItemDto>> update(@RequestBody List<OrderItemDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<OrderItemDto> delete(@RequestBody OrderItemDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<OrderItemDto>> delete(@RequestBody List<OrderItemDto> dtos) {
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
@DeleteMapping("/order/id/{id}")
public ResponseEntity<Long> deleteByOrderId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByOrderId);
}
@GetMapping("/order/id/{id}")
public ResponseEntity<List<OrderItemDto>> findByOrderId(@PathVariable Long id){
return super.findListByChildId(id, service::findByOrderId);
}
@DeleteMapping("/product/id/{id}")
public ResponseEntity<Long> deleteByProductId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByProductId);
}
@GetMapping("/product/id/{id}")
public ResponseEntity<List<OrderItemDto>> findByProductId(@PathVariable Long id){
return super.findListByChildId(id, service::findByProductId);
}
}