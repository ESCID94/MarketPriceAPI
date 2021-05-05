/*
 * Creation : 26 Apr 2021
 */
package com.ust.pricemarket.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ust.pricemarket.model.MarketPrice;

public class SubscriberImp implements SubscriberI<MarketPrice> {

    // assumes the current class is called MyLogger
    private final static Logger LOGGER = Logger.getLogger(SubscriberImp.class.getName());
    Level ERROR;

    @Override
    public void onMessage(String message) {
        // TODO Auto-generated method stub

    }

    public List<MarketPrice> importCSV(File csv) {

        List<MarketPrice> priceList = new ArrayList<MarketPrice>();
        ArrayList<String> list = new ArrayList<String>();
        String[] line = null;

        try {

            // We use internal csv file, we can change it when project advance in functionality
            BufferedReader csvReader = new BufferedReader(new FileReader("src/main/java/TestMarketPriceFeed.csv"));

            while (csvReader.read() != -1) {
                list.add(csvReader.readLine());
            }

            for (int i = 0; i <= list.size(); i++) {
                for (int j = 0; j <= list.get(i).split(",").length; j++) {
                    line = list.get(i).split(",");
                }

                String inDate = line[4];
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date date = df.parse(inDate);
                long time = date.getTime();
                Timestamp ts = new Timestamp(time);

                MarketPrice price = new MarketPrice(Long.parseLong(line[0]), line[1], Double.parseDouble(line[2]), Double.parseDouble(line[3]), ts);
                priceList.add(price);
            }

            try {
                csvReader.close();
            } catch (IOException e) {
                LOGGER.log(ERROR, "Cannot close BufferedReader");
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            LOGGER.log(ERROR, "No file to import was found.");
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.log(ERROR, "Cannot read csv file");
            e.printStackTrace();
        } catch (ParseException e) {
            LOGGER.log(ERROR, "Cannot parse date from csv file");
            e.printStackTrace();
        }

        return priceList;
    }

}
