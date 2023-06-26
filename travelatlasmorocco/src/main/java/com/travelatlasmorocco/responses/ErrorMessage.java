package com.travelatlasmorocco.responses;
import java.util.Date;
public class ErrorMessage {
    private Date timesTamp ;
    private String message;
    public ErrorMessage(Date timesTamp, String message) {
        super();
        this.timesTamp = timesTamp;
        this.message = message;
    }
    public Date getTimesTamp() {
        return timesTamp;
    }
    public void setTimesTamp(Date timesTamp) {
        this.timesTamp = timesTamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
