package test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName Test
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午11:55
 * @Version 1.0
 */

public class Test {


    public static void main(String[] args) {

        Integer[] ids = {1,2,3,4,5,6,7,8,9};

        Object[] objects = Stream.of(ids).filter(integer -> integer > 4).toArray();

        Stream.of(objects).forEach(integer -> System.out.println(integer));

        try {
            generateQRCodeImage("This is my first QR Code", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }

    private static final String QR_CODE_IMAGE_PATH = "D:/MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }




}
