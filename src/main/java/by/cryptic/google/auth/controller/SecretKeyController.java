package by.cryptic.google.auth.controller;

import by.cryptic.google.auth.domain.VerificationResultDto;
import by.cryptic.google.auth.twoFA.TwoFAUtils;
import by.cryptic.google.auth.domain.SecretKeyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/secret", produces = "application/json")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Secret Google keys")
public class SecretKeyController {

    @RequestMapping(value = "/getSecretKey", method = RequestMethod.GET)
    @Operation(summary = "Получение рандомного секретного ключа для использования в Google Autheficator")
    public SecretKeyDto getGoogleSecretKey() {
        return SecretKeyDto.builder().secretKey(TwoFAUtils.generateSecretKey()).build();
    }

    @RequestMapping(value = "/verifyFromGoogle", method = RequestMethod.POST)
    @Operation(summary = "Верификация с помощью двухфакторной аунтефикации с помощью GAuth")
    public VerificationResultDto verifyUserBySecretKey(
            @Parameter(required = true) @RequestParam(value = "secretKey", defaultValue = "secret_key") String secretKey,
            @Parameter(required = true) @RequestParam(value = "secretTimeCode", defaultValue = "123456") String timeCode){
    return VerificationResultDto.builder().verificationResult(timeCode.equals(TwoFAUtils.getTOTPCode(secretKey))).build();
    }
}
