package com.lushidea.evetools.domain.shared.Mapper;

import com.lushidea.evetools.domain.shared.model.entity.Category;

public interface CategoryMapper {
    static Category categoryEntityToModel(com.lushidea.evetools.infrastructure.entity.Category category) {
        if (category == null) return null;
        return Category.builder()
                .id(category.getId())
                .label(LabelMapper.labelEntityToModel(category.getLabel()))
                .build();
    }
}
