package user.conveter;

import org.springframework.stereotype.Component;
import user.domain.User;
import user.dto.UserDto;

@Component
public class UserConverter {

  public User toEntity(final UserDto dto) {
    return new User(dto.getId(), dto.getEmail(), dto.getPassword());
  }

  public UserDto toDto(final User entity) {
    return new UserDto(entity.getId(), entity.getEmail(), entity.getPassword());
  }

  public User enrich(final User entity, final UserDto dto) {
    entity.setEmail(dto.getEmail());
    entity.setPassword(dto.getPassword());
    return entity;
  }
}
