package org.jointheleague.api.Historical.DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class LocResponse {

    private List<Result> results = null;

    @JsonProperty("Results")
    public List <Result> getResults() {
        return results;
    }

    @JsonProperty("Result")
    public void setResults(List <Result> results) {
        this.results = results;
    }
}
