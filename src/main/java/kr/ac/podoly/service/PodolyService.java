package kr.ac.podoly.service;

import kr.ac.podoly.domain.Article;
import kr.ac.podoly.dto.AddArticleRequest;
import kr.ac.podoly.repository.PodolyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PodolyService {
    @Autowired
    private PodolyRepository podolyRepository;
    public Article save(AddArticleRequest request) {
        return podolyRepository.save(request.toEntity());
    }
}
