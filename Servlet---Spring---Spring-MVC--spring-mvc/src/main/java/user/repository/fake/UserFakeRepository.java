package user.repository.fake;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import user.domain.User;
import user.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserFakeRepository implements UserRepository {

  private Map<Long, User> users;

  @Override
  public Optional<User> findOne(final Long id) {
    return Optional.ofNullable(users.get(id));
  }

  @Override
  public Iterable<User> findAll() {
    return users.values();
  }

  @Override
  public void save(final User user) {
    users.put(user.getId(), user);
  }

  @Override
  public void delete(final User user) {
    users.remove(user.getId());
  }

  @PostConstruct
  public void init() {
    users = new HashMap<>(10);
    users.put(1L, new User(1L, "1@email.com", "1password"));
    users.put(2L, new User(2L, "2@email.com", "2password"));
    users.put(3L, new User(3L, "3@email.com", "3password"));
    users.put(4L, new User(4L, "4@email.com", "4password"));
    users.put(5L, new User(5L, "5@email.com", "5password"));
    users.put(6L, new User(6L, "6@email.com", "6password"));
    users.put(7L, new User(7L, "7@email.com", "7password"));
    users.put(8L, new User(8L, "8@email.com", "8password"));
    users.put(9L, new User(9L, "9@email.com", "9password"));
    users.put(10L, new User(10L, "10@email.com", "10password"));
  }
}
