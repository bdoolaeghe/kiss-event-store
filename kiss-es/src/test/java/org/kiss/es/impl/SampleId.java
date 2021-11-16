package org.kiss.es.impl;

import org.kiss.es.api.EntityId;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class SampleId implements EntityId {

    private String id;

    public static SampleId from(String id) {
        return new SampleId(id);
    }

    @Override
    public String getIdValue() {
        return id;
    }
}
