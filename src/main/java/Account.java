public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name != null) {
            boolean isLengthValid = name.length() >= 3 && name.length() <= 19;
            boolean isSpaceOne = name.indexOf(' ') == name.lastIndexOf(' ');
            boolean isEndSpacesNotExist = name.indexOf(' ') > 0 && name.indexOf(' ') + 1 != name.length();

            return isLengthValid && isSpaceOne && isEndSpacesNotExist;
        }
        return false;
    }
}
