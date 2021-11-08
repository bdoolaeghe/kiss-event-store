package com.bdoolaeghe.ses.library.domain;

import com.bdoolaeghe.ses.api.EntityId;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Reference implements EntityId {

    private String reference;

    public static Reference reference(String reference) {
        return new Reference(reference);
    }

    @Override
    public String getIdValue() {
        return reference;
    }
}
