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

    @Override
    public List<ShortcutKey> getShortcutKeysByCategory(ShortcutKeyCategory category) {
        return shortcutKeyRepository.findByCategory(category);
    }

    @Override
    public List<ShortcutKey> searchShortcutKeys(String keyword) {
        return shortcutKeyRepository.findByExplanationContainingOrDetailExplanationContaining(keyword, keyword);
    }

}
