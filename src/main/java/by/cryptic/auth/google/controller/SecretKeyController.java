package by.cryptic.auth.google.controller;

import by.cryptic.auth.google.domain.VerificationResultDto;
import by.cryptic.auth.google.twoFA.TwoFAUtils;
import by.cryptic.auth.google.domain.SecretKeyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/secret", produces = "application/json")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Secret Google keys")
public class SecretKeyController {

    @GetMapping(value = "/getSecretKey")
    @Operation(summary = "Получение рандомного секретного ключа для использования в Google Autheficator")
    public SecretKeyDto getGoogleSecretKey() {
        return SecretKeyDto.builder().secretKey(TwoFAUtils.generateSecretKey()).build();
    }

    @GetMapping(value = "/verifyFromGoogle")
    @Operation(summary = "Верификация с помощью двухфакторной аунтефикации с помощью GAuth")
    public VerificationResultDto verifyUserBySecretKey(
            @Parameter(required = true) @RequestParam(value = "secretKey", defaultValue = "secret_key") String secretKey,
            @Parameter(required = true) @RequestParam(value = "secretTimeCode", defaultValue = "123456") String timeCode){
    return VerificationResultDto.builder().verificationResult(timeCode.equals(TwoFAUtils.getTOTPCode(secretKey))).build();
    }
}
