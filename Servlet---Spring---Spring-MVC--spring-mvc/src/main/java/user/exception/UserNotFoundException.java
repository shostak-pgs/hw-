package user.exception;

public class UserNotFoundException extends RuntimeException {

  private final String message;

  public UserNotFoundException(String message) {
    this.message = message;
  }

  public UserNotFoundException() {
    this.message = "User not found";
  }

  @Override
  public String getMessage() {
    return message;
  }
}
