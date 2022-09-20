package cn.ikangjia.fun.backend.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/9/5 11:17
 */
public class Test2 {
    public static void drawTable(PDDocument doc, PDPage page, PDPageContentStream contentStream,
                                 float y, float margin,
                                 String[][] content) throws IOException {
        final int rows = content.length;
        final int cols = content[0].length;
        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth / (float) cols;
        final float cellMargin = 5f;

        //draw the rows
        float nexty = y;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        //draw the columns
        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
            nextx += colWidth;
        }

        //now add the text
//        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        contentStream.setFont(PDType0Font.load(doc,
                new File("D:\\code\\IdeaProjects\\fun-backend\\src\\main\\resources\\static\\SourceHanSansSC-Light.ttf")), 12);
        float textx = margin + cellMargin;
        float texty = y - 15;
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                String text = content[i][j];
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }
    }

    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);

        PDPageContentStream contentStream
                = new PDPageContentStream(doc, page);

        String[][] content = {{"a啊糖糖糖夥，·丶", "b", "1"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"c", "d", "2"},
                {"e", "f", "3"},
                {"g", "h", "4"},
                {"i", "j", "5"}};


        drawTable(doc, page, contentStream, 700, 100, content);
        contentStream.close();
        doc.save("src/main/resources/t1.pdf");
    }
}
