package POJO.test;

import java.util.Date;

public class ContactUs {

    private String email;
    private String message;
    private Date date;

    public ContactUs(){}

    public ContactUs(String email, String message){
        this.email = email;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
