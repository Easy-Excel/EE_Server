package umc.easyexcel.service.ShortcutKeyService;

import umc.easyexcel.domain.*;
import umc.easyexcel.domain.enums.*;

import java.util.List;

public interface ShortcutKeyQueryService {
    List<ShortcutKey> getShortcutKeysByCategory(ShortcutKeyCategory category);
}
