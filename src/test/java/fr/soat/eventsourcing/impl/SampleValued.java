package fr.soat.eventsourcing.impl;

import lombok.*;

import static fr.soat.util.Util.append;

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
                .events(append(sample.getEvents(), this))
                .build();
    }

}
