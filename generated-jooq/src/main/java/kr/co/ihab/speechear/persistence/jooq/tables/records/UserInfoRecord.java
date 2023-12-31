/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.records;


import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.tables.UserInfo;

import org.jooq.Field;
import org.jooq.Record1;
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
public class UserInfoRecord extends UpdatableRecordImpl<UserInfoRecord> implements Record5<String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user_info.id</code>.
     */
    public UserInfoRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.user_info.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.user_info.password</code>.
     */
    public UserInfoRecord setPassword(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.user_info.password</code>.
     */
    public String getPassword() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.user_info.name</code>.
     */
    public UserInfoRecord setName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.user_info.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.user_info.email</code>.
     */
    public UserInfoRecord setEmail(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.user_info.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.user_info.cellphone</code>.
     */
    public UserInfoRecord setCellphone(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.user_info.cellphone</code>.
     */
    public String getCellphone() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return UserInfo.USER_INFO.ID;
    }

    @Override
    public Field<String> field2() {
        return UserInfo.USER_INFO.PASSWORD;
    }

    @Override
    public Field<String> field3() {
        return UserInfo.USER_INFO.NAME;
    }

    @Override
    public Field<String> field4() {
        return UserInfo.USER_INFO.EMAIL;
    }

    @Override
    public Field<String> field5() {
        return UserInfo.USER_INFO.CELLPHONE;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getPassword();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public String component4() {
        return getEmail();
    }

    @Override
    public String component5() {
        return getCellphone();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getPassword();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public String value4() {
        return getEmail();
    }

    @Override
    public String value5() {
        return getCellphone();
    }

    @Override
    public UserInfoRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public UserInfoRecord value2(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserInfoRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public UserInfoRecord value4(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserInfoRecord value5(String value) {
        setCellphone(value);
        return this;
    }

    @Override
    public UserInfoRecord values(String value1, String value2, String value3, String value4, String value5) {
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
     * Create a detached UserInfoRecord
     */
    public UserInfoRecord() {
        super(UserInfo.USER_INFO);
    }

    /**
     * Create a detached, initialised UserInfoRecord
     */
    public UserInfoRecord(String id, String password, String name, String email, String cellphone) {
        super(UserInfo.USER_INFO);

        setId(id);
        setPassword(password);
        setName(name);
        setEmail(email);
        setCellphone(cellphone);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised UserInfoRecord
     */
    public UserInfoRecord(kr.co.ihab.speechear.persistence.jooq.tables.pojos.UserInfo value) {
        super(UserInfo.USER_INFO);

        if (value != null) {
            setId(value.getId());
            setPassword(value.getPassword());
            setName(value.getName());
            setEmail(value.getEmail());
            setCellphone(value.getCellphone());
            resetChangedOnNotNull();
        }
    }
}
