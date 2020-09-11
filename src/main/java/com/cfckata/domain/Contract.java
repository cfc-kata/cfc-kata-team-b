package com.cfckata.domain;

import com.github.meixuesong.aggregatepersistence.Versionable;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
public class Contract implements Versionable {

    private int version;

    @Override
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
