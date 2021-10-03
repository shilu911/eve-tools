package com.lushidea.evetools.controller.shared.mapper;

import com.lushidea.evetools.controller.shared.viewobject.Label;

public interface LabelMapper {
    static Label labelModelToViewObject(com.lushidea.evetools.domain.shared.model.valueobject.Label label) {
        if (label == null) return null;
        return Label.builder()
                .zh(label.getZh())
                .en(label.getEn())
                .build();
    }
}
