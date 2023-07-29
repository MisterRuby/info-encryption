package ruby.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;


    @GetMapping
    public List<Account> getList() {
        return accountRepository.findAll();
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) {

        Account account = new Account(signUpDto.getNickname(), signUpDto.getPassword());
        accountRepository.save(account);
    }

}
