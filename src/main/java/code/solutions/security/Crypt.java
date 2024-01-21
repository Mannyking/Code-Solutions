package code.solutions.security;

import org.json.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Crypt{

    private final SecretKeySpec key;
    private final IvParameterSpec iv;

    public Crypt() {
        String keyString = "=";
        this.key = new SecretKeySpec(Base64.getDecoder().decode(keyString), "AES");
        String ivString = "==";
        this.iv = new IvParameterSpec(Base64.getDecoder().decode(ivString));
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(data));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        Crypt teqrypt = new Crypt();
        JSONObject jsonChangePIN = new JSONObject();

        String pin_ = "drhte";
        String pinConfirm_ = "ertw";
        String currentPin_ = "nffbg";

        jsonChangePIN.put("pin", teqrypt.encrypt(pin_));
        jsonChangePIN.put("pin_confirmation", teqrypt.encrypt(pinConfirm_));
        jsonChangePIN.put("current_pin", teqrypt.encrypt(currentPin_));

        // Convert request body to json string then:
        String jsonString = jsonChangePIN.toString();
//        System.out.println(jsonString);

        String encryptedText = "Aw3TRk3sUxQAxrammc2vbkp4BQ1c6lOVzR3huDsWmJuyDrXnaIWKRUgBtbvEm72mVp9NETbM40sgrmeeOaxWRmhQnG2C7XjjjDQFfgB6Uq2fMfvIngJ4KOuHiTaq38Ya1C1W1hv+nFTVCd0rRvMtt/oxpkuOexU+rov+pV6hI/kFrcq3Fz39E/nMNFcSr7dNtfW72esO/F8xCjDkOvrOQMPSKeK/2z6Xn5nGg0m7NhK5CmvmxbVlWXzKya7Bwfn6LldRHNSlmlKe2ojZrFXV+7k3xQ76O0dSG+vWLV759kzMDB0K4wdCxZJEo23hcnD3fy7kcXj3p4MXjfQ2IV1gBfGNUwXehI3BT+V/xZiPuRRxq+YqIKTf3WVNS5KfMVJDjRgPzEkz8OHnSK5UaXMy7MMOBMWFb2IpuErWAydImcsISTlImbgox2jtQ36zQI3AknDVrsjNgn6RdDboo+bkBTKu8pbjlbCOrRsGQGpyPA0iw3vqGu0MLjbGDPSj9U8fiCVWXbMaWOZ5tlmdGkJJs9G67ZGokxo1SOVBeb3e3np+qEMWA1xAcN0q3AfljwKGvJ8YSSRqRKzdfXjyj4aRTYvRHisYFhlG5DVPaXJEhkxXBzBkDyNfc+vTtqQAOEGxtbbbZfy4oOEL5jAWb6EG7Ly10MvpeuonkEVZWCNeeIUWuzQ5SkzYonGyai7jg+YobWfObMMyVeP6NUDCTtncMw==";
        System.out.println(teqrypt.decrypt(encryptedText));

//        String encryptedText = teqrypt.encrypt(jsonString);
//        String decryptedText = teqrypt.decrypt(encryptedText);
//        decryptedText = decryptedText.replaceAll(",", ",\n");
//
//        System.out.println("Original: " + jsonString);
//        System.out.println("EncryptedText: " + encryptedText);
//        System.out.println("Decryptedext: " + decryptedText);

        jsonChangePIN.put("pin",(pin_));
        jsonChangePIN.put("pin_confirmation", (pinConfirm_));
        jsonChangePIN.put("current_pin", (currentPin_));

//        System.out.println(teqrypt.encrypt(jsonChangePIN.toString()));
    }
}

