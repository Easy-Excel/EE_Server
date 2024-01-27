package umc.easyexcel.service.ShortcutKeyService;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import umc.easyexcel.domain.*;
import umc.easyexcel.domain.enums.*;
import umc.easyexcel.repository.*;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class ShortcutKeyQueryServiceImpl implements ShortcutKeyQueryService {

    private final ShortcutKeyRepository shortcutKeyRepository;
    private final SimilarWordsRepository similarWordsRepository;

    @Override
    public List<ShortcutKey> getShortcutKeysByCategory(ShortcutKeyCategory category) {
        return shortcutKeyRepository.findByCategory(category);
    }

    @Override
    public List<ShortcutKey> searchShortcutKeys(String keyword) {
        // keyword가 explanation이나 detail explanation에 포함된 경우
        List<ShortcutKey> result = shortcutKeyRepository.findByExplanationContainingIgnoreCaseOrDetailExplanationContainingIgnoreCase(keyword, keyword);

        // keyword가 SimilarWords의 content에 포함된 경우
        List<SimilarWords> similarWordsList = similarWordsRepository.findByContentContaining(keyword);
        for (SimilarWords similarWords : similarWordsList) {
            Words words = similarWords.getWords();
            List<ShortcutKey> keys = shortcutKeyRepository.findByExplanationContainingIgnoreCaseOrDetailExplanationContainingIgnoreCase(words.getContent(), words.getContent());
            result.addAll(keys);
        }

        result = new ArrayList<>(new HashSet<>(result));    // 중복 제거

        return result;
    }

}
