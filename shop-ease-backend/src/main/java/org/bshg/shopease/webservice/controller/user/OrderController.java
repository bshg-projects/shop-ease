package org.bshg.shopease.webservice.controller.user;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.services.facade.user.OrderService;
import org.bshg.shopease.webservice.converter.user.OrderConverter;
import org.bshg.shopease.webservice.dto.user.OrderDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/order")
public class OrderController extends AbstractRestApi<Order,OrderDto,OrderService,OrderConverter> {
public OrderController( OrderService service, OrderConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<OrderDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<OrderDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<OrderDto> save(@RequestBody OrderDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<OrderDto>> save(@RequestBody List<OrderDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<OrderDto> update(@RequestBody OrderDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<OrderDto>> update(@RequestBody List<OrderDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<OrderDto> delete(@RequestBody OrderDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<OrderDto>> delete(@RequestBody List<OrderDto> dtos) {
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
public ResponseEntity<List<OrderDto>> findByUserId(@PathVariable Long id){
return super.findListByChildId(id, service::findByUserId);
}
}