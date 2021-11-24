import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class App {

    public static void main(String[] args) {

        Marker marker = MarkerManager.getMarker("CLASS");
        Child child = new Child();

        System.out.println("------- Parent Logger ----------");
        child.log(null);
        child.log(marker);
        child.logFromChild(null);
        child.logFromChild(marker);
        child.parentLog(null);
        child.parentLog(marker);

        child.setLogger(child.childLogger);

        System.out.println("------- Parent Logger set to Child Logger ----------");
        child.log(null);
        child.log(marker);
        child.logFromChild(null);
        child.logFromChild(marker);
    }
}
