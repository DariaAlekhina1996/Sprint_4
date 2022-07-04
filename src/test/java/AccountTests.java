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

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {"aa ", false},
                {" a", false},
                {"bbb", false},
                {"aaaaaaaaaaaaaaaaaaa", false},
                {"aaaaaaaaa aaaaaaaa", true},
                {"aaaaaaaaaaaaaaaaaa ", false},
                {"a a", true},
                {"aaaa", false},
                {" aaa", false},
                {" aaaaaaaaaaaaaaaaaa", false},
                {"a ", false},
                {" aaaaaaaaaaaaaaaaaaa", false},
                {"aaaaaaaaaaaaaaaaa ", false},
                {"aaaaaaaaaaaaaaaaaaa ", false},
                {"aaaaaaaaa aaaaaaaaa", true},
                {"aaaaaaaaa aaaaaaaaaa", false},
                {" aaaaaaaaaaaaaaaaaa", false},
                {"aaaaaaaaaaaaaaaaaa", false},
                {"aaa ", false},
                {"aaaaaaaaaaaaaaaaaaaa", false},
                {"aa", false},
                {"aa a", true},
                {" aa", false}
        };
    }

    @Test
    public void checkAccountName() {
        Account account = new Account(accountName);
        assertEquals(expected, account.checkNameToEmboss());
    }
}
