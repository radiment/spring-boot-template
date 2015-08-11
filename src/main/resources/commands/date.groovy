package commands
import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Usage
import org.springframework.beans.factory.BeanFactory
import org.tepmplate.HelloService

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

public class date {

    public static final String DEFAULT = "EEE MMM d HH:mm:ss z yyyy";

    @Usage("show the current time")
    @Command
    def main(@Usage("the time format") @Option(names=["f","format"]) String format) {
        if (format == null)
            format = DEFAULT;
        Instant now = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(now.atZone(ZoneId.systemDefault()));
    }

}