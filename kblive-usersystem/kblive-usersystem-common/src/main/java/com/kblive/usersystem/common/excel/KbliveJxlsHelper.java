package com.kblive.usersystem.common.excel;

import org.jxls.area.Area;
import org.jxls.area.CommandData;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.command.GridCommand;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.formula.FastFormulaProcessor;
import org.jxls.formula.StandardFormulaProcessor;
import org.jxls.template.SimpleExporter;
import org.jxls.transform.Transformer;
import org.jxls.util.TransformerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * title: KbliveJxlsHelper
 * projectName kbLive
 * description: 自定义JxlsHelper
 * author 2671242147@qq.com
 * date 2019-06-29 14:59
 ***/
public class KbliveJxlsHelper {

    private boolean hideTemplateSheet = false;
    private boolean deleteTemplateSheet = true;
    private boolean processFormulas = true;
    private boolean useFastFormulaProcessor = true;
    private String expressionNotationBegin;
    private String expressionNotationEnd;
    private SimpleExporter simpleExporter = new SimpleExporter();
    private AreaBuilder areaBuilder = new XlsCommentAreaBuilder();

    public static KbliveJxlsHelper getInstance() {
        return new KbliveJxlsHelper();
    }

    private KbliveJxlsHelper() {
    }

    public AreaBuilder getAreaBuilder() {
        return this.areaBuilder;
    }

    public KbliveJxlsHelper setAreaBuilder(AreaBuilder areaBuilder) {
        this.areaBuilder = areaBuilder;
        return this;
    }

    public boolean isProcessFormulas() {
        return this.processFormulas;
    }

    public KbliveJxlsHelper setProcessFormulas(boolean processFormulas) {
        this.processFormulas = processFormulas;
        return this;
    }

    public boolean isHideTemplateSheet() {
        return this.hideTemplateSheet;
    }

    public KbliveJxlsHelper setHideTemplateSheet(boolean hideTemplateSheet) {
        this.hideTemplateSheet = hideTemplateSheet;
        return this;
    }

    public boolean isDeleteTemplateSheet() {
        return this.deleteTemplateSheet;
    }

    public KbliveJxlsHelper setDeleteTemplateSheet(boolean deleteTemplateSheet) {
        this.deleteTemplateSheet = deleteTemplateSheet;
        return this;
    }

    public boolean isUseFastFormulaProcessor() {
        return this.useFastFormulaProcessor;
    }

    public KbliveJxlsHelper setUseFastFormulaProcessor(boolean useFastFormulaProcessor) {
        this.useFastFormulaProcessor = useFastFormulaProcessor;
        return this;
    }

    public KbliveJxlsHelper buildExpressionNotation(String expressionNotationBegin, String expressionNotationEnd) {
        this.expressionNotationBegin = expressionNotationBegin;
        this.expressionNotationEnd = expressionNotationEnd;
        return this;
    }

    public KbliveJxlsHelper processTemplate(InputStream templateStream, OutputStream targetStream, Context context) throws IOException {
        Transformer transformer = this.createTransformer(templateStream, targetStream);
        this.processTemplate(context, transformer);
        return this;
    }

    public void processTemplate(Context context, Transformer transformer) throws IOException {
        this.areaBuilder.setTransformer(transformer);
        List<Area> xlsAreaList = this.areaBuilder.build();
        Iterator var4 = xlsAreaList.iterator();

        while(var4.hasNext()) {
            Area xlsArea = (Area)var4.next();
            xlsArea.applyAt(new CellRef(xlsArea.getStartCellRef().getCellName()), context);
            if (this.processFormulas) {
                this.setFormulaProcessor(xlsArea);
                xlsArea.processFormulas();
            }
        }

        if (this.isDeleteTemplateSheet()) {
            transformer.deleteSheet("gggg");
        }

        transformer.write();
    }

    private Area setFormulaProcessor(Area xlsArea) {
        if (this.useFastFormulaProcessor) {
            xlsArea.setFormulaProcessor(new FastFormulaProcessor());
        } else {
            xlsArea.setFormulaProcessor(new StandardFormulaProcessor());
        }

        return xlsArea;
    }

