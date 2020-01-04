package user.repository;

import user.domain.User;

import java.util.Optional;

public interface UserRepository {

  Optional<User> findOne(final Long id);

  Iterable<User> findAll();

  void save(final User user);

  void delete(final User user);
}
