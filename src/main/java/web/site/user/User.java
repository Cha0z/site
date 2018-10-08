package web.site.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class User implements Serializable,Cloneable {
    private Long id;
    private String name;
    private String surname;
    private LocalDate lastSession;
    private UserStatus status;
    private Activity activity;


    public User() {
    }

    public User(long id, String name, String surname, LocalDate lastSession) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastSession = lastSession;
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

    public LocalDate getLastSession() {
        return lastSession;
    }

    public void setLastSession(LocalDate lastSession) {
        this.lastSession = lastSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(lastSession, user.lastSession);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, lastSession);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastSession=" + lastSession +
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
