package com.lushidea.evetools.domain.shared.Mapper;

import com.lushidea.evetools.domain.shared.model.entity.Group;

public interface GroupMapper {
    static Group groupEntityToModel(com.lushidea.evetools.infrastructure.entity.Group group) {
        if (group == null) return null;
        return Group.builder()
                .id(group.getId())
                .category(CategoryMapper.categoryEntityToModel(group.getCategory()))
                .label(LabelMapper.labelEntityToModel(group.getLabel()))
                .build();
    }
}
