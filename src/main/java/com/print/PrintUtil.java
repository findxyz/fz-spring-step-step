package com.print;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.PrintRequestAttributeSet;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * Created by fz on 2016/4/1.
 */
public class PrintUtil {

    private static PrintService getPrintService() throws PrinterException {

        PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
        if (ps == null) {
            throw new RuntimeException("No default printer service available.");
        }
        return ps;
    }

    public static void printPrintable(PrintRequestAttributeSet pras, Printable printable) throws PrinterException {

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(printable);
        printerJob.setPrintService(getPrintService());
        printerJob.print(pras);
    }
}
