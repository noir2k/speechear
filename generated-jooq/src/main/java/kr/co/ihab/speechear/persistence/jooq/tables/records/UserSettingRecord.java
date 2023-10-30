/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.records;


import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.tables.UserSetting;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class UserSettingRecord extends UpdatableRecordImpl<UserSettingRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user_setting.user_id</code>.
     */
    public UserSettingRecord setUserId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.user_setting.user_id</code>.
     */
    public String getUserId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.user_setting.noise_type</code>.
     */
    public UserSettingRecord setNoiseType(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.user_setting.noise_type</code>.
     */
    public String getNoiseType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.user_setting.play_speed</code>.
     */
    public UserSettingRecord setPlaySpeed(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.user_setting.play_speed</code>.
     */
    public String getPlaySpeed() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record3<String, String, String> key() {
        return (Record3) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return UserSetting.USER_SETTING.USER_ID;
    }

    @Override
    public Field<String> field2() {
        return UserSetting.USER_SETTING.NOISE_TYPE;
    }

    @Override
    public Field<String> field3() {
        return UserSetting.USER_SETTING.PLAY_SPEED;
    }

    @Override
    public String component1() {
        return getUserId();
    }

    @Override
    public String component2() {
        return getNoiseType();
    }

    @Override
    public String component3() {
        return getPlaySpeed();
    }

    @Override
    public String value1() {
        return getUserId();
    }

    @Override
    public String value2() {
        return getNoiseType();
    }

    @Override
    public String value3() {
        return getPlaySpeed();
    }

    @Override
    public UserSettingRecord value1(String value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserSettingRecord value2(String value) {
        setNoiseType(value);
        return this;
    }

    @Override
    public UserSettingRecord value3(String value) {
        setPlaySpeed(value);
        return this;
    }

    @Override
    public UserSettingRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserSettingRecord
     */
    public UserSettingRecord() {
        super(UserSetting.USER_SETTING);
    }

    /**
     * Create a detached, initialised UserSettingRecord
     */
    public UserSettingRecord(String userId, String noiseType, String playSpeed) {
        super(UserSetting.USER_SETTING);

        setUserId(userId);
        setNoiseType(noiseType);
        setPlaySpeed(playSpeed);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised UserSettingRecord
     */
    public UserSettingRecord(kr.co.ihab.speechear.persistence.jooq.tables.pojos.UserSetting value) {
        super(UserSetting.USER_SETTING);

        if (value != null) {
            setUserId(value.getUserId());
            setNoiseType(value.getNoiseType());
            setPlaySpeed(value.getPlaySpeed());
            resetChangedOnNotNull();
        }
    }
}