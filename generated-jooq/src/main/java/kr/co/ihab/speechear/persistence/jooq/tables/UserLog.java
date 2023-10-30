/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables;


import java.util.function.Function;

import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.Public;
import kr.co.ihab.speechear.persistence.jooq.tables.records.UserLogRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
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
public class UserLog extends TableImpl<UserLogRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user_log</code>
     */
    public static final UserLog USER_LOG = new UserLog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserLogRecord> getRecordType() {
        return UserLogRecord.class;
    }

    /**
     * The column <code>public.user_log.access_ip</code>.
     */
    public final TableField<UserLogRecord, String> ACCESS_IP = createField(DSL.name("access_ip"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>public.user_log.access_id</code>.
     */
    public final TableField<UserLogRecord, String> ACCESS_ID = createField(DSL.name("access_id"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>public.user_log.access_time</code>.
     */
    public final TableField<UserLogRecord, String> ACCESS_TIME = createField(DSL.name("access_time"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>public.user_log.access_role</code>.
     */
    public final TableField<UserLogRecord, String> ACCESS_ROLE = createField(DSL.name("access_role"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>public.user_log.access_uri</code>.
     */
    public final TableField<UserLogRecord, String> ACCESS_URI = createField(DSL.name("access_uri"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    private UserLog(Name alias, Table<UserLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserLog(Name alias, Table<UserLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user_log</code> table reference
     */
    public UserLog(String alias) {
        this(DSL.name(alias), USER_LOG);
    }

    /**
     * Create an aliased <code>public.user_log</code> table reference
     */
    public UserLog(Name alias) {
        this(alias, USER_LOG);
    }

    /**
     * Create a <code>public.user_log</code> table reference
     */
    public UserLog() {
        this(DSL.name("user_log"), null);
    }

    public <O extends Record> UserLog(Table<O> child, ForeignKey<O, UserLogRecord> key) {
        super(child, key, USER_LOG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UserLog as(String alias) {
        return new UserLog(DSL.name(alias), this);
    }

    @Override
    public UserLog as(Name alias) {
        return new UserLog(alias, this);
    }

    @Override
    public UserLog as(Table<?> alias) {
        return new UserLog(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserLog rename(String name) {
        return new UserLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserLog rename(Name name) {
        return new UserLog(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserLog rename(Table<?> name) {
        return new UserLog(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super String, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super String, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
