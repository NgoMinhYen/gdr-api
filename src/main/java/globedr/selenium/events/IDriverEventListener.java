package globedr.selenium.events;

public interface IDriverEventListener {

    void beforeOpenUrl(String url);

    void afterOpenUrl(String url);

}
