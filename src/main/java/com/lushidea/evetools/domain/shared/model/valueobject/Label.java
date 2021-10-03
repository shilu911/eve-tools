package com.lushidea.evetools.domain.shared.model.valueobject;

import lombok.Builder;
import lombok.ToString;

@Builder(toBuilder = true)
@ToString
public class Label {
    private String en;
    private String zh;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }
}
