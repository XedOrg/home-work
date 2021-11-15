package com.sbrf.reboot;

import lombok.AllArgsConstructor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private static final String FILE_NAME = "Accounts.txt";

    @Override
    public Set<Account> getAllAccountsByClientId(long l) {
        Set<Account> result = new HashSet<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found: " + FILE_NAME);
        }
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(streamReader)
        ) {
            ArrayList<String> splitAccounts = new ArrayList<>();
            bufferedReader.lines().forEach(account -> splitAccounts.addAll(Arrays.asList(account.split(";"))));
            if (splitAccounts.isEmpty()) {
                throw new IllegalArgumentException(FILE_NAME + " file is empty");
            }
            splitAccounts.stream().forEach(s -> {
                String[] AccountArray = s.split("-");
                if (Long.parseLong(AccountArray[0]) == l) {
                    result.add(new Account(AccountArray[1]));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateAccountByClientId(long clientId, String newAccount) {
        getAllAccountsByClientId(clientId).remove(getAllAccountsByClientId(clientId).stream().findFirst().get());
        getAllAccountsByClientId(clientId).add(new Account(newAccount));
    }
}
