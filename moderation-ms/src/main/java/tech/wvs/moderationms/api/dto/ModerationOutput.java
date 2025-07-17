package tech.wvs.moderationms.api.dto;

public record ModerationOutput(Boolean approved,
                               String reason) {
}
