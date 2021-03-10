package dataObject;

import java.util.Map;

public class Lecture {
    private String profName;
    private String topic;
    private String size;
    private String frequency;
    private String rooms;

    public Lecture() {
    }

    public Lecture(String profName, String topic, String size, String frequency, String rooms) {
        this.profName = profName;
        this.topic = topic;
        this.size = size;
        this.frequency = frequency;
        this.rooms = rooms;
    }

    public Lecture createLecture(Map<String, String> map) {
        for (Map.Entry<String, String> entry :map.entrySet()){
            System.out.println("k " + entry.getKey());
            System.out.println("v " +entry.getValue());
        }
        return new Lecture("A", "b", "c", "d", "e");
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }
}
