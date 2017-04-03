package com.voronovich.util;

import com.voronovich.pojo.*;

import javax.xml.bind.*;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Special methods for data converting JAXB parser and Date feature
 *
 * @author Dmitry V
 * @version 1.0
 */
public class DataConverter {

    private static final String CINEMA_PATH = "C:/Projects/cinemabooking/dao/src/main/java/com/voronovich/cinema.xml";
    private static final String ORDER_PATH = "C:/Projects/cinemabooking/dao/src/main/java/com/voronovich/order.xml";

    /**
     * Convert Sessions to XML
     *
     * @param sessions Sessions
     */
    public static void marshalingSessions(Sessions sessions) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Sessions.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(sessions, new File(CINEMA_PATH));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads XML to Sessions
     *
     * @return sessions Sessions
     */
    public static Sessions unMarshalingSessions() {
        Sessions sessions = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Sessions.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            sessions = (Sessions) jaxbUnmarshaller.unmarshal(new File(CINEMA_PATH));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return sessions;
    }

    /**
     * Converts Orders to XML
     *
     * @param orders Orders
     */
    public static void marshalingOrders(Orders orders) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(orders, new File(ORDER_PATH));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads XML to Orders
     * @return orders Orders
     */
    public static Orders unMarshalingOrders() {
        Orders orders = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            orders = (Orders) jaxbUnmarshaller.unmarshal(new File(ORDER_PATH));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    /**
     * Converts String date to Date date
     *
     * @param dateString String
     * @return date Date
     */
    public static Date convertDate(String dateString){
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a");
            date = (Date) formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
