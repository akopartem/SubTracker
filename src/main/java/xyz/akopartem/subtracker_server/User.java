
package xyz.akopartem.subtracker_server;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class User implements Serializable
{

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("subs")
    @Expose
    private List<Sub> subs = null;
    private final static long serialVersionUID = 2931361918837778896L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
    }

    /**
     * 
     * @param subs
     * @param token
     */
    public User(String token, List<Sub> subs) {
        super();
        this.token = token;
        this.subs = subs;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Sub> getSubs() {
        return subs;
    }

    public void setSubs(List<Sub> subs) {
        this.subs = subs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("token");
        sb.append('=');
        sb.append(((this.token == null)?"<null>":this.token));
        sb.append(',');
        sb.append("subs");
        sb.append('=');
        sb.append(((this.subs == null)?"<null>":this.subs));
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
        result = ((result* 31)+((this.subs == null)? 0 :this.subs.hashCode()));
        result = ((result* 31)+((this.token == null)? 0 :this.token.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return (((this.subs == rhs.subs)||((this.subs!= null)&&this.subs.equals(rhs.subs)))&&((this.token == rhs.token)||((this.token!= null)&&this.token.equals(rhs.token))));
    }

}
