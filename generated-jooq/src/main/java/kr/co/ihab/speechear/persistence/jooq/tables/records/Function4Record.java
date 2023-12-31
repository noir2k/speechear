/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.records;


import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.tables.Function4;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


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
public class Function4Record extends TableRecordImpl<Function4Record> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.function4.index</code>.
     */
    public Function4Record setIndex(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.function4.index</code>.
     */
    public String getIndex() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.function4.filename</code>.
     */
    public Function4Record setFilename(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.function4.filename</code>.
     */
    public String getFilename() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.function4.context</code>.
     */
    public Function4Record setContext(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.function4.context</code>.
     */
    public String getContext() {
        return (String) get(2);
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
        return Function4.FUNCTION4.INDEX;
    }

    @Override
    public Field<String> field2() {
        return Function4.FUNCTION4.FILENAME;
    }

    @Override
    public Field<String> field3() {
        return Function4.FUNCTION4.CONTEXT;
    }

    @Override
    public String component1() {
        return getIndex();
    }

    @Override
    public String component2() {
        return getFilename();
    }

    @Override
    public String component3() {
        return getContext();
    }

    @Override
    public String value1() {
        return getIndex();
    }

    @Override
    public String value2() {
        return getFilename();
    }

    @Override
    public String value3() {
        return getContext();
    }

    @Override
    public Function4Record value1(String value) {
        setIndex(value);
        return this;
    }

    @Override
    public Function4Record value2(String value) {
        setFilename(value);
        return this;
    }

    @Override
    public Function4Record value3(String value) {
        setContext(value);
        return this;
    }

    @Override
    public Function4Record values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Function4Record
     */
    public Function4Record() {
        super(Function4.FUNCTION4);
    }

    /**
     * Create a detached, initialised Function4Record
     */
    public Function4Record(String index, String filename, String context) {
        super(Function4.FUNCTION4);

        setIndex(index);
        setFilename(filename);
        setContext(context);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised Function4Record
     */
    public Function4Record(kr.co.ihab.speechear.persistence.jooq.tables.pojos.Function4 value) {
        super(Function4.FUNCTION4);

        if (value != null) {
            setIndex(value.getIndex());
            setFilename(value.getFilename());
            setContext(value.getContext());
            resetChangedOnNotNull();
        }
    }
}
