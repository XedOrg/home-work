package com.sbrf.reboot;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.Set;
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository{
    @Getter
    private Map<Long, Set<Account>> accounts;

    @Override
    public Set<Account> getAllAccountsByClientId(long l) {
        return accounts.get(l);
    }
}
