package io.swagger.data.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long duration;
    private String className;
    private String methodName;
    @CreationTimestamp
    private Date timestamp;
    private String uuid = UUID.randomUUID().toString();

    public Statistic(Long duration, String className, String methodName) {
        this.duration = duration;
        this.className = className;
        this.methodName = methodName;
    }

    public Long getId() {
        return id;
    }

    public Long getDuration() {
        return duration;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUuid() {
        return uuid;
    }


    // Spring methods
    public Statistic() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    // Spring methods


    public String getFullName() {
        return className + ":" + methodName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return uuid.equals(((Statistic) o).uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

}
