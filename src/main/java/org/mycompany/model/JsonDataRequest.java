package org.mycompany.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;
import org.apache.camel.dataformat.bindy.annotation.OneToMany;

import java.util.List;

@FixedLengthRecord()
@CsvRecord(separator=",")
public class JsonDataRequest {
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

    @OneToMany
    public List<FixedDao> noa;
}
