package xyz.akopartem.subtracker_server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Notification__1 implements Serializable
{

    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("title")
    @Expose
    private String title;
    private final static long serialVersionUID = -7783697808318319391L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Notification__1() {
    }

    /**
     * 
     * @param body
     * @param title
     */
    public Notification__1(String body, String title) {
        super();
        this.body = body;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Notification__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("body");
        sb.append('=');
        sb.append(((this.body == null)?"<null>":this.body));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
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
        result = ((result* 31)+((this.body == null)? 0 :this.body.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Notification__1) == false) {
            return false;
        }
        Notification__1 rhs = ((Notification__1) other);
        return (((this.body == rhs.body)||((this.body!= null)&&this.body.equals(rhs.body)))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))));
    }

}
