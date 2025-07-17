package tech.wvs.moderationms.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wvs.moderationms.api.dto.ModerationInput;
import tech.wvs.moderationms.api.dto.ModerationOutput;
import tech.wvs.moderationms.service.ModerationService;

@RestController
@RequestMapping(path = "/api/moderate")
public class ModerationController {

    private final ModerationService service;

    public ModerationController(ModerationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ModerationOutput> validate(@RequestBody ModerationInput dto) {
        var output = service.validateComment(dto);
        return ResponseEntity.ok(output);
    }
}
