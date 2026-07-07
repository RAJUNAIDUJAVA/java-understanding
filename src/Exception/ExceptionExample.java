package Exception;

import java.util.Optional;

public class ExceptionExample {

    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(null);
        String names=name.orElseThrow(() ->new InvalidXmlExcpeption("no element present"));
    }
}
