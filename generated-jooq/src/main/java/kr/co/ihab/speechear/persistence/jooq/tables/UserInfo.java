/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables;


import java.util.function.Function;

import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.Keys;
import kr.co.ihab.speechear.persistence.jooq.Public;
import kr.co.ihab.speechear.persistence.jooq.tables.records.UserInfoRecord;

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
public class UserInfo extends TableImpl<UserInfoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user_info</code>
     */
    public static final UserInfo USER_INFO = new UserInfo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserInfoRecord> getRecordType() {
        return UserInfoRecord.class;
    }

    /**
     * The column <code>public.user_info.id</code>.
     */
    public final TableField<UserInfoRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>public.user_info.password</code>.
     */
    public final TableField<UserInfoRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.user_info.name</code>.
     */
    public final TableField<UserInfoRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>public.user_info.email</code>.
     */
    public final TableField<UserInfoRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(40), this, "");

    /**
     * The column <code>public.user_info.cellphone</code>.
     */
    public final TableField<UserInfoRecord, String> CELLPHONE = createField(DSL.name("cellphone"), SQLDataType.VARCHAR(15), this, "");

    private UserInfo(Name alias, Table<UserInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserInfo(Name alias, Table<UserInfoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user_info</code> table reference
     */
    public UserInfo(String alias) {
        this(DSL.name(alias), USER_INFO);
    }

    /**
     * Create an aliased <code>public.user_info</code> table reference
     */
    public UserInfo(Name alias) {
        this(alias, USER_INFO);
    }

    /**
     * Create a <code>public.user_info</code> table reference
     */
    public UserInfo() {
        this(DSL.name("user_info"), null);
    }

    public <O extends Record> UserInfo(Table<O> child, ForeignKey<O, UserInfoRecord> key) {
        super(child, key, USER_INFO);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<UserInfoRecord> getPrimaryKey() {
        return Keys.USER_INFO_PK;
    }

    @Override
    public UserInfo as(String alias) {
        return new UserInfo(DSL.name(alias), this);
    }

    @Override
    public UserInfo as(Name alias) {
        return new UserInfo(alias, this);
    }

    @Override
    public UserInfo as(Table<?> alias) {
        return new UserInfo(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserInfo rename(String name) {
        return new UserInfo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserInfo rename(Name name) {
        return new UserInfo(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserInfo rename(Table<?> name) {
        return new UserInfo(name.getQualifiedName(), null);
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
