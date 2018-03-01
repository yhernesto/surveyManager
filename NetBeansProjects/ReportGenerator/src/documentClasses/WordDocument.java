/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentClasses;

import GeneratorClasses.Answers;
import GeneratorClasses.NumericalAnswers;
import GeneratorClasses.Proffesor;
import GeneratorClasses.Subject;
import InterfaceClasses.QuestionType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Text;
import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.CTBorder;
import org.docx4j.wml.HpsMeasure;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.RPr;
import org.docx4j.wml.STBorder;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.TblBorders;
import org.docx4j.wml.TblPr;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Tr;

/**
 *
 * @author ernesto
 */
public class WordDocument {

    static WordprocessingMLPackage plantilla;
    private static ObjectFactory factory;
    private Subject subject;
    private Proffesor proffesor;
    private String archDestino;

    public WordDocument(Subject subject, Proffesor proffesor, String archDest) {
        this.subject = subject;
        this.proffesor = proffesor;
        archDestino = archDest;
    }

    public void generateDocument() throws FileNotFoundException, IOException, Exception {
//        BasicConfigurator.configure();
        plantilla = WordprocessingMLPackage.createPackage();

// The image to add
        File uibLogo = new File(System.getProperty("user.dir") + "/NetBeansProjects/CardLayoutDemo/imagenes/logoUib.png");
        addImage(uibLogo);

        int currentYear = Year.now().getValue();
        String estudio1 = subject.getEstudio();
        String title = "ENQUESTES " + estudio1 + "\n";
        String curso = (currentYear - 2000) + "-" + (currentYear -1999);
        String mainData = subject.getCode() + " " + subject.getName() + " (" + proffesor.getName() + ')';
        //adding current data
        addParagraph(title);
        addParagraph("Curs " + curso);
        addParagraph(mainData);

        //------tabla AlumnosMatriculados-------
        // agregar la tabla
        factory = Context.getWmlObjectFactory();
        plantilla.getMainDocumentPart().addStyledParagraphOfText("Subtitle", "Dades Estadístiques");
        Tbl table = factory.createTbl();
        //Row with enrolled students and surveyed students
        Tr tableRow0 = factory.createTr();
        addTableCell(tableRow0, Integer.toString(subject.getEnrolledStudents()) + " Alumnes matriculats");
        addTableCell(tableRow0, Integer.toString(proffesor.getSurveyedAmount()) + " Enquestes");
        table.getContent().add(tableRow0);
        plantilla.getMainDocumentPart().addObject(table);
        //------tablaAlumnosMatriculados fi------------
        addParagraph("");
        //------tabla Asignatura -----------------
        Tbl tableA = factory.createTbl();
        //fila con encabezados
        Tr tableRowA0 = factory.createTr();
        addStyledTableCell(tableRowA0, "ASSIGNATURA", true, null);
        
        // addTableCell(tableRowA0, "ASIGNATURA");
        tableA.getContent().add(tableRowA0);
        Tr tableRowA1 = factory.createTr();
        addTableCell(tableRowA1, "Valoració alumnes (1 a 10)");
        addTableCell(tableRowA1, "Mitjana");
        addTableCell(tableRowA1, "Mediana");
        addTableCell(tableRowA1, "Variaça");
        addTableCell(tableRowA1, "Error Mitjana (±)");
        tableA.getContent().add(tableRowA1);
        
        DecimalFormat df = new DecimalFormat("#.##");
        for(Answers answers : subject.getAnswers(QuestionType.type.NUMERICAL)){
            Tr tableRow = factory.createTr();
            NumericalAnswers numericalAnswer = (NumericalAnswers) answers;
            addTableCell(tableRow, numericalAnswer.getQuestion());
            addTableCell(tableRow, String.valueOf(numericalAnswer.getMean()));
            addTableCell(tableRow, String.valueOf(numericalAnswer.getMean()));
            addTableCell(tableRow, String.valueOf(numericalAnswer.getVariance()));
            addTableCell(tableRow, String.valueOf(numericalAnswer.getMeanError()));
            tableA.getContent().add(tableRow);
        }
        
//        ListIterator itPA = subject.getAnswers(QuestionType.type.NUMERICAL).listIterator();
//        int i1 = 0;
//        ArrayList arrayMediasA = subject.getMedias();
//        ArrayList arrayMedianasA = subject.getMedianas();
//        ArrayList arrayVarianzasA = subject.getVarianzas();
//        ArrayList arrayErroresMediosA = subject.getErroresMedios();
//        DecimalFormat df = new DecimalFormat("#.##");
//        while (itPA.hasNext()) {
//            Tr tableRowA2 = factory.createTr();
//            addTableCell(tableRowA2, (String) itPA.next());
//            addTableCell(tableRowA2, df.format(arrayMediasA.get(i1)));
//            addTableCell(tableRowA2, df.format(arrayMedianasA.get(i1)));
//            addTableCell(tableRowA2, df.format(arrayVarianzasA.get(i1)));
//            addTableCell(tableRowA2, df.format(arrayErroresMediosA.get(i1)));
//            tableA.getContent().add(tableRowA2);
//            i1++;
//        }
        plantilla.getMainDocumentPart().addObject(tableA);
        //------tabla Asignatura fi --------------
        addParagraph("");
        
        //**********************************************************************
        //*************************** Proffesor Table **************************
        //**********************************************************************
        Tbl tableP = factory.createTbl();
        Tr tableRowP0 = factory.createTr();
        addStyledTableCell(tableRowP0, "PROFESSOR", true, null);
        tableP.getContent().add(tableRowP0);
        tableP.getContent().add(tableRowA1);
        
        for(Answers answers : proffesor.getAnswers(QuestionType.type.NUMERICAL)){
            Tr tableRow = factory.createTr();
            NumericalAnswers numericalAnswer = (NumericalAnswers) answers;
            addTableCell(tableRow, numericalAnswer.getQuestion());
            addTableCell(tableRow, String.valueOf(numericalAnswer.getMean()));
            addTableCell(tableRow, String.valueOf(numericalAnswer.getMean()));
            addTableCell(tableRow, String.valueOf(numericalAnswer.getVariance()));
            addTableCell(tableRow, String.valueOf(numericalAnswer.getMeanError()));
            tableP.getContent().add(tableRow);
        }
        plantilla.getMainDocumentPart().addObject(tableP);
        //------tabla Profesor fi --------------

        if (!subject.getAnswers(QuestionType.type.TEXTUAL).isEmpty()) {
            addParagraph("");
            plantilla.getMainDocumentPart().addStyledParagraphOfText("Subtitle", "Respostes de text lliure sobre l'assignatura");
            addTextualAnswers(subject.getAnswers(QuestionType.type.TEXTUAL));    //0 = De Asignatura; 1 = De Profesor
        }
        if (!proffesor.getAnswers(QuestionType.type.TEXTUAL).isEmpty()) {
            addParagraph("");
            plantilla.getMainDocumentPart().addStyledParagraphOfText("Subtitle", "Respostes de text lliure sobre l'professor");
            addTextualAnswers(proffesor.getAnswers(QuestionType.type.TEXTUAL));    //0 = De Asignatura; 1 = De Profesor
        }
        plantilla.save(new java.io.File(archDestino + "/" + subject.getCode() + "_" + subject.getGroupCode() + "_" + proffesor.getName() + ".docx"));
    }

