package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse2001
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-09T23:17:28.193Z[GMT]")
public class InlineResponse2001   {
  @JsonProperty("rights")
  private String rights = null;

  @JsonProperty("blocked")
  private Boolean blocked = null;

  public InlineResponse2001 rights(String rights) {
    this.rights = rights;
    return this;
  }

  /**
   * Get rights
   * @return rights
  **/
  @ApiModelProperty(value = "")
  
    public String getRights() {
    return rights;
  }

  public void setRights(String rights) {
    this.rights = rights;
  }

  public InlineResponse2001 blocked(Boolean blocked) {
    this.blocked = blocked;
    return this;
  }

  /**
   * Get blocked
   * @return blocked
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isBlocked() {
    return blocked;
  }

  public void setBlocked(Boolean blocked) {
    this.blocked = blocked;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(this.rights, inlineResponse2001.rights) &&
        Objects.equals(this.blocked, inlineResponse2001.blocked);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rights, blocked);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    rights: ").append(toIndentedString(rights)).append("\n");
    sb.append("    blocked: ").append(toIndentedString(blocked)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
