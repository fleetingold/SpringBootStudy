package com.example.accessingdatarest;

import org.springframework.web.bind.annotation.*;

@RestController
class NavigationGroupInUsersController {

  private final NavigationGroupInUsersRepository repository;

  NavigationGroupInUsersController(NavigationGroupInUsersRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/navigationgroupinusers")
  Iterable<NavigationGroupInUsers> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/navigationgroupinusers")
  NavigationGroupInUsers newNavigationGroupInUsers(@RequestBody NavigationGroupInUsers navigationGroupInUsers) {
    System.out.println("Id:" + navigationGroupInUsers.getId());
    System.out.println("NavigationGroupId:" + navigationGroupInUsers.getNavigationGroupId());
    System.out.println("UseId:" + navigationGroupInUsers.getUserId());
    System.out.println("ApplicationId:" + navigationGroupInUsers.getApplicationId());
    return repository.save(navigationGroupInUsers);
  }

  // Single item
  
  @GetMapping("/navigationgroupinusers/{id}")
  NavigationGroupInUsers one(@PathVariable String id) {
    return repository.findById(id).get();
  }

  @PutMapping("/navigationgroupinusers/{id}")
  NavigationGroupInUsers replaceEntireNavigationGroupInUsers(@RequestBody NavigationGroupInUsers navigationGroupInUsers, @PathVariable String id) {
    return repository.findById(id)
      .map(tmp -> {
        tmp.setNavigationGroupId(navigationGroupInUsers.getNavigationGroupId());
        tmp.setUserId(navigationGroupInUsers.getUserId());
        tmp.setApplicationId(navigationGroupInUsers.getApplicationId());
        return repository.save(tmp);
      })
      .orElseGet(() -> {
        navigationGroupInUsers.setId("0CF41101-3898-4856-B572-CA6BB52C37AA");
        return repository.save(navigationGroupInUsers);
      });
  }

  @PatchMapping("navigationgroupinusers/{id}")
  NavigationGroupInUsers UpdateSubsetNavigationGroupInUsers(@RequestBody NavigationGroupInUsers navigationGroupInUsers, @PathVariable String id){
    System.out.println("Id:" + navigationGroupInUsers.getId());
    System.out.println("NavigationGroupId:" + navigationGroupInUsers.getNavigationGroupId());
    System.out.println("UseId:" + navigationGroupInUsers.getUserId());
    System.out.println("ApplicationId:" + navigationGroupInUsers.getApplicationId());
    return repository.save(navigationGroupInUsers);
  }

  @DeleteMapping("/navigationgroupinusers/{id}")
  void deleteEmployee(@PathVariable String id) {
    repository.deleteById(id);
  }
}