package com.pucp.lab5gtics.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class JobHistoryId implements Serializable {
    private static final long serialVersionUID = 1699879179201617813L;
    @Column(name = "job_history_id", nullable = false)
    private Integer jobHistoryId;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    public Integer getJobHistoryId() {
        return jobHistoryId;
    }

    public void setJobHistoryId(Integer jobHistoryId) {
        this.jobHistoryId = jobHistoryId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JobHistoryId entity = (JobHistoryId) o;
        return Objects.equals(this.jobHistoryId, entity.jobHistoryId) &&
                Objects.equals(this.employeeId, entity.employeeId) &&
                Objects.equals(this.startDate, entity.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobHistoryId, employeeId, startDate);
    }

}