package org.bshg.shopease.webservice.controller.transaction;
import org.bshg.shopease.entity.core.transaction.Address;
import org.bshg.shopease.services.facade.transaction.AddressService;
import org.bshg.shopease.webservice.converter.transaction.AddressConverter;
import org.bshg.shopease.webservice.dto.transaction.AddressDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/address")
public class AddressController extends AbstractRestApi<Address,AddressDto,AddressService,AddressConverter> {
public AddressController( AddressService service, AddressConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<AddressDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<AddressDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<AddressDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<AddressDto> save(@RequestBody AddressDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<AddressDto>> save(@RequestBody List<AddressDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<AddressDto> update(@RequestBody AddressDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<AddressDto>> update(@RequestBody List<AddressDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<AddressDto> delete(@RequestBody AddressDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<AddressDto>> delete(@RequestBody List<AddressDto> dtos) {
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