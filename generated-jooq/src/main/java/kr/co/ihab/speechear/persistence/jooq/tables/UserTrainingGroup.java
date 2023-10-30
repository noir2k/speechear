/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables;


import java.util.function.Function;

import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.Keys;
import kr.co.ihab.speechear.persistence.jooq.Public;
import kr.co.ihab.speechear.persistence.jooq.tables.records.UserTrainingGroupRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
public class UserTrainingGroup extends TableImpl<UserTrainingGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user_training_group</code>
     */
    public static final UserTrainingGroup USER_TRAINING_GROUP = new UserTrainingGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserTrainingGroupRecord> getRecordType() {
        return UserTrainingGroupRecord.class;
    }

    /**
     * The column <code>public.user_training_group.training_id</code>.
     */
    public final TableField<UserTrainingGroupRecord, String> TRAINING_ID = createField(DSL.name("training_id"), SQLDataType.VARCHAR(2).nullable(false), this, "");

    /**
     * The column <code>public.user_training_group.training_category</code>.
     */
    public final TableField<UserTrainingGroupRecord, String> TRAINING_CATEGORY = createField(DSL.name("training_category"), SQLDataType.VARCHAR(1).nullable(false), this, "");

    /**
     * The column <code>public.user_training_group.category_name</code>.
     */
    public final TableField<UserTrainingGroupRecord, String> CATEGORY_NAME = createField(DSL.name("category_name"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    private UserTrainingGroup(Name alias, Table<UserTrainingGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserTrainingGroup(Name alias, Table<UserTrainingGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user_training_group</code> table reference
     */
    public UserTrainingGroup(String alias) {
        this(DSL.name(alias), USER_TRAINING_GROUP);
    }

    /**
     * Create an aliased <code>public.user_training_group</code> table reference
     */
    public UserTrainingGroup(Name alias) {
        this(alias, USER_TRAINING_GROUP);
    }

    /**
     * Create a <code>public.user_training_group</code> table reference
     */
    public UserTrainingGroup() {
        this(DSL.name("user_training_group"), null);
    }

    public <O extends Record> UserTrainingGroup(Table<O> child, ForeignKey<O, UserTrainingGroupRecord> key) {
        super(child, key, USER_TRAINING_GROUP);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<UserTrainingGroupRecord> getPrimaryKey() {
        return Keys.USER_TRAINING_GROUP_PK;
    }

    @Override
    public UserTrainingGroup as(String alias) {
        return new UserTrainingGroup(DSL.name(alias), this);
    }

    @Override
    public UserTrainingGroup as(Name alias) {
        return new UserTrainingGroup(alias, this);
    }

    @Override
    public UserTrainingGroup as(Table<?> alias) {
        return new UserTrainingGroup(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTrainingGroup rename(String name) {
        return new UserTrainingGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTrainingGroup rename(Name name) {
        return new UserTrainingGroup(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTrainingGroup rename(Table<?> name) {
        return new UserTrainingGroup(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