    public KbliveJxlsHelper processTemplateAtCell(InputStream templateStream, OutputStream targetStream, Context context, String targetCell) throws IOException {
        Transformer transformer = this.createTransformer(templateStream, targetStream);
        this.areaBuilder.setTransformer(transformer);
        List<Area> xlsAreaList = this.areaBuilder.build();
        if (xlsAreaList.isEmpty()) {
            throw new IllegalStateException("No XlsArea were detected for this processing");
        } else {
            Area firstArea = (Area)xlsAreaList.get(0);
            CellRef targetCellRef = new CellRef(targetCell);
            firstArea.applyAt(targetCellRef, context);
            if (this.processFormulas) {
                this.setFormulaProcessor(firstArea);
                firstArea.processFormulas();
            }

            String sourceSheetName = firstArea.getStartCellRef().getSheetName();
            if (!sourceSheetName.equalsIgnoreCase(targetCellRef.getSheetName())) {
                if (this.hideTemplateSheet) {
                    transformer.setHidden(sourceSheetName, true);
                }

                if (this.deleteTemplateSheet) {
                    transformer.deleteSheet(sourceSheetName);
                }
            }

            transformer.write();
            return this;
        }
    }

    public KbliveJxlsHelper processGridTemplate(InputStream templateStream, OutputStream targetStream, Context context, String objectProps) throws IOException {
        Transformer transformer = this.createTransformer(templateStream, targetStream);
        this.areaBuilder.setTransformer(transformer);
        List<Area> xlsAreaList = this.areaBuilder.build();
        Iterator var7 = xlsAreaList.iterator();

        while(var7.hasNext()) {
            Area xlsArea = (Area)var7.next();
            GridCommand gridCommand = (GridCommand)((CommandData)xlsArea.getCommandDataList().get(0)).getCommand();
            gridCommand.setProps(objectProps);
            this.setFormulaProcessor(xlsArea);
            xlsArea.applyAt(new CellRef(xlsArea.getStartCellRef().getCellName()), context);
            if (this.processFormulas) {
                xlsArea.processFormulas();
            }
        }

        transformer.write();
        return this;
    }

    public void processGridTemplateAtCell(InputStream templateStream, OutputStream targetStream, Context context, String objectProps, String targetCell) throws IOException {
        Transformer transformer = this.createTransformer(templateStream, targetStream);
        this.areaBuilder.setTransformer(transformer);
        List<Area> xlsAreaList = this.areaBuilder.build();
        Area firstArea = (Area)xlsAreaList.get(0);
        CellRef targetCellRef = new CellRef(targetCell);
        GridCommand gridCommand = (GridCommand)((CommandData)firstArea.getCommandDataList().get(0)).getCommand();
        gridCommand.setProps(objectProps);
        firstArea.applyAt(targetCellRef, context);
        if (this.processFormulas) {
            this.setFormulaProcessor(firstArea);
            firstArea.processFormulas();
        }

        String sourceSheetName = firstArea.getStartCellRef().getSheetName();
        if (!sourceSheetName.equalsIgnoreCase(targetCellRef.getSheetName())) {
            if (this.hideTemplateSheet) {
                transformer.setHidden(sourceSheetName, true);
            }

            if (this.deleteTemplateSheet) {
                transformer.deleteSheet(sourceSheetName);
            }
        }

        transformer.write();
    }

    public KbliveJxlsHelper registerGridTemplate(InputStream inputStream) throws IOException {
        this.simpleExporter.registerGridTemplate(inputStream);
        return this;
    }

    public KbliveJxlsHelper gridExport(Collection headers, Collection dataObjects, String objectProps, OutputStream outputStream) {
        this.simpleExporter.gridExport(headers, dataObjects, objectProps, outputStream);
        return this;
    }

    public Transformer createTransformer(InputStream templateStream, OutputStream targetStream) {
        Transformer transformer = TransformerFactory.createTransformer(templateStream, targetStream);
        if (transformer == null) {
            throw new IllegalStateException("Cannot load XLS transformer. Please make sure a Transformer implementation is in classpath");
        } else {
            if (this.expressionNotationBegin != null && this.expressionNotationEnd != null) {
                transformer.getTransformationConfig().buildExpressionNotation(this.expressionNotationBegin, this.expressionNotationEnd);
            }

            return transformer;
        }
    }
}
