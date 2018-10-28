package spring_training.lab4.model.contact;

import java.util.Objects;

public abstract class AbstractContact implements Contact {
    private String name;
    private String phone;

    public AbstractContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractContact)) return false;
        AbstractContact that = (AbstractContact) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}
