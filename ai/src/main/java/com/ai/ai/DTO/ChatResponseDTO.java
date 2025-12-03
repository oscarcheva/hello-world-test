package com.ai.ai.DTO;

import com.google.genai.types.Candidate;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatResponseDTO {
    private String text;

    public static ChatResponseDTO from(GenerateContentResponse response) {
        String text = response.candidates()
                .flatMap(candidates -> candidates.stream().findFirst())
                .flatMap(Candidate::content)
                .map(Content::text)
                .orElse(null);

        return ChatResponseDTO.builder().text(text).build();
    }

}
