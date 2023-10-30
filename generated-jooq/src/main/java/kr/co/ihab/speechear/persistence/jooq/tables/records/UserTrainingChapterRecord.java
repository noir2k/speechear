/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.records;


import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.tables.UserTrainingChapter;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class UserTrainingChapterRecord extends UpdatableRecordImpl<UserTrainingChapterRecord> implements Record4<String, String, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user_training_chapter.training_id</code>.
     */
    public UserTrainingChapterRecord setTrainingId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_chapter.training_id</code>.
     */
    public String getTrainingId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.user_training_chapter.training_category</code>.
     */
    public UserTrainingChapterRecord setTrainingCategory(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_chapter.training_category</code>.
     */
    public String getTrainingCategory() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.user_training_chapter.training_chapter</code>.
     */
    public UserTrainingChapterRecord setTrainingChapter(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_chapter.training_chapter</code>.
     */
    public Integer getTrainingChapter() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.user_training_chapter.chapter_length</code>.
     */
    public UserTrainingChapterRecord setChapterLength(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.user_training_chapter.chapter_length</code>.
     */
    public Integer getChapterLength() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record3<String, String, Integer> key() {
        return (Record3) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return UserTrainingChapter.USER_TRAINING_CHAPTER.TRAINING_ID;
    }

    @Override
    public Field<String> field2() {
        return UserTrainingChapter.USER_TRAINING_CHAPTER.TRAINING_CATEGORY;
    }

    @Override
    public Field<Integer> field3() {
        return UserTrainingChapter.USER_TRAINING_CHAPTER.TRAINING_CHAPTER;
    }

    @Override
    public Field<Integer> field4() {
        return UserTrainingChapter.USER_TRAINING_CHAPTER.CHAPTER_LENGTH;
    }

    @Override
    public String component1() {
        return getTrainingId();
    }

    @Override
    public String component2() {
        return getTrainingCategory();
    }

    @Override
    public Integer component3() {
        return getTrainingChapter();
    }

    @Override
    public Integer component4() {
        return getChapterLength();
    }

    @Override
    public String value1() {
        return getTrainingId();
    }

    @Override
    public String value2() {
        return getTrainingCategory();
    }

    @Override
    public Integer value3() {
        return getTrainingChapter();
    }

    @Override
    public Integer value4() {
        return getChapterLength();
    }

    @Override
    public UserTrainingChapterRecord value1(String value) {
        setTrainingId(value);
        return this;
    }

    @Override
    public UserTrainingChapterRecord value2(String value) {
        setTrainingCategory(value);
        return this;
    }

    @Override
    public UserTrainingChapterRecord value3(Integer value) {
        setTrainingChapter(value);
        return this;
    }

    @Override
    public UserTrainingChapterRecord value4(Integer value) {
        setChapterLength(value);
        return this;
    }

    @Override
    public UserTrainingChapterRecord values(String value1, String value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserTrainingChapterRecord
     */
    public UserTrainingChapterRecord() {
        super(UserTrainingChapter.USER_TRAINING_CHAPTER);
    }

    /**
     * Create a detached, initialised UserTrainingChapterRecord
     */
    public UserTrainingChapterRecord(String trainingId, String trainingCategory, Integer trainingChapter, Integer chapterLength) {
        super(UserTrainingChapter.USER_TRAINING_CHAPTER);

        setTrainingId(trainingId);
        setTrainingCategory(trainingCategory);
        setTrainingChapter(trainingChapter);
        setChapterLength(chapterLength);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised UserTrainingChapterRecord
     */
    public UserTrainingChapterRecord(kr.co.ihab.speechear.persistence.jooq.tables.pojos.UserTrainingChapter value) {
        super(UserTrainingChapter.USER_TRAINING_CHAPTER);

        if (value != null) {
            setTrainingId(value.getTrainingId());
            setTrainingCategory(value.getTrainingCategory());
            setTrainingChapter(value.getTrainingChapter());
            setChapterLength(value.getChapterLength());
            resetChangedOnNotNull();
        }
    }
}
