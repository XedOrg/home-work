package com.sbrf.reboot;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
public class Account {
    private Long id;
    private LocalDate createDate;
    private BigDecimal balance;
}
