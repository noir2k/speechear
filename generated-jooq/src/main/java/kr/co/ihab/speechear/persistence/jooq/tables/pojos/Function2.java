/*
 * This file is generated by jOOQ.
 */
package kr.co.ihab.speechear.persistence.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;


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
public class Function2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String speechcode;
    private String speechcontext;
    private String questioncode;
    private String questioncontext;
    private String answer;

    public Function2() {}

    public Function2(Function2 value) {
        this.speechcode = value.speechcode;
        this.speechcontext = value.speechcontext;
        this.questioncode = value.questioncode;
        this.questioncontext = value.questioncontext;
        this.answer = value.answer;
    }

    public Function2(
        String speechcode,
        String speechcontext,
        String questioncode,
        String questioncontext,
        String answer
    ) {
        this.speechcode = speechcode;
        this.speechcontext = speechcontext;
        this.questioncode = questioncode;
        this.questioncontext = questioncontext;
        this.answer = answer;
    }

    /**
     * Getter for <code>public.function2.speechcode</code>.
     */
    public String getSpeechcode() {
        return this.speechcode;
    }

    /**
     * Setter for <code>public.function2.speechcode</code>.
     */
    public Function2 setSpeechcode(String speechcode) {
        this.speechcode = speechcode;
        return this;
    }

    /**
     * Getter for <code>public.function2.speechcontext</code>.
     */
    public String getSpeechcontext() {
        return this.speechcontext;
    }

    /**
     * Setter for <code>public.function2.speechcontext</code>.
     */
    public Function2 setSpeechcontext(String speechcontext) {
        this.speechcontext = speechcontext;
        return this;
    }

    /**
     * Getter for <code>public.function2.questioncode</code>.
     */
    public String getQuestioncode() {
        return this.questioncode;
    }

    /**
     * Setter for <code>public.function2.questioncode</code>.
     */
    public Function2 setQuestioncode(String questioncode) {
        this.questioncode = questioncode;
        return this;
    }

    /**
     * Getter for <code>public.function2.questioncontext</code>.
     */
    public String getQuestioncontext() {
        return this.questioncontext;
    }

    /**
     * Setter for <code>public.function2.questioncontext</code>.
     */
    public Function2 setQuestioncontext(String questioncontext) {
        this.questioncontext = questioncontext;
        return this;
    }

    /**
     * Getter for <code>public.function2.answer</code>.
     */
    public String getAnswer() {
        return this.answer;
    }

    /**
     * Setter for <code>public.function2.answer</code>.
     */
    public Function2 setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Function2 other = (Function2) obj;
        if (this.speechcode == null) {
            if (other.speechcode != null)
                return false;
        }
        else if (!this.speechcode.equals(other.speechcode))
            return false;
        if (this.speechcontext == null) {
            if (other.speechcontext != null)
                return false;
        }
        else if (!this.speechcontext.equals(other.speechcontext))
            return false;
        if (this.questioncode == null) {
            if (other.questioncode != null)
                return false;
        }
        else if (!this.questioncode.equals(other.questioncode))
            return false;
        if (this.questioncontext == null) {
            if (other.questioncontext != null)
                return false;
        }
        else if (!this.questioncontext.equals(other.questioncontext))
            return false;
        if (this.answer == null) {
            if (other.answer != null)
                return false;
        }
        else if (!this.answer.equals(other.answer))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.speechcode == null) ? 0 : this.speechcode.hashCode());
        result = prime * result + ((this.speechcontext == null) ? 0 : this.speechcontext.hashCode());
        result = prime * result + ((this.questioncode == null) ? 0 : this.questioncode.hashCode());
        result = prime * result + ((this.questioncontext == null) ? 0 : this.questioncontext.hashCode());
        result = prime * result + ((this.answer == null) ? 0 : this.answer.hashCode());
        return result;
    }
}
