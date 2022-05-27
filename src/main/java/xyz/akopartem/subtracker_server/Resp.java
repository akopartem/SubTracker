
package xyz.akopartem.subtracker_server;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import xyz.akopartem.subtracker_server.Result;

@Generated("jsonschema2pojo")
public class Resp implements Serializable
{

    @SerializedName("multicast_id")
    @Expose
    private Long multicastId;
    @SerializedName("success")
    @Expose
    private Long success;
    @SerializedName("failure")
    @Expose
    private Long failure;
    @SerializedName("canonical_ids")
    @Expose
    private Long canonicalIds;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    private final static long serialVersionUID = -1122829323701222881L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Resp() {
    }

    /**
     * 
     * @param multicastId
     * @param success
     * @param failure
     * @param canonicalIds
     * @param results
     */
    public Resp(Long multicastId, Long success, Long failure, Long canonicalIds, List<Result> results) {
        super();
        this.multicastId = multicastId;
        this.success = success;
        this.failure = failure;
        this.canonicalIds = canonicalIds;
        this.results = results;
    }

    public Long getMulticastId() {
        return multicastId;
    }

    public void setMulticastId(Long multicastId) {
        this.multicastId = multicastId;
    }

    public Long getSuccess() {
        return success;
    }

    public void setSuccess(Long success) {
        this.success = success;
    }

    public Long getFailure() {
        return failure;
    }

    public void setFailure(Long failure) {
        this.failure = failure;
    }

    public Long getCanonicalIds() {
        return canonicalIds;
    }

    public void setCanonicalIds(Long canonicalIds) {
        this.canonicalIds = canonicalIds;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Resp.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("multicastId");
        sb.append('=');
        sb.append(((this.multicastId == null)?"<null>":this.multicastId));
        sb.append(',');
        sb.append("success");
        sb.append('=');
        sb.append(((this.success == null)?"<null>":this.success));
        sb.append(',');
        sb.append("failure");
        sb.append('=');
        sb.append(((this.failure == null)?"<null>":this.failure));
        sb.append(',');
        sb.append("canonicalIds");
        sb.append('=');
        sb.append(((this.canonicalIds == null)?"<null>":this.canonicalIds));
        sb.append(',');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null)?"<null>":this.results));
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
        result = ((result* 31)+((this.multicastId == null)? 0 :this.multicastId.hashCode()));
        result = ((result* 31)+((this.canonicalIds == null)? 0 :this.canonicalIds.hashCode()));
        result = ((result* 31)+((this.results == null)? 0 :this.results.hashCode()));
        result = ((result* 31)+((this.success == null)? 0 :this.success.hashCode()));
        result = ((result* 31)+((this.failure == null)? 0 :this.failure.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Resp) == false) {
            return false;
        }
        Resp rhs = ((Resp) other);
        return ((((((this.multicastId == rhs.multicastId)||((this.multicastId!= null)&&this.multicastId.equals(rhs.multicastId)))&&((this.canonicalIds == rhs.canonicalIds)||((this.canonicalIds!= null)&&this.canonicalIds.equals(rhs.canonicalIds))))&&((this.results == rhs.results)||((this.results!= null)&&this.results.equals(rhs.results))))&&((this.success == rhs.success)||((this.success!= null)&&this.success.equals(rhs.success))))&&((this.failure == rhs.failure)||((this.failure!= null)&&this.failure.equals(rhs.failure))));
    }

}
