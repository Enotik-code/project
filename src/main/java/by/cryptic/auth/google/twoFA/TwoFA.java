package by.cryptic.auth.google.twoFA;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class TwoFA {

    /*public static void main(String[] args) throws IOException, WriterException {
        String secretKey = "KMMC7VFMM3YNN5KX6GL4W5TPHQ47RN3T";
        String email = "fvantop@gmail.com";
        String companyName = "BitCash";
        String barCodeUrl = TwoFAUtils.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
        System.out.println(barCodeUrl);
        TwoFAUtils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);

        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        if (code.equals(TwoFAUtils.getTOTPCode(secretKey))) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Invalid 2FA Code");
        }
    }*/

}
