package xyz.akopartem.subtracker_server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Result implements Serializable
{

    @SerializedName("message_id")
    @Expose
    private String messageId;
    private final static long serialVersionUID = 5522382097234076472L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param messageId
     */
    public Result(String messageId) {
        super();
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("messageId");
        sb.append('=');
        sb.append(((this.messageId == null)?"<null>":this.messageId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.messageId == null)? 0 :this.messageId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return ((this.messageId == rhs.messageId)||((this.messageId!= null)&&this.messageId.equals(rhs.messageId)));
    }

}
