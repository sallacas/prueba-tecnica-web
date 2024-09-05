package com.co.pruebatecnicaweb.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataToFeature {
    public DataToFeature() {
    }

    private static List<String> setExcelDataToFeature2(File featureFile) throws InvalidFormatException, IOException {
        List<String> fileData = new ArrayList<>();
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), StandardCharsets.UTF_8));

        try {
            List<Map<String, String>> excelData;
            boolean foundHashTag = false;
            boolean featureData = false;
            boolean esUnRango = false;
            boolean esMultiple = false;
            boolean esRangoDefinido = false;

            label113:
            while(true) {
                while(true) {
                    String data;
                    if ((data = buffReader.readLine()) == null) {
                        break label113;
                    }

                    String[] dataVector;
                    String[] dataVectorRango = null;
                    String sheetName = null;
                    String excelFilePath = null;
                    int filaSeleccionada = 0;
                    int pos = 0;
                    if (data.trim().contains("##@externaldata")) {
                        dataVector = data.trim().split("@");
                        excelFilePath = dataVector[2];
                        sheetName = dataVector[3];
                        if (dataVector.length == 4) {
                            esUnRango = true;
                        }

                        if (dataVector.length == 5) {
                            if (dataVector[4].contains("-")) {
                                dataVectorRango = dataVector[4].trim().split("-");
                                esRangoDefinido = true;
                                filaSeleccionada = Integer.parseInt(dataVectorRango[pos]) - 1;
                            } else if (dataVector[4].contains(",")) {
                                dataVectorRango = dataVector[4].trim().split(",");
                                esUnRango = true;
                                esMultiple = true;
                                filaSeleccionada = Integer.parseInt(dataVectorRango[pos]) - 1;
                            } else {
                                filaSeleccionada = Integer.parseInt(dataVector[4]) - 1;
                            }
                        }

                        foundHashTag = true;
                        fileData.add(data);
                    }

                    if (foundHashTag) {
                        excelData = (new Excel()).getData(excelFilePath, sheetName);

                        for(int rowNumber = filaSeleccionada; rowNumber < excelData.size() - 1; ++rowNumber) {
                            StringBuilder cellData = new StringBuilder();

                            for (Object o : ((Map) excelData.get(rowNumber)).entrySet()) {
                                Map.Entry<String, String> mapData = (Map.Entry) o;
                                if (dataVectorRango == null) {
                                    cellData.append("   |").append(mapData.getValue());
                                } else if (esRangoDefinido) {
                                    if (rowNumber < Integer.parseInt(dataVectorRango[1])) {
                                        cellData.append("   |").append(mapData.getValue());
                                    }
                                } else if (rowNumber + 1 == Integer.parseInt(dataVectorRango[pos]) && esUnRango) {
                                    cellData.append("   |").append(mapData.getValue());
                                }
                            }

                            fileData.add(cellData + "|");
                            if (!esUnRango && !esRangoDefinido) {
                                rowNumber = excelData.size();
                            }

                            if (esMultiple) {
                                assert dataVectorRango != null;
                                if (pos + 1 < dataVectorRango.length) {
                                    filaSeleccionada = Integer.parseInt(dataVectorRango[pos + 1]) - 1;
                                    rowNumber = filaSeleccionada - 1;
                                    ++pos;
                                } else {
                                    rowNumber = excelData.size() - 1;
                                }
                            }

                            if (esRangoDefinido) {
                                if (null == dataVectorRango) {
                                    throw new IllegalStateException("vector is null");
                                }

                                if (rowNumber + 1 == Integer.parseInt(dataVectorRango[1])) {
                                    rowNumber = excelData.size() - 1;
                                }
                                ++pos;
                            }
                        }

                        foundHashTag = false;
                        featureData = true;
                    } else if (!data.startsWith("|") && !data.endsWith("|")) {
                        featureData = false;
                        fileData.add(data);
                    } else if (!featureData) {
                        fileData.add(data);
                    }
                }
            }
        } catch (Throwable var21) {
            try {
                buffReader.close();
            } catch (Throwable var20) {
                var21.addSuppressed(var20);
            }

            throw var21;
        }

        buffReader.close();
        return fileData;
    }

    private static List<File> listOfFeatureFiles(File folder) {
        List<File> featureFiles = new ArrayList<>();
        if (folder.getName().endsWith(".feature")) {
            featureFiles.add(folder);
        } else {
            File[] var2 = folder.listFiles();
            assert var2 != null;

            for (File fileEntry : var2) {
                if (fileEntry.isDirectory()) {
                    featureFiles.addAll(listOfFeatureFiles(fileEntry));
                } else if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
                    featureFiles.add(fileEntry);
                }
            }
        }

        return featureFiles;
    }

    public static void overrideFeatureFiles(String featuresDirectoryPath) throws IOException, InvalidFormatException {
        List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));

        BufferedWriter writer;
        for(Iterator var2 = listOfFeatureFiles.iterator(); var2.hasNext(); writer.close()) {
            File featureFile = (File)var2.next();
            List<String> featureWithExcelData = setExcelDataToFeature2(featureFile);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(featureFile), StandardCharsets.UTF_8));

            try {

                for (String string : featureWithExcelData) {
                    writer.write(string);
                    writer.write("\n");
                }
            } catch (Throwable var9) {
                try {
                    writer.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }
        }

    }
}
