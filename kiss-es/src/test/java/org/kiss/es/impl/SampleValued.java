package org.kiss.es.impl;

import org.kiss.util.Util;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SampleValued implements SampleEvent {

    private String value;

    @Override
    public SampleEntity applyOn(SampleEntity sample) {
        return sample.toBuilder()
                .sampleValue(value)
                .events(Util.append(sample.getEvents(), this))
                .build();
    }

}
