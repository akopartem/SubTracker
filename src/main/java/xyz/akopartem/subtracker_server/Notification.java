package xyz.akopartem.subtracker_server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Notification implements Serializable
{

    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("collapse_key")
    @Expose
    private String collapseKey;
    @SerializedName("notification")
    @Expose
    private Notification__1 notification;
    private final static long serialVersionUID = 941035855308754486L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Notification() {
    }

    /**
     * 
     * @param notification
     * @param collapseKey
     * @param to
     */
    public Notification(String to, String collapseKey, Notification__1 notification) {
        super();
        this.to = to;
        this.collapseKey = collapseKey;
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCollapseKey() {
        return collapseKey;
    }

    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }

    public Notification__1 getNotification() {
        return notification;
    }

    public void setNotification(Notification__1 notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Notification.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("to");
        sb.append('=');
        sb.append(((this.to == null)?"<null>":this.to));
        sb.append(',');
        sb.append("collapseKey");
        sb.append('=');
        sb.append(((this.collapseKey == null)?"<null>":this.collapseKey));
        sb.append(',');
        sb.append("notification");
        sb.append('=');
        sb.append(((this.notification == null)?"<null>":this.notification));
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
        result = ((result* 31)+((this.notification == null)? 0 :this.notification.hashCode()));
        result = ((result* 31)+((this.to == null)? 0 :this.to.hashCode()));
        result = ((result* 31)+((this.collapseKey == null)? 0 :this.collapseKey.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Notification) == false) {
            return false;
        }
        Notification rhs = ((Notification) other);
        return ((((this.notification == rhs.notification)||((this.notification!= null)&&this.notification.equals(rhs.notification)))&&((this.to == rhs.to)||((this.to!= null)&&this.to.equals(rhs.to))))&&((this.collapseKey == rhs.collapseKey)||((this.collapseKey!= null)&&this.collapseKey.equals(rhs.collapseKey))));
    }

}
