package user.service;

import org.springframework.stereotype.Service;
import user.conveter.UserConverter;
import user.domain.User;
import user.dto.UserDto;
import user.exception.UserNotFoundException;
import user.repository.UserRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

  private final UserRepository repository;
  private final UserConverter converter;

  public UserService(UserRepository repository, UserConverter converter) {
    this.repository = repository;
    this.converter = converter;
  }

  @NotNull(message = "The user not found")
  public UserDto get(final Long id) {
    return converter.toDto(repository.findOne(id).orElseThrow(UserNotFoundException::new));
  }

  @NotEmpty(message = "The users not found")
  public List<UserDto> get() {
    return StreamSupport.stream(repository.findAll().spliterator(), false)
        .map(converter::toDto)
        .collect(Collectors.toList());
  }

  public UserDto create(final UserDto dto) {
    repository.save(converter.toEntity(dto));
    return dto;
  }

  public UserDto update(final Long id, final UserDto dto) {
    final User entity = repository.findOne(id).orElseThrow(UserNotFoundException::new);
    repository.save(converter.enrich(entity, dto));
    return dto;
  }

  public void delete(final Long id) {
    final User entity = repository.findOne(id).orElseThrow(UserNotFoundException::new);
    repository.delete(entity);
  }
}
