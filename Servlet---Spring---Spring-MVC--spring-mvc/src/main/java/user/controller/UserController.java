package user.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import user.dto.UserDto;
import user.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/api/users")
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ModelAndView get(
      @NotNull(message = "The id should not be null") @PathVariable final Long id) {
    return new ModelAndView("users/user").addObject("user", service.get(id));
  }

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView("users/users").addObject("users", service.get());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ModelAndView post(@RequestBody @Valid final UserDto dto) {
    service.create(dto);
    return new ModelAndView("users/users").addObject("users", service.get());
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ModelAndView put(
      @NotNull(message = "The id should not be null") @PathVariable final Long id,
      @PathVariable @RequestBody @Valid final UserDto dto) {
    service.update(id, dto);
    return new ModelAndView("users/user").addObject("user", dto);
  }

  @DeleteMapping(value = "/{id}")
  public ModelAndView delete(
      @NotNull(message = "The id should not be null") @PathVariable final Long id) {
    service.delete(id);
    return new ModelAndView("users/users").addObject("users", service.get());
  }
}
