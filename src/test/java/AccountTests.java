import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTests {
    private final String accountName;
    private final boolean expected;

    public AccountTests(String accountName, boolean expected) {
        this.accountName = accountName;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Test data: {0} {1}")
    public static Object[] getData() {
        return new Object[][]{
                {"aa ", false},
                {" a", false},
                {"bbb", false},
                {"paaaaaaaaaaaaaaaaaa", false},
                {"aaaaaaaaa aaaaaaaa", true},
                {"faaaaaaaaaaaaaaaaa ", false},
                {"a a", true},
                {"aaaa", false},
                {" aaa", false},
                {" aaaaaaaaaaaaaaaaad", false},
                {"a ", false},
                {" aaaaaaaaaaaaaaaaaac", false},
                {"aaaaaaaaaaaaaaaaa ", false},
                {"aaaaaaaaaaaaaaaaaaa ", false},
                {"aaaaaaaaa aaaaaaaaa", true},
                {"aaaaaaaaa aaaaaaaaax", false},
                {" aaaaaaaaaaaaaaaaay", false},
                {"aaaaaaaaaaaaaaaaaz", false},
                {"aaa ", false},
                {"aaaaaaaaaaaaaaaaaaab", false},
                {"aa", false},
                {"aa a", true},
                {" aa", false},
                {" ", false},
                {null, false}
        };
    }

    @Test
    public void checkAccountName() {
        Account account = createAccount(accountName);
        checkAccount(account, expected);
    }

    @Step("Create account")
    public static Account createAccount(String name) {
        return new Account(name);
    }

    @Step("Check account")
    public static void checkAccount(Account account, boolean expected) {
        assertEquals(expected, account.checkNameToEmboss());
    }
}
