/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables;


import java.util.function.Function;

import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.Keys;
import kr.co.ihab.speechear.persistence.jooq.Public;
import kr.co.ihab.speechear.persistence.jooq.tables.records.UserTrainingChapterRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


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
public class UserTrainingChapter extends TableImpl<UserTrainingChapterRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user_training_chapter</code>
     */
    public static final UserTrainingChapter USER_TRAINING_CHAPTER = new UserTrainingChapter();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserTrainingChapterRecord> getRecordType() {
        return UserTrainingChapterRecord.class;
    }

    /**
     * The column <code>public.user_training_chapter.training_id</code>.
     */
    public final TableField<UserTrainingChapterRecord, String> TRAINING_ID = createField(DSL.name("training_id"), SQLDataType.VARCHAR(2).nullable(false), this, "");

    /**
     * The column <code>public.user_training_chapter.training_category</code>.
     */
    public final TableField<UserTrainingChapterRecord, String> TRAINING_CATEGORY = createField(DSL.name("training_category"), SQLDataType.VARCHAR(1).nullable(false), this, "");

    /**
     * The column <code>public.user_training_chapter.training_chapter</code>.
     */
    public final TableField<UserTrainingChapterRecord, Integer> TRAINING_CHAPTER = createField(DSL.name("training_chapter"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.user_training_chapter.chapter_length</code>.
     */
    public final TableField<UserTrainingChapterRecord, Integer> CHAPTER_LENGTH = createField(DSL.name("chapter_length"), SQLDataType.INTEGER.nullable(false), this, "");

    private UserTrainingChapter(Name alias, Table<UserTrainingChapterRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserTrainingChapter(Name alias, Table<UserTrainingChapterRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user_training_chapter</code> table
     * reference
     */
    public UserTrainingChapter(String alias) {
        this(DSL.name(alias), USER_TRAINING_CHAPTER);
    }

    /**
     * Create an aliased <code>public.user_training_chapter</code> table
     * reference
     */
    public UserTrainingChapter(Name alias) {
        this(alias, USER_TRAINING_CHAPTER);
    }

    /**
     * Create a <code>public.user_training_chapter</code> table reference
     */
    public UserTrainingChapter() {
        this(DSL.name("user_training_chapter"), null);
    }

    public <O extends Record> UserTrainingChapter(Table<O> child, ForeignKey<O, UserTrainingChapterRecord> key) {
        super(child, key, USER_TRAINING_CHAPTER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<UserTrainingChapterRecord> getPrimaryKey() {
        return Keys.USER_TRAINING_CHAPTER_PK;
    }

    @Override
    public UserTrainingChapter as(String alias) {
        return new UserTrainingChapter(DSL.name(alias), this);
    }

    @Override
    public UserTrainingChapter as(Name alias) {
        return new UserTrainingChapter(alias, this);
    }

    @Override
    public UserTrainingChapter as(Table<?> alias) {
        return new UserTrainingChapter(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTrainingChapter rename(String name) {
        return new UserTrainingChapter(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTrainingChapter rename(Name name) {
        return new UserTrainingChapter(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTrainingChapter rename(Table<?> name) {
        return new UserTrainingChapter(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super String, ? super String, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super String, ? super String, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
