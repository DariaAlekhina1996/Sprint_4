public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (((name.length() >= 3) && (name.length() <= 19)) &&
                !((Character.isWhitespace(name.charAt(0))) ^ (Character.isWhitespace(name.charAt(name.length() - 1)))) && (name.split(" ").length == 2)) {
            return true;
        } else
            return false;
    }
}
