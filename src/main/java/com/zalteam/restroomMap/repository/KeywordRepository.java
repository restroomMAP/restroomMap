package com.zalteam.restroomMap.repository;

import com.zalteam.restroomMap.domain.Keyword;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class KeywordRepository {

    private final EntityManager em;

    /**
     * 키워드 등록
     */
    public Keyword save(Keyword keyword) {
        em.persist(keyword);
        return keyword;
    }
}
