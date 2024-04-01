package com.example.domain;

import com.example.domain.code.LocationCode;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmbededCollection {

    @Enumerated(EnumType.STRING)
    private LocationCode locationCode1;

    @Enumerated(EnumType.STRING)
    private LocationCode locationCode2;

    @Enumerated(EnumType.STRING)
    private LocationCode locationCode3;

    @Builder
    public EmbededCollection(LocationCode locationCode1, LocationCode locationCode2, LocationCode locationCode3) {
        this.locationCode1 = locationCode1;
        this.locationCode2 = locationCode2;
        this.locationCode3 = locationCode3;
    }
}
