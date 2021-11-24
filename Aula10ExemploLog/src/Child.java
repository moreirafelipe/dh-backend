import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

public class Child extends Parent{

    // The name of this Logge will be "org.apache.logging.Child"
    public Logger childLogger = LogManager.getLogger();

    public void childLog(Marker marker) {
        childLogger.debug(marker,"Child logger message");
    }

    public void logFromChild(Marker marker) {
        getLogger().debug(marker,"Log message from Child");
    }

    public void parentLog(Marker marker) {
        parentLogger.debug(marker,"Parent logger, message from Child");
    }

}
