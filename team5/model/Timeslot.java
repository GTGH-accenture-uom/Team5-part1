package team5.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Timeslot {

    private LocalDateTime localDateTime;
    private LocalDateTime endLocalDateTime;
    private int duration;
    private Doctor doctor;

    public Timeslot(LocalDateTime localDateTime, int duration, Doctor doctor){
        this.localDateTime = localDateTime;
        this.duration = duration;
        this.endLocalDateTime = localDateTime.plusMinutes(duration);
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

    public LocalDateTime getEndLocalDateTime() {
        return endLocalDateTime;
    }

    public void setEndLocalDateTime(LocalDateTime endLocalDateTime) {
        this.endLocalDateTime = endLocalDateTime;
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
        sb.append(", endLocalDateTime=").append(endLocalDateTime);
        sb.append(", duration=").append(duration);
        sb.append(", doctor's FirstName=").append(doctor.getName());
        sb.append(",doctor's SurName=").append(doctor.getSurname());
        sb.append(",doctor's Amka=").append(doctor.getAmka());
        sb.append('}');
        return sb.toString();
    }
}
