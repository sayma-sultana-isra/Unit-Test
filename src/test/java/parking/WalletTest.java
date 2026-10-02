package parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    @Test
    void newWalletShouldHaveZeroBalance() {
        Wallet wallet = new Wallet();

        assertEquals(0.0, wallet.getBalance());
    }

    @Test
    void walletShouldStartWithGivenBalance() {
        Wallet wallet = new Wallet(500.0);

        assertEquals(500.0, wallet.getBalance());
    }

    @Test
    void addFundsShouldIncreaseBalance() {
        Wallet wallet = new Wallet(100.0);

        wallet.addFunds(50.0);

        assertEquals(150.0, wallet.getBalance());
    }

    @Test
    void addFundsShouldRejectZeroAmount() {
        Wallet wallet = new Wallet(100.0);

        assertThrows(
                InvalidAmountException.class,
                () -> wallet.addFunds(0)
        );
    }

    @Test
    void addFundsShouldRejectNegativeAmount() {
        Wallet wallet = new Wallet(100.0);

        assertThrows(
                InvalidAmountException.class,
                () -> wallet.addFunds(-50)
        );
    }

    @Test
    void deductFundsShouldDecreaseBalance() {
        Wallet wallet = new Wallet(100.0);

        wallet.deductFunds(40.0);

        assertEquals(60.0, wallet.getBalance());
    }

    @Test
    void deductFundsShouldAllowExactBalance() {
        Wallet wallet = new Wallet(100.0);

        wallet.deductFunds(100.0);

        assertEquals(0.0, wallet.getBalance());
    }

    @Test
    void deductFundsShouldRejectInsufficientFunds() {
        Wallet wallet = new Wallet(100.0);

        assertThrows(
                InsufficientFundsException.class,
                () -> wallet.deductFunds(150.0)
        );
    }

    @Test
    void deductFundsShouldRejectZeroAmount() {
        Wallet wallet = new Wallet(100.0);

        assertThrows(
                InvalidAmountException.class,
                () -> wallet.deductFunds(0)
        );
    }

    @Test
    void deductFundsShouldRejectNegativeAmount() {
        Wallet wallet = new Wallet(100.0);

        assertThrows(
                InvalidAmountException.class,
                () -> wallet.deductFunds(-50)
        );
    }
    @Test
    void transferFundsShouldTransferAmount() {
        Wallet fromWallet = new Wallet(100.0);
        Wallet toWallet = new Wallet(50.0);

        fromWallet.transferFunds(toWallet, 30.0);

        assertEquals(70.0, fromWallet.getBalance());
        assertEquals(80.0, toWallet.getBalance());
    }

    @Test
    void transferFundsShouldAllowExactBalance() {
        Wallet fromWallet = new Wallet(100.0);
        Wallet toWallet = new Wallet(50.0);

        fromWallet.transferFunds(toWallet, 100.0);

        assertEquals(0.0, fromWallet.getBalance());
        assertEquals(150.0, toWallet.getBalance());
    }

    @Test
    void transferFundsShouldRejectInsufficientFunds() {
        Wallet fromWallet = new Wallet(100.0);
        Wallet toWallet = new Wallet(50.0);

        assertThrows(
                InsufficientFundsException.class,
                () -> fromWallet.transferFunds(toWallet, 150.0)
        );

        assertEquals(100.0, fromWallet.getBalance());
        assertEquals(50.0, toWallet.getBalance());
    }

    @Test
    void transferFundsShouldRejectZeroAmount() {
        Wallet fromWallet = new Wallet(100.0);
        Wallet toWallet = new Wallet(50.0);

        assertThrows(
                InvalidAmountException.class,
                () -> fromWallet.transferFunds(toWallet, 0)
        );
    }

    @Test
    void transferFundsShouldRejectNegativeAmount() {
        Wallet fromWallet = new Wallet(100.0);
        Wallet toWallet = new Wallet(50.0);

        assertThrows(
                InvalidAmountException.class,
                () -> fromWallet.transferFunds(toWallet, -20.0)
        );
    }


}