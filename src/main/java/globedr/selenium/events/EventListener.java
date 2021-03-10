package globedr.selenium.events;


public final class EventListener {
    private static IEventListener event;

    public static void register(IEventListener eventListener) {
        setEvent(eventListener);
    }

    public static IEventListener getEvent() {
        return event;
    }

    private static void setEvent(IEventListener event) {
        EventListener.event = event;
    }


}
