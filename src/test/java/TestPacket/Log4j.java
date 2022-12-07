package TestPacket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {
    static Logger log = LogManager.getLogger(Log4j.class.getName());

    public static void main(String[] args) {
        log.info("1");
        log.error("2");
    }
}
