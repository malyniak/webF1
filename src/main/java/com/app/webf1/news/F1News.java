package com.app.webf1.news;

import com.app.webf1.Audit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "f1_news")
public class F1News extends Audit<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String shortText;
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    private String imagePath;

}
