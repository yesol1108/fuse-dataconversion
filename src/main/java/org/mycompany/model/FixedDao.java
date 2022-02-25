package org.mycompany.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.camel.dataformat.bindy.annotation.DataField;

public class FixedDao {

    @DataField(pos = 7, length=5, align = "R", paddingChar=' ')
    public String title;

    @DataField(pos = 8, length=5, align = "R", paddingChar=' ')
    public String artist;

    @JsonProperty("itunes_link")
    @DataField(pos = 9, length=30, align = "R", paddingChar=' ')
    public String itunesLink;

}
