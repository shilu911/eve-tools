package com.lushidea.evetools.controller.group;

import com.lushidea.evetools.controller.shared.mapper.GroupMapper;
import com.lushidea.evetools.controller.shared.viewobject.Group;
import com.lushidea.evetools.domain.group.service.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/ships")
    List<Group> getShipGroups() {
        return groupService.findShipGroups().stream().map(group -> GroupMapper.groupModelToViewObject(group)).collect(Collectors.toList());
    }
}
