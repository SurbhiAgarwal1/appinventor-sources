// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.widgets;

import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.uibinder.elementparsers.ElementParser;
import com.google.gwt.uibinder.rebind.FieldWriter;
import com.google.gwt.uibinder.rebind.UiBinderWriter;
import com.google.gwt.uibinder.rebind.XMLElement;

@SuppressWarnings("unused")
public class DropDownItemParser implements ElementParser {
  @Override
  public void parse(XMLElement elem, String fieldName, JClassType type,
      UiBinderWriter writer) throws UnableToCompleteException {
    String name = elem.consumeRawAttribute("name", null);
    if (name != null) {
      writer.addStatement("%1$s.setName(\"%2$s\");", fieldName, name);
    }
    String caption = elem.consumeRawAttribute("caption", null);
    if (caption != null) {
      writer.addStatement("%1$s.setCaption(%2$s);", fieldName,
          writer.declareField("java.lang.String", caption));
    }
    String styleName = elem.consumeRawAttribute("styleName", null);
    if (styleName != null) {
      writer.addStatement("%1$s.setStyleName(\"%2$s\");", fieldName, styleName);
    }
    String dependentStyleName = elem.consumeRawAttribute("dependentStyleName", null);
    if (dependentStyleName != null) {
      writer.addStatement("%1$s.setDependentStyleName(\"%2$s\");", fieldName, dependentStyleName);
    }
    String visible = elem.consumeRawAttribute("visible", null);
    if (visible != null) {
      writer.addStatement("%1$s.setVisible(%2$s);", fieldName, visible);
    }
    String beta = elem.consumeRawAttribute("beta", null);
    if (beta != null) {
      writer.addStatement("%1$s.setBeta(%2$s);", fieldName, beta);
    }

    if (elem.hasChildNodes()) {
      XMLElement child = elem.consumeSingleChildElement();
      FieldWriter childField = writer.parseElementToField(child);
      writer.addStatement("%1$s.setCommand(%2$s);", fieldName, childField.getNextReference());
    }
  }
}
