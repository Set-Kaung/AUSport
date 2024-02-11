package ausport.model;

import java.time.LocalDateTime;

import java.time.*;

public class Reservation {
    private int id;
    private int fieldID;
    private String username;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration duration;



    public int getFieldID() {
        return fieldID;
    }
    public void setFieldID(int fieldID) {
        this.fieldID = fieldID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public Duration getDuration() {
        return duration;
    }
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    public int getId() {
        return id;
    }    
}
