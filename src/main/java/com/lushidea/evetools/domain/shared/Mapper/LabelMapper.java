package com.lushidea.evetools.domain.shared.Mapper;

import com.lushidea.evetools.domain.shared.model.valueobject.Label;

public interface LabelMapper {
    static Label labelEntityToModel(com.lushidea.evetools.infrastructure.entity.Label label) {
        if (label == null) return null;
        return Label.builder()
                .en(label.getEn())
                .zh(label.getZh())
                .build();
    }
}
