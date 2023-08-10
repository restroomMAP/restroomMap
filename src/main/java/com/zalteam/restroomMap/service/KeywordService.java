package com.zalteam.restroomMap.service;

import com.zalteam.restroomMap.domain.Keyword;
import com.zalteam.restroomMap.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;

    /**
     * 키워드 등록기능
     */
    @Transactional
    public Keyword saveKeyword(Keyword keyword) {
        return keywordRepository.save(keyword);
    }


}
