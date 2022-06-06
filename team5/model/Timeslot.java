package team5.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Timeslot {
    private LocalDateTime localDateTime;
    private LocalTime startMinute;
    private LocalTime endMinute;
    private Doctor doctor;


    public Timeslot(LocalDateTime localDateTime, LocalTime startMinute, LocalTime endMinute, Doctor doctor) {
        this.localDateTime = localDateTime;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalTime getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(LocalTime startMinute) {
        this.startMinute = startMinute;
    }

    public LocalTime getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(LocalTime endMinute) {
        this.endMinute = endMinute;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Timeslot{");
        sb.append("localDateTime=").append(localDateTime);
        sb.append(", startMinute=").append(startMinute);
        sb.append(", endMinute=").append(endMinute);
        sb.append(", doctor=").append(doctor);
        sb.append('}');
        return sb.toString();
    }
}
