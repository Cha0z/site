package web.site.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class User implements Serializable, Cloneable {
    private Long id;
    private String name;
    private String surname;
    private LocalDateTime lastDateAndTime;
    private LocalDate lastSessionDate;
    private LocalTime lastSessionTime;
    private UserStatus status;
    private Activity activity;


    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public LocalDateTime getLastDateAndTime() {
        return lastDateAndTime;
    }

    public void setLastDateAndTime(LocalDateTime lastDateAndTime) {
        this.lastDateAndTime = lastDateAndTime;
        this.lastSessionDate = this.lastDateAndTime.toLocalDate();
        this.lastSessionTime = this.lastDateAndTime.toLocalTime();
    }

    public LocalDate getLastSessionDate() {
        return lastSessionDate;
    }

    public void setLastSessionDate(LocalDate lastSessionDate) {
        this.lastSessionDate = lastSessionDate;
    }

    public LocalTime getLastSessionTime() {
        return lastSessionTime;
    }

    public void setLastSessionTime(LocalTime lastSessionTime) {
        this.lastSessionTime = lastSessionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(lastDateAndTime, user.lastDateAndTime) &&
                Objects.equals(lastSessionDate, user.lastSessionDate) &&
                Objects.equals(lastSessionTime, user.lastSessionTime) &&
                status == user.status &&
                activity == user.activity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, lastDateAndTime, lastSessionDate, lastSessionTime, status, activity);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastDateAndTime=" + lastDateAndTime +
                ", lastSessionDate=" + lastSessionDate +
                ", lastSessionTime=" + lastSessionTime +
                ", status=" + status +
                ", activity=" + activity +
                '}';
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
