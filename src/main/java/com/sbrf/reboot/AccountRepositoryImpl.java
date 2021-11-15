package com.sbrf.reboot;

import lombok.AllArgsConstructor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private static final String fileName = "Accounts.txt";

    @Override
    public Set<Account> getAllAccountsByClientId(long l) {
        Set<Account> result = new HashSet<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found: " + fileName);
        }
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(streamReader)
        ) {
            ArrayList<String> splitAccount = new ArrayList<>();
            bufferedReader.lines().forEach(account -> splitAccount.add(account));
            if (splitAccount.isEmpty()) {
                throw new IllegalArgumentException(fileName + " file is empty");
            }
            splitAccount.stream().forEach(num -> result.add(new Account(num)));

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
