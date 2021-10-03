package com.lushidea.evetools.domain.group.service.interfaces;

import com.lushidea.evetools.domain.shared.model.entity.Group;
import java.util.List;

public interface GroupService {
    List<Group> findShipGroups();
}