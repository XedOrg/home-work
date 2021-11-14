package com.sbrf.reboot;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public boolean isAccountExist(long l, Account account) {
        return accountRepository.getAllAccountsByClientId(l).contains(account);
    }
}
