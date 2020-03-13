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
 * InlineResponse2002
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-09T23:17:28.193Z[GMT]")
public class InlineResponse2002   {
  @JsonProperty("blocked")
  private Boolean blocked = null;

  public InlineResponse2002 blocked(Boolean blocked) {
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
    InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
    return Objects.equals(this.blocked, inlineResponse2002.blocked);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blocked);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002 {\n");
    
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
