/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.records;


import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.tables.UserTrainingScore;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class UserTrainingScoreRecord extends UpdatableRecordImpl<UserTrainingScoreRecord> implements Record5<String, String, String, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user_training_score.user_id</code>.
     */
    public UserTrainingScoreRecord setUserId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.user_id</code>.
     */
    public String getUserId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.user_training_score.training_id</code>.
     */
    public UserTrainingScoreRecord setTrainingId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.training_id</code>.
     */
    public String getTrainingId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.user_training_score.training_category</code>.
     */
    public UserTrainingScoreRecord setTrainingCategory(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.training_category</code>.
     */
    public String getTrainingCategory() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.user_training_score.training_chapter</code>.
     */
    public UserTrainingScoreRecord setTrainingChapter(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.training_chapter</code>.
     */
    public Integer getTrainingChapter() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.user_training_score.user_score</code>.
     */
    public UserTrainingScoreRecord setUserScore(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_score.user_score</code>.
     */
    public Integer getUserScore() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record4<String, String, String, Integer> key() {
        return (Record4) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, String, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return UserTrainingScore.USER_TRAINING_SCORE.USER_ID;
    }

    @Override
    public Field<String> field2() {
        return UserTrainingScore.USER_TRAINING_SCORE.TRAINING_ID;
    }

    @Override
    public Field<String> field3() {
        return UserTrainingScore.USER_TRAINING_SCORE.TRAINING_CATEGORY;
    }

    @Override
    public Field<Integer> field4() {
        return UserTrainingScore.USER_TRAINING_SCORE.TRAINING_CHAPTER;
    }

    @Override
    public Field<Integer> field5() {
        return UserTrainingScore.USER_TRAINING_SCORE.USER_SCORE;
    }

    @Override
    public String component1() {
        return getUserId();
    }

    @Override
    public String component2() {
        return getTrainingId();
    }

    @Override
    public String component3() {
        return getTrainingCategory();
    }

    @Override
    public Integer component4() {
        return getTrainingChapter();
    }

    @Override
    public Integer component5() {
        return getUserScore();
    }

    @Override
    public String value1() {
        return getUserId();
    }

    @Override
    public String value2() {
        return getTrainingId();
    }

    @Override
    public String value3() {
        return getTrainingCategory();
    }

    @Override
    public Integer value4() {
        return getTrainingChapter();
    }

    @Override
    public Integer value5() {
        return getUserScore();
    }

    @Override
    public UserTrainingScoreRecord value1(String value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserTrainingScoreRecord value2(String value) {
        setTrainingId(value);
        return this;
    }

    @Override
    public UserTrainingScoreRecord value3(String value) {
        setTrainingCategory(value);
        return this;
    }

    @Override
    public UserTrainingScoreRecord value4(Integer value) {
        setTrainingChapter(value);
        return this;
    }

    @Override
    public UserTrainingScoreRecord value5(Integer value) {
        setUserScore(value);
        return this;
    }

    @Override
    public UserTrainingScoreRecord values(String value1, String value2, String value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserTrainingScoreRecord
     */
    public UserTrainingScoreRecord() {
        super(UserTrainingScore.USER_TRAINING_SCORE);
    }

    /**
     * Create a detached, initialised UserTrainingScoreRecord
     */
    public UserTrainingScoreRecord(String userId, String trainingId, String trainingCategory, Integer trainingChapter, Integer userScore) {
        super(UserTrainingScore.USER_TRAINING_SCORE);

        setUserId(userId);
        setTrainingId(trainingId);
        setTrainingCategory(trainingCategory);
        setTrainingChapter(trainingChapter);
        setUserScore(userScore);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised UserTrainingScoreRecord
     */
    public UserTrainingScoreRecord(kr.co.ihab.speechear.persistence.jooq.tables.pojos.UserTrainingScore value) {
        super(UserTrainingScore.USER_TRAINING_SCORE);

        if (value != null) {
            setUserId(value.getUserId());
            setTrainingId(value.getTrainingId());
            setTrainingCategory(value.getTrainingCategory());
            setTrainingChapter(value.getTrainingChapter());
            setUserScore(value.getUserScore());
            resetChangedOnNotNull();
        }
    }
}
