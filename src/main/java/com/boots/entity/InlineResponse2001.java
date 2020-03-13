package com.boots.entity;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse2001
 */
public class InlineResponse2001   {
    @JsonProperty("blocked")
    private Boolean blocked;

    public InlineResponse2001 blocked(Boolean blocked) {
        this.blocked = blocked;
        return this;
    }

    /**
     * Get blocked
     * @return blocked
     */
    @ApiModelProperty(value = "")


    public Boolean getBlocked() {
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
        return Objects.equals(this.blocked, inlineResponse2001.blocked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocked);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse2001 {\n");

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

