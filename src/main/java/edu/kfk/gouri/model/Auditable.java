package edu.kfk.gouri.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.Instant;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Auditable {

    private Instant createdAt;

    private Instant updatedAt;

    public Instant getCreatedAt() {
        return createdAt != null ? createdAt : Instant.now();
    }
    public Instant getUpdatedAt() {
        return updatedAt != null ? updatedAt : Instant.now();
    }
}
