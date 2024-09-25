package com.scm.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;
}
