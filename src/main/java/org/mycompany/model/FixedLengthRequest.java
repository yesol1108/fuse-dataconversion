package org.mycompany.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

@FixedLengthRecord
@CsvRecord(separator=",")
public class FixedLengthRequest {
    @DataField(pos = 1, length = 5, align = "L", paddingChar = ' ')
    public String blockType;

    @DataField(pos = 2, length = 8, align = "R", paddingChar = '0')
    public int blockTypeLength;

    @DataField(pos = 3, length = 15, align = "L", paddingChar = ' ')
    public String blockId;

    @DataField(pos = 4, length = 3, align = "R", paddingChar = '0')
    public int totalNoOfTX;

    @DataField(pos = 5, length = 5, align = "L", paddingChar = ' ')
    public String msgblockType;

    @DataField(pos = 6, length = 8, align = "R", paddingChar = '0')
    public int messageLength;

    @DataField(pos = 7, length=5, align = "R", paddingChar=' ')
    public String title;

    @DataField(pos = 8, length=5, align = "R", paddingChar=' ')
    public String artist;

    @DataField(pos = 9, length=30, align = "R", paddingChar=' ')
    public String itunesLink;
}
