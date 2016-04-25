package com.qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by fz on 2016/4/25.
 */
public class ImageMergeTest {

    public static void main(String[] args) throws IOException {

        // qr code image width
        final int width = 70;

        // qr code image height
        final int height = 70;

        File path = new File("src/main/java/com/qrcode/qrImages");

        BufferedImage image = ImageIO.read(new File(path, "1AC86.png"));
        BufferedImage image2 = ImageIO.read(new File(path, "1AC86.png"));
        BufferedImage image3 = ImageIO.read(new File(path, "1AC86.png"));
        BufferedImage overlay = ImageIO.read(new File(path, "1AC87.png"));
        BufferedImage overlay2 = ImageIO.read(new File(path, "1AC87.png"));
        BufferedImage overlay3 = ImageIO.read(new File(path, "1AC87.png"));

        int w = width * 2;
        int h = height * 3;
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics g = combined.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.drawImage(image2, 0, height, null);
        g.drawImage(image3, 0, height * 2, null);
        g.drawImage(overlay, width, 0, null);
        g.drawImage(overlay2, width, height, null);
        g.drawImage(overlay3, width, height * 2, null);

        File combinedPng = new File(path, "combined.png");
        ImageIO.write(combined, "PNG", combinedPng);
    }
}
