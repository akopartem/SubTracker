
package xyz.akopartem.subtracker_server;

import java.io.Serializable;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Sub implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("lastDate")
    @Expose
    private String lastDate;
    private final static long serialVersionUID = 7788697570566051331L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sub() {
    }

    /**
     * 
     * @param price
     * @param name
     * @param lastDate
     */
    public Sub(String name, Integer price, String lastDate) {
        super();
        this.name = name;
        this.price = price;
        this.lastDate = lastDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Sub.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("price");
        sb.append('=');
        sb.append(((this.price == null)?"<null>":this.price));
        sb.append(',');
        sb.append("lastDate");
        sb.append('=');
        sb.append(((this.lastDate == null)?"<null>":this.lastDate));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        result = ((result* 31)+((this.lastDate == null)? 0 :this.lastDate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sub) == false) {
            return false;
        }
        Sub rhs = ((Sub) other);
        return ((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))))&&((this.lastDate == rhs.lastDate)||((this.lastDate!= null)&&this.lastDate.equals(rhs.lastDate))));
    }

}
