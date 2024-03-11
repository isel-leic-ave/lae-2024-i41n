package pt.isel;

import java.time.LocalDate;

class Constants {
    static final int BITS_OF_10KB = 8*10*1024; // <=> Kotlin const val
}

public class SavingsAccount {
    private static int accountsCount = 0;
    private static double DEFAULT_INTEREST_RATE = 0.07;
    private final double interestRate = DEFAULT_INTEREST_RATE;
    private short accountCode = (short) accountsCount++;
    private String holderName;
    private long balance;
    private boolean isActive;
    private final LocalDate createdDate = LocalDate.now(); // <=> Kotlin val


    static {
    }
    public SavingsAccount() {

    }

    public SavingsAccount(short ac) {
        accountCode = ac;
    }


}