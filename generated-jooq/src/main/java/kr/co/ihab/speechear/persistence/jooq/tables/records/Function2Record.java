/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.records;


import javax.annotation.processing.Generated;

import kr.co.ihab.speechear.persistence.jooq.tables.Function2;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class Function2Record extends TableRecordImpl<Function2Record> implements Record5<String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.function2.speechcode</code>.
     */
    public Function2Record setSpeechcode(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.function2.speechcode</code>.
     */
    public String getSpeechcode() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.function2.speechcontext</code>.
     */
    public Function2Record setSpeechcontext(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.function2.speechcontext</code>.
     */
    public String getSpeechcontext() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.function2.questioncode</code>.
     */
    public Function2Record setQuestioncode(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.function2.questioncode</code>.
     */
    public String getQuestioncode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.function2.questioncontext</code>.
     */
    public Function2Record setQuestioncontext(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.function2.questioncontext</code>.
     */
    public String getQuestioncontext() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.function2.answer</code>.
     */
    public Function2Record setAnswer(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.function2.answer</code>.
     */
    public String getAnswer() {
        return (String) get(4);
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
        return Function2.FUNCTION2.SPEECHCODE;
    }

    @Override
    public Field<String> field2() {
        return Function2.FUNCTION2.SPEECHCONTEXT;
    }

    @Override
    public Field<String> field3() {
        return Function2.FUNCTION2.QUESTIONCODE;
    }

    @Override
    public Field<String> field4() {
        return Function2.FUNCTION2.QUESTIONCONTEXT;
    }

    @Override
    public Field<String> field5() {
        return Function2.FUNCTION2.ANSWER;
    }

    @Override
    public String component1() {
        return getSpeechcode();
    }

    @Override
    public String component2() {
        return getSpeechcontext();
    }

    @Override
    public String component3() {
        return getQuestioncode();
    }

    @Override
    public String component4() {
        return getQuestioncontext();
    }

    @Override
    public String component5() {
        return getAnswer();
    }

    @Override
    public String value1() {
        return getSpeechcode();
    }

    @Override
    public String value2() {
        return getSpeechcontext();
    }

    @Override
    public String value3() {
        return getQuestioncode();
    }

    @Override
    public String value4() {
        return getQuestioncontext();
    }

    @Override
    public String value5() {
        return getAnswer();
    }

    @Override
    public Function2Record value1(String value) {
        setSpeechcode(value);
        return this;
    }

    @Override
    public Function2Record value2(String value) {
        setSpeechcontext(value);
        return this;
    }

    @Override
    public Function2Record value3(String value) {
        setQuestioncode(value);
        return this;
    }

    @Override
    public Function2Record value4(String value) {
        setQuestioncontext(value);
        return this;
    }

    @Override
    public Function2Record value5(String value) {
        setAnswer(value);
        return this;
    }

    @Override
    public Function2Record values(String value1, String value2, String value3, String value4, String value5) {
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
     * Create a detached Function2Record
     */
    public Function2Record() {
        super(Function2.FUNCTION2);
    }

    /**
     * Create a detached, initialised Function2Record
     */
    public Function2Record(String speechcode, String speechcontext, String questioncode, String questioncontext, String answer) {
        super(Function2.FUNCTION2);

        setSpeechcode(speechcode);
        setSpeechcontext(speechcontext);
        setQuestioncode(questioncode);
        setQuestioncontext(questioncontext);
        setAnswer(answer);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised Function2Record
     */
    public Function2Record(kr.co.ihab.speechear.persistence.jooq.tables.pojos.Function2 value) {
        super(Function2.FUNCTION2);

        if (value != null) {
            setSpeechcode(value.getSpeechcode());
            setSpeechcontext(value.getSpeechcontext());
            setQuestioncode(value.getQuestioncode());
            setQuestioncontext(value.getQuestioncontext());
            setAnswer(value.getAnswer());
            resetChangedOnNotNull();
        }
    }
}
