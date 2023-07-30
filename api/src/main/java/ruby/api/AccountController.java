package ruby.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ruby.api.encrypt.AES256Util;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AES256Util aes256Util;

    @GetMapping("/encryptData")
    public List<AccountDto> getEncryptList() {
        return accountRepository.findAll().stream()
            .map(account -> new AccountDto(account.getNickname(), account.getPassword()))
            .collect(Collectors.toList());
    }

    @GetMapping("/decryptData")
    public List<AccountDto> getDncryptList() {
        return accountRepository.findAll().stream()
            .map(account -> {
                String decryptNickname = aes256Util.decrypt(account.getNickname());
                return new AccountDto(decryptNickname, account.getPassword());
            })
            .collect(Collectors.toList());
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody AccountDto accountDto) {
        String encryptNickname = aes256Util.encrypt(accountDto.nickname());
        String encodePassword = passwordEncoder.encode(accountDto.password());

        Account account = new Account(encryptNickname, encodePassword);
        accountRepository.save(account);
    }

}
