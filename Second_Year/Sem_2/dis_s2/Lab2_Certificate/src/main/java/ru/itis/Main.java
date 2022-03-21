package ru.itis;

import ru.itis.annotations.Inject;
import ru.itis.models.CertificateData;
import ru.itis.models.CertificateService;

public class Main {

    @Inject
    private static CertificateService certificateService;

    public static void main(String[] args) {

        Context context = new Context(Main.class);

        String folderName = "Lab2_Certificate\\src\\main\\java\\ru\\itis\\files";

        certificateService.setFolderName(folderName);

        //  ключа УЦ

        String rootKey = "itisKeyRoot";

        certificateService.createKey(rootKey);

        // выпуск сертификата УЦ

        CertificateData dataCA = new CertificateData();
        dataCA.setCountry_Name("RU");
        dataCA.setState("Республика Татарстан");
        dataCA.setCity("Казань");
        dataCA.setOrganization("ИТИС");
        dataCA.setCommon("УЦ ИТИС");
        dataCA.setEmail_Address("mian@kpfu.ru");


        String rootCertificateName = "itis";

        certificateService.createCertificateRoot(rootKey, dataCA, rootCertificateName);

        //  ключа  пользователя

        String nameKeyUser = "ali";

        certificateService.createKey(nameKeyUser);

        // формирование запроса на выпуск сертификата  пользователя

        CertificateData dataUser = new CertificateData();
        dataUser.setCountry_Name("RU");
        dataUser.setState("Республика Татарстан");
        dataUser.setCity("Казань");
        dataUser.setOrganization("ИТИС");
        dataUser.setCommon("Борейк Али");
        dataUser.setEmail_Address("ali@gmail.com");


        String nameCertificateUser = "aliCertificate";

        certificateService.createCertificateUser(nameKeyUser, dataUser, nameCertificateUser);

        //выпуск сертификата  пользователя

        certificateService.IssuingUserCertificate(nameCertificateUser,rootCertificateName,rootKey,"alifinal");
    }
}
