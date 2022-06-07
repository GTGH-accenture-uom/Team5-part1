package team5.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Timeslot {
    private LocalDateTime localDateTime;
    private int duration;
    private Doctor doctor;

    public Timeslot(LocalDateTime localDateTime, int duration, Doctor doctor) {
        this.localDateTime = localDateTime;
        this.duration = duration;
        this.doctor = doctor;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
        sb.append(", duration=").append(duration);
        sb.append(", doctor=").append(doctor);
        sb.append('}');
        return sb.toString();
    }
}
