/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables;


import java.util.function.Function;

import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.Public;
import kr.co.ihab.speechear.persistence.jooq.tables.records.Function3_2Record;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
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
public class Function3_2 extends TableImpl<Function3_2Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.function3_2</code>
     */
    public static final Function3_2 FUNCTION3_2 = new Function3_2();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Function3_2Record> getRecordType() {
        return Function3_2Record.class;
    }

    /**
     * The column <code>public.function3_2.speechcode</code>.
     */
    public final TableField<Function3_2Record, String> SPEECHCODE = createField(DSL.name("speechcode"), SQLDataType.VARCHAR(5).nullable(false), this, "");

    /**
     * The column <code>public.function3_2.speechcontext</code>.
     */
    public final TableField<Function3_2Record, String> SPEECHCONTEXT = createField(DSL.name("speechcontext"), SQLDataType.VARCHAR(620).nullable(false), this, "");

    private Function3_2(Name alias, Table<Function3_2Record> aliased) {
        this(alias, aliased, null);
    }

    private Function3_2(Name alias, Table<Function3_2Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.function3_2</code> table reference
     */
    public Function3_2(String alias) {
        this(DSL.name(alias), FUNCTION3_2);
    }

    /**
     * Create an aliased <code>public.function3_2</code> table reference
     */
    public Function3_2(Name alias) {
        this(alias, FUNCTION3_2);
    }

    /**
     * Create a <code>public.function3_2</code> table reference
     */
    public Function3_2() {
        this(DSL.name("function3_2"), null);
    }

    public <O extends Record> Function3_2(Table<O> child, ForeignKey<O, Function3_2Record> key) {
        super(child, key, FUNCTION3_2);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Function3_2 as(String alias) {
        return new Function3_2(DSL.name(alias), this);
    }

    @Override
    public Function3_2 as(Name alias) {
        return new Function3_2(alias, this);
    }

    @Override
    public Function3_2 as(Table<?> alias) {
        return new Function3_2(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Function3_2 rename(String name) {
        return new Function3_2(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Function3_2 rename(Name name) {
        return new Function3_2(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Function3_2 rename(Table<?> name) {
        return new Function3_2(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
