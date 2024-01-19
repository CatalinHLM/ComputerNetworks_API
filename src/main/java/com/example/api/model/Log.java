package com.example.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity@Table(name = "log")
public class Log {

    @Id
    private Long time;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    private String logText;

    @PrePersist
    public void prePersist() {
        if (time == null) {
            time = System.currentTimeMillis();
        }
    }

}
