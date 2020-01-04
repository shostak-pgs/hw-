package user.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import user.exception.UserNotFoundException;

@ControllerAdvice
public class UserExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ModelAndView handleUserNotFoundException(final UserNotFoundException exception) {
    final ModelAndView content = new ModelAndView("errors/error");
    content.addObject("error", exception.getMessage());
    return content;
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ModelAndView handleIllegalArgumentException(final IllegalArgumentException exception) {
    final ModelAndView content = new ModelAndView("errors/error");
    content.addObject("error", exception.getMessage());
    return content;
  }
}
