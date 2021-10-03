package com.lushidea.evetools.controller.shared.mapper;

import com.lushidea.evetools.controller.shared.viewobject.Group;

public interface GroupMapper {
    static Group groupModelToViewObject(com.lushidea.evetools.domain.shared.model.entity.Group group) {
        if (group == null) return null;
        return Group.builder()
                .id(group.getId())
                .label(LabelMapper.labelModelToViewObject(group.getLabel()))
                .build();
    }
}
