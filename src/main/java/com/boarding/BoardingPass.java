package com.boarding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class BoardingPass {

    private Flight flight;
    private User user;
    private final UUID BPNumber = UUID.randomUUID();

    public BoardingPass() {}

    public BoardingPass(Flight flight, User user) {
        this.flight = flight;
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getUUID()
    {
       return BPNumber;
    }
    public void serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            String boardingPass = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            FileWriter file = new FileWriter("target/boarding_pass.json");
            BufferedWriter out = new BufferedWriter(file);
            out.write(boardingPass);
            out.close();
            Map<EncodeHintType, Object> hintType = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hintType.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hintType.put(EncodeHintType.MARGIN, 1);
            hintType.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(boardingPass, BarcodeFormat.QR_CODE, 256,
                    256, hintType);
            BufferedImage qrImage = new BufferedImage(bitMatrix.getWidth(), bitMatrix.getWidth(),
                    BufferedImage.TYPE_INT_RGB);
            qrImage.createGraphics();
            Graphics2D qrGraphics = (Graphics2D) qrImage.getGraphics();
            qrGraphics.setColor(Color.white);
            qrGraphics.fillRect(0, 0, bitMatrix.getWidth(), bitMatrix.getWidth());
            qrGraphics.setColor(Color.black);
            for (int i = 0; i < bitMatrix.getWidth(); i++) {
                for (int j = 0; j < bitMatrix.getWidth(); j++) {
                    if (bitMatrix.get(i, j)) {
                        qrGraphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(qrImage, "png", new File("target/bp_qr.png"));
            File jsonFile = new File("target/boarding_pass.json");
            Scanner scanner = new Scanner(jsonFile);
            StringBuilder sb = new StringBuilder();
            while(scanner.hasNextLine()) {
                sb.append(scanner.nextLine().replace(": {", " :\n")
                        .replace("}", "").replace("\"", "")
                        .replace(",", "\n").replace("{" , ""));
            }
            PdfWriter pdfWriter = new PdfWriter("target/boarding_pass.pdf");
            PdfDocument pdf = new PdfDocument(pdfWriter);
            pdf.addNewPage();
            Document document = new Document(pdf);
            document.close();
            PDDocument doc = PDDocument.load(new File("target/boarding_pass.pdf"));
            PDPage page = doc.getPage(0);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(10, 800);
            contentStream.setFont(PDType1Font.HELVETICA, 16);
            for (String s : sb.toString().split("\n")) {
                int y = -16;
                contentStream.showText(s);
                contentStream.newLineAtOffset(0, y);
            }
            contentStream.endText();
            contentStream.close();
            doc.save(new File("target/boarding_pass.pdf"));
            doc.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException occurred during serialization!\n\n");
            e.printStackTrace();
        } catch (WriterException e) {
            System.out.println("WriterException occurred during serialization!\n\n");
            e.printStackTrace();
        }
    }
}
