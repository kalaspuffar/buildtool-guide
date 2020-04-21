package org.ea;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.File;

public class LiftGuide {
    public static void main(String[] args) {
        final int FONT_SIZE_1 = 140;
        final int FONT_SIZE_2 = 140;

        try {
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);

            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.beginText();
            contents.setNonStrokingColor(Color.RED);

            PDFont font = PDType1Font.HELVETICA_BOLD;
            contents.setFont(font, FONT_SIZE_1);
            String text1 = "DON'T";
            float textWidth1 = (font.getStringWidth(text1) / 1000) * FONT_SIZE_1;
            contents.newLineAtOffset(
                    (page.getMediaBox().getWidth() / 2) - (textWidth1 / 2),
                    (page.getMediaBox().getHeight() / 2)
            );
            contents.showText(text1);

            String text2 = "PANIC";
            contents.setFont(font, FONT_SIZE_2);
            float textWidth2 = (font.getStringWidth(text2) / 1000) * FONT_SIZE_2;
            contents.newLineAtOffset(
            (textWidth1 / 2) - (textWidth2 / 2),
                -FONT_SIZE_2
            );
            contents.showText(text2);

            contents.endText();


            contents.close();
            doc.save(new File("guide.pdf"));
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
