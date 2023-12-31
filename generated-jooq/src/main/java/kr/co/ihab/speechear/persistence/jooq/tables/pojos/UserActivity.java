/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String activity;
    private Double activityTime;
    private LocalDateTime activityDate;

    public UserActivity() {}

    public UserActivity(UserActivity value) {
        this.id = value.id;
        this.activity = value.activity;
        this.activityTime = value.activityTime;
        this.activityDate = value.activityDate;
    }

    public UserActivity(
        String id,
        String activity,
        Double activityTime,
        LocalDateTime activityDate
    ) {
        this.id = id;
        this.activity = activity;
        this.activityTime = activityTime;
        this.activityDate = activityDate;
    }

    /**
     * Getter for <code>public.user_activity.id</code>.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.user_activity.id</code>.
     */
    public UserActivity setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.user_activity.activity</code>.
     */
    public String getActivity() {
        return this.activity;
    }

    /**
     * Setter for <code>public.user_activity.activity</code>.
     */
    public UserActivity setActivity(String activity) {
        this.activity = activity;
        return this;
    }

    /**
     * Getter for <code>public.user_activity.activity_time</code>.
     */
    public Double getActivityTime() {
        return this.activityTime;
    }

    /**
     * Setter for <code>public.user_activity.activity_time</code>.
     */
    public UserActivity setActivityTime(Double activityTime) {
        this.activityTime = activityTime;
        return this;
    }

    /**
     * Getter for <code>public.user_activity.activity_date</code>.
     */
    public LocalDateTime getActivityDate() {
        return this.activityDate;
    }

    /**
     * Setter for <code>public.user_activity.activity_date</code>.
     */
    public UserActivity setActivityDate(LocalDateTime activityDate) {
        this.activityDate = activityDate;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserActivity other = (UserActivity) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.activity == null) {
            if (other.activity != null)
                return false;
        }
        else if (!this.activity.equals(other.activity))
            return false;
        if (this.activityTime == null) {
            if (other.activityTime != null)
                return false;
        }
        else if (!this.activityTime.equals(other.activityTime))
            return false;
        if (this.activityDate == null) {
            if (other.activityDate != null)
                return false;
        }
        else if (!this.activityDate.equals(other.activityDate))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.activity == null) ? 0 : this.activity.hashCode());
        result = prime * result + ((this.activityTime == null) ? 0 : this.activityTime.hashCode());
        result = prime * result + ((this.activityDate == null) ? 0 : this.activityDate.hashCode());
        return result;
    }
}
