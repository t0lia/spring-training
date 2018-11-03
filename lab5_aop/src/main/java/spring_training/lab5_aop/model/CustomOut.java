package spring_training.lab5_aop.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CustomOut {

    private static StringBuilder result = new StringBuilder();

    public static void execute(Consumer<PrintStream> streamConsumer) {

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintStream ps = new PrintStream(baos, true, UTF_8)) {
            streamConsumer.accept(ps);
        }
        result.append(new String(baos.toByteArray(), UTF_8));

    }

    public static String getOutResult() {
        return result.toString();
    }

    public static void clear() {
        result = new StringBuilder();
    }

}
