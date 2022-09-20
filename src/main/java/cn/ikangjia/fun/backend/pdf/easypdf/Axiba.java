package cn.ikangjia.fun.backend.pdf.easypdf;

import wiki.xsx.core.pdf.component.XEasyPdfComponent;
import wiki.xsx.core.pdf.component.table.XEasyPdfCell;
import wiki.xsx.core.pdf.component.table.XEasyPdfRow;
import wiki.xsx.core.pdf.component.table.XEasyPdfTable;
import wiki.xsx.core.pdf.component.text.XEasyPdfText;
import wiki.xsx.core.pdf.doc.XEasyPdfDefaultFontStyle;
import wiki.xsx.core.pdf.doc.XEasyPdfDocument;
import wiki.xsx.core.pdf.doc.XEasyPdfPage;
import wiki.xsx.core.pdf.doc.XEasyPdfPositionStyle;
import wiki.xsx.core.pdf.handler.XEasyPdfHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/9/7 15:41
 */
public class Axiba {
    public static void main(String[] args) {
        XEasyPdfDocument document = XEasyPdfHandler.Document.build();
        document.setGlobalHeader(
                XEasyPdfHandler.Header.build(
                        XEasyPdfHandler.Text.build("健康检查报告").setFontSize(30F).setHorizontalStyle(XEasyPdfPositionStyle.CENTER)
                )
        ).setDefaultFontStyle(XEasyPdfDefaultFontStyle.NORMAL);

        XEasyPdfPage page = XEasyPdfHandler.Page.build();

        XEasyPdfText text = XEasyPdfHandler.Text.build("hello，中国");

        List<XEasyPdfRow> rowList = new ArrayList<>(10);
        List<XEasyPdfCell> cellList;

        for (int i = 0; i < 10; i++) {
            cellList = new ArrayList<>(3);
            for (int i1 = 0; i1 < 3; i1++) {
                cellList.add(
                        XEasyPdfHandler.Table.Row.Cell.build(100F, 20F)
                                .addContent(XEasyPdfHandler.Text.build("row" + i))
                );
            }
            rowList.add(XEasyPdfHandler.Table.Row.build(cellList));
        }
        XEasyPdfTable table = XEasyPdfHandler.Table.build(rowList);

        page.addComponent(text)
                        .addComponent(table);


        document.addPage(page);

        document.save("src/main/resources/e.pdf").close();

    }
}
