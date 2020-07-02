package com.shiva.auth.service;

import com.shiva.auth.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AccountUserDetailService implements UserDetailsService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountUserDetailService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.accountRepository.findByUsername(username)
                .map(account -> new User(account.getUsername(), account.getPassword(), account.isActive(), account.isActive(), account.isActive(), account.isActive()
                        , AuthorityUtils.createAuthorityList("ROLE_ADMINa", "ROLE_USER")))
                .orElseThrow(() -> new UsernameNotFoundException("No user name found with " + username));
    }
}