    private void addImage(File file) throws FileNotFoundException, IOException, Exception {
        java.io.InputStream is = new java.io.FileInputStream(file);
        long length = file.length();
        // You cannot create an array using a long type.
        // It needs to be an int type.
        if (length > Integer.MAX_VALUE) {
            System.out.println("File too large!!");
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            System.out.println("Could not completely read file " + file.getName());
        }
        is.close();

        String filenameHint = null;
        String altText = null;
        int id1 = 0;
        int id2 = 1;

// Image 2: width 3000
        org.docx4j.wml.P p2 = newImage(plantilla, bytes,
                filenameHint, altText,
                id1, id2, 9000);
        plantilla.getMainDocumentPart().addObject(p2);

    }

    public static org.docx4j.wml.P newImage(WordprocessingMLPackage wordMLPackage,
            byte[] bytes,
            String filenameHint, String altText,
            int id1, int id2, long cx) throws Exception {

        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);

        Inline inline = imagePart.createImageInline(filenameHint, altText,
                id1, id2, false);

        // Now add the inline in w:p/w:r/w:drawing
        org.docx4j.wml.ObjectFactory factory = Context.getWmlObjectFactory();
        org.docx4j.wml.P p = factory.createP();
        org.docx4j.wml.R run = factory.createR();
        p.getContent().add(run);
        org.docx4j.wml.Drawing drawing = factory.createDrawing();
        run.getContent().add(drawing);
        drawing.getAnchorOrInline().add(inline);

