package com.lushidea.evetools.controller.shared.viewobject;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString
public class Label {
    String zh;
    String en;
}
