package com.example.jarnin.quickmed;

import android.util.Xml;
import java.io.StringReader;
import org.xmlpull.v1.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


/* Things to know about implementing a parser:
    each tag opening is going to be called an event,
    we're going to extract the data from certain events on event.START_TAG and
    cut off data saving for this tag on event.END_TAG. at least so long until
    event != parser.END_DOCUMENT

    NOTE: In order to instantiate a new parser, we need to also instantiate
    a XMLFactoryObject class:

private XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
private XmlPullParser myparser = xmlFactoryObject.newPullParser();

myparser.setInput("file", null);

example:
int event = myParser.getEventType();
while (event != XmlPullParser.END_DOCUMENT)
{
   String name=myParser.getName();
   switch (event){
      case XmlPullParser.START_TAG:
      break;

      case XmlPullParser.END_TAG:
      if(name.equals("temperature")){
         temperature = myParser.getAttributeValue(null,"value");
      }
      break;
   }
   event = myParser.next();
}


 */

public class QuestionXmlParser {
    private String survey = "survey";
    private String section = "section";
    private String title = "title";
    private String question = "question";
    private String text = "text";
    private String type = "type";
    private String response = "response";

    private String fileName = "questions.xml";
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    public QuestionXmlParser(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getText() {
        return this.text;
    }

    public String getType() {
        return this.type;
    }

    public String getResponse() {
        return this.response;
    }

    public void parseXMLAndStoreIt(XmlPullParser parser) {
        int event;
        String entryText = null;

        try {
            event = parser.getEventType();

            while(event != XmlPullParser.END_DOCUMENT) {
                String entryName = parser.getName();

                switch(event) {
                    case XmlPullParser.START_TAG:
                        break;

                    case XmlPullParser.TEXT:
                        entryText = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (entryName.equals("title"))
                            title = entryText;
                        else if (entryName.equals("question"))
                            question = entryText;
                        else if (entryName.equals("text"))
                            text = entryText;
                        else if (entryName.equals("type"))
                            type = entryText;
                        else if (entryName.equals("response"))
                            response = entryText;
                        else {
                            //something screwed up severly here. if we're here
                        }
                        break;
                }
                event = parser.next();
            }

            parsingComplete = false;
        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
