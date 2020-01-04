package user.dto;

import user.validator.password.Password;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class UserDto {

  private final Long id;
  private final String email;
  private final String password;

  public UserDto(Long id, @NotBlank String email, @Password String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserDto userDto = (UserDto) o;

    if (!Objects.equals(id, userDto.id)) return false;
    if (!Objects.equals(email, userDto.email)) return false;
    return Objects.equals(password, userDto.password);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserDto{" + "id=" + id + ", email='" + email + '\'' + ", password='***'}";
  }
}
