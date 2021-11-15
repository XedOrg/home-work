package com.sbrf.reboot;

import java.util.Set;

public interface AccountRepository {

    Set<Account> getAllAccountsByClientId(long l);

    void updateAccountByClientId(long clientId, String newAccount);
}