        return p;

    }

    private static void addParagraph(String textToAdd) {
        ObjectFactory obj = new ObjectFactory();

        // paragraph element / object
        P paragraph = obj.createP();

        // run object - number of runs may comprise a single paragraph element
        R run = obj.createR();

        //run comprises of various elements such as text, format, tab etc...
        // tab element
        Text text = obj.createText();

        // set text value
        text.setValue(textToAdd);

        // add text to run
        run.getContent().add(text);
        paragraph.getContent().add(run);
        //add the paragraph object to the main document part
        plantilla.getMainDocumentPart().addObject(paragraph);
    }

    private static void addBorders(Tbl table) {
        table.setTblPr(new TblPr());
        CTBorder border = new CTBorder();
        border.setColor("auto");
        border.setSz(new BigInteger("4"));
        border.setSpace(new BigInteger("0"));
        border.setVal(STBorder.SINGLE);

        TblBorders borders = new TblBorders();
        borders.setBottom(border);
        borders.setLeft(border);
        borders.setRight(border);
        borders.setTop(border);
        borders.setInsideH(border);
        borders.setInsideV(border);
        table.getTblPr().setTblBorders(borders);
    }

    private static void addTableCell(Tr tableRow, String content) {
        Tc tableCell = factory.createTc();
        tableCell.getContent().add(
                plantilla.getMainDocumentPart().createParagraphOfText(content));
        tableRow.getContent().add(tableCell);
    }

    private static void addStyledTableCell(Tr tableRow, String content,
            boolean bold, String fontSize) {
        Tc tableCell = factory.createTc();
        addStyling(tableCell, content, bold, fontSize);
        tableRow.getContent().add(tableCell);
    }

    private static void addStyling(Tc tableCell, String content,
            boolean bold, String fontSize) {
        P paragraph = factory.createP();

        Text text = factory.createText();
        text.setValue(content);

        R run = factory.createR();
        run.getContent().add(text);

        paragraph.getContent().add(run);

        RPr runProperties = factory.createRPr();
        if (bold) {
            addBoldStyle(runProperties);
        }

        if (fontSize != null && !fontSize.isEmpty()) {
            setFontSize(runProperties, fontSize);
        }

        run.setRPr(runProperties);

        tableCell.getContent().add(paragraph);
    }

    private static void setFontSize(RPr runProperties, String fontSize) {
        HpsMeasure size = new HpsMeasure();
        size.setVal(new BigInteger(fontSize));
        runProperties.setSz(size);
        runProperties.setSzCs(size);
    }

    private static void addBoldStyle(RPr runProperties) {
        BooleanDefaultTrue b = new BooleanDefaultTrue();
        b.setVal(true);
        runProperties.setB(b);
    }

    private void addTextualAnswers(ArrayList<Answers> answers) {
        for(Answers textualAnswer : answers){
            addParagraph(textualAnswer.getQuestion());
            for(Object answer : textualAnswer.getAnswers()){
                String strAnswer = (String) answer;
                if (strAnswer.startsWith("L-")) strAnswer = strAnswer.substring(2);
                addParagraph("\t" + "- " + strAnswer);
            }
        }
    }

}
