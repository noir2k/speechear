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
public class UserTrainingScore implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String trainingId;
    private String trainingCategory;
    private Integer trainingChapter;
    private Integer userScore;

    public UserTrainingScore() {}

    public UserTrainingScore(UserTrainingScore value) {
        this.userId = value.userId;
        this.trainingId = value.trainingId;
        this.trainingCategory = value.trainingCategory;
        this.trainingChapter = value.trainingChapter;
        this.userScore = value.userScore;
    }

    public UserTrainingScore(
        String userId,
        String trainingId,
        String trainingCategory,
        Integer trainingChapter,
        Integer userScore
    ) {
        this.userId = userId;
        this.trainingId = trainingId;
        this.trainingCategory = trainingCategory;
        this.trainingChapter = trainingChapter;
        this.userScore = userScore;
    }

    /**
     * Getter for <code>public.user_training_score.user_id</code>.
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.user_training_score.user_id</code>.
     */
    public UserTrainingScore setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.training_id</code>.
     */
    public String getTrainingId() {
        return this.trainingId;
    }

    /**
     * Setter for <code>public.user_training_score.training_id</code>.
     */
    public UserTrainingScore setTrainingId(String trainingId) {
        this.trainingId = trainingId;
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.training_category</code>.
     */
    public String getTrainingCategory() {
        return this.trainingCategory;
    }

    /**
     * Setter for <code>public.user_training_score.training_category</code>.
     */
    public UserTrainingScore setTrainingCategory(String trainingCategory) {
        this.trainingCategory = trainingCategory;
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.training_chapter</code>.
     */
    public Integer getTrainingChapter() {
        return this.trainingChapter;
    }

    /**
     * Setter for <code>public.user_training_score.training_chapter</code>.
     */
    public UserTrainingScore setTrainingChapter(Integer trainingChapter) {
        this.trainingChapter = trainingChapter;
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.user_score</code>.
     */
    public Integer getUserScore() {
        return this.userScore;
    }

    /**
     * Setter for <code>public.user_training_score.user_score</code>.
     */
    public UserTrainingScore setUserScore(Integer userScore) {
        this.userScore = userScore;
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
        final UserTrainingScore other = (UserTrainingScore) obj;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
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
        if (this.trainingChapter == null) {
            if (other.trainingChapter != null)
                return false;
        }
        else if (!this.trainingChapter.equals(other.trainingChapter))
            return false;
        if (this.userScore == null) {
            if (other.userScore != null)
                return false;
        }
        else if (!this.userScore.equals(other.userScore))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.trainingId == null) ? 0 : this.trainingId.hashCode());
        result = prime * result + ((this.trainingCategory == null) ? 0 : this.trainingCategory.hashCode());
        result = prime * result + ((this.trainingChapter == null) ? 0 : this.trainingChapter.hashCode());
        result = prime * result + ((this.userScore == null) ? 0 : this.userScore.hashCode());
        return result;
    }
}
