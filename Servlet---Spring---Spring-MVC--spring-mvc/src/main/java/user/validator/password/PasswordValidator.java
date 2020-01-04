package user.validator.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

  @Override
  public void initialize(final Password constraintAnnotation) {}

  @Override
  public boolean isValid(
      final String password, final ConstraintValidatorContext constraintValidatorContext) {
    return password != null && password.length() > 8 ;
  }
}
