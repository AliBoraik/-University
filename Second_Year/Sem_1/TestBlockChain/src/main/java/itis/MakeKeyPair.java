package itis;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;

public class MakeKeyPair {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator rsa;

        rsa = KeyPairGenerator.getInstance("RSA");
        rsa.initialize(1024, new SecureRandom());
        KeyPair keyPair = rsa.generateKeyPair();

        PrivateKey priKey = keyPair.getPrivate();
        PublicKey pubKey = keyPair.getPublic();


        String privateKey = new String(Hex.encode(priKey.getEncoded()));
        String publicKey = new String(Hex.encode(pubKey.getEncoded()));


        BufferedWriter writer1 = new BufferedWriter(new FileWriter("src/main/java/itis/Keys/privateKey.txt"));

        writer1.write(privateKey);

        BufferedWriter writer2 = new BufferedWriter(new FileWriter("src/main/java/itis/Keys/publicKey.txt"));

        writer2.write(publicKey);

        writer1.close();
        writer2.close();





    }
}
