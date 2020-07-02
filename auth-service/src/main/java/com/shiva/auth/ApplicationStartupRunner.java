package com.shiva.auth;

import com.shiva.auth.model.Account;
import com.shiva.auth.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private AccountRepository accountRepository;

    @Autowired
    public ApplicationStartupRunner(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> users = Arrays.asList("shiva,krishna", "admin,admin123", "user,password");
        users.stream().map(user -> user.split(",")).forEach(arr -> {

                    this.accountRepository.save(new Account(arr[0], arr[1], true));
                }
        );
    }
}