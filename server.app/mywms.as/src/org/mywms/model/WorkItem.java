/*
 * Copyright (c) 2006 by Fraunhofer IML, Dortmund.
 * All rights reserved.
 *
 * Project: myWMS
 */
package org.mywms.model;

import java.math.BigDecimal;
import java.util.Date;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.OrderBy;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*import org.mywms.facade.FacadeException;
import org.mywms.globals.SerialNoRecordType;
import org.mywms.globals.ReparabilityCodeType;
import org.mywms.service.ConstraintViolatedException;*/
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Entity
@Table(name="mywms_workitem")
/*,uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "client_id", "item_nr"
    })
})*/
@Inheritance(strategy = InheritanceType.JOINED)
public class WorkItem
    extends BasicEntity {

    private ItemData itemDataId;
    private String remarks;
    private WorkType workTypeId;
    private User workerId;
    private boolean urgent = false;
    private Date scheduleTime;
    private Date executeDeadline;

    @ManyToOne(optional = false)
    public ItemData getItemDataId() {
        return this.itemDataId;
    }

    public void setItemDataId(ItemData itemDataId) {
        this.itemDataId = itemDataId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ManyToOne(optional = false)
    //@Column(nullable = false)
    public WorkType getWorkTypeId() {
        return this.workTypeId;
    }

    public void setWorkTypeId(WorkType workTypeId) {
        this.workTypeId = workTypeId;
    }

    @ManyToOne(optional = false)
    //@Column(nullable = false)
    public User getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(User workerId) {
        this.workerId = workerId;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getScheduleTime() {
        return this.scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getExecuteDeadline() {
        return this.executeDeadline;
    }

    public void setExecuteDeadline(Date executeDeadline) {
        this.executeDeadline = executeDeadline;
    }

}