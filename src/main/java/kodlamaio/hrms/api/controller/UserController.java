package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entity.concretes.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getall")
    public DataResult<List<User>> getAll()
    {
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user){
        return this.userService.add(user);
    }
}
