package tech.wvs.moderationms.service;

import org.springframework.stereotype.Service;
import tech.wvs.moderationms.api.dto.ModerationInput;
import tech.wvs.moderationms.api.dto.ModerationOutput;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModerationService {

    private final List<String> FORBIDDEN_WORDS = List.of("ódio", "xingamento");

    public ModerationOutput validateComment(ModerationInput dto) {

        var comment = dto.text();

        if (comment == null || comment.trim().isEmpty()) {
            return new ModerationOutput(false, "Empty comment");
        }

        String commentLower = comment.toLowerCase();
        var forbiddenWords = new ArrayList<>();

        for (String word : FORBIDDEN_WORDS) {
            if (commentLower.contains(word))
                forbiddenWords.add(word);
        }

        if (!forbiddenWords.isEmpty()) {
            return new ModerationOutput(false, "Comment have forbidden words: " + forbiddenWords);
        }

        return new ModerationOutput(true, "Valid");
    }
}
