package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roonumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");


    public Reservation(Integer roonumber, Date checkIn, Date checkOut) {
        this.roonumber = roonumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoonumber() {
        return roonumber;
    }

    public void setRoonumber(Integer roonumber) {
        this.roonumber = roonumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
        return diff;
    }

    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String toString() {
        return "Room "
            + roonumber
            + ", check-in: "
            + sdf.format(checkIn)
            + ", check-out"
            + sdf.format(checkOut)
            + ", "
            + duration()
            + " nights";
    }

}
