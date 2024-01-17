package umc.easyexcel.web.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import umc.easyexcel.domain.*;
import umc.easyexcel.repository.*;
import umc.easyexcel.web.dto.*;

import java.util.*;
import java.util.stream.*;

@RestController
public class ShortcutKeyController {

    @Autowired
    private ShortcutKeyRepository shortcutKeyRepository;

    @GetMapping("/shortcut-key")
    public List<ShortcutKeyResponseDto> getShortcutKeysByCategory(@RequestParam ShortcutKeyCategory category) {
        List<ShortcutKey> shortcutKeys = shortcutKeyRepository.findByCategory(category);
        return shortcutKeys.stream()
                .map(ShortcutKeyResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
