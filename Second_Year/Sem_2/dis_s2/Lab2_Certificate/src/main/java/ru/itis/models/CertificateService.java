package ru.itis.models;

import ru.itis.annotations.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CertificateService {

    private final ProcessBuilder processBuilder;
    private String folderName;

    public CertificateService() {
        processBuilder = new ProcessBuilder();
    }

    public void createCertificateRoot(String pathKey, CertificateData data, String nameCertificate) {

        if (folderName != null) {

            // выпуск сертификата УЦ

            String cmd  = "openssl req -x509 -utf8 -new -key " + pathKey + ".key -days 365 -out " + nameCertificate + ".crt -subj " +
                    subjSwitch(data);

            processBuilder.command("cmd", "/c", cmd);

            readResult();
        } else {
            System.out.println("There is no file to save the data....");
        }
    }

    public void createCertificateUser(String userKey, CertificateData data, String nameCertificate) {


        if (folderName != null) {

            // формирование запроса на выпуск сертификата  пользователя

            String cmd = "openssl req -new -utf8 -key " + userKey + ".key  -out " + nameCertificate + ".csr -subj "
                    + subjSwitch(data);

            processBuilder.command("cmd", "/c", cmd);

            readResult();
        } else {
            System.out.println("There is no file to save the data....");
        }
    }


    public void IssuingUserCertificate(String userCfName, String rootCfName, String rootCA, String nameFinalCf) {

        if (folderName != null) {

            processBuilder.command("cmd", "/c",
                    "openssl x509 -req -in " + userCfName + ".csr -CA " + rootCfName + ".crt -CAkey " + rootCA + ".key -CAcreateserial -out "
                            + nameFinalCf + ".crt -days 365");

            readResult();
        } else {
            System.out.println("FolderName = null");
        }

    }

    public void createKey(String nameKey) {

        // выпуск ключа
        processBuilder.command("cmd", "/c", "openssl genrsa -out " + nameKey + ".key 2048 ");

        readResult();

    }

    private String subjSwitch(CertificateData data) {
        return "\"/C=" + data.getCountry_Name() + "" +
                "/ST=" + data.getState() + "" +
                "/L=" + data.getCity() + "" +
                "/O=" + data.getOrganization() + "" +
                "/OU=" + data.getCommon() + "" +
                "/CN=" + data.getEmail_Address() + "\"";
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
        processBuilder.directory(new File(folderName));
    }


    private void readResult() {
        try {

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
