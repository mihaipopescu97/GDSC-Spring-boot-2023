package com.example.gdscspringboot2023.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data @AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "gdsc.id_sequence", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Version
    @Column(name = "DATABASE_VERSION", nullable = false)
    private Long databaseVersion;

    /**
     * Time of entity creation.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", updatable = false, nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    /**
     * Time of last update
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @PrePersist
    private void setUpdateDate() {
        updateDate = LocalDateTime.now();
    }
}