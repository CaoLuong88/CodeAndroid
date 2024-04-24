package com.example.docbaorss;
import android.util.Log;

import com.example.docbaorss.model.Item;
import com.example.docbaorss.model.Item;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import java.util.List;
import java.io.InputStream;

import javax.xml.parsers.SAXParserFactory;

public class MySaxParser {
    public static List<Item> xmlParser(InputStream is){
        List<Item> list=null;
        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            MySaxHandler handler=new MySaxHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(is));
            //list=handler.getList();
            list=handler.getItems();

        }catch (Exception e){
            Log.d("Loi",e.getMessage());
        }
        return list;
    }
}
