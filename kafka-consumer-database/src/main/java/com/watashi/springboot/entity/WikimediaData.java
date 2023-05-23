package com.watashi.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Length;
import org.hibernate.annotations.Type;

@Entity
@Table(name="wikimedia_recent_changes")
@Getter
@Setter
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "doc_txt", length = Length.LONG32)
    private String wikiEventData;
}
