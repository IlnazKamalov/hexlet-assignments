package exercise.controller;
import exercise.model.User;
import exercise.model.QUser;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


// Зависимости для самостоятельной работы
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import com.querydsl.core.types.Predicate;

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    // BEGIN
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<User> findAllByQuerydsl(
            @QuerydslPredicate(root = User.class)
            Predicate predicate) {

        return userRepository.findAll(predicate);
    }
    // END
    /*@GetMapping(path = "")
    public Iterable<User> filtrationUserByFullName(
                    @RequestParam(name = "firstName", required = false) String firstName,
                    @RequestParam(name = "lastName", required = false) String lastName) {

            if (firstName == null && lastName == null) {
                    return userRepository.findAll();
                }

            String first = firstName == null ? "" : firstName;
            String last = lastName == null ? "" : lastName;

            return userRepository
                            .findAll(QUser.user.firstName.containsIgnoreCase(first)
                                    .and
                                            (QUser.user.lastName.containsIgnoreCase(last)));
        }*/
}
