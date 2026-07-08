package com.example.createqrcode.Service;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class qrcodeService {

    public String criarqrCode(String link) throws Exception {
        Path caminho = Paths.get("qrcodes/qrcode.png");


        if (Files.exists(caminho)) {
            Files.delete(caminho);
        }

        BitMatrix matrix = new MultiFormatWriter().encode(
                link,
                BarcodeFormat.QR_CODE,
                300,
                300
        );



        MatrixToImageWriter.writeToPath(
                matrix,
                "PNG",
                caminho
        );

        return "/qrcode.png";
    }

}
