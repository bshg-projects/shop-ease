package org.bshg.shopease.webservice.controller.user;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.services.facade.user.UserService;
import org.bshg.shopease.webservice.converter.user.UserConverter;
import org.bshg.shopease.webservice.dto.user.UserDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractRestApi<User,UserDto,UserService,UserConverter> {
public UserController( UserService service, UserConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<UserDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<UserDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<UserDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<UserDto>> save(@RequestBody List<UserDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<UserDto>> update(@RequestBody List<UserDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<UserDto> delete(@RequestBody UserDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<UserDto>> delete(@RequestBody List<UserDto> dtos) {
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
@DeleteMapping("/address/id/{id}")
public ResponseEntity<Long> deleteByAddressId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByAddressId);
}
@GetMapping("/address/id/{id}")
public ResponseEntity<List<UserDto>> findByAddressId(@PathVariable Long id){
return super.findListByChildId(id, service::findByAddressId);
}
}