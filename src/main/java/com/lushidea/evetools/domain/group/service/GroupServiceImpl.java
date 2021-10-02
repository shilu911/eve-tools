package com.lushidea.evetools.domain.group.service;

import com.lushidea.evetools.domain.group.service.interfaces.GroupService;
import com.lushidea.evetools.domain.shared.Mapper.GroupMapper;
import com.lushidea.evetools.domain.shared.model.entity.Group;
import com.lushidea.evetools.infrastructure.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepo groupRepo;

    @Autowired
    public GroupServiceImpl(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    @Override
    public List<Group> findShipGroups() {
        return groupRepo.findByCategoryId(10l).stream()
                .map(group -> GroupMapper.groupEntityToModel(group)).collect(Collectors.toList());
    }
}
