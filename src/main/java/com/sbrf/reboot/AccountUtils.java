package com.sbrf.reboot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountUtils {
    public static void sortedById(List<Account> accounts) {
        accounts.sort(((o1, o2) -> o1.getId().compareTo(o2.getId())));
    }


    public static void sortedByIdDate(List<Account> accounts) {
        Collections.sort(accounts, Comparator.comparing(Account::getId)
                .thenComparing(Account::getCreateDate));
    }
/**
 * ascending sort by Id and CreateDate and descending sort by balance
 * */
    public static void sortedByIdDateBalance(List<Account> accounts) {
        Collections.sort(accounts, ((o1, o2) -> {
            int sortId = o1.getId().compareTo(o2.getId());
            if (sortId != 0) {
                return sortId;
            }
            int sortDate = o1.getCreateDate().compareTo(o2.getCreateDate());
            if (sortDate != 0) {
                return sortDate;
            }
//            Descending balance sort
            int sortBalance = o2.getBalance().compareTo(o1.getBalance());
            if (sortBalance != 0){
                return sortBalance;
            }
            return o1.getId().compareTo(o2.getId());
        }));
    }
}
