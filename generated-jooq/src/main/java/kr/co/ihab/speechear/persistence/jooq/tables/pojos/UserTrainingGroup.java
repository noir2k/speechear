/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.pojos;


import java.io.Serializable;

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
public class UserTrainingGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trainingId;
    private String trainingCategory;
    private String categoryName;

    public UserTrainingGroup() {}

    public UserTrainingGroup(UserTrainingGroup value) {
        this.trainingId = value.trainingId;
        this.trainingCategory = value.trainingCategory;
        this.categoryName = value.categoryName;
    }

    public UserTrainingGroup(
        String trainingId,
        String trainingCategory,
        String categoryName
    ) {
        this.trainingId = trainingId;
        this.trainingCategory = trainingCategory;
        this.categoryName = categoryName;
    }

    /**
     * Getter for <code>public.user_training_group.training_id</code>.
     */
    public String getTrainingId() {
        return this.trainingId;
    }

    /**
     * Setter for <code>public.user_training_group.training_id</code>.
     */
    public UserTrainingGroup setTrainingId(String trainingId) {
        this.trainingId = trainingId;
        return this;
    }

    /**
     * Getter for <code>public.user_training_group.training_category</code>.
     */
    public String getTrainingCategory() {
        return this.trainingCategory;
    }

    /**
     * Setter for <code>public.user_training_group.training_category</code>.
     */
    public UserTrainingGroup setTrainingCategory(String trainingCategory) {
        this.trainingCategory = trainingCategory;
        return this;
    }

    /**
     * Getter for <code>public.user_training_group.category_name</code>.
     */
    public String getCategoryName() {
        return this.categoryName;
    }

    /**
     * Setter for <code>public.user_training_group.category_name</code>.
     */
    public UserTrainingGroup setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        final UserTrainingGroup other = (UserTrainingGroup) obj;
        if (this.trainingId == null) {
            if (other.trainingId != null)
                return false;
        }
        else if (!this.trainingId.equals(other.trainingId))
            return false;
        if (this.trainingCategory == null) {
            if (other.trainingCategory != null)
                return false;
        }
        else if (!this.trainingCategory.equals(other.trainingCategory))
            return false;
        if (this.categoryName == null) {
            if (other.categoryName != null)
                return false;
        }
        else if (!this.categoryName.equals(other.categoryName))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.trainingId == null) ? 0 : this.trainingId.hashCode());
        result = prime * result + ((this.trainingCategory == null) ? 0 : this.trainingCategory.hashCode());
        result = prime * result + ((this.categoryName == null) ? 0 : this.categoryName.hashCode());
        return result;
    }
